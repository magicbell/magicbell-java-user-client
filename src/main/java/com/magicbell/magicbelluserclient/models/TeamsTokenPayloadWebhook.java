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
public class TeamsTokenPayloadWebhook {

  @JsonProperty("url")
  private JsonNullable<String> url;

  @JsonIgnore
  public String getUrl() {
    return url.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class TeamsTokenPayloadWebhookBuilder {

    private JsonNullable<String> url = JsonNullable.undefined();

    @JsonProperty("url")
    public TeamsTokenPayloadWebhookBuilder url(String value) {
      if (value == null) {
        throw new IllegalStateException("url cannot be null");
      }
      this.url = JsonNullable.of(value);
      return this;
    }
  }
}
