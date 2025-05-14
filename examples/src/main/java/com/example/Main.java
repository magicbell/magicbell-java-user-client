package com.example;

import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.exceptions.ApiException;
import com.magicbell.magicbelluserclient.models.GetInAppInboxTokensParameters;
import com.magicbell.magicbelluserclient.models.InboxTokenResponseCollection;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    GetInAppInboxTokensParameters requestParameters = GetInAppInboxTokensParameters.builder()
      .limit(10L)
      .startingAfter("starting_after")
      .endingBefore("ending_before")
      .build();

    try {
      InboxTokenResponseCollection response = magicbellUserClient.channels.getInAppInboxTokens(requestParameters);

      System.out.println(response);
    } catch (ApiException e) {
      e.printStackTrace();
    }

    System.exit(0);
  }
}
