package com.magicbell.magicbelluserclient.models;

import com.fasterxml.jackson.annotation.JsonInclude;
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
public class WebPushToken {

  @NonNull
  @JsonProperty("created_at")
  private String createdAt;

  /**
   * The push subscription URL obtained from PushSubscription.endpoint after calling registration.pushManager.subscribe(). This is the unique URL for this device that push messages will be sent to.
   */
  @NonNull
  private String endpoint;

  @NonNull
  private String id;

  /**
   * The encryption keys from the PushSubscription.getKey() method, needed to encrypt push messages for this subscription.
   */
  @NonNull
  private WebPushTokenKeys keys;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("discarded_at")
  private String discardedAt;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("updated_at")
  private String updatedAt;
}
