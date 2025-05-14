import { replaceInFile } from "replace-in-file";

import pkgJson from "../package.json";

const version = pkgJson.version;

const replacements = [
  {
    files: [
      "liblab.config.json",
      "README.md",
      "pom.xml",
      "examples/pom.xml",
      "kotlin-example/pom.xml",
    ],

    from: [
      /\"sdkVersion\": \"\d.\d.\d\"/g,
      /implementation group: com.magicbell, name: magicbell-user-client, version: \d.\d.\d/g,
      /MagicbellUserClient Java SDK \d.\d.\d/g,
      /- SDK version: `\d.\d.\d`/g,
      /<artifactId>magicbell-user-client<\/artifactId>\n.*<version>\d.\d.\d<\/version>/g,
    ],
    to: [
      `"sdkVersion": "${version}"`,
      `implementation group: com.magicbell, name: magicbell-user-client, version: ${version}`,
      `MagicbellUserClient Java SDK ${version}`,
      `- SDK version: \`${version}\``,
      (artifactVersion: string) => artifactVersion.replace(/\d.\d.\d/, version),
    ],
  },
];

await Promise.all(replacements.map((options) => replaceInFile(options))).catch(
  (e) => {
    process.stdout.write(
      `Error updating version via update-version.ts: ${e}\n`
    );
    process.exit(1);
  }
);
