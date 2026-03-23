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
public class SlackTokenOauth {

  /**
   * The ID of the Slack channel this installation is associated with
   */
  @NonNull
  @JsonProperty("channel_id")
  private String channelId;

  /**
   * A unique identifier for this Slack workspace installation
   */
  @NonNull
  @JsonProperty("installation_id")
  private String installationId;

  /**
   * The OAuth scope granted during installation
   */
  @JsonProperty("scope")
  private JsonNullable<String> scope;

  @JsonIgnore
  public String getScope() {
    return scope.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class SlackTokenOauthBuilder {

    private JsonNullable<String> scope = JsonNullable.undefined();

    @JsonProperty("scope")
    public SlackTokenOauthBuilder scope(String value) {
      if (value == null) {
        throw new IllegalStateException("scope cannot be null");
      }
      this.scope = JsonNullable.of(value);
      return this;
    }
  }
}
