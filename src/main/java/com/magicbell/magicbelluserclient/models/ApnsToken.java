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
public class ApnsToken {

  /**
   * The timestamp when the token was created.
   */
  @NonNull
  @JsonProperty("created_at")
  private String createdAt;

  /**
   * The APNs device token to register with MagicBell.
   */
  @NonNull
  @JsonProperty("device_token")
  private String deviceToken;

  /**
   * The unique identifier for the token.
   */
  @NonNull
  private String id;

  /**
   * The bundle identifier of the application registering this token. Use this to override the default identifier configured on the APNs integration.
   */
  @JsonProperty("app_id")
  private JsonNullable<String> appId;

  /**
   * The timestamp when the token was discarded, if applicable.
   */
  @JsonProperty("discarded_at")
  private JsonNullable<String> discardedAt;

  /**
   * The APNs environment this token belongs to. If omitted we assume it targets `production`.
   */
  @JsonProperty("installation_id")
  private JsonNullable<ApnsTokenInstallationId> installationId;

  /**
   * The timestamp when the token metadata last changed.
   */
  @JsonProperty("updated_at")
  private JsonNullable<String> updatedAt;

  @JsonIgnore
  public String getAppId() {
    return appId.orElse(null);
  }

  @JsonIgnore
  public String getDiscardedAt() {
    return discardedAt.orElse(null);
  }

  @JsonIgnore
  public ApnsTokenInstallationId getInstallationId() {
    return installationId.orElse(null);
  }

  @JsonIgnore
  public String getUpdatedAt() {
    return updatedAt.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class ApnsTokenBuilder {

    private JsonNullable<String> appId = JsonNullable.undefined();

    @JsonProperty("app_id")
    public ApnsTokenBuilder appId(String value) {
      if (value == null) {
        throw new IllegalStateException("appId cannot be null");
      }
      this.appId = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> discardedAt = JsonNullable.undefined();

    @JsonProperty("discarded_at")
    public ApnsTokenBuilder discardedAt(String value) {
      this.discardedAt = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<ApnsTokenInstallationId> installationId = JsonNullable.undefined();

    @JsonProperty("installation_id")
    public ApnsTokenBuilder installationId(ApnsTokenInstallationId value) {
      if (value == null) {
        throw new IllegalStateException("installationId cannot be null");
      }
      this.installationId = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> updatedAt = JsonNullable.undefined();

    @JsonProperty("updated_at")
    public ApnsTokenBuilder updatedAt(String value) {
      this.updatedAt = JsonNullable.of(value);
      return this;
    }
  }
}
