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
public class Header {

  @NonNull
  private String backgroundColor;

  @NonNull
  private String borderRadius;

  @NonNull
  private String fontFamily;

  @NonNull
  private String fontSize;

  @NonNull
  private String textColor;
}
