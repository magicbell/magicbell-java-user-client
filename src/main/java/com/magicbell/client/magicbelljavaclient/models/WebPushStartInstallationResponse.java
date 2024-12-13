package com.magicbell.client.magicbelljavaclient.models;

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
public class WebPushStartInstallationResponse {

  @NonNull
  @JsonProperty("auth_token")
  private String authToken;

  @NonNull
  @JsonProperty("public_key")
  private String publicKey;
}
