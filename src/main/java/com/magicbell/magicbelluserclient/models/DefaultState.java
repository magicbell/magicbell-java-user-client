package com.magicbell.magicbelluserclient.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

/**
 * Accent colors for notification state indicators.
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class DefaultState {

  /**
   * Color used for the state indicator.
   */
  @NonNull
  private String color;
}
