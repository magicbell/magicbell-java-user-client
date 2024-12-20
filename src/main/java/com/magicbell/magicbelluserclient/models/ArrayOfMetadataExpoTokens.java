package com.magicbell.magicbelluserclient.models;

import java.util.List;
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
public class ArrayOfMetadataExpoTokens {

  private List<MetadataExpoToken> data;

  private Links links;
}
