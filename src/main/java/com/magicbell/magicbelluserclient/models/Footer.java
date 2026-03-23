package com.magicbell.magicbelluserclient.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

/**
 * Footer styling for the inbox modal.
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class Footer {

  /**
   * Footer background color.
   */
  @NonNull
  private String backgroundColor;

  /**
   * Border radius applied to the footer container.
   */
  @NonNull
  private String borderRadius;

  /**
   * Font size used in the footer.
   */
  @NonNull
  private String fontSize;

  /**
   * Footer text color.
   */
  @NonNull
  private String textColor;
}
