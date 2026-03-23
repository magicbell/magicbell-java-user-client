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
public class InboxTokenResponseCollection {

  @JsonProperty("data")
  private JsonNullable<List<InboxTokenResponse>> data;

  @JsonProperty("links")
  private JsonNullable<Links> links;

  @JsonIgnore
  public List<InboxTokenResponse> getData() {
    return data.orElse(null);
  }

  @JsonIgnore
  public Links getLinks() {
    return links.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class InboxTokenResponseCollectionBuilder {

    private JsonNullable<List<InboxTokenResponse>> data = JsonNullable.undefined();

    @JsonProperty("data")
    public InboxTokenResponseCollectionBuilder data(List<InboxTokenResponse> value) {
      if (value == null) {
        throw new IllegalStateException("data cannot be null");
      }
      this.data = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Links> links = JsonNullable.undefined();

    @JsonProperty("links")
    public InboxTokenResponseCollectionBuilder links(Links value) {
      if (value == null) {
        throw new IllegalStateException("links cannot be null");
      }
      this.links = JsonNullable.of(value);
      return this;
    }
  }
}
