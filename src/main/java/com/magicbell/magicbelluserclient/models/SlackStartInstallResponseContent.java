package com.magicbell.magicbelluserclient.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
public class SlackStartInstallResponseContent {

  @JsonProperty("app_id")
  private JsonNullable<String> appId;

  @JsonProperty("auth_url")
  private JsonNullable<String> authUrl;

  @JsonProperty("scopes")
  private JsonNullable<List<String>> scopes;

  @JsonIgnore
  public String getAppId() {
    return appId.orElse(null);
  }

  @JsonIgnore
  public String getAuthUrl() {
    return authUrl.orElse(null);
  }

  @JsonIgnore
  public List<String> getScopes() {
    return scopes.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class SlackStartInstallResponseContentBuilder {

    private JsonNullable<String> appId = JsonNullable.undefined();

    @JsonProperty("app_id")
    public SlackStartInstallResponseContentBuilder appId(String value) {
      if (value == null) {
        throw new IllegalStateException("appId cannot be null");
      }
      this.appId = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> authUrl = JsonNullable.undefined();

    @JsonProperty("auth_url")
    public SlackStartInstallResponseContentBuilder authUrl(String value) {
      if (value == null) {
        throw new IllegalStateException("authUrl cannot be null");
      }
      this.authUrl = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<List<String>> scopes = JsonNullable.undefined();

    @JsonProperty("scopes")
    public SlackStartInstallResponseContentBuilder scopes(List<String> value) {
      if (value == null) {
        throw new IllegalStateException("scopes cannot be null");
      }
      this.scopes = JsonNullable.of(value);
      return this;
    }
  }
}
