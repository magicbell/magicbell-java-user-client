package com.magicbell.magicbelluserclient.models;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class SlackTokenOauth {

  @NonNull
  @JsonProperty("channel_id")
  private String channelId;

  @NonNull
  @JsonProperty("installation_id")
  private String installationId;

  private String scope;
}
