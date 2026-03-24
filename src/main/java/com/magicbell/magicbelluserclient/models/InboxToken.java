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
public class InboxToken {

  /**
   * The in-app inbox token generated for this user.
   */
  @NonNull
  private String token;

  /**
   * Realtime connection ID to restrict delivery to a specific Ably connection.
   */
  @JsonProperty("connection_id")
  private JsonNullable<String> connectionId;

  @JsonIgnore
  public String getConnectionId() {
    return connectionId.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class InboxTokenBuilder {

    private JsonNullable<String> connectionId = JsonNullable.undefined();

    @JsonProperty("connection_id")
    public InboxTokenBuilder connectionId(String value) {
      this.connectionId = JsonNullable.of(value);
      return this;
    }
  }
}
