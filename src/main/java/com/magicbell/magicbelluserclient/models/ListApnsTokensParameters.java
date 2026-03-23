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
public class ListApnsTokensParameters {

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

  // Overwrite lombok builder methods
  public static class ListApnsTokensParametersBuilder {

    private JsonNullable<Long> limit = JsonNullable.undefined();

    @JsonProperty("limit")
    public ListApnsTokensParametersBuilder limit(Long value) {
      if (value == null) {
        throw new IllegalStateException("limit cannot be null");
      }
      this.limit = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> startingAfter = JsonNullable.undefined();

    @JsonProperty("starting_after")
    public ListApnsTokensParametersBuilder startingAfter(String value) {
      if (value == null) {
        throw new IllegalStateException("startingAfter cannot be null");
      }
      this.startingAfter = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> endingBefore = JsonNullable.undefined();

    @JsonProperty("ending_before")
    public ListApnsTokensParametersBuilder endingBefore(String value) {
      if (value == null) {
        throw new IllegalStateException("endingBefore cannot be null");
      }
      this.endingBefore = JsonNullable.of(value);
      return this;
    }
  }
}
