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
public class Categories {

  @JsonProperty("channels")
  private JsonNullable<List<Channels>> channels;

  @JsonProperty("key")
  private JsonNullable<String> key;

  @JsonProperty("label")
  private JsonNullable<String> label;

  @JsonIgnore
  public List<Channels> getChannels() {
    return channels.orElse(null);
  }

  @JsonIgnore
  public String getKey() {
    return key.orElse(null);
  }

  @JsonIgnore
  public String getLabel() {
    return label.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class CategoriesBuilder {

    private JsonNullable<List<Channels>> channels = JsonNullable.undefined();

    @JsonProperty("channels")
    public CategoriesBuilder channels(List<Channels> value) {
      if (value == null) {
        throw new IllegalStateException("channels cannot be null");
      }
      this.channels = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> key = JsonNullable.undefined();

    @JsonProperty("key")
    public CategoriesBuilder key(String value) {
      if (value == null) {
        throw new IllegalStateException("key cannot be null");
      }
      this.key = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> label = JsonNullable.undefined();

    @JsonProperty("label")
    public CategoriesBuilder label(String value) {
      this.label = JsonNullable.of(value);
      return this;
    }
  }
}
