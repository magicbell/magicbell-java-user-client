package com.magicbell.magicbelluserclient.models;

import com.fasterxml.jackson.annotation.JsonInclude;
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
public class WebPushTokenResponse {

  @NonNull
  @JsonProperty("created_at")
  private String createdAt;

  @NonNull
  private String endpoint;

  @NonNull
  private String id;

  @NonNull
  private WebPushTokenResponseKeys keys;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("discarded_at")
  private String discardedAt;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("updated_at")
  private String updatedAt;
}
