package com.magicbell.magicbelluserclient.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

/**
 * Badge styling for unseen notification counts.
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class UnseenBadge {

  /**
   * Badge background color.
   */
  @NonNull
  private String backgroundColor;
}
