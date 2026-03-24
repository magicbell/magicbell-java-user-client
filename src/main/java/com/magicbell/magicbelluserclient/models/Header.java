package com.magicbell.magicbelluserclient.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

/**
 * Header styling for the inbox modal.
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class Header {

  /**
   * Header background color.
   */
  @NonNull
  private String backgroundColor;

  /**
   * Border radius applied to the header container.
   */
  @NonNull
  private String borderRadius;

  /**
   * CSS font family for the header title.
   */
  @NonNull
  private String fontFamily;

  /**
   * Font size used in the header.
   */
  @NonNull
  private String fontSize;

  /**
   * Header text color.
   */
  @NonNull
  private String textColor;
}
