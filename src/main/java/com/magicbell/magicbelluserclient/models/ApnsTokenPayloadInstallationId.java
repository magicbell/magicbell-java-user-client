package com.magicbell.magicbelluserclient.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The APNs environment this token belongs to. If omitted we assume it targets `production`.
 */
@Getter
@AllArgsConstructor
public enum ApnsTokenPayloadInstallationId {
  DEVELOPMENT("development"),
  PRODUCTION("production");

  @JsonValue
  private final String value;

  @JsonCreator
  public static ApnsTokenPayloadInstallationId fromValue(String value) {
    return Arrays.stream(ApnsTokenPayloadInstallationId.values())
      .filter(item -> item.value.equals(value))
      .findFirst()
      .orElse(null);
  }
}
