package com.magicbell.magicbelluserclient.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class ThemeNotification {

  @NonNull
  @JsonProperty("default")
  private Default_ default_;

  @NonNull
  private Unread unread;

  @NonNull
  private Unseen unseen;
}
