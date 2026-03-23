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
public class TeamsTokenPayload {

  @JsonProperty("webhook")
  private JsonNullable<TeamsTokenPayloadWebhook> webhook;

  @JsonIgnore
  public TeamsTokenPayloadWebhook getWebhook() {
    return webhook.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class TeamsTokenPayloadBuilder {

    private JsonNullable<TeamsTokenPayloadWebhook> webhook = JsonNullable.undefined();

    @JsonProperty("webhook")
    public TeamsTokenPayloadBuilder webhook(TeamsTokenPayloadWebhook value) {
      if (value == null) {
        throw new IllegalStateException("webhook cannot be null");
      }
      this.webhook = JsonNullable.of(value);
      return this;
    }
  }
}
