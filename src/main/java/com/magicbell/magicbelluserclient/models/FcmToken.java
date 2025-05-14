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
public class FcmToken {

  @NonNull
  @JsonProperty("created_at")
  private String createdAt;

  @NonNull
  @JsonProperty("device_token")
  private String deviceToken;

  @NonNull
  private String id;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("discarded_at")
  private String discardedAt;

  @JsonProperty("installation_id")
  private FcmTokenInstallationId installationId;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("updated_at")
  private String updatedAt;
}
