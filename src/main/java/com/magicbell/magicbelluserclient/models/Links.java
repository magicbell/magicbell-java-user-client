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
public class Links {

  @JsonProperty("first")
  private JsonNullable<String> first;

  @JsonProperty("next")
  private JsonNullable<String> next;

  @JsonProperty("prev")
  private JsonNullable<String> prev;

  @JsonIgnore
  public String getFirst() {
    return first.orElse(null);
  }

  @JsonIgnore
  public String getNext() {
    return next.orElse(null);
  }

  @JsonIgnore
  public String getPrev() {
    return prev.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class LinksBuilder {

    private JsonNullable<String> first = JsonNullable.undefined();

    @JsonProperty("first")
    public LinksBuilder first(String value) {
      if (value == null) {
        throw new IllegalStateException("first cannot be null");
      }
      this.first = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> next = JsonNullable.undefined();

    @JsonProperty("next")
    public LinksBuilder next(String value) {
      this.next = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> prev = JsonNullable.undefined();

    @JsonProperty("prev")
    public LinksBuilder prev(String value) {
      this.prev = JsonNullable.of(value);
      return this;
    }
  }
}
