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
public class SlackToken {

  @NonNull
  @JsonProperty("created_at")
  private String createdAt;

  @NonNull
  private String id;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("discarded_at")
  private String discardedAt;

  private SlackTokenOauth oauth;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("updated_at")
  private String updatedAt;

  /**
   * Obtained directly from the incoming_webhook object in the installation response from the Slack API.
   */
  private SlackTokenWebhook webhook;
}
