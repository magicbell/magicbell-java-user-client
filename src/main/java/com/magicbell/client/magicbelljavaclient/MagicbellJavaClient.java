package com.magicbell.client.magicbelljavaclient;

import com.magicbell.client.magicbelljavaclient.config.MagicbellJavaClientConfig;
import com.magicbell.client.magicbelljavaclient.http.Environment;
import com.magicbell.client.magicbelljavaclient.http.interceptors.DefaultHeadersInterceptor;
import com.magicbell.client.magicbelljavaclient.http.interceptors.RetryInterceptor;
import com.magicbell.client.magicbelljavaclient.http.interceptors.TokenInterceptor;
import com.magicbell.client.magicbelljavaclient.services.ChannelsService;
import com.magicbell.client.magicbelljavaclient.services.IntegrationsService;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;

/** OpenAPI 3.1.0 Specification for MagicBell API. */
public class MagicbellJavaClient {

  public final ChannelsService channels;
  public final IntegrationsService integrations;

  private final TokenInterceptor accessAuthInterceptor;

  public MagicbellJavaClient() {
    // Default configs
    this(MagicbellJavaClientConfig.builder().build());
  }

  public MagicbellJavaClient(MagicbellJavaClientConfig config) {
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
