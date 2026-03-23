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
  private JsonNullable<String> redirectUrl;

  @JsonIgnore
  public String getRedirectUrl() {
    return redirectUrl.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class SlackFinishInstallResponseBuilder {

    private JsonNullable<String> redirectUrl = JsonNullable.undefined();

    @JsonProperty("redirect_url")
    public SlackFinishInstallResponseBuilder redirectUrl(String value) {
      if (value == null) {
        throw new IllegalStateException("redirectUrl cannot be null");
      }
      this.redirectUrl = JsonNullable.of(value);
      return this;
    }
  }
}
