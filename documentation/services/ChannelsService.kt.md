# ChannelsService

A list of all methods in the `ChannelsService` service. Click on the method name to view detailed information about that method.

| Methods                                                   | Description                                                                                                                                                                                                                                                      |
| :-------------------------------------------------------- | :--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| [getInAppInboxTokens](#getinappinboxtokens)               | Lists all in_app tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.                                                                                                |
| [saveInAppInboxToken](#saveinappinboxtoken)               | Saves a in_app token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.      |
| [getInAppInboxToken](#getinappinboxtoken)                 | Retrieves details of a specific in_app token belonging to the authenticated user. Returns information about the token's status, creation date, and any associated metadata. Users can only access their own tokens.                                              |
| [discardInAppInboxToken](#discardinappinboxtoken)         | Revokes one of the authenticated user's in_app tokens. This permanently invalidates the specified token, preventing it from being used for future channel access. This action cannot be undone. Users can only revoke their own tokens.                          |
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

## getInAppInboxTokens

Lists all in_app tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.

- HTTP Method: `GET`
- Endpoint: `/channels/in_app/inbox/tokens`

**Parameters**

| Name              | Type                                                                        | Required | Description               |
| :---------------- | :-------------------------------------------------------------------------- | :------- | :------------------------ |
| requestParameters | [GetInAppInboxTokensParameters](../models/GetInAppInboxTokensParameters.md) | ❌       | Request Parameters Object |

**Return Type**

`InboxTokenResponseCollection`

**Example Usage Code Snippet**

```kotlin
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
```

## saveInAppInboxToken

Saves a in_app token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.

- HTTP Method: `POST`
- Endpoint: `/channels/in_app/inbox/tokens`

**Parameters**

| Name       | Type                                  | Required | Description  |
| :--------- | :------------------------------------ | :------- | :----------- |
| inboxToken | [InboxToken](../models/InboxToken.md) | ❌       | Request Body |

**Return Type**

`InboxToken`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.InboxToken;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val inboxToken: InboxToken = InboxToken.builder()
			.connectionId("connection_id")
			.token("in exeu esse co")
			.build();

    val response: InboxToken = magicbellUserClient.channels.saveInAppInboxToken(inboxToken);

    println(response);
}
```

## getInAppInboxToken

Retrieves details of a specific in_app token belonging to the authenticated user. Returns information about the token's status, creation date, and any associated metadata. Users can only access their own tokens.

- HTTP Method: `GET`
- Endpoint: `/channels/in_app/inbox/tokens/{token_id}`

**Parameters**

| Name    | Type   | Required | Description |
| :------ | :----- | :------- | :---------- |
| tokenId | String | ✅       |             |

**Return Type**

`InboxTokenResponse`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.InboxTokenResponse;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val response: InboxTokenResponse = magicbellUserClient.channels.getInAppInboxToken("token_id");

    println(response);
}
```

## discardInAppInboxToken

Revokes one of the authenticated user's in_app tokens. This permanently invalidates the specified token, preventing it from being used for future channel access. This action cannot be undone. Users can only revoke their own tokens.

- HTTP Method: `DELETE`
- Endpoint: `/channels/in_app/inbox/tokens/{token_id}`

**Parameters**

| Name    | Type   | Required | Description |
| :------ | :----- | :------- | :---------- |
| tokenId | String | ✅       |             |

**Return Type**

`DiscardResult`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.DiscardResult;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val response: DiscardResult = magicbellUserClient.channels.discardInAppInboxToken("token_id");

    println(response);
}
```

## getMobilePushApnsTokens

Lists all mobile_push tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.

- HTTP Method: `GET`
- Endpoint: `/channels/mobile_push/apns/tokens`

**Parameters**

| Name              | Type                                                                                | Required | Description               |
| :---------------- | :---------------------------------------------------------------------------------- | :------- | :------------------------ |
| requestParameters | [GetMobilePushApnsTokensParameters](../models/GetMobilePushApnsTokensParameters.md) | ❌       | Request Parameters Object |

**Return Type**

`ApnsTokenCollection`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.ApnsTokenCollection;
import com.magicbell.magicbelluserclient.models.GetMobilePushApnsTokensParameters;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val requestParameters: GetMobilePushApnsTokensParameters = GetMobilePushApnsTokensParameters.builder()
			.limit(3L)
			.startingAfter("starting_after")
			.endingBefore("ending_before")
			.build();

    val response: ApnsTokenCollection = magicbellUserClient.channels.getMobilePushApnsTokens(requestParameters);

    println(response);
}
```

## saveMobilePushApnsToken

Saves a mobile_push token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.

- HTTP Method: `POST`
- Endpoint: `/channels/mobile_push/apns/tokens`

**Parameters**

| Name             | Type                                              | Required | Description  |
| :--------------- | :------------------------------------------------ | :------- | :----------- |
| apnsTokenPayload | [ApnsTokenPayload](../models/ApnsTokenPayload.md) | ❌       | Request Body |

**Return Type**

`ApnsTokenPayload`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.ApnsTokenPayload;
import com.magicbell.magicbelluserclient.models.ApnsTokenPayloadInstallationId;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val apnsTokenPayload: ApnsTokenPayload = ApnsTokenPayload.builder()
			.appId("app_id")
			.deviceToken("doloresed quis ")
			.installationId(ApnsTokenPayloadInstallationId.DEVELOPMENT)
			.build();

    val response: ApnsTokenPayload = magicbellUserClient.channels.saveMobilePushApnsToken(apnsTokenPayload);

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

`ApnsToken`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.ApnsToken;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val response: ApnsToken = magicbellUserClient.channels.getMobilePushApnsToken("token_id");

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
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.DiscardResult;

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

`ExpoTokenCollection`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.ExpoTokenCollection;
import com.magicbell.magicbelluserclient.models.GetMobilePushExpoTokensParameters;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val requestParameters: GetMobilePushExpoTokensParameters = GetMobilePushExpoTokensParameters.builder()
			.limit(9L)
			.startingAfter("starting_after")
			.endingBefore("ending_before")
			.build();

    val response: ExpoTokenCollection = magicbellUserClient.channels.getMobilePushExpoTokens(requestParameters);

    println(response);
}
```

## saveMobilePushExpoToken

Saves a mobile_push token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.

- HTTP Method: `POST`
- Endpoint: `/channels/mobile_push/expo/tokens`

**Parameters**

| Name             | Type                                              | Required | Description  |
| :--------------- | :------------------------------------------------ | :------- | :----------- |
| expoTokenPayload | [ExpoTokenPayload](../models/ExpoTokenPayload.md) | ❌       | Request Body |

**Return Type**

`ExpoTokenPayload`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.ExpoTokenPayload;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val expoTokenPayload: ExpoTokenPayload = ExpoTokenPayload.builder()
			.deviceToken("device_token")
			.build();

    val response: ExpoTokenPayload = magicbellUserClient.channels.saveMobilePushExpoToken(expoTokenPayload);

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

`ExpoToken`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.ExpoToken;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val response: ExpoToken = magicbellUserClient.channels.getMobilePushExpoToken("token_id");

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
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.DiscardResult;

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

`FcmTokenCollection`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.FcmTokenCollection;
import com.magicbell.magicbelluserclient.models.GetMobilePushFcmTokensParameters;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val requestParameters: GetMobilePushFcmTokensParameters = GetMobilePushFcmTokensParameters.builder()
			.limit(6L)
			.startingAfter("starting_after")
			.endingBefore("ending_before")
			.build();

    val response: FcmTokenCollection = magicbellUserClient.channels.getMobilePushFcmTokens(requestParameters);

    println(response);
}
```

## saveMobilePushFcmToken

Saves a mobile_push token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.

- HTTP Method: `POST`
- Endpoint: `/channels/mobile_push/fcm/tokens`

**Parameters**

| Name            | Type                                            | Required | Description  |
| :-------------- | :---------------------------------------------- | :------- | :----------- |
| fcmTokenPayload | [FcmTokenPayload](../models/FcmTokenPayload.md) | ❌       | Request Body |

**Return Type**

`FcmTokenPayload`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.FcmTokenPayload;
import com.magicbell.magicbelluserclient.models.FcmTokenPayloadInstallationId;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val fcmTokenPayload: FcmTokenPayload = FcmTokenPayload.builder()
			.deviceToken("in commodo quis")
			.installationId(FcmTokenPayloadInstallationId.DEVELOPMENT)
			.build();

    val response: FcmTokenPayload = magicbellUserClient.channels.saveMobilePushFcmToken(fcmTokenPayload);

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

`FcmToken`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.FcmToken;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val response: FcmToken = magicbellUserClient.channels.getMobilePushFcmToken("token_id");

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
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.DiscardResult;

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

`SlackTokenCollection`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.GetSlackTokensParameters;
import com.magicbell.magicbelluserclient.models.SlackTokenCollection;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val requestParameters: GetSlackTokensParameters = GetSlackTokensParameters.builder()
			.limit(2L)
			.startingAfter("starting_after")
			.endingBefore("ending_before")
			.build();

    val response: SlackTokenCollection = magicbellUserClient.channels.getSlackTokens(requestParameters);

    println(response);
}
```

## saveSlackToken

Saves a slack token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.

- HTTP Method: `POST`
- Endpoint: `/channels/slack/tokens`

**Parameters**

| Name              | Type                                                | Required | Description  |
| :---------------- | :-------------------------------------------------- | :------- | :----------- |
| slackTokenPayload | [SlackTokenPayload](../models/SlackTokenPayload.md) | ❌       | Request Body |

**Return Type**

`SlackTokenPayload`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.SlackTokenPayload;
import com.magicbell.magicbelluserclient.models.SlackTokenPayloadOauth;
import com.magicbell.magicbelluserclient.models.SlackTokenPayloadWebhook;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val slackTokenPayloadOauth: SlackTokenPayloadOauth = SlackTokenPayloadOauth.builder()
			.channelId("channel_id")
			.installationId("installation_id")
			.scope("scope")
			.build();

		val slackTokenPayloadWebhook: SlackTokenPayloadWebhook = SlackTokenPayloadWebhook.builder()
			.url("url")
			.build();

		val slackTokenPayload: SlackTokenPayload = SlackTokenPayload.builder()
			.oauth(slackTokenPayloadOauth)
			.webhook(slackTokenPayloadWebhook)
			.build();

    val response: SlackTokenPayload = magicbellUserClient.channels.saveSlackToken(slackTokenPayload);

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

`SlackToken`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.SlackToken;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val response: SlackToken = magicbellUserClient.channels.getSlackToken("token_id");

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
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.DiscardResult;

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

`TeamsTokenCollection`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.GetTeamsTokensParameters;
import com.magicbell.magicbelluserclient.models.TeamsTokenCollection;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val requestParameters: GetTeamsTokensParameters = GetTeamsTokensParameters.builder()
			.limit(5L)
			.startingAfter("starting_after")
			.endingBefore("ending_before")
			.build();

    val response: TeamsTokenCollection = magicbellUserClient.channels.getTeamsTokens(requestParameters);

    println(response);
}
```

