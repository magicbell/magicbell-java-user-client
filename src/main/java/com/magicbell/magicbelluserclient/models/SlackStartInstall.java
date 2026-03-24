package com.magicbell.magicbelluserclient.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
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
public class SlackStartInstall {

  /**
   * Slack app ID that the installation flow should use.
   */
  @NonNull
  @JsonProperty("app_id")
  private String appId;

  /**
   * Optional override for the authorization URL returned to the client.
   */
  @JsonProperty("auth_url")
  private JsonNullable<String> authUrl;

  /**
   * Additional OAuth scopes to request during installation.
   */
  @JsonProperty("extra_scopes")
  private JsonNullable<List<String>> extraScopes;

  /**
   * Custom redirect URL to use after OAuth completes.
   */
  @JsonProperty("redirect_url")
  private JsonNullable<String> redirectUrl;

  @JsonIgnore
  public String getAuthUrl() {
    return authUrl.orElse(null);
  }

  @JsonIgnore
  public List<String> getExtraScopes() {
    return extraScopes.orElse(null);
  }

  @JsonIgnore
  public String getRedirectUrl() {
    return redirectUrl.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class SlackStartInstallBuilder {

    private JsonNullable<String> authUrl = JsonNullable.undefined();

    @JsonProperty("auth_url")
    public SlackStartInstallBuilder authUrl(String value) {
      if (value == null) {
        throw new IllegalStateException("authUrl cannot be null");
      }
      this.authUrl = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<List<String>> extraScopes = JsonNullable.undefined();

    @JsonProperty("extra_scopes")
    public SlackStartInstallBuilder extraScopes(List<String> value) {
      if (value == null) {
        throw new IllegalStateException("extraScopes cannot be null");
      }
      this.extraScopes = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> redirectUrl = JsonNullable.undefined();

    @JsonProperty("redirect_url")
    public SlackStartInstallBuilder redirectUrl(String value) {
      if (value == null) {
        throw new IllegalStateException("redirectUrl cannot be null");
      }
      this.redirectUrl = JsonNullable.of(value);
      return this;
    }
  }
}
