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

/**
 * Overrides for unseen notifications.
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class Unseen {

  /**
   * Background color applied to unseen notifications.
   */
  @NonNull
  private String backgroundColor;

  /**
   * Text color used when a notification is unseen.
   */
  @NonNull
  private String textColor;

  /**
   * Hover styles for unseen notifications.
   */
  @JsonProperty("hover")
  private JsonNullable<UnseenHover> hover;

  /**
   * State indicator styling for unseen notifications.
   */
  @JsonProperty("state")
  private JsonNullable<UnseenState> state;

  @JsonIgnore
  public UnseenHover getHover() {
    return hover.orElse(null);
  }

  @JsonIgnore
  public UnseenState getState() {
    return state.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class UnseenBuilder {

    private JsonNullable<UnseenHover> hover = JsonNullable.undefined();

    @JsonProperty("hover")
    public UnseenBuilder hover(UnseenHover value) {
      if (value == null) {
        throw new IllegalStateException("hover cannot be null");
      }
      this.hover = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<UnseenState> state = JsonNullable.undefined();

    @JsonProperty("state")
    public UnseenBuilder state(UnseenState value) {
      if (value == null) {
        throw new IllegalStateException("state cannot be null");
      }
      this.state = JsonNullable.of(value);
      return this;
    }
  }
}
