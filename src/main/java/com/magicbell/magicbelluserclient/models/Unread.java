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
 * Overrides for unread notifications.
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class Unread {

  /**
   * Background color applied to unread notifications.
   */
  @NonNull
  private String backgroundColor;

  /**
   * Text color used when a notification is unread.
   */
  @NonNull
  private String textColor;

  /**
   * Hover styles for unread notifications.
   */
  @JsonProperty("hover")
  private JsonNullable<UnreadHover> hover;

  /**
   * State indicator styling for unread notifications.
   */
  @JsonProperty("state")
  private JsonNullable<UnreadState> state;

  @JsonIgnore
  public UnreadHover getHover() {
    return hover.orElse(null);
  }

  @JsonIgnore
  public UnreadState getState() {
    return state.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class UnreadBuilder {

    private JsonNullable<UnreadHover> hover = JsonNullable.undefined();

    @JsonProperty("hover")
    public UnreadBuilder hover(UnreadHover value) {
      if (value == null) {
        throw new IllegalStateException("hover cannot be null");
      }
      this.hover = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<UnreadState> state = JsonNullable.undefined();

    @JsonProperty("state")
    public UnreadBuilder state(UnreadState value) {
      if (value == null) {
        throw new IllegalStateException("state cannot be null");
      }
      this.state = JsonNullable.of(value);
      return this;
    }
  }
}
