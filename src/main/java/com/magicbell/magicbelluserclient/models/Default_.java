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
 * Base styles applied to every notification item.
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class Default_ {

  /**
   * Background color for notifications in their default state.
   */
  @NonNull
  private String backgroundColor;

  /**
   * Border radius applied to each notification card.
   */
  @NonNull
  private String borderRadius;

  /**
   * Font family for notification text.
   */
  @NonNull
  private String fontFamily;

  /**
   * Font size for notification text.
   */
  @NonNull
  private String fontSize;

  /**
   * CSS margin applied around each notification card.
   */
  @NonNull
  private String margin;

  /**
   * Default text color for notifications.
   */
  @NonNull
  private String textColor;

  /**
   * Styles applied when a notification is hovered.
   */
  @JsonProperty("hover")
  private JsonNullable<DefaultHover> hover;

  /**
   * Accent colors for notification state indicators.
   */
  @JsonProperty("state")
  private JsonNullable<DefaultState> state;

  @JsonIgnore
  public DefaultHover getHover() {
    return hover.orElse(null);
  }

  @JsonIgnore
  public DefaultState getState() {
    return state.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class Default_Builder {

    private JsonNullable<DefaultHover> hover = JsonNullable.undefined();

    @JsonProperty("hover")
    public Default_Builder hover(DefaultHover value) {
      if (value == null) {
        throw new IllegalStateException("hover cannot be null");
      }
      this.hover = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<DefaultState> state = JsonNullable.undefined();

    @JsonProperty("state")
    public Default_Builder state(DefaultState value) {
      if (value == null) {
        throw new IllegalStateException("state cannot be null");
      }
      this.state = JsonNullable.of(value);
      return this;
    }
  }
}
