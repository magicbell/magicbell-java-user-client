package com.magicbell.magicbelluserclient.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

/**
 * Obtained directly from the incoming_webhook object in the installation response from the Slack API.
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class SlackTokenWebhook {

  @NonNull
  private String url;
}
