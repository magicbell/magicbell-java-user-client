package com.magicbell.userclient.models;

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
public class SlackInstallation {

  @NonNull
  @JsonProperty("access_token")
  private String accessToken;

  @NonNull
  @JsonProperty("app_id")
  private String appId;

  @NonNull
  @JsonProperty("authed_user")
  private AuthedUser authedUser;

  @NonNull
  private Team team;

  @JsonProperty("bot_user_id")
  private String botUserId;

  private Enterprise enterprise;

  @JsonProperty("expires_in")
  private Long expiresIn;

  private String id;

  @JsonProperty("incoming_webhook")
  private IncomingWebhook incomingWebhook;

  @JsonProperty("is_enterprise_install")
  private Boolean isEnterpriseInstall;

  @JsonProperty("refresh_token")
  private String refreshToken;

  private String scope;

  @JsonProperty("token_type")
  private String tokenType;
}
