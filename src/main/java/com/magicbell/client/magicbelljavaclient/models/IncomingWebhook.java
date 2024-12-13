package com.magicbell.client.magicbelljavaclient.models;

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
public class IncomingWebhook {

  @NonNull
  private String channel;

  @NonNull
  @JsonProperty("configuration_url")
  private String configurationUrl;

  @NonNull
  private String url;
}
