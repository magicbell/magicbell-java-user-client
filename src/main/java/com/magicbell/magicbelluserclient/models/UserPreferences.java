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
public class UserPreferences {

  @JsonProperty("categories")
  private JsonNullable<List<Categories>> categories;

  @JsonIgnore
  public List<Categories> getCategories() {
    return categories.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class UserPreferencesBuilder {

    private JsonNullable<List<Categories>> categories = JsonNullable.undefined();

    @JsonProperty("categories")
    public UserPreferencesBuilder categories(List<Categories> value) {
      if (value == null) {
        throw new IllegalStateException("categories cannot be null");
      }
      this.categories = JsonNullable.of(value);
      return this;
    }
  }
}
