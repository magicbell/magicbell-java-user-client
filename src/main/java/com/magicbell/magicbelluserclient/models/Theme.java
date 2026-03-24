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

/**
 * Visual customization options for the hosted inbox widget.
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class Theme {

  /**
   * Top banner styling options.
   */
  @JsonProperty("banner")
  private JsonNullable<Banner> banner;

  /**
   * Styling for confirmation and action dialogs.
   */
  @JsonProperty("dialog")
  private JsonNullable<Dialog> dialog;

  /**
   * Footer styling for the inbox modal.
   */
  @JsonProperty("footer")
  private JsonNullable<Footer> footer;

  /**
   * Header styling for the inbox modal.
   */
  @JsonProperty("header")
  private JsonNullable<Header> header;

  /**
   * Launcher icon styling overrides.
   */
  @JsonProperty("icon")
  private JsonNullable<Icon> icon;

  /**
   * Styling overrides for notification list items.
   */
  @JsonProperty("notification")
  private JsonNullable<ThemeNotification> notification;

  /**
   * Badge styling for unseen notification counts.
   */
  @JsonProperty("unseenBadge")
  private JsonNullable<UnseenBadge> unseenBadge;

  @JsonIgnore
  public Banner getBanner() {
    return banner.orElse(null);
  }

  @JsonIgnore
  public Dialog getDialog() {
    return dialog.orElse(null);
  }

  @JsonIgnore
  public Footer getFooter() {
    return footer.orElse(null);
  }

  @JsonIgnore
  public Header getHeader() {
    return header.orElse(null);
  }

  @JsonIgnore
  public Icon getIcon() {
    return icon.orElse(null);
  }

  @JsonIgnore
  public ThemeNotification getNotification() {
    return notification.orElse(null);
  }

  @JsonIgnore
  public UnseenBadge getUnseenBadge() {
    return unseenBadge.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class ThemeBuilder {

    private JsonNullable<Banner> banner = JsonNullable.undefined();

    @JsonProperty("banner")
    public ThemeBuilder banner(Banner value) {
      if (value == null) {
        throw new IllegalStateException("banner cannot be null");
      }
      this.banner = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Dialog> dialog = JsonNullable.undefined();

    @JsonProperty("dialog")
    public ThemeBuilder dialog(Dialog value) {
      if (value == null) {
        throw new IllegalStateException("dialog cannot be null");
      }
      this.dialog = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Footer> footer = JsonNullable.undefined();

    @JsonProperty("footer")
    public ThemeBuilder footer(Footer value) {
      if (value == null) {
        throw new IllegalStateException("footer cannot be null");
      }
      this.footer = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Header> header = JsonNullable.undefined();

    @JsonProperty("header")
    public ThemeBuilder header(Header value) {
      if (value == null) {
        throw new IllegalStateException("header cannot be null");
      }
      this.header = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Icon> icon = JsonNullable.undefined();

    @JsonProperty("icon")
    public ThemeBuilder icon(Icon value) {
      if (value == null) {
        throw new IllegalStateException("icon cannot be null");
      }
      this.icon = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<ThemeNotification> notification = JsonNullable.undefined();

    @JsonProperty("notification")
    public ThemeBuilder notification(ThemeNotification value) {
      if (value == null) {
        throw new IllegalStateException("notification cannot be null");
      }
      this.notification = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<UnseenBadge> unseenBadge = JsonNullable.undefined();

    @JsonProperty("unseenBadge")
    public ThemeBuilder unseenBadge(UnseenBadge value) {
      if (value == null) {
        throw new IllegalStateException("unseenBadge cannot be null");
      }
      this.unseenBadge = JsonNullable.of(value);
      return this;
    }
  }
}
