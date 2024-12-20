package com.magicbell.user_client.magicbelljavauserclient.http;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * SDK Environments
 */
@Getter
@RequiredArgsConstructor
public enum Environment {
  DEFAULT("https://api.magicbell.com/v2");

  private final String url;
}
