package com.magicbell.magicbelluserclient.http;

import lombok.Getter;
import okhttp3.HttpUrl;

/**
 * SDK Environments
 */
@Getter
public enum Environment {
  DEFAULT("https://api.magicbell.com/v2");

  private final String url;

  Environment(String url) {
    if (HttpUrl.parse(url) == null) {
      throw new IllegalArgumentException(
        String.format("Environment url [%s] is not valid. Please use the following format https://api.example.com", url)
      );
    }
    this.url = url;
  }
}
