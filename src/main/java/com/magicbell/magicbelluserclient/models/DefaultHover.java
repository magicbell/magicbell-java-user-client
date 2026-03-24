package com.magicbell.magicbelluserclient.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

/**
 * Styles applied when a notification is hovered.
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class DefaultHover {

  /**
   * Background color on hover.
   */
  @NonNull
  private String backgroundColor;
}
