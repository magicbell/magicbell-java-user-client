package com.magicbell.user_client.magicbelljavauserclient;

import com.magicbell.user_client.magicbelljavauserclient.config.MagicbellJavaUserClientConfig;
import com.magicbell.user_client.magicbelljavauserclient.http.Environment;
import com.magicbell.user_client.magicbelljavauserclient.http.interceptors.DefaultHeadersInterceptor;
import com.magicbell.user_client.magicbelljavauserclient.http.interceptors.RetryInterceptor;
import com.magicbell.user_client.magicbelljavauserclient.http.interceptors.TokenInterceptor;
import com.magicbell.user_client.magicbelljavauserclient.services.ChannelsService;
import com.magicbell.user_client.magicbelljavauserclient.services.IntegrationsService;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;

/** OpenAPI 3.0.3 Specification for MagicBell API. */
public class MagicbellJavaUserClient {

  public final ChannelsService channels;
  public final IntegrationsService integrations;

  private final TokenInterceptor accessAuthInterceptor;

  public MagicbellJavaUserClient() {
    // Default configs
    this(MagicbellJavaUserClientConfig.builder().build());
  }

  public MagicbellJavaUserClient(MagicbellJavaUserClientConfig config) {
    final String serverUrl = config.getEnvironment().getUrl();

    this.accessAuthInterceptor =
      TokenInterceptor.builder().header("Authorization").prefix("Bearer").token(config.getAccessToken()).build();

    final OkHttpClient httpClient = new OkHttpClient.Builder()
      .addInterceptor(new DefaultHeadersInterceptor(config))
      .addInterceptor(accessAuthInterceptor)
      .addInterceptor(new RetryInterceptor(config.getRetryConfig()))
      .readTimeout(config.getTimeout(), TimeUnit.MILLISECONDS)
      .build();

    this.channels = new ChannelsService(httpClient, serverUrl);
    this.integrations = new IntegrationsService(httpClient, serverUrl);
  }

  public void setEnvironment(Environment environment) {
    setBaseUrl(environment.getUrl());
  }

  public void setBaseUrl(String baseUrl) {
    this.channels.setBaseUrl(baseUrl);
    this.integrations.setBaseUrl(baseUrl);
  }

  public void setAccessToken(String token) {
    this.accessAuthInterceptor.setToken(token);
  }
}
// c029837e0e474b76bc487506e8799df5e3335891efe4fb02bda7a1441840310c
