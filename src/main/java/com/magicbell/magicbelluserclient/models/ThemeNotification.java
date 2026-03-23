package com.magicbell.magicbelluserclient.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

/**
 * Styling overrides for notification list items.
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class ThemeNotification {

  /**
   * Base styles applied to every notification item.
   */
  @NonNull
  @JsonProperty("default")
  private Default_ default_;

  /**
   * Overrides for unread notifications.
   */
  @NonNull
  private Unread unread;

  /**
   * Overrides for unseen notifications.
   */
  @NonNull
  private Unseen unseen;
}
