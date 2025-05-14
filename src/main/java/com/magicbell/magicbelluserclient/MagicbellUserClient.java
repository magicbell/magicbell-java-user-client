package com.magicbell.magicbelluserclient;

import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.http.Environment;
import com.magicbell.magicbelluserclient.http.interceptors.DefaultHeadersInterceptor;
import com.magicbell.magicbelluserclient.http.interceptors.RetryInterceptor;
import com.magicbell.magicbelluserclient.services.ChannelsService;
import com.magicbell.magicbelluserclient.services.IntegrationsService;
import com.magicbell.magicbelluserclient.services.NotificationsService;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;

/** OpenAPI 3.1.0 Specification for MagicBell API. */
public class MagicbellUserClient {

  public final ChannelsService channels;
  public final IntegrationsService integrations;
  public final NotificationsService notifications;

  private final MagicbellUserClientConfig config;

  public MagicbellUserClient() {
    // Default configs
    this(MagicbellUserClientConfig.builder().build());
  }

  public MagicbellUserClient(MagicbellUserClientConfig config) {
    this.config = config;

    final OkHttpClient httpClient = new OkHttpClient.Builder()
      .addInterceptor(new DefaultHeadersInterceptor(config))
      .addInterceptor(new RetryInterceptor(config.getRetryConfig()))
      .readTimeout(config.getTimeout(), TimeUnit.MILLISECONDS)
      .build();

    this.channels = new ChannelsService(httpClient, config);
    this.integrations = new IntegrationsService(httpClient, config);
    this.notifications = new NotificationsService(httpClient, config);
  }

  public void setEnvironment(Environment environment) {
    setBaseUrl(environment.getUrl());
  }

  public void setBaseUrl(String baseUrl) {
    this.config.setBaseUrl(baseUrl);
  }

  public void setAccessToken(String token) {
    this.config.setAccessToken(token);
  }
}
// c029837e0e474b76bc487506e8799df5e3335891efe4fb02bda7a1441840310c
