package com.magicbell.user_client.magicbelljavauserclient.models;

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
public class SlackToken {

  private Oauth oauth;

  private SlackTokenWebhook webhook;
}
