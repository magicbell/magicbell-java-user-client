package com.example

import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.InboxTokenResponseCollection;
import com.magicbell.magicbelluserclient.models.ListInboxTokensParameters;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val requestParameters: ListInboxTokensParameters = ListInboxTokensParameters.builder()
			.limit(8L)
			.startingAfter("starting_after")
			.endingBefore("ending_before")
			.build();

    val response: InboxTokenResponseCollection = magicbellUserClient.channels.listInboxTokens(requestParameters);
    
    println(response);
}

