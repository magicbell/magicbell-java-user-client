package com.magicbell.magicbelluserclient.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
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
public class SlackStartInstall {

  @NonNull
  @JsonProperty("app_id")
  private String appId;

  @JsonProperty("auth_url")
  private String authUrl;

  @JsonProperty("extra_scopes")
  private List<String> extraScopes;

  @JsonProperty("redirect_url")
  private String redirectUrl;
}
