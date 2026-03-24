package com.magicbell.magicbelluserclient.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

/**
 * Hover styles for unread notifications.
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class UnreadHover {

  /**
   * Background color on hover for unread notifications.
   */
  @NonNull
  private String backgroundColor;
}
