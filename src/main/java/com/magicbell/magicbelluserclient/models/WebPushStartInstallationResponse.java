package com.magicbell.magicbelluserclient.models;

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

  /**
   * Auth secret returned from PushSubscription.getKey('auth').
   */
  @NonNull
  @JsonProperty("auth_token")
  private String authToken;

  /**
   * VAPID public key generated for this web push installation.
   */
  @NonNull
  @JsonProperty("public_key")
  private String publicKey;
}
