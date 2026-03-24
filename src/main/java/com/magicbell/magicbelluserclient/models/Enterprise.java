package com.magicbell.magicbelluserclient.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class Enterprise {

  /**
   * Enterprise grid identifier.
   */
  @NonNull
  private String id;

  /**
   * Enterprise grid name.
   */
  @NonNull
  private String name;
}
