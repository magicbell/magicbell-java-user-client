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
public class SlackInstallation {

  /**
   * Bot token returned from the Slack OAuth exchange.
   */
  @NonNull
  @JsonProperty("access_token")
  private String accessToken;

  /**
   * Slack app identifier for the installed app.
   */
  @NonNull
  @JsonProperty("app_id")
  private String appId;

  @NonNull
  @JsonProperty("authed_user")
  private AuthedUser authedUser;

  @NonNull
  private Team team;

  /**
   * Slack user ID of the installed bot.
   */
  @JsonProperty("bot_user_id")
  private JsonNullable<String> botUserId;

  @JsonProperty("enterprise")
  private JsonNullable<Enterprise> enterprise;

  /**
   * Seconds until the bot access token expires.
   */
  @JsonProperty("expires_in")
  private JsonNullable<Long> expiresIn;

  /**
   * Unique identifier MagicBell assigns to the Slack installation.
   */
  @JsonProperty("id")
  private JsonNullable<String> id;

  @JsonProperty("incoming_webhook")
  private JsonNullable<IncomingWebhook> incomingWebhook;

  /**
   * Indicates whether the installation occurred on an enterprise grid.
   */
  @JsonProperty("is_enterprise_install")
  private JsonNullable<Boolean> isEnterpriseInstall;

  /**
   * Refresh token for regenerating the bot access token.
   */
  @JsonProperty("refresh_token")
  private JsonNullable<String> refreshToken;

  /**
   * Space-delimited OAuth scopes granted to the bot token.
   */
  @JsonProperty("scope")
  private JsonNullable<String> scope;

  /**
   * Type of bot token returned by Slack.
   */
  @JsonProperty("token_type")
  private JsonNullable<String> tokenType;

  @JsonIgnore
  public String getBotUserId() {
    return botUserId.orElse(null);
  }

  @JsonIgnore
  public Enterprise getEnterprise() {
    return enterprise.orElse(null);
  }

  @JsonIgnore
  public Long getExpiresIn() {
    return expiresIn.orElse(null);
  }

  @JsonIgnore
  public String getId() {
    return id.orElse(null);
  }

  @JsonIgnore
  public IncomingWebhook getIncomingWebhook() {
    return incomingWebhook.orElse(null);
  }

  @JsonIgnore
  public Boolean getIsEnterpriseInstall() {
    return isEnterpriseInstall.orElse(null);
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
  public static class SlackInstallationBuilder {

    private JsonNullable<String> botUserId = JsonNullable.undefined();

    @JsonProperty("bot_user_id")
    public SlackInstallationBuilder botUserId(String value) {
      if (value == null) {
        throw new IllegalStateException("botUserId cannot be null");
      }
      this.botUserId = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Enterprise> enterprise = JsonNullable.undefined();

    @JsonProperty("enterprise")
    public SlackInstallationBuilder enterprise(Enterprise value) {
      if (value == null) {
        throw new IllegalStateException("enterprise cannot be null");
      }
      this.enterprise = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> expiresIn = JsonNullable.undefined();

    @JsonProperty("expires_in")
    public SlackInstallationBuilder expiresIn(Long value) {
      if (value == null) {
        throw new IllegalStateException("expiresIn cannot be null");
      }
      this.expiresIn = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> id = JsonNullable.undefined();

    @JsonProperty("id")
    public SlackInstallationBuilder id(String value) {
      if (value == null) {
        throw new IllegalStateException("id cannot be null");
      }
      this.id = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<IncomingWebhook> incomingWebhook = JsonNullable.undefined();

    @JsonProperty("incoming_webhook")
    public SlackInstallationBuilder incomingWebhook(IncomingWebhook value) {
      if (value == null) {
        throw new IllegalStateException("incomingWebhook cannot be null");
      }
      this.incomingWebhook = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Boolean> isEnterpriseInstall = JsonNullable.undefined();

    @JsonProperty("is_enterprise_install")
    public SlackInstallationBuilder isEnterpriseInstall(Boolean value) {
      if (value == null) {
        throw new IllegalStateException("isEnterpriseInstall cannot be null");
      }
      this.isEnterpriseInstall = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> refreshToken = JsonNullable.undefined();

    @JsonProperty("refresh_token")
    public SlackInstallationBuilder refreshToken(String value) {
      if (value == null) {
        throw new IllegalStateException("refreshToken cannot be null");
      }
      this.refreshToken = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> scope = JsonNullable.undefined();

    @JsonProperty("scope")
    public SlackInstallationBuilder scope(String value) {
      if (value == null) {
        throw new IllegalStateException("scope cannot be null");
      }
      this.scope = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> tokenType = JsonNullable.undefined();

    @JsonProperty("token_type")
    public SlackInstallationBuilder tokenType(String value) {
      if (value == null) {
        throw new IllegalStateException("tokenType cannot be null");
      }
      this.tokenType = JsonNullable.of(value);
      return this;
    }
  }
}
