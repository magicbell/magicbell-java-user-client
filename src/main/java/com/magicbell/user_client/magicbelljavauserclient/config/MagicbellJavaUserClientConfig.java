package com.magicbell.user_client.magicbelljavauserclient.config;

import com.magicbell.user_client.magicbelljavauserclient.http.Environment;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Builder
@Data
public class MagicbellJavaUserClientConfig {

  @NonNull
  @Builder.Default
  private String userAgent = "magicbelljavauserclient/1.0.0";

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