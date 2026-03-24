package com.example;

import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.exceptions.ApiError;
import com.magicbell.magicbelluserclient.models.InboxTokenResponseCollection;
import com.magicbell.magicbelluserclient.models.ListInboxTokensParameters;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    ListInboxTokensParameters requestParameters = ListInboxTokensParameters.builder()
      .limit(8L)
      .startingAfter("starting_after")
      .endingBefore("ending_before")
      .build();

    try {
      InboxTokenResponseCollection response = magicbellUserClient.channels.listInboxTokens(requestParameters);

      System.out.println(response);
    } catch (ApiError e) {
      e.printStackTrace();
    }

    System.exit(0);
  }
}
