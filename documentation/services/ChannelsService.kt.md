# ChannelsService

A list of all methods in the `ChannelsService` service. Click on the method name to view detailed information about that method.

| Methods                                                   | Description                                                                                                                                                                                                                                                      |
| :-------------------------------------------------------- | :--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| [getMobilePushApnsTokens](#getmobilepushapnstokens)       | Lists all mobile_push tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.                                                                                           |
| [saveMobilePushApnsToken](#savemobilepushapnstoken)       | Saves a mobile_push token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel. |
| [getMobilePushApnsToken](#getmobilepushapnstoken)         | Retrieves details of a specific mobile_push token belonging to the authenticated user. Returns information about the token's status, creation date, and any associated metadata. Users can only access their own tokens.                                         |
| [discardMobilePushApnsToken](#discardmobilepushapnstoken) | Revokes one of the authenticated user's mobile_push tokens. This permanently invalidates the specified token, preventing it from being used for future channel access. This action cannot be undone. Users can only revoke their own tokens.                     |
| [getMobilePushExpoTokens](#getmobilepushexpotokens)       | Lists all mobile_push tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.                                                                                           |
| [saveMobilePushExpoToken](#savemobilepushexpotoken)       | Saves a mobile_push token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel. |
| [getMobilePushExpoToken](#getmobilepushexpotoken)         | Retrieves details of a specific mobile_push token belonging to the authenticated user. Returns information about the token's status, creation date, and any associated metadata. Users can only access their own tokens.                                         |
| [discardMobilePushExpoToken](#discardmobilepushexpotoken) | Revokes one of the authenticated user's mobile_push tokens. This permanently invalidates the specified token, preventing it from being used for future channel access. This action cannot be undone. Users can only revoke their own tokens.                     |
| [getMobilePushFcmTokens](#getmobilepushfcmtokens)         | Lists all mobile_push tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.                                                                                           |
| [saveMobilePushFcmToken](#savemobilepushfcmtoken)         | Saves a mobile_push token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel. |
| [getMobilePushFcmToken](#getmobilepushfcmtoken)           | Retrieves details of a specific mobile_push token belonging to the authenticated user. Returns information about the token's status, creation date, and any associated metadata. Users can only access their own tokens.                                         |
| [discardMobilePushFcmToken](#discardmobilepushfcmtoken)   | Revokes one of the authenticated user's mobile_push tokens. This permanently invalidates the specified token, preventing it from being used for future channel access. This action cannot be undone. Users can only revoke their own tokens.                     |
| [getSlackTokens](#getslacktokens)                         | Lists all slack tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.                                                                                                 |
| [saveSlackToken](#saveslacktoken)                         | Saves a slack token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.       |
| [getSlackToken](#getslacktoken)                           | Retrieves details of a specific slack token belonging to the authenticated user. Returns information about the token's status, creation date, and any associated metadata. Users can only access their own tokens.                                               |
| [discardSlackToken](#discardslacktoken)                   | Revokes one of the authenticated user's slack tokens. This permanently invalidates the specified token, preventing it from being used for future channel access. This action cannot be undone. Users can only revoke their own tokens.                           |
| [getTeamsTokens](#getteamstokens)                         | Lists all teams tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.                                                                                                 |
| [saveTeamsToken](#saveteamstoken)                         | Saves a teams token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.       |
| [getTeamsToken](#getteamstoken)                           | Retrieves details of a specific teams token belonging to the authenticated user. Returns information about the token's status, creation date, and any associated metadata. Users can only access their own tokens.                                               |
| [discardTeamsToken](#discardteamstoken)                   | Revokes one of the authenticated user's teams tokens. This permanently invalidates the specified token, preventing it from being used for future channel access. This action cannot be undone. Users can only revoke their own tokens.                           |
| [getWebPushTokens](#getwebpushtokens)                     | Lists all web_push tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.                                                                                              |
| [saveWebPushToken](#savewebpushtoken)                     | Saves a web_push token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.    |
| [getWebPushToken](#getwebpushtoken)                       | Retrieves details of a specific web_push token belonging to the authenticated user. Returns information about the token's status, creation date, and any associated metadata. Users can only access their own tokens.                                            |
| [discardWebPushToken](#discardwebpushtoken)               | Revokes one of the authenticated user's web_push tokens. This permanently invalidates the specified token, preventing it from being used for future channel access. This action cannot be undone. Users can only revoke their own tokens.                        |

## getMobilePushApnsTokens

Lists all mobile_push tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.

- HTTP Method: `GET`
- Endpoint: `/channels/mobile_push/apns/tokens`

**Parameters**

| Name              | Type                                                                                | Required | Description               |
| :---------------- | :---------------------------------------------------------------------------------- | :------- | :------------------------ |
| requestParameters | [GetMobilePushApnsTokensParameters](../models/GetMobilePushApnsTokensParameters.md) | ❌       | Request Parameters Object |

**Return Type**

`ArrayOfMetadataApnsTokens`

**Example Usage Code Snippet**

```kotlin
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
			.pageAfter("page[after]")
			.pageBefore("page[before]")
			.build();

    val response: ArrayOfMetadataApnsTokens = magicbellUserClient.channels.getMobilePushApnsTokens(requestParameters);

    println(response);
}
```

## saveMobilePushApnsToken

Saves a mobile_push token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.

- HTTP Method: `POST`
- Endpoint: `/channels/mobile_push/apns/tokens`

**Parameters**

| Name      | Type                                | Required | Description  |
| :-------- | :---------------------------------- | :------- | :----------- |
| apnsToken | [ApnsToken](../models/ApnsToken.md) | ❌       | Request Body |

**Return Type**

`ApnsToken`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.userclient.MagicbellUserClient;
import com.magicbell.userclient.config.MagicbellUserClientConfig;
import com.magicbell.userclient.models.ApnsToken;
import com.magicbell.userclient.models.ApnsTokenInstallationId;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    ApnsToken apnsToken = ApnsToken.builder()
			.appId("app_id")
			.deviceToken("magna commodo s")
			.installationId(ApnsTokenInstallationId.DEVELOPMENT)
			.build();

    val response: ApnsToken = magicbellUserClient.channels.saveMobilePushApnsToken(apnsToken);

    println(response);
}
```

## getMobilePushApnsToken

Retrieves details of a specific mobile_push token belonging to the authenticated user. Returns information about the token's status, creation date, and any associated metadata. Users can only access their own tokens.

- HTTP Method: `GET`
- Endpoint: `/channels/mobile_push/apns/tokens/{token_id}`

**Parameters**

| Name    | Type   | Required | Description |
| :------ | :----- | :------- | :---------- |
| tokenId | String | ✅       |             |

**Return Type**

`MetadataApnsToken`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.userclient.MagicbellUserClient;
import com.magicbell.userclient.config.MagicbellUserClientConfig;
import com.magicbell.userclient.models.MetadataApnsToken;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val response: MetadataApnsToken = magicbellUserClient.channels.getMobilePushApnsToken("token_id");

    println(response);
}
```

## discardMobilePushApnsToken

Revokes one of the authenticated user's mobile_push tokens. This permanently invalidates the specified token, preventing it from being used for future channel access. This action cannot be undone. Users can only revoke their own tokens.

- HTTP Method: `DELETE`
- Endpoint: `/channels/mobile_push/apns/tokens/{token_id}`

**Parameters**

| Name    | Type   | Required | Description |
| :------ | :----- | :------- | :---------- |
| tokenId | String | ✅       |             |

**Return Type**

`DiscardResult`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.userclient.MagicbellUserClient;
import com.magicbell.userclient.config.MagicbellUserClientConfig;
import com.magicbell.userclient.models.DiscardResult;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val response: DiscardResult = magicbellUserClient.channels.discardMobilePushApnsToken("token_id");

    println(response);
}
```

## getMobilePushExpoTokens

Lists all mobile_push tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.

- HTTP Method: `GET`
- Endpoint: `/channels/mobile_push/expo/tokens`

**Parameters**

| Name              | Type                                                                                | Required | Description               |
| :---------------- | :---------------------------------------------------------------------------------- | :------- | :------------------------ |
| requestParameters | [GetMobilePushExpoTokensParameters](../models/GetMobilePushExpoTokensParameters.md) | ❌       | Request Parameters Object |

**Return Type**

`ArrayOfMetadataExpoTokens`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.userclient.MagicbellUserClient;
import com.magicbell.userclient.config.MagicbellUserClientConfig;
import com.magicbell.userclient.models.ArrayOfMetadataExpoTokens;
import com.magicbell.userclient.models.GetMobilePushExpoTokensParameters;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    GetMobilePushExpoTokensParameters requestParameters = GetMobilePushExpoTokensParameters.builder()
			.pageSize(7L)
			.pageAfter("page[after]")
			.pageBefore("page[before]")
			.build();

    val response: ArrayOfMetadataExpoTokens = magicbellUserClient.channels.getMobilePushExpoTokens(requestParameters);

    println(response);
}
```

## saveMobilePushExpoToken

Saves a mobile_push token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.

- HTTP Method: `POST`
- Endpoint: `/channels/mobile_push/expo/tokens`

**Parameters**

| Name      | Type                                | Required | Description  |
| :-------- | :---------------------------------- | :------- | :----------- |
| expoToken | [ExpoToken](../models/ExpoToken.md) | ❌       | Request Body |

**Return Type**

`ExpoToken`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.userclient.MagicbellUserClient;
import com.magicbell.userclient.config.MagicbellUserClientConfig;
import com.magicbell.userclient.models.ExpoToken;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    ExpoToken expoToken = ExpoToken.builder()
			.deviceToken("device_token")
			.build();

    val response: ExpoToken = magicbellUserClient.channels.saveMobilePushExpoToken(expoToken);

    println(response);
}
```

## getMobilePushExpoToken

Retrieves details of a specific mobile_push token belonging to the authenticated user. Returns information about the token's status, creation date, and any associated metadata. Users can only access their own tokens.

- HTTP Method: `GET`
- Endpoint: `/channels/mobile_push/expo/tokens/{token_id}`

**Parameters**

| Name    | Type   | Required | Description |
| :------ | :----- | :------- | :---------- |
| tokenId | String | ✅       |             |

**Return Type**

`MetadataExpoToken`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.userclient.MagicbellUserClient;
import com.magicbell.userclient.config.MagicbellUserClientConfig;
import com.magicbell.userclient.models.MetadataExpoToken;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val response: MetadataExpoToken = magicbellUserClient.channels.getMobilePushExpoToken("token_id");

    println(response);
}
```

## discardMobilePushExpoToken

Revokes one of the authenticated user's mobile_push tokens. This permanently invalidates the specified token, preventing it from being used for future channel access. This action cannot be undone. Users can only revoke their own tokens.

- HTTP Method: `DELETE`
- Endpoint: `/channels/mobile_push/expo/tokens/{token_id}`

**Parameters**

| Name    | Type   | Required | Description |
| :------ | :----- | :------- | :---------- |
| tokenId | String | ✅       |             |

**Return Type**

`DiscardResult`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.userclient.MagicbellUserClient;
import com.magicbell.userclient.config.MagicbellUserClientConfig;
import com.magicbell.userclient.models.DiscardResult;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val response: DiscardResult = magicbellUserClient.channels.discardMobilePushExpoToken("token_id");

    println(response);
}
```

## getMobilePushFcmTokens

Lists all mobile_push tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.

- HTTP Method: `GET`
- Endpoint: `/channels/mobile_push/fcm/tokens`

**Parameters**

| Name              | Type                                                                              | Required | Description               |
| :---------------- | :-------------------------------------------------------------------------------- | :------- | :------------------------ |
| requestParameters | [GetMobilePushFcmTokensParameters](../models/GetMobilePushFcmTokensParameters.md) | ❌       | Request Parameters Object |

**Return Type**

`ArrayOfMetadataFcmTokens`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.userclient.MagicbellUserClient;
import com.magicbell.userclient.config.MagicbellUserClientConfig;
import com.magicbell.userclient.models.ArrayOfMetadataFcmTokens;
import com.magicbell.userclient.models.GetMobilePushFcmTokensParameters;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    GetMobilePushFcmTokensParameters requestParameters = GetMobilePushFcmTokensParameters.builder()
			.pageSize(3L)
			.pageAfter("page[after]")
			.pageBefore("page[before]")
			.build();

    val response: ArrayOfMetadataFcmTokens = magicbellUserClient.channels.getMobilePushFcmTokens(requestParameters);

    println(response);
}
```

## saveMobilePushFcmToken

Saves a mobile_push token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.

- HTTP Method: `POST`
- Endpoint: `/channels/mobile_push/fcm/tokens`

**Parameters**

| Name     | Type                              | Required | Description  |
| :------- | :-------------------------------- | :------- | :----------- |
| fcmToken | [FcmToken](../models/FcmToken.md) | ❌       | Request Body |

**Return Type**

`FcmToken`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.userclient.MagicbellUserClient;
import com.magicbell.userclient.config.MagicbellUserClientConfig;
import com.magicbell.userclient.models.FcmToken;
import com.magicbell.userclient.models.FcmTokenInstallationId;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    FcmToken fcmToken = FcmToken.builder()
			.deviceToken("labore dolorull")
			.installationId(FcmTokenInstallationId.DEVELOPMENT)
			.build();

    val response: FcmToken = magicbellUserClient.channels.saveMobilePushFcmToken(fcmToken);

    println(response);
}
```

## getMobilePushFcmToken

Retrieves details of a specific mobile_push token belonging to the authenticated user. Returns information about the token's status, creation date, and any associated metadata. Users can only access their own tokens.

- HTTP Method: `GET`
- Endpoint: `/channels/mobile_push/fcm/tokens/{token_id}`

**Parameters**

| Name    | Type   | Required | Description |
| :------ | :----- | :------- | :---------- |
| tokenId | String | ✅       |             |

**Return Type**

`MetadataFcmToken`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.userclient.MagicbellUserClient;
import com.magicbell.userclient.config.MagicbellUserClientConfig;
import com.magicbell.userclient.models.MetadataFcmToken;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val response: MetadataFcmToken = magicbellUserClient.channels.getMobilePushFcmToken("token_id");

    println(response);
}
```

## discardMobilePushFcmToken

Revokes one of the authenticated user's mobile_push tokens. This permanently invalidates the specified token, preventing it from being used for future channel access. This action cannot be undone. Users can only revoke their own tokens.

- HTTP Method: `DELETE`
- Endpoint: `/channels/mobile_push/fcm/tokens/{token_id}`

**Parameters**

| Name    | Type   | Required | Description |
| :------ | :----- | :------- | :---------- |
| tokenId | String | ✅       |             |

**Return Type**

`DiscardResult`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.userclient.MagicbellUserClient;
import com.magicbell.userclient.config.MagicbellUserClientConfig;
import com.magicbell.userclient.models.DiscardResult;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val response: DiscardResult = magicbellUserClient.channels.discardMobilePushFcmToken("token_id");

    println(response);
}
```

## getSlackTokens

Lists all slack tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.

- HTTP Method: `GET`
- Endpoint: `/channels/slack/tokens`

**Parameters**

| Name              | Type                                                              | Required | Description               |
| :---------------- | :---------------------------------------------------------------- | :------- | :------------------------ |
| requestParameters | [GetSlackTokensParameters](../models/GetSlackTokensParameters.md) | ❌       | Request Parameters Object |

**Return Type**

`ArrayOfMetadataSlackTokens`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.userclient.MagicbellUserClient;
import com.magicbell.userclient.config.MagicbellUserClientConfig;
import com.magicbell.userclient.models.ArrayOfMetadataSlackTokens;
import com.magicbell.userclient.models.GetSlackTokensParameters;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    GetSlackTokensParameters requestParameters = GetSlackTokensParameters.builder()
			.pageSize(1L)
			.pageAfter("page[after]")
			.pageBefore("page[before]")
			.build();

    val response: ArrayOfMetadataSlackTokens = magicbellUserClient.channels.getSlackTokens(requestParameters);

    println(response);
}
```

## saveSlackToken

Saves a slack token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.

- HTTP Method: `POST`
- Endpoint: `/channels/slack/tokens`

**Parameters**

| Name       | Type                                  | Required | Description  |
| :--------- | :------------------------------------ | :------- | :----------- |
| slackToken | [SlackToken](../models/SlackToken.md) | ❌       | Request Body |

**Return Type**

`SlackToken`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.userclient.MagicbellUserClient;
import com.magicbell.userclient.config.MagicbellUserClientConfig;
import com.magicbell.userclient.models.Oauth;
import com.magicbell.userclient.models.SlackToken;
import com.magicbell.userclient.models.SlackTokenWebhook;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    Oauth oauth = Oauth.builder()
			.channelId("channel_id")
			.installationId("installation_id")
			.scope("scope")
			.build();

		SlackTokenWebhook slackTokenWebhook = SlackTokenWebhook.builder()
			.url("url")
			.build();

		SlackToken slackToken = SlackToken.builder()
			.oauth(oauth)
			.webhook(slackTokenWebhook)
			.build();

    val response: SlackToken = magicbellUserClient.channels.saveSlackToken(slackToken);

    println(response);
}
```

## getSlackToken

Retrieves details of a specific slack token belonging to the authenticated user. Returns information about the token's status, creation date, and any associated metadata. Users can only access their own tokens.

- HTTP Method: `GET`
- Endpoint: `/channels/slack/tokens/{token_id}`

**Parameters**

| Name    | Type   | Required | Description |
| :------ | :----- | :------- | :---------- |
| tokenId | String | ✅       |             |

**Return Type**

`MetadataSlackToken`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.userclient.MagicbellUserClient;
import com.magicbell.userclient.config.MagicbellUserClientConfig;
import com.magicbell.userclient.models.MetadataSlackToken;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val response: MetadataSlackToken = magicbellUserClient.channels.getSlackToken("token_id");

    println(response);
}
```

## discardSlackToken

Revokes one of the authenticated user's slack tokens. This permanently invalidates the specified token, preventing it from being used for future channel access. This action cannot be undone. Users can only revoke their own tokens.

- HTTP Method: `DELETE`
- Endpoint: `/channels/slack/tokens/{token_id}`

**Parameters**

| Name    | Type   | Required | Description |
| :------ | :----- | :------- | :---------- |
| tokenId | String | ✅       |             |

**Return Type**

`DiscardResult`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.userclient.MagicbellUserClient;
import com.magicbell.userclient.config.MagicbellUserClientConfig;
import com.magicbell.userclient.models.DiscardResult;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val response: DiscardResult = magicbellUserClient.channels.discardSlackToken("token_id");

    println(response);
}
```

## getTeamsTokens

Lists all teams tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.

- HTTP Method: `GET`
- Endpoint: `/channels/teams/tokens`

**Parameters**

| Name              | Type                                                              | Required | Description               |
| :---------------- | :---------------------------------------------------------------- | :------- | :------------------------ |
| requestParameters | [GetTeamsTokensParameters](../models/GetTeamsTokensParameters.md) | ❌       | Request Parameters Object |

**Return Type**

`ArrayOfMetadataTeamsTokens`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.userclient.MagicbellUserClient;
import com.magicbell.userclient.config.MagicbellUserClientConfig;
import com.magicbell.userclient.models.ArrayOfMetadataTeamsTokens;
import com.magicbell.userclient.models.GetTeamsTokensParameters;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    GetTeamsTokensParameters requestParameters = GetTeamsTokensParameters.builder()
			.pageSize(4L)
			.pageAfter("page[after]")
			.pageBefore("page[before]")
			.build();

    val response: ArrayOfMetadataTeamsTokens = magicbellUserClient.channels.getTeamsTokens(requestParameters);

    println(response);
}
```

## saveTeamsToken

Saves a teams token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.

- HTTP Method: `POST`
- Endpoint: `/channels/teams/tokens`

**Parameters**

| Name       | Type                                  | Required | Description  |
| :--------- | :------------------------------------ | :------- | :----------- |
| teamsToken | [TeamsToken](../models/TeamsToken.md) | ❌       | Request Body |

**Return Type**

`TeamsToken`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.userclient.MagicbellUserClient;
import com.magicbell.userclient.config.MagicbellUserClientConfig;
import com.magicbell.userclient.models.TeamsToken;
import com.magicbell.userclient.models.TeamsTokenWebhook;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    TeamsTokenWebhook teamsTokenWebhook = TeamsTokenWebhook.builder()
			.url("url")
			.build();

		TeamsToken teamsToken = TeamsToken.builder()
			.webhook(teamsTokenWebhook)
			.build();

    val response: TeamsToken = magicbellUserClient.channels.saveTeamsToken(teamsToken);

    println(response);
}
```

## getTeamsToken

Retrieves details of a specific teams token belonging to the authenticated user. Returns information about the token's status, creation date, and any associated metadata. Users can only access their own tokens.

- HTTP Method: `GET`
- Endpoint: `/channels/teams/tokens/{token_id}`

**Parameters**

| Name    | Type   | Required | Description |
| :------ | :----- | :------- | :---------- |
| tokenId | String | ✅       |             |

**Return Type**

`MetadataTeamsToken`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.userclient.MagicbellUserClient;
import com.magicbell.userclient.config.MagicbellUserClientConfig;
import com.magicbell.userclient.models.MetadataTeamsToken;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val response: MetadataTeamsToken = magicbellUserClient.channels.getTeamsToken("token_id");

    println(response);
}
```

## discardTeamsToken

Revokes one of the authenticated user's teams tokens. This permanently invalidates the specified token, preventing it from being used for future channel access. This action cannot be undone. Users can only revoke their own tokens.

- HTTP Method: `DELETE`
- Endpoint: `/channels/teams/tokens/{token_id}`

**Parameters**

| Name    | Type   | Required | Description |
| :------ | :----- | :------- | :---------- |
| tokenId | String | ✅       |             |

**Return Type**

`DiscardResult`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.userclient.MagicbellUserClient;
import com.magicbell.userclient.config.MagicbellUserClientConfig;
import com.magicbell.userclient.models.DiscardResult;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val response: DiscardResult = magicbellUserClient.channels.discardTeamsToken("token_id");

    println(response);
}
```

## getWebPushTokens

Lists all web_push tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.

- HTTP Method: `GET`
- Endpoint: `/channels/web_push/tokens`

**Parameters**

| Name              | Type                                                                  | Required | Description               |
| :---------------- | :-------------------------------------------------------------------- | :------- | :------------------------ |
| requestParameters | [GetWebPushTokensParameters](../models/GetWebPushTokensParameters.md) | ❌       | Request Parameters Object |

**Return Type**

`ArrayOfMetadataWebPushTokens`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.userclient.MagicbellUserClient;
import com.magicbell.userclient.config.MagicbellUserClientConfig;
import com.magicbell.userclient.models.ArrayOfMetadataWebPushTokens;
import com.magicbell.userclient.models.GetWebPushTokensParameters;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    GetWebPushTokensParameters requestParameters = GetWebPushTokensParameters.builder()
			.pageSize(5L)
			.pageAfter("page[after]")
			.pageBefore("page[before]")
			.build();

    val response: ArrayOfMetadataWebPushTokens = magicbellUserClient.channels.getWebPushTokens(requestParameters);

    println(response);
}
```

## saveWebPushToken

Saves a web_push token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.

- HTTP Method: `POST`
- Endpoint: `/channels/web_push/tokens`

**Parameters**

| Name         | Type                                      | Required | Description  |
| :----------- | :---------------------------------------- | :------- | :----------- |
| webPushToken | [WebPushToken](../models/WebPushToken.md) | ❌       | Request Body |

**Return Type**

`WebPushToken`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.userclient.MagicbellUserClient;
import com.magicbell.userclient.config.MagicbellUserClientConfig;
import com.magicbell.userclient.models.Keys;
import com.magicbell.userclient.models.WebPushToken;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    Keys keys = Keys.builder()
			.auth("auth")
			.p256dh("p256dh")
			.build();

		WebPushToken webPushToken = WebPushToken.builder()
			.endpoint("endpoint")
			.keys(keys)
			.build();

    val response: WebPushToken = magicbellUserClient.channels.saveWebPushToken(webPushToken);

    println(response);
}
```

## getWebPushToken

Retrieves details of a specific web_push token belonging to the authenticated user. Returns information about the token's status, creation date, and any associated metadata. Users can only access their own tokens.

- HTTP Method: `GET`
- Endpoint: `/channels/web_push/tokens/{token_id}`

**Parameters**

| Name    | Type   | Required | Description |
| :------ | :----- | :------- | :---------- |
| tokenId | String | ✅       |             |

**Return Type**

`MetadataWebPushToken`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.userclient.MagicbellUserClient;
import com.magicbell.userclient.config.MagicbellUserClientConfig;
import com.magicbell.userclient.models.MetadataWebPushToken;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val response: MetadataWebPushToken = magicbellUserClient.channels.getWebPushToken("token_id");

    println(response);
}
```

## discardWebPushToken

Revokes one of the authenticated user's web_push tokens. This permanently invalidates the specified token, preventing it from being used for future channel access. This action cannot be undone. Users can only revoke their own tokens.

- HTTP Method: `DELETE`
- Endpoint: `/channels/web_push/tokens/{token_id}`

**Parameters**

| Name    | Type   | Required | Description |
| :------ | :----- | :------- | :---------- |
| tokenId | String | ✅       |             |

**Return Type**

`DiscardResult`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.userclient.MagicbellUserClient;
import com.magicbell.userclient.config.MagicbellUserClientConfig;
import com.magicbell.userclient.models.DiscardResult;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val response: DiscardResult = magicbellUserClient.channels.discardWebPushToken("token_id");

    println(response);
}
```
