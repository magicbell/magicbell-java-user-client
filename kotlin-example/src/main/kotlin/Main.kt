package com.example

import com.magicbell.userclient.MagicbellUserClient;
import com.magicbell.userclient.config.MagicbellUserClientConfig;
import com.magicbell.userclient.models.ArrayOfMetadataApnsTokens;
import com.magicbell.userclient.models.GetMobilePushApnsTokensParameters;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    GetMobilePushApnsTokensParameters requestParameters = GetMobilePushApnsTokensParameters.builder()
			.pageSize(5L)
			.pageAfter("")
			.pageBefore("")
			.build();

    val response: ArrayOfMetadataApnsTokens = magicbellUserClient.channels.getMobilePushApnsTokens(requestParameters);
    
    println(response);
}

