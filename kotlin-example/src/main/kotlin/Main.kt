package com.example

import com.magicbell.client.magicbelljavaclient.MagicbellJavaClient;
import com.magicbell.client.magicbelljavaclient.config.MagicbellJavaClientConfig;
import com.magicbell.client.magicbelljavaclient.models.ArrayOfMetadataApnsTokens;
import com.magicbell.client.magicbelljavaclient.models.GetMobilePushApnsTokensParameters;

fun main() {
	val config: MagicbellJavaClientConfig = MagicbellJavaClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellJavaClient: MagicbellJavaClient = MagicbellJavaClient(config);

    GetMobilePushApnsTokensParameters requestParameters = GetMobilePushApnsTokensParameters.builder()
			.pageSize(3L)
			.pageAfter("")
			.pageBefore("")
			.build();

    val response: ArrayOfMetadataApnsTokens = magicbellJavaClient.channels.getMobilePushApnsTokens(requestParameters);
    
    println(response);
}

