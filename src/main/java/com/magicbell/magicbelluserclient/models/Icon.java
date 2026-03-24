package com.magicbell.magicbelluserclient.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

/**
 * Launcher icon styling overrides.
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class Icon {

  /**
   * CSS color used for the icon border.
   */
  @NonNull
  private String borderColor;

  /**
   * Width of the launcher icon (any CSS length).
   */
  @NonNull
  private String width;
}
