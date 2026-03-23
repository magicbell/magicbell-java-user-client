package com.magicbell.magicbelluserclient.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
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
public class SlackToken {

  /**
   * The timestamp when the token was created.
   */
  @NonNull
  @JsonProperty("created_at")
  private String createdAt;

  /**
   * The unique identifier for the token.
   */
  @NonNull
  private String id;

  /**
   * The timestamp when the token was discarded, if applicable.
   */
  @JsonProperty("discarded_at")
  private JsonNullable<String> discardedAt;

  @JsonProperty("oauth")
  private JsonNullable<SlackTokenOauth> oauth;

  /**
   * The timestamp when the token metadata last changed.
   */
  @JsonProperty("updated_at")
  private JsonNullable<String> updatedAt;

  /**
   * Obtained directly from the incoming_webhook object in the installation response from the Slack API.
   */
  @JsonProperty("webhook")
  private JsonNullable<SlackTokenWebhook> webhook;

  @JsonIgnore
  public String getDiscardedAt() {
    return discardedAt.orElse(null);
  }

  @JsonIgnore
  public SlackTokenOauth getOauth() {
    return oauth.orElse(null);
  }

  @JsonIgnore
  public String getUpdatedAt() {
    return updatedAt.orElse(null);
  }

  @JsonIgnore
  public SlackTokenWebhook getWebhook() {
    return webhook.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class SlackTokenBuilder {

    private JsonNullable<String> discardedAt = JsonNullable.undefined();

    @JsonProperty("discarded_at")
    public SlackTokenBuilder discardedAt(String value) {
      this.discardedAt = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<SlackTokenOauth> oauth = JsonNullable.undefined();

    @JsonProperty("oauth")
    public SlackTokenBuilder oauth(SlackTokenOauth value) {
      if (value == null) {
        throw new IllegalStateException("oauth cannot be null");
      }
      this.oauth = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> updatedAt = JsonNullable.undefined();

    @JsonProperty("updated_at")
    public SlackTokenBuilder updatedAt(String value) {
      this.updatedAt = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<SlackTokenWebhook> webhook = JsonNullable.undefined();

    @JsonProperty("webhook")
    public SlackTokenBuilder webhook(SlackTokenWebhook value) {
      if (value == null) {
        throw new IllegalStateException("webhook cannot be null");
      }
      this.webhook = JsonNullable.of(value);
      return this;
    }
  }
}
