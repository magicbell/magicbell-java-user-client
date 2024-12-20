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
public class SlackFinishInstallResponse {

  @NonNull
  @JsonProperty("app_id")
  private String appId;

  @NonNull
  private String code;

  @JsonProperty("redirect_url")
  private String redirectUrl;
}
