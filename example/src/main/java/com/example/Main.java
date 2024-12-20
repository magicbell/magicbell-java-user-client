package com.example;

import com.magicbell.userclient.MagicbellUserClient;
import com.magicbell.userclient.config.MagicbellUserClientConfig;
import com.magicbell.userclient.models.ArrayOfMetadataApnsTokens;
import com.magicbell.userclient.models.GetMobilePushApnsTokensParameters;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    GetMobilePushApnsTokensParameters requestParameters = GetMobilePushApnsTokensParameters
      .builder()
      .pageSize(5L)
      .pageAfter("")
      .pageBefore("")
      .build();

    ArrayOfMetadataApnsTokens response = magicbellUserClient.channels.getMobilePushApnsTokens(requestParameters);

    System.out.println(response);
  }
}
