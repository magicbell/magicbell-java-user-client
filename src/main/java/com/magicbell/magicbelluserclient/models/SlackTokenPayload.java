package com.magicbell.magicbelluserclient.models;

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
public class SlackTokenPayload {

  private SlackTokenPayloadOauth oauth;

  /**
   * Obtained directly from the incoming_webhook object in the installation response from the Slack API.
   */
  private SlackTokenPayloadWebhook webhook;
}
