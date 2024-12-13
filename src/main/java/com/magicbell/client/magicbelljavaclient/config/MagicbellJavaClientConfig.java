package com.magicbell.client.magicbelljavaclient.config;

import com.magicbell.client.magicbelljavaclient.http.Environment;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Builder
@Data
public class MagicbellJavaClientConfig {

  @NonNull
  @Builder.Default
  private String userAgent = "magicbelljavaclient/1.0.0";

  @NonNull
  @Builder.Default
  private Environment environment = Environment.DEFAULT;

  @NonNull
  @Builder.Default
  private RetryConfig retryConfig = RetryConfig.builder().build();

  private String accessToken;

  /** Timeout in milliseconds */
  @Builder.Default
  private long timeout = 10_000;
}
