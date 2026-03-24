package com.magicbell.magicbelluserclient.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

/**
 * State indicator styling for unseen notifications.
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class UnseenState {

  /**
   * Color for the unseen state indicator.
   */
  @NonNull
  private String color;
}
