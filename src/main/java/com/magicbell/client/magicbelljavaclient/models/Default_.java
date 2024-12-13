package com.magicbell.client.magicbelljavaclient.models;

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
public class Default_ {

  @NonNull
  private String backgroundColor;

  @NonNull
  private String borderRadius;

  @NonNull
  private String fontFamily;

  @NonNull
  private String fontSize;

  @NonNull
  private String margin;

  @NonNull
  private String textColor;

  private DefaultHover hover;

  private DefaultState state;
}
