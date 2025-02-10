package com.example;

import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.exceptions.ApiException;
import com.magicbell.magicbelluserclient.models.ArrayOfApnsTokenResponses;
import com.magicbell.magicbelluserclient.models.GetMobilePushApnsTokensParameters;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    GetMobilePushApnsTokensParameters requestParameters = GetMobilePushApnsTokensParameters
      .builder()
      .pageSize(8L)
      .pageAfter("")
      .pageBefore("")
      .build();

    try {
      ArrayOfApnsTokenResponses response = magicbellUserClient.channels.getMobilePushApnsTokens(requestParameters);

      System.out.println(response);
    } catch (ApiException e) {
      e.printStackTrace();
    }

    System.exit(0);
  }
}
