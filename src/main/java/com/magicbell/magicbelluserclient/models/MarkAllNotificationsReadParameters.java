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
public class MarkAllNotificationsReadParameters {

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
  public String getCategory() {
    return category.orElse(null);
  }

  @JsonIgnore
  public String getTopic() {
    return topic.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class MarkAllNotificationsReadParametersBuilder {

    private JsonNullable<String> category = JsonNullable.undefined();

    @JsonProperty("category")
    public MarkAllNotificationsReadParametersBuilder category(String value) {
      if (value == null) {
        throw new IllegalStateException("category cannot be null");
      }
      this.category = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> topic = JsonNullable.undefined();

    @JsonProperty("topic")
    public MarkAllNotificationsReadParametersBuilder topic(String value) {
      if (value == null) {
        throw new IllegalStateException("topic cannot be null");
      }
      this.topic = JsonNullable.of(value);
      return this;
    }
  }
}