## saveTeamsToken

Saves a teams token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.

- HTTP Method: `POST`
- Endpoint: `/channels/teams/tokens`

**Parameters**

| Name              | Type                                                | Required | Description  |
| :---------------- | :-------------------------------------------------- | :------- | :----------- |
| teamsTokenPayload | [TeamsTokenPayload](../models/TeamsTokenPayload.md) | ❌       | Request Body |

**Return Type**

`TeamsTokenPayload`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.TeamsTokenPayload;
import com.magicbell.magicbelluserclient.models.TeamsTokenPayloadWebhook;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val teamsTokenPayloadWebhook: TeamsTokenPayloadWebhook = TeamsTokenPayloadWebhook.builder()
			.url("url")
			.build();

		val teamsTokenPayload: TeamsTokenPayload = TeamsTokenPayload.builder()
			.webhook(teamsTokenPayloadWebhook)
			.build();

    val response: TeamsTokenPayload = magicbellUserClient.channels.saveTeamsToken(teamsTokenPayload);

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

`TeamsToken`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.TeamsToken;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val response: TeamsToken = magicbellUserClient.channels.getTeamsToken("token_id");

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
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.DiscardResult;

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

`WebPushTokenCollection`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.GetWebPushTokensParameters;
import com.magicbell.magicbelluserclient.models.WebPushTokenCollection;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val requestParameters: GetWebPushTokensParameters = GetWebPushTokensParameters.builder()
			.limit(3L)
			.startingAfter("starting_after")
			.endingBefore("ending_before")
			.build();

    val response: WebPushTokenCollection = magicbellUserClient.channels.getWebPushTokens(requestParameters);

    println(response);
}
```

## saveWebPushToken

Saves a web_push token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.

- HTTP Method: `POST`
- Endpoint: `/channels/web_push/tokens`

**Parameters**

| Name                | Type                                                    | Required | Description  |
| :------------------ | :------------------------------------------------------ | :------- | :----------- |
| webPushTokenPayload | [WebPushTokenPayload](../models/WebPushTokenPayload.md) | ❌       | Request Body |

**Return Type**

`WebPushTokenPayload`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.WebPushTokenPayload;
import com.magicbell.magicbelluserclient.models.WebPushTokenPayloadKeys;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val webPushTokenPayloadKeys: WebPushTokenPayloadKeys = WebPushTokenPayloadKeys.builder()
			.auth("auth")
			.p256dh("p256dh")
			.build();

		val webPushTokenPayload: WebPushTokenPayload = WebPushTokenPayload.builder()
			.endpoint("endpoint")
			.keys(webPushTokenPayloadKeys)
			.build();

    val response: WebPushTokenPayload = magicbellUserClient.channels.saveWebPushToken(webPushTokenPayload);

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

`WebPushToken`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.WebPushToken;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val response: WebPushToken = magicbellUserClient.channels.getWebPushToken("token_id");

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
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.DiscardResult;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val response: DiscardResult = magicbellUserClient.channels.discardWebPushToken("token_id");

    println(response);
}
```
