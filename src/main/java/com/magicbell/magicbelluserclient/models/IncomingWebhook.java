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
public class IncomingWebhook {

  /**
   * Human readable name for the webhook channel.
   */
  @NonNull
  private String channel;

  /**
   * URL users can visit to manage the webhook.
   */
  @NonNull
  @JsonProperty("configuration_url")
  private String configurationUrl;

  /**
   * Webhook URL that Slack posts events to.
   */
  @NonNull
  private String url;
}
