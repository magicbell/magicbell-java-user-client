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
public class DiscardResult {

  /**
   * The timestamp when the token was discarded.
   */
  @JsonProperty("discarded_at")
  private JsonNullable<String> discardedAt;

  /**
   * The unique identifier for the discarded token.
   */
  @JsonProperty("id")
  private JsonNullable<String> id;

  @JsonIgnore
  public String getDiscardedAt() {
    return discardedAt.orElse(null);
  }

  @JsonIgnore
  public String getId() {
    return id.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class DiscardResultBuilder {

    private JsonNullable<String> discardedAt = JsonNullable.undefined();

    @JsonProperty("discarded_at")
    public DiscardResultBuilder discardedAt(String value) {
      if (value == null) {
        throw new IllegalStateException("discardedAt cannot be null");
      }
      this.discardedAt = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> id = JsonNullable.undefined();

    @JsonProperty("id")
    public DiscardResultBuilder id(String value) {
      if (value == null) {
        throw new IllegalStateException("id cannot be null");
      }
      this.id = JsonNullable.of(value);
      return this;
    }
  }
}
