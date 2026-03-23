package com.magicbell.magicbelluserclient.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

/**
 * Image overrides for assets used in the inbox UI.
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class Images {

  /**
   * URL for the illustration shown when the inbox is empty.
   */
  @NonNull
  private String emptyInboxUrl;
}
