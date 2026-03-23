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
public class AuthedUser {

  /**
   * Slack user ID for the installer.
   */
  @NonNull
  private String id;

  /**
   * User token returned from the OAuth exchange.
   */
  @JsonProperty("access_token")
  private JsonNullable<String> accessToken;

  /**
   * Seconds until the user token expires.
   */
  @JsonProperty("expires_in")
  private JsonNullable<Long> expiresIn;

  /**
   * Refresh token for the authed user.
   */
  @JsonProperty("refresh_token")
  private JsonNullable<String> refreshToken;

  /**
   * Space-delimited OAuth scopes granted to the user token.
   */
  @JsonProperty("scope")
  private JsonNullable<String> scope;

  /**
   * Token type value provided by Slack.
   */
  @JsonProperty("token_type")
  private JsonNullable<String> tokenType;

  @JsonIgnore
  public String getAccessToken() {
    return accessToken.orElse(null);
  }

  @JsonIgnore
  public Long getExpiresIn() {
    return expiresIn.orElse(null);
  }

  @JsonIgnore
  public String getRefreshToken() {
    return refreshToken.orElse(null);
  }

  @JsonIgnore
  public String getScope() {
    return scope.orElse(null);
  }

  @JsonIgnore
  public String getTokenType() {
    return tokenType.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class AuthedUserBuilder {

    private JsonNullable<String> accessToken = JsonNullable.undefined();

    @JsonProperty("access_token")
    public AuthedUserBuilder accessToken(String value) {
      if (value == null) {
        throw new IllegalStateException("accessToken cannot be null");
      }
      this.accessToken = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> expiresIn = JsonNullable.undefined();

    @JsonProperty("expires_in")
    public AuthedUserBuilder expiresIn(Long value) {
      if (value == null) {
        throw new IllegalStateException("expiresIn cannot be null");
      }
      this.expiresIn = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> refreshToken = JsonNullable.undefined();

    @JsonProperty("refresh_token")
    public AuthedUserBuilder refreshToken(String value) {
      if (value == null) {
        throw new IllegalStateException("refreshToken cannot be null");
      }
      this.refreshToken = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> scope = JsonNullable.undefined();

    @JsonProperty("scope")
    public AuthedUserBuilder scope(String value) {
      if (value == null) {
        throw new IllegalStateException("scope cannot be null");
      }
      this.scope = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> tokenType = JsonNullable.undefined();

    @JsonProperty("token_type")
    public AuthedUserBuilder tokenType(String value) {
      if (value == null) {
        throw new IllegalStateException("tokenType cannot be null");
      }
      this.tokenType = JsonNullable.of(value);
      return this;
    }
  }
}
