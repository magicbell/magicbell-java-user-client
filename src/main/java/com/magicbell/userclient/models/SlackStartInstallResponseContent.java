package com.magicbell.userclient.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class SlackStartInstallResponseContent {

  @JsonProperty("app_id")
  private String appId;

  @JsonProperty("auth_url")
  private String authUrl;

  private List<String> scopes;
}
