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
public class Channels {

  @JsonProperty("enabled")
  private JsonNullable<Boolean> enabled;

  @JsonProperty("name")
  private JsonNullable<String> name;

  @JsonIgnore
  public Boolean getEnabled() {
    return enabled.orElse(null);
  }

  @JsonIgnore
  public String getName() {
    return name.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class ChannelsBuilder {

    private JsonNullable<Boolean> enabled = JsonNullable.undefined();

    @JsonProperty("enabled")
    public ChannelsBuilder enabled(Boolean value) {
      if (value == null) {
        throw new IllegalStateException("enabled cannot be null");
      }
      this.enabled = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> name = JsonNullable.undefined();

    @JsonProperty("name")
    public ChannelsBuilder name(String value) {
      if (value == null) {
        throw new IllegalStateException("name cannot be null");
      }
      this.name = JsonNullable.of(value);
      return this;
    }
  }
}
