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
public class TeamsToken {

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

  /**
   * The timestamp when the token metadata last changed.
   */
  @JsonProperty("updated_at")
  private JsonNullable<String> updatedAt;

  @JsonProperty("webhook")
  private JsonNullable<TeamsTokenWebhook> webhook;

  @JsonIgnore
  public String getDiscardedAt() {
    return discardedAt.orElse(null);
  }

  @JsonIgnore
  public String getUpdatedAt() {
    return updatedAt.orElse(null);
  }

  @JsonIgnore
  public TeamsTokenWebhook getWebhook() {
    return webhook.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class TeamsTokenBuilder {

    private JsonNullable<String> discardedAt = JsonNullable.undefined();

    @JsonProperty("discarded_at")
    public TeamsTokenBuilder discardedAt(String value) {
      this.discardedAt = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> updatedAt = JsonNullable.undefined();

    @JsonProperty("updated_at")
    public TeamsTokenBuilder updatedAt(String value) {
      this.updatedAt = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<TeamsTokenWebhook> webhook = JsonNullable.undefined();

    @JsonProperty("webhook")
    public TeamsTokenBuilder webhook(TeamsTokenWebhook value) {
      if (value == null) {
        throw new IllegalStateException("webhook cannot be null");
      }
      this.webhook = JsonNullable.of(value);
      return this;
    }
  }
}
