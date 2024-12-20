package com.example

import com.magicbell.userclient.MagicbellJavaUserClient;
import com.magicbell.userclient.config.MagicbellJavaUserClientConfig;
import com.magicbell.userclient.models.ArrayOfMetadataApnsTokens;
import com.magicbell.userclient.models.GetMobilePushApnsTokensParameters;

fun main() {
	val config: MagicbellJavaUserClientConfig = MagicbellJavaUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellJavaUserClient: MagicbellJavaUserClient = MagicbellJavaUserClient(config);

    GetMobilePushApnsTokensParameters requestParameters = GetMobilePushApnsTokensParameters.builder()
			.pageSize(9L)
			.pageAfter("")
			.pageBefore("")
			.build();

    val response: ArrayOfMetadataApnsTokens = magicbellJavaUserClient.channels.getMobilePushApnsTokens(requestParameters);
    
    println(response);
}

