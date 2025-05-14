package com.magicbell.magicbelluserclient.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * (Optional) The APNs environment the token is registered for. If none is provided we assume the token is used in `production`.
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
