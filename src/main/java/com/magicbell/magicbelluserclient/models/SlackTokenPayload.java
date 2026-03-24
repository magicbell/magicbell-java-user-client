package com.magicbell.magicbelluserclient.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;
import org.openapitools.jackson.nullable.JsonNullable;

@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class SlackTokenPayload {

  @JsonProperty("oauth")
  private JsonNullable<SlackTokenPayloadOauth> oauth;

  /**
   * Obtained directly from the incoming_webhook object in the installation response from the Slack API.
   */
  @JsonProperty("webhook")
  private JsonNullable<SlackTokenPayloadWebhook> webhook;

  @JsonIgnore
  public SlackTokenPayloadOauth getOauth() {
    return oauth.orElse(null);
  }

  @JsonIgnore
  public SlackTokenPayloadWebhook getWebhook() {
    return webhook.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class SlackTokenPayloadBuilder {

    private JsonNullable<SlackTokenPayloadOauth> oauth = JsonNullable.undefined();

    @JsonProperty("oauth")
    public SlackTokenPayloadBuilder oauth(SlackTokenPayloadOauth value) {
      if (value == null) {
        throw new IllegalStateException("oauth cannot be null");
      }
      this.oauth = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<SlackTokenPayloadWebhook> webhook = JsonNullable.undefined();

    @JsonProperty("webhook")
    public SlackTokenPayloadBuilder webhook(SlackTokenPayloadWebhook value) {
      if (value == null) {
        throw new IllegalStateException("webhook cannot be null");
      }
      this.webhook = JsonNullable.of(value);
      return this;
    }
  }
}
