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
public class Notification {

  @NonNull
  @JsonProperty("created_at")
  private String createdAt;

  @NonNull
  private String id;

  @NonNull
  private String title;

  @NonNull
  @JsonProperty("updated_at")
  private String updatedAt;

  @NonNull
  @JsonProperty("user_id")
  private String userId;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("action_url")
  private String actionUrl;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("archived_at")
  private String archivedAt;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private String category;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private String content;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("custom_attributes")
  private Object customAttributes;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("discarded_at")
  private String discardedAt;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("read_at")
  private String readAt;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("seen_at")
  private String seenAt;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("sent_at")
  private String sentAt;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private String topic;
}
