package com.magicbell.magicbelluserclient.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;
import org.openapitools.jackson.nullable.JsonNullable;

@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class ApnsTokenPayload {

  /**
   * The APNs device token to register with MagicBell.
   */
  @NonNull
  @JsonProperty("device_token")
  private String deviceToken;

  /**
   * The bundle identifier of the application registering this token. Use this to override the default identifier configured on the APNs integration.
   */
  @JsonProperty("app_id")
  private JsonNullable<String> appId;

  /**
   * The APNs environment this token belongs to. If omitted we assume it targets `production`.
   */
  @JsonProperty("installation_id")
  private JsonNullable<ApnsTokenPayloadInstallationId> installationId;

  @JsonIgnore
  public String getAppId() {
    return appId.orElse(null);
  }

  @JsonIgnore
  public ApnsTokenPayloadInstallationId getInstallationId() {
    return installationId.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class ApnsTokenPayloadBuilder {

    private JsonNullable<String> appId = JsonNullable.undefined();

    @JsonProperty("app_id")
    public ApnsTokenPayloadBuilder appId(String value) {
      if (value == null) {
        throw new IllegalStateException("appId cannot be null");
      }
      this.appId = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<ApnsTokenPayloadInstallationId> installationId = JsonNullable.undefined();

    @JsonProperty("installation_id")
    public ApnsTokenPayloadBuilder installationId(ApnsTokenPayloadInstallationId value) {
      if (value == null) {
        throw new IllegalStateException("installationId cannot be null");
      }
      this.installationId = JsonNullable.of(value);
      return this;
    }
  }
}
