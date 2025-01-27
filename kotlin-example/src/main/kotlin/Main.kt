package com.example

import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.ArrayOfMetadataApnsTokens;
import com.magicbell.magicbelluserclient.models.GetMobilePushApnsTokensParameters;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val requestParameters: GetMobilePushApnsTokensParameters = GetMobilePushApnsTokensParameters.builder()
			.pageSize(8L)
			.pageAfter("")
			.pageBefore("")
			.build();

    val response: ArrayOfMetadataApnsTokens = magicbellUserClient.channels.getMobilePushApnsTokens(requestParameters);
    
    println(response);
}

