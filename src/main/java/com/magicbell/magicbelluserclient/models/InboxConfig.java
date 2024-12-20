package com.magicbell.magicbelluserclient.models;

import com.fasterxml.jackson.annotation.JsonInclude;
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
public class InboxConfig {

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private Images images;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private String locale;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private Theme theme;

  // Overwrite lombok builder methods
  public static class InboxConfigBuilder {

    /**
     * Flag to track if the images property has been set.
     */
    private boolean wasImagesSet = false;

    /**
     * Flag to track if the locale property has been set.
     */
    private boolean wasLocaleSet = false;

    /**
     * Flag to track if the theme property has been set.
     */
    private boolean wasThemeSet = false;

    public InboxConfigBuilder images(Images images) {
      this.wasImagesSet = true;
      this.images = images;
      return this;
    }

    public InboxConfigBuilder locale(String locale) {
      this.wasLocaleSet = true;
      this.locale = locale;
      return this;
    }

    public InboxConfigBuilder theme(Theme theme) {
      this.wasThemeSet = true;
      this.theme = theme;
      return this;
    }

    public InboxConfig build() {
      if (!wasImagesSet) {
        throw new IllegalStateException("images is required");
      }
      if (!wasLocaleSet) {
        throw new IllegalStateException("locale is required");
      }
      if (!wasThemeSet) {
        throw new IllegalStateException("theme is required");
      }
      return new InboxConfig(images, locale, theme);
    }
  }
}
