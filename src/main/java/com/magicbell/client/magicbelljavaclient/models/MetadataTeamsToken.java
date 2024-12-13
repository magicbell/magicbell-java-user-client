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
public class MetadataTeamsToken {

  @NonNull
  private TeamsToken data;

  @NonNull
  private TokenMetadata metadata;
}
