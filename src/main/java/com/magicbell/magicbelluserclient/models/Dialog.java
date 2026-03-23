package com.magicbell.magicbelluserclient.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

/**
 * Styling for confirmation and action dialogs.
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class Dialog {

  /**
   * Accent color for dialog buttons and highlights.
   */
  @NonNull
  private String accentColor;

  /**
   * Dialog background color.
   */
  @NonNull
  private String backgroundColor;

  /**
   * Dialog text color.
   */
  @NonNull
  private String textColor;
}
