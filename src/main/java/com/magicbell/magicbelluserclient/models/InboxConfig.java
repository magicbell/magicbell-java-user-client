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
    private boolean images$set = false;

    /**
     * Flag to track if the locale property has been set.
     */
    private boolean locale$set = false;

    /**
     * Flag to track if the theme property has been set.
     */
    private boolean theme$set = false;

    public InboxConfigBuilder images(Images images) {
      this.images$set = true;
      this.images = images;
      return this;
    }

    public InboxConfigBuilder locale(String locale) {
      this.locale$set = true;
      this.locale = locale;
      return this;
    }

    public InboxConfigBuilder theme(Theme theme) {
      this.theme$set = true;
      this.theme = theme;
      return this;
    }

    public InboxConfig build() {
      if (!images$set) {
        throw new IllegalStateException("images is required");
      }
      if (!locale$set) {
        throw new IllegalStateException("locale is required");
      }
      if (!theme$set) {
        throw new IllegalStateException("theme is required");
      }
      return new InboxConfig(images, locale, theme);
    }
  }
}
