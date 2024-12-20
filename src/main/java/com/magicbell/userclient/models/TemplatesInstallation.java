package com.magicbell.userclient.models;

import com.fasterxml.jackson.annotation.JsonInclude;
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
public class TemplatesInstallation {

  @NonNull
  private String channel;

  @NonNull
  private String text;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private String category;
}
