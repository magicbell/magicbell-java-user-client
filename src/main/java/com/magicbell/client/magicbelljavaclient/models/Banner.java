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
public class Banner {

  @NonNull
  private String backgroundColor;

  @NonNull
  private String fontSize;

  @NonNull
  private String textColor;

  private Double backgroundOpacity;
}
