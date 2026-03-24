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
public class InboxConfigPayload {

  /**
   * Image overrides for assets used in the inbox UI.
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  private Images images;

  /**
   * Locale code (ISO language tag) used to localize built-in strings.
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  private String locale;

  /**
   * Visual customization options for the hosted inbox widget.
   */
  @JsonInclude(JsonInclude.Include.ALWAYS)
  private Theme theme;

  // Overwrite lombok builder methods
  public static class InboxConfigPayloadBuilder {

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

    public InboxConfigPayloadBuilder images(Images images) {
      this.images$set = true;
      this.images = images;
      return this;
    }

    public InboxConfigPayloadBuilder locale(String locale) {
      this.locale$set = true;
      this.locale = locale;
      return this;
    }

    public InboxConfigPayloadBuilder theme(Theme theme) {
      this.theme$set = true;
      this.theme = theme;
      return this;
    }

    public InboxConfigPayload build() {
      if (!images$set) {
        throw new IllegalStateException("images is required");
      }
      if (!locale$set) {
        throw new IllegalStateException("locale is required");
      }
      if (!theme$set) {
        throw new IllegalStateException("theme is required");
      }
      return new InboxConfigPayload(images, locale, theme);
    }
  }
}
