import { exec, execSync } from "node:child_process";
import * as fs from "node:fs/promises";
import * as path from "node:path";

import { replaceInFile } from "replace-in-file";

async function move(oldPath: string, newPath: string) {
  await fs.rm(newPath, { recursive: true, force: true });
  await fs.mkdir(path.dirname(newPath), { recursive: true });
  await fs.rename(oldPath, newPath);
}

async function readJSON(path: string) {
  return fs
    .readFile(path, { encoding: "utf-8" })
    .then((data) => JSON.parse(data));
}

function hasChangesInPath(path: string) {
  try {
    execSync(`git diff --quiet HEAD ${path}`, { stdio: "ignore" });
    return false;
  } catch (error) {
    return true;
  }
}

async function fixExamples() {
  await replaceInFile({
    files: [
      "examples/src/main/java/com/example/Main.java",
      "kotlin-example/src/main/kotlin/Main.kt",
    ],
    from: ["page[before]", "page[after]"],
    to: "",
  });
  await exec("chmod +x example/run.sh kotlin-example/run.sh");
}

async function build() {
  const pkgPath = `./packages/${path.basename(path.resolve("."))}`;

  let pkgJson = await readJSON("./package.json");
  const liblabConfig = await readJSON("./liblab.config.json");
  console.log(
    `Building '${pkgJson.name}' using spec '${liblabConfig.specFilePath}'`
  );

  execSync("npx -y liblab@latest build -y --skip-validation", {
    stdio: "inherit",
  });

  await move("output/java/src", "./src");

  if (!hasChangesInPath("./src")) {
    console.log("No changes detected in output.");
    return;
  }

  const artifacts = [
    "pom.xml",
    "README.md",
    "documentation",
    "examples",
    "kotlin-example",
  ];
  for (const artifact of artifacts) {
    await move(`output/java/${artifact}`, `./${artifact}`);
  }

  await fixExamples();
}

void build().finally(() => fs.rm("output", { recursive: true, force: true }));
