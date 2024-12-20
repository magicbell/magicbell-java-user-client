package com.example

import com.magicbell.user_client.magicbelljavauserclient.MagicbellJavaUserClient;
import com.magicbell.user_client.magicbelljavauserclient.config.MagicbellJavaUserClientConfig;
import com.magicbell.user_client.magicbelljavauserclient.models.ArrayOfMetadataApnsTokens;
import com.magicbell.user_client.magicbelljavauserclient.models.GetMobilePushApnsTokensParameters;

fun main() {
	val config: MagicbellJavaUserClientConfig = MagicbellJavaUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellJavaUserClient: MagicbellJavaUserClient = MagicbellJavaUserClient(config);

    GetMobilePushApnsTokensParameters requestParameters = GetMobilePushApnsTokensParameters.builder()
			.pageSize(8L)
			.pageAfter("")
			.pageBefore("")
			.build();

    val response: ArrayOfMetadataApnsTokens = magicbellJavaUserClient.channels.getMobilePushApnsTokens(requestParameters);
    
    println(response);
}

