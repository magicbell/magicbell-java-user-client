package com.magicbell.magicbelluserclient.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FcmTokenInstallationId {
  DEVELOPMENT("development"),
  PRODUCTION("production");

  @JsonValue
  private final String value;

  @JsonCreator
  public static FcmTokenInstallationId fromValue(String value) {
    return Arrays
      .stream(FcmTokenInstallationId.values())
      .filter(item -> item.value.equals(value))
      .findFirst()
      .orElse(null);
  }
}
