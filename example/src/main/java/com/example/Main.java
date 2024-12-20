package com.example;

import com.magicbell.user_client.magicbelljavauserclient.MagicbellJavaUserClient;
import com.magicbell.user_client.magicbelljavauserclient.config.MagicbellJavaUserClientConfig;
import com.magicbell.user_client.magicbelljavauserclient.models.ArrayOfMetadataApnsTokens;
import com.magicbell.user_client.magicbelljavauserclient.models.GetMobilePushApnsTokensParameters;

public class Main {

  public static void main(String[] args) {
    MagicbellJavaUserClientConfig config = MagicbellJavaUserClientConfig
      .builder()
      .accessToken("YOUR_ACCESS_TOKEN")
      .build();

    MagicbellJavaUserClient magicbellJavaUserClient = new MagicbellJavaUserClient(config);

    GetMobilePushApnsTokensParameters requestParameters = GetMobilePushApnsTokensParameters
      .builder()
      .pageSize(8L)
      .pageAfter("")
      .pageBefore("")
      .build();

    ArrayOfMetadataApnsTokens response = magicbellJavaUserClient.channels.getMobilePushApnsTokens(requestParameters);

    System.out.println(response);
  }
}
