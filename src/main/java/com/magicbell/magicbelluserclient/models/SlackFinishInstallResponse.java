package com.magicbell.magicbelluserclient.models;

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
public class SlackFinishInstallResponse {

  /**
   * The app ID of the Slack app that was originally configured at the project-level.
   */
  @NonNull
  @JsonProperty("app_id")
  private String appId;

  /**
   * The code that was returned from the OAuth flow, and found in the query string of the redirect URL.
   */
  @NonNull
  private String code;

  @JsonProperty("redirect_url")
  private String redirectUrl;
}
