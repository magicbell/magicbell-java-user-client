package com.example;

import com.magicbell.userclient.MagicbellJavaUserClient;
import com.magicbell.userclient.config.MagicbellJavaUserClientConfig;
import com.magicbell.userclient.models.ArrayOfMetadataApnsTokens;
import com.magicbell.userclient.models.GetMobilePushApnsTokensParameters;

public class Main {

  public static void main(String[] args) {
    MagicbellJavaUserClientConfig config = MagicbellJavaUserClientConfig
      .builder()
      .accessToken("YOUR_ACCESS_TOKEN")
      .build();

    MagicbellJavaUserClient magicbellJavaUserClient = new MagicbellJavaUserClient(config);

    GetMobilePushApnsTokensParameters requestParameters = GetMobilePushApnsTokensParameters
      .builder()
      .pageSize(9L)
      .pageAfter("")
      .pageBefore("")
      .build();

    ArrayOfMetadataApnsTokens response = magicbellJavaUserClient.channels.getMobilePushApnsTokens(requestParameters);

    System.out.println(response);
  }
}
