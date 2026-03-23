package com.magicbell.magicbelluserclient.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
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
public class SlackTokenCollection {

  @JsonProperty("data")
  private JsonNullable<List<SlackToken>> data;

  @JsonProperty("links")
  private JsonNullable<Links> links;

  @JsonIgnore
  public List<SlackToken> getData() {
    return data.orElse(null);
  }

  @JsonIgnore
  public Links getLinks() {
    return links.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class SlackTokenCollectionBuilder {

    private JsonNullable<List<SlackToken>> data = JsonNullable.undefined();

    @JsonProperty("data")
    public SlackTokenCollectionBuilder data(List<SlackToken> value) {
      if (value == null) {
        throw new IllegalStateException("data cannot be null");
      }
      this.data = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Links> links = JsonNullable.undefined();

    @JsonProperty("links")
    public SlackTokenCollectionBuilder links(Links value) {
      if (value == null) {
        throw new IllegalStateException("links cannot be null");
      }
      this.links = JsonNullable.of(value);
      return this;
    }
  }
}
