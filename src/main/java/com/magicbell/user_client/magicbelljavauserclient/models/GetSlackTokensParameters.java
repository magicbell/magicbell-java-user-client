package com.magicbell.user_client.magicbelljavauserclient.models;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class GetSlackTokensParameters {

  @JsonProperty("page[size]")
  private Long pageSize;

  @JsonProperty("page[after]")
  private String pageAfter;

  @JsonProperty("page[before]")
  private String pageBefore;
}
