package com.magicbell.magicbelluserclient.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;
import org.openapitools.jackson.nullable.JsonNullable;

@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class Notification {

  /**
   * The timestamp when the notification was created.
   */
  @NonNull
  @JsonProperty("created_at")
  private String createdAt;

  /**
   * The unique identifier for the notification.
   */
  @NonNull
  private String id;

  /**
   * The title that is displayed to recipients.
   */
  @NonNull
  private String title;

  /**
   * The timestamp when the notification was last updated.
   */
  @NonNull
  @JsonProperty("updated_at")
  private String updatedAt;

  /**
   * The user that should receive the notification.
   */
  @NonNull
  @JsonProperty("user_id")
  private String userId;

  /**
   * The link associated with the notification.
   */
  @JsonProperty("action_url")
  private JsonNullable<String> actionUrl;

  /**
   * The timestamp when the notification was archived.
   */
  @JsonProperty("archived_at")
  private JsonNullable<String> archivedAt;

  /**
   * The category grouping for the notification.
   */
  @JsonProperty("category")
  private JsonNullable<String> category;

  /**
   * The body content of the notification.
   */
  @JsonProperty("content")
  private JsonNullable<String> content;

  /**
   * The custom data stored with the notification.
   */
  @JsonProperty("custom_attributes")
  private JsonNullable<Object> customAttributes;

  /**
   * The timestamp when the notification was discarded.
   */
  @JsonProperty("discarded_at")
  private JsonNullable<String> discardedAt;

  /**
   * The timestamp when the notification was marked as read.
   */
  @JsonProperty("read_at")
  private JsonNullable<String> readAt;

  /**
   * The timestamp when the notification was seen.
   */
  @JsonProperty("seen_at")
  private JsonNullable<String> seenAt;

  /**
   * The timestamp when the notification was sent.
   */
  @JsonProperty("sent_at")
  private JsonNullable<String> sentAt;

  /**
   * The topic for additional classification.
   */
  @JsonProperty("topic")
  private JsonNullable<String> topic;

  @JsonIgnore
  public String getActionUrl() {
    return actionUrl.orElse(null);
  }

  @JsonIgnore
  public String getArchivedAt() {
    return archivedAt.orElse(null);
  }

  @JsonIgnore
  public String getCategory() {
    return category.orElse(null);
  }

  @JsonIgnore
  public String getContent() {
    return content.orElse(null);
  }

  @JsonIgnore
  public Object getCustomAttributes() {
    return customAttributes.orElse(null);
  }

  @JsonIgnore
  public String getDiscardedAt() {
    return discardedAt.orElse(null);
  }

  @JsonIgnore
  public String getReadAt() {
    return readAt.orElse(null);
  }

  @JsonIgnore
  public String getSeenAt() {
    return seenAt.orElse(null);
  }

  @JsonIgnore
  public String getSentAt() {
    return sentAt.orElse(null);
  }

  @JsonIgnore
  public String getTopic() {
    return topic.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class NotificationBuilder {

    private JsonNullable<String> actionUrl = JsonNullable.undefined();

    @JsonProperty("action_url")
    public NotificationBuilder actionUrl(String value) {
      this.actionUrl = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> archivedAt = JsonNullable.undefined();

    @JsonProperty("archived_at")
    public NotificationBuilder archivedAt(String value) {
      this.archivedAt = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> category = JsonNullable.undefined();

    @JsonProperty("category")
    public NotificationBuilder category(String value) {
      this.category = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> content = JsonNullable.undefined();

    @JsonProperty("content")
    public NotificationBuilder content(String value) {
      this.content = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Object> customAttributes = JsonNullable.undefined();

    @JsonProperty("custom_attributes")
    public NotificationBuilder customAttributes(Object value) {
      this.customAttributes = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> discardedAt = JsonNullable.undefined();

    @JsonProperty("discarded_at")
    public NotificationBuilder discardedAt(String value) {
      this.discardedAt = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> readAt = JsonNullable.undefined();

    @JsonProperty("read_at")
    public NotificationBuilder readAt(String value) {
      this.readAt = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> seenAt = JsonNullable.undefined();

    @JsonProperty("seen_at")
    public NotificationBuilder seenAt(String value) {
      this.seenAt = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> sentAt = JsonNullable.undefined();

    @JsonProperty("sent_at")
    public NotificationBuilder sentAt(String value) {
      this.sentAt = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> topic = JsonNullable.undefined();

    @JsonProperty("topic")
    public NotificationBuilder topic(String value) {
      this.topic = JsonNullable.of(value);
      return this;
    }
  }
}
