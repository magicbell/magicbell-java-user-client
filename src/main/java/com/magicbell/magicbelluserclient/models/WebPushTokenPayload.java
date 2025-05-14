package com.magicbell.magicbelluserclient.models;

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
public class WebPushTokenPayload {

  /**
   * The push subscription URL obtained from PushSubscription.endpoint after calling registration.pushManager.subscribe(). This is the unique URL for this device that push messages will be sent to.
   */
  @NonNull
  private String endpoint;

  /**
   * The encryption keys from the PushSubscription.getKey() method, needed to encrypt push messages for this subscription.
   */
  @NonNull
  private WebPushTokenPayloadKeys keys;
}
