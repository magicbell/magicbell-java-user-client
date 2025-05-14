package com.example

import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.GetInAppInboxTokensParameters;
import com.magicbell.magicbelluserclient.models.InboxTokenResponseCollection;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val requestParameters: GetInAppInboxTokensParameters = GetInAppInboxTokensParameters.builder()
			.limit(10L)
			.startingAfter("starting_after")
			.endingBefore("ending_before")
			.build();

    val response: InboxTokenResponseCollection = magicbellUserClient.channels.getInAppInboxTokens(requestParameters);
    
    println(response);
}

