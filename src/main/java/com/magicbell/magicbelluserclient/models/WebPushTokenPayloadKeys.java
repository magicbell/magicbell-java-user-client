package com.magicbell.magicbelluserclient.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

/**
 * The encryption keys from the PushSubscription.getKey() method, needed to encrypt push messages for this subscription.
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class WebPushTokenPayloadKeys {

  /**
   * The authentication secret obtained from PushSubscription.getKey('auth'). Used to encrypt push messages for this subscription.
   */
  @NonNull
  private String auth;

  /**
   * The P-256 ECDH public key obtained from PushSubscription.getKey('p256dh'). Used to encrypt push messages for this subscription.
   */
  @NonNull
  private String p256dh;
}
