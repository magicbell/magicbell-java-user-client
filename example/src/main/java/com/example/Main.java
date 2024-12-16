package com.example;

import com.magicbell.client.magicbelljavaclient.MagicbellJavaClient;
import com.magicbell.client.magicbelljavaclient.config.MagicbellJavaClientConfig;
import com.magicbell.client.magicbelljavaclient.models.ArrayOfMetadataApnsTokens;
import com.magicbell.client.magicbelljavaclient.models.GetMobilePushApnsTokensParameters;

public class Main {

  public static void main(String[] args) {
    MagicbellJavaClientConfig config = MagicbellJavaClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellJavaClient magicbellJavaClient = new MagicbellJavaClient(config);

    GetMobilePushApnsTokensParameters requestParameters = GetMobilePushApnsTokensParameters
      .builder()
      .pageSize(8L)
      .pageAfter("")
      .pageBefore("")
      .build();

    ArrayOfMetadataApnsTokens response = magicbellJavaClient.channels.getMobilePushApnsTokens(requestParameters);

    System.out.println(response);
  }
}
