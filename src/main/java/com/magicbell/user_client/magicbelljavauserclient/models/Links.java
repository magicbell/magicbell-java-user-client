package com.magicbell.user_client.magicbelljavauserclient.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class Links {

  private String first;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private String next;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private String prev;
}
