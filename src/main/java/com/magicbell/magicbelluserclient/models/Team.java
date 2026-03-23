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
public class Team {

  /**
   * Workspace ID where the app was installed.
   */
  @NonNull
  private String id;

  /**
   * Workspace name where the app was installed.
   */
  @JsonProperty("name")
  private JsonNullable<String> name;

  @JsonIgnore
  public String getName() {
    return name.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class TeamBuilder {

    private JsonNullable<String> name = JsonNullable.undefined();

    @JsonProperty("name")
    public TeamBuilder name(String value) {
      if (value == null) {
        throw new IllegalStateException("name cannot be null");
      }
      this.name = JsonNullable.of(value);
      return this;
    }
  }
}
