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
 * Top banner styling options.
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class Banner {

  /**
   * Banner background color.
   */
  @NonNull
  private String backgroundColor;

  /**
   * Font size for banner text.
   */
  @NonNull
  private String fontSize;

  /**
   * Banner text color.
   */
  @NonNull
  private String textColor;

  /**
   * Opacity applied to the banner background.
   */
  @JsonProperty("backgroundOpacity")
  private JsonNullable<Double> backgroundOpacity;

  @JsonIgnore
  public Double getBackgroundOpacity() {
    return backgroundOpacity.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class BannerBuilder {

    private JsonNullable<Double> backgroundOpacity = JsonNullable.undefined();

    @JsonProperty("backgroundOpacity")
    public BannerBuilder backgroundOpacity(Double value) {
      if (value == null) {
        throw new IllegalStateException("backgroundOpacity cannot be null");
      }
      this.backgroundOpacity = JsonNullable.of(value);
      return this;
    }
  }
}
