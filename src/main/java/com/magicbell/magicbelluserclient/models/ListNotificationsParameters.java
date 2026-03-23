package com.magicbell.magicbelluserclient.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
public class ListNotificationsParameters {

  /**
   * defines the maximum number of items to return per page (default: 50)
   */
  @JsonProperty("limit")
  private JsonNullable<Long> limit;

  /**
   * a cursor for use in pagination, points to the last ID in previous page
   */
  @JsonProperty("starting_after")
  private JsonNullable<String> startingAfter;

  /**
   * a cursor for use in pagination, points to the first ID in next page
   */
  @JsonProperty("ending_before")
  private JsonNullable<String> endingBefore;

  /**
   * filter notifications by their read state, one of 'unread' | 'read' | 'archived'
   */
  @JsonProperty("status")
  private JsonNullable<String> status;

  /**
   * filter notifications by their category
   */
  @JsonProperty("category")
  private JsonNullable<String> category;

  /**
   * filter notifications by their topic
   */
  @JsonProperty("topic")
  private JsonNullable<String> topic;

  @JsonIgnore
  public Long getLimit() {
    return limit.orElse(null);
  }

  @JsonIgnore
  public String getStartingAfter() {
    return startingAfter.orElse(null);
  }

  @JsonIgnore
  public String getEndingBefore() {
    return endingBefore.orElse(null);
  }

  @JsonIgnore
  public String getStatus() {
    return status.orElse(null);
  }

  @JsonIgnore
  public String getCategory() {
    return category.orElse(null);
  }

  @JsonIgnore
  public String getTopic() {
    return topic.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class ListNotificationsParametersBuilder {

    private JsonNullable<Long> limit = JsonNullable.undefined();

    @JsonProperty("limit")
    public ListNotificationsParametersBuilder limit(Long value) {
      if (value == null) {
        throw new IllegalStateException("limit cannot be null");
      }
      this.limit = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> startingAfter = JsonNullable.undefined();

    @JsonProperty("starting_after")
    public ListNotificationsParametersBuilder startingAfter(String value) {
      if (value == null) {
        throw new IllegalStateException("startingAfter cannot be null");
      }
      this.startingAfter = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> endingBefore = JsonNullable.undefined();

    @JsonProperty("ending_before")
    public ListNotificationsParametersBuilder endingBefore(String value) {
      if (value == null) {
        throw new IllegalStateException("endingBefore cannot be null");
      }
      this.endingBefore = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> status = JsonNullable.undefined();

    @JsonProperty("status")
    public ListNotificationsParametersBuilder status(String value) {
      if (value == null) {
        throw new IllegalStateException("status cannot be null");
      }
      this.status = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> category = JsonNullable.undefined();

    @JsonProperty("category")
    public ListNotificationsParametersBuilder category(String value) {
      if (value == null) {
        throw new IllegalStateException("category cannot be null");
      }
      this.category = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> topic = JsonNullable.undefined();

    @JsonProperty("topic")
    public ListNotificationsParametersBuilder topic(String value) {
      if (value == null) {
        throw new IllegalStateException("topic cannot be null");
      }
      this.topic = JsonNullable.of(value);
      return this;
    }
  }
}
