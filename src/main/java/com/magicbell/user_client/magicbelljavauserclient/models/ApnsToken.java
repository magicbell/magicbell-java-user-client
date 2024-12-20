package com.magicbell.user_client.magicbelljavauserclient.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class ApnsToken {

  @NonNull
  @JsonProperty("device_token")
  private String deviceToken;

  /**
   * (Optional) The bundle identifier of the application that is registering this token. Use this field to override the default identifier specified in the projects APNs integration.
   */
  @JsonProperty("app_id")
  private String appId;

  /**
   * (Optional) The APNs environment the token is registered for. If none is provided we assume the token is used in `production`.
   */
  @JsonProperty("installation_id")
  private ApnsTokenInstallationId installationId;
}
