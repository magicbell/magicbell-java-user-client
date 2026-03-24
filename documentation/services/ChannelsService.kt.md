# ChannelsService

A list of all methods in the `ChannelsService` service. Click on the method name to view detailed information about that method.

| Methods                                                       | Description                                                                                                                                                                                                                                                               |
| :------------------------------------------------------------ | :------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| [listInboxTokens](#listinboxtokens)                           | Lists all Inbox tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.                                                                                                          |
| [saveInboxToken](#saveinboxtoken)                             | Saves the Inbox token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.              |
| [fetchInboxToken](#fetchinboxtoken)                           | Fetches details of a specific Inbox token belonging to the authenticated user. Returns information about the token's status, creation date, and any associated metadata. Users can only access their own tokens.                                                          |
| [deleteInboxToken](#deleteinboxtoken)                         | Deletes one of the authenticated user's Inbox tokens. This permanently invalidates the specified token, preventing it from being used for future channel access. This action cannot be undone. Users can only revoke their own tokens.                                    |
| [listApnsTokens](#listapnstokens)                             | Lists all APNs tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.                                                                                                           |
| [saveApnsToken](#saveapnstoken)                               | Saves the APNs token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.               |
| [fetchApnsToken](#fetchapnstoken)                             | Fetches details of a specific APNs token belonging to the authenticated user. Returns information about the token's status, creation date, and any associated metadata. Users can only access their own tokens.                                                           |
| [deleteApnsToken](#deleteapnstoken)                           | Deletes one of the authenticated user's APNs tokens. This permanently invalidates the specified token, preventing it from being used for future channel access. This action cannot be undone. Users can only revoke their own tokens.                                     |
| [listExpoTokens](#listexpotokens)                             | Lists all Expo tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.                                                                                                           |
| [saveExpoToken](#saveexpotoken)                               | Saves the Expo token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.               |
| [fetchExpoToken](#fetchexpotoken)                             | Fetches details of a specific Expo token belonging to the authenticated user. Returns information about the token's status, creation date, and any associated metadata. Users can only access their own tokens.                                                           |
| [deleteExpoToken](#deleteexpotoken)                           | Deletes one of the authenticated user's Expo tokens. This permanently invalidates the specified token, preventing it from being used for future channel access. This action cannot be undone. Users can only revoke their own tokens.                                     |
| [listFcmTokens](#listfcmtokens)                               | Lists all FCM tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.                                                                                                            |
| [saveFcmToken](#savefcmtoken)                                 | Saves the FCM token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.                |
| [fetchFcmToken](#fetchfcmtoken)                               | Fetches details of a specific FCM token belonging to the authenticated user. Returns information about the token's status, creation date, and any associated metadata. Users can only access their own tokens.                                                            |
| [deleteFcmToken](#deletefcmtoken)                             | Deletes one of the authenticated user's FCM tokens. This permanently invalidates the specified token, preventing it from being used for future channel access. This action cannot be undone. Users can only revoke their own tokens.                                      |
| [listMagicbellSlackbotTokens](#listmagicbellslackbottokens)   | Lists all MagicBell SlackBot tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.                                                                                             |
| [saveMagicbellSlackbotToken](#savemagicbellslackbottoken)     | Saves the MagicBell SlackBot token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel. |
| [fetchMagicbellSlackbotToken](#fetchmagicbellslackbottoken)   | Fetches details of a specific MagicBell SlackBot token belonging to the authenticated user. Returns information about the token's status, creation date, and any associated metadata. Users can only access their own tokens.                                             |
| [deleteMagicbellSlackbotToken](#deletemagicbellslackbottoken) | Deletes one of the authenticated user's MagicBell SlackBot tokens. This permanently invalidates the specified token, preventing it from being used for future channel access. This action cannot be undone. Users can only revoke their own tokens.                       |
| [listSlackTokens](#listslacktokens)                           | Lists all Slack tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.                                                                                                          |
| [saveSlackToken](#saveslacktoken)                             | Saves the Slack token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.              |
| [fetchSlackToken](#fetchslacktoken)                           | Fetches details of a specific Slack token belonging to the authenticated user. Returns information about the token's status, creation date, and any associated metadata. Users can only access their own tokens.                                                          |
| [deleteSlackToken](#deleteslacktoken)                         | Deletes one of the authenticated user's Slack tokens. This permanently invalidates the specified token, preventing it from being used for future channel access. This action cannot be undone. Users can only revoke their own tokens.                                    |
| [listTeamsTokens](#listteamstokens)                           | Lists all Teams tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.                                                                                                          |
| [saveTeamsToken](#saveteamstoken)                             | Saves the Teams token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.              |
| [fetchTeamsToken](#fetchteamstoken)                           | Fetches details of a specific Teams token belonging to the authenticated user. Returns information about the token's status, creation date, and any associated metadata. Users can only access their own tokens.                                                          |
| [deleteTeamsToken](#deleteteamstoken)                         | Deletes one of the authenticated user's Teams tokens. This permanently invalidates the specified token, preventing it from being used for future channel access. This action cannot be undone. Users can only revoke their own tokens.                                    |
| [fetchUserPreferences](#fetchuserpreferences)                 | Fetch a user's channel delivery preferences.                                                                                                                                                                                                                              |
| [saveUserPreferences](#saveuserpreferences)                   | Save a user's channel preferences.                                                                                                                                                                                                                                        |
| [listWebPushTokens](#listwebpushtokens)                       | Lists all Web Push tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.                                                                                                       |
| [saveWebPushToken](#savewebpushtoken)                         | Saves the Web Push token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.           |
| [fetchWebPushToken](#fetchwebpushtoken)                       | Fetches details of a specific Web Push token belonging to the authenticated user. Returns information about the token's status, creation date, and any associated metadata. Users can only access their own tokens.                                                       |
| [deleteWebPushToken](#deletewebpushtoken)                     | Deletes one of the authenticated user's Web Push tokens. This permanently invalidates the specified token, preventing it from being used for future channel access. This action cannot be undone. Users can only revoke their own tokens.                                 |

## listInboxTokens

Lists all Inbox tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.

- HTTP Method: `GET`
- Endpoint: `/channels/in_app/inbox/tokens`

**Parameters**

| Name              | Type                                                                | Required | Description               |
| :---------------- | :------------------------------------------------------------------ | :------- | :------------------------ |
| requestParameters | [ListInboxTokensParameters](../models/ListInboxTokensParameters.md) | ❌       | Request Parameters Object |

**Return Type**

`InboxTokenResponseCollection`

**Example Usage Code Snippet**

```kotlin
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
```

## saveInboxToken

Saves the Inbox token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.

- HTTP Method: `PUT`
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
			.token("ipsum nulla mag")
			.build();

    val response: InboxToken = magicbellUserClient.channels.saveInboxToken(inboxToken);

    println(response);
}
```

## fetchInboxToken

Fetches details of a specific Inbox token belonging to the authenticated user. Returns information about the token's status, creation date, and any associated metadata. Users can only access their own tokens.

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

    val response: InboxTokenResponse = magicbellUserClient.channels.fetchInboxToken("token_id");

    println(response);
}
```

## deleteInboxToken

Deletes one of the authenticated user's Inbox tokens. This permanently invalidates the specified token, preventing it from being used for future channel access. This action cannot be undone. Users can only revoke their own tokens.

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

    val response: DiscardResult = magicbellUserClient.channels.deleteInboxToken("token_id");

    println(response);
}
```

## listApnsTokens

Lists all APNs tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.

- HTTP Method: `GET`
- Endpoint: `/channels/mobile_push/apns/tokens`

**Parameters**

| Name              | Type                                                              | Required | Description               |
| :---------------- | :---------------------------------------------------------------- | :------- | :------------------------ |
| requestParameters | [ListApnsTokensParameters](../models/ListApnsTokensParameters.md) | ❌       | Request Parameters Object |

**Return Type**

`ApnsTokenCollection`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.ApnsTokenCollection;
import com.magicbell.magicbelluserclient.models.ListApnsTokensParameters;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val requestParameters: ListApnsTokensParameters = ListApnsTokensParameters.builder()
			.limit(7L)
			.startingAfter("starting_after")
			.endingBefore("ending_before")
			.build();

    val response: ApnsTokenCollection = magicbellUserClient.channels.listApnsTokens(requestParameters);

    println(response);
}
```

## saveApnsToken

Saves the APNs token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.

- HTTP Method: `PUT`
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
			.deviceToken("sit culpa incid")
			.installationId(ApnsTokenPayloadInstallationId.DEVELOPMENT)
			.build();

    val response: ApnsTokenPayload = magicbellUserClient.channels.saveApnsToken(apnsTokenPayload);

    println(response);
}
```

## fetchApnsToken

Fetches details of a specific APNs token belonging to the authenticated user. Returns information about the token's status, creation date, and any associated metadata. Users can only access their own tokens.

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

    val response: ApnsToken = magicbellUserClient.channels.fetchApnsToken("token_id");

    println(response);
}
```

## deleteApnsToken

Deletes one of the authenticated user's APNs tokens. This permanently invalidates the specified token, preventing it from being used for future channel access. This action cannot be undone. Users can only revoke their own tokens.

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

    val response: DiscardResult = magicbellUserClient.channels.deleteApnsToken("token_id");

    println(response);
}
```

## listExpoTokens

Lists all Expo tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.

- HTTP Method: `GET`
- Endpoint: `/channels/mobile_push/expo/tokens`

**Parameters**

| Name              | Type                                                              | Required | Description               |
| :---------------- | :---------------------------------------------------------------- | :------- | :------------------------ |
| requestParameters | [ListExpoTokensParameters](../models/ListExpoTokensParameters.md) | ❌       | Request Parameters Object |

**Return Type**

`ExpoTokenCollection`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.ExpoTokenCollection;
import com.magicbell.magicbelluserclient.models.ListExpoTokensParameters;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val requestParameters: ListExpoTokensParameters = ListExpoTokensParameters.builder()
			.limit(8L)
			.startingAfter("starting_after")
			.endingBefore("ending_before")
			.build();

    val response: ExpoTokenCollection = magicbellUserClient.channels.listExpoTokens(requestParameters);

    println(response);
}
```

## saveExpoToken

Saves the Expo token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.

- HTTP Method: `PUT`
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

    val response: ExpoTokenPayload = magicbellUserClient.channels.saveExpoToken(expoTokenPayload);

    println(response);
}
```

## fetchExpoToken

Fetches details of a specific Expo token belonging to the authenticated user. Returns information about the token's status, creation date, and any associated metadata. Users can only access their own tokens.

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

    val response: ExpoToken = magicbellUserClient.channels.fetchExpoToken("token_id");

    println(response);
}
```

## deleteExpoToken

Deletes one of the authenticated user's Expo tokens. This permanently invalidates the specified token, preventing it from being used for future channel access. This action cannot be undone. Users can only revoke their own tokens.

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

    val response: DiscardResult = magicbellUserClient.channels.deleteExpoToken("token_id");

    println(response);
}
```

## listFcmTokens

Lists all FCM tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.

- HTTP Method: `GET`
- Endpoint: `/channels/mobile_push/fcm/tokens`

**Parameters**

| Name              | Type                                                            | Required | Description               |
| :---------------- | :-------------------------------------------------------------- | :------- | :------------------------ |
| requestParameters | [ListFcmTokensParameters](../models/ListFcmTokensParameters.md) | ❌       | Request Parameters Object |

**Return Type**

`FcmTokenCollection`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.FcmTokenCollection;
import com.magicbell.magicbelluserclient.models.ListFcmTokensParameters;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val requestParameters: ListFcmTokensParameters = ListFcmTokensParameters.builder()
			.limit(6L)
			.startingAfter("starting_after")
			.endingBefore("ending_before")
			.build();

    val response: FcmTokenCollection = magicbellUserClient.channels.listFcmTokens(requestParameters);

    println(response);
}
```

## saveFcmToken

Saves the FCM token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.

- HTTP Method: `PUT`
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

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val fcmTokenPayload: FcmTokenPayload = FcmTokenPayload.builder()
			.deviceToken("estminim adipis")
			.build();

    val response: FcmTokenPayload = magicbellUserClient.channels.saveFcmToken(fcmTokenPayload);

    println(response);
}
```

## fetchFcmToken

Fetches details of a specific FCM token belonging to the authenticated user. Returns information about the token's status, creation date, and any associated metadata. Users can only access their own tokens.

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

    val response: FcmToken = magicbellUserClient.channels.fetchFcmToken("token_id");

    println(response);
}
```

## deleteFcmToken

Deletes one of the authenticated user's FCM tokens. This permanently invalidates the specified token, preventing it from being used for future channel access. This action cannot be undone. Users can only revoke their own tokens.

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

    val response: DiscardResult = magicbellUserClient.channels.deleteFcmToken("token_id");

    println(response);
}
```

## listMagicbellSlackbotTokens

Lists all MagicBell SlackBot tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.

- HTTP Method: `GET`
- Endpoint: `/channels/slack/magicbell_slackbot/tokens`

**Parameters**

| Name              | Type                                                                                        | Required | Description               |
| :---------------- | :------------------------------------------------------------------------------------------ | :------- | :------------------------ |
| requestParameters | [ListMagicbellSlackbotTokensParameters](../models/ListMagicbellSlackbotTokensParameters.md) | ❌       | Request Parameters Object |

**Return Type**

`SlackTokenCollection`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.ListMagicbellSlackbotTokensParameters;
import com.magicbell.magicbelluserclient.models.SlackTokenCollection;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val requestParameters: ListMagicbellSlackbotTokensParameters = ListMagicbellSlackbotTokensParameters.builder()
			.limit(7L)
			.startingAfter("starting_after")
			.endingBefore("ending_before")
			.build();

    val response: SlackTokenCollection = magicbellUserClient.channels.listMagicbellSlackbotTokens(requestParameters);

    println(response);
}
```

## saveMagicbellSlackbotToken

Saves the MagicBell SlackBot token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.

- HTTP Method: `PUT`
- Endpoint: `/channels/slack/magicbell_slackbot/tokens`

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

    val response: SlackTokenPayload = magicbellUserClient.channels.saveMagicbellSlackbotToken(slackTokenPayload);

    println(response);
}
```

## fetchMagicbellSlackbotToken

Fetches details of a specific MagicBell SlackBot token belonging to the authenticated user. Returns information about the token's status, creation date, and any associated metadata. Users can only access their own tokens.

- HTTP Method: `GET`
- Endpoint: `/channels/slack/magicbell_slackbot/tokens/{token_id}`

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

    val response: SlackToken = magicbellUserClient.channels.fetchMagicbellSlackbotToken("token_id");

    println(response);
}
```

## deleteMagicbellSlackbotToken

Deletes one of the authenticated user's MagicBell SlackBot tokens. This permanently invalidates the specified token, preventing it from being used for future channel access. This action cannot be undone. Users can only revoke their own tokens.

- HTTP Method: `DELETE`
- Endpoint: `/channels/slack/magicbell_slackbot/tokens/{token_id}`

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

    val response: DiscardResult = magicbellUserClient.channels.deleteMagicbellSlackbotToken("token_id");

    println(response);
}
```

## listSlackTokens

Lists all Slack tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.

- HTTP Method: `GET`
- Endpoint: `/channels/slack/tokens`

**Parameters**

| Name              | Type                                                                | Required | Description               |
| :---------------- | :------------------------------------------------------------------ | :------- | :------------------------ |
| requestParameters | [ListSlackTokensParameters](../models/ListSlackTokensParameters.md) | ❌       | Request Parameters Object |

**Return Type**

`SlackTokenCollection`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.ListSlackTokensParameters;
import com.magicbell.magicbelluserclient.models.SlackTokenCollection;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val requestParameters: ListSlackTokensParameters = ListSlackTokensParameters.builder()
			.limit(2L)
			.startingAfter("starting_after")
			.endingBefore("ending_before")
			.build();

    val response: SlackTokenCollection = magicbellUserClient.channels.listSlackTokens(requestParameters);

    println(response);
}
```

## saveSlackToken

Saves the Slack token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.

- HTTP Method: `PUT`
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

## fetchSlackToken

Fetches details of a specific Slack token belonging to the authenticated user. Returns information about the token's status, creation date, and any associated metadata. Users can only access their own tokens.

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

    val response: SlackToken = magicbellUserClient.channels.fetchSlackToken("token_id");

    println(response);
}
```

## deleteSlackToken

Deletes one of the authenticated user's Slack tokens. This permanently invalidates the specified token, preventing it from being used for future channel access. This action cannot be undone. Users can only revoke their own tokens.

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

    val response: DiscardResult = magicbellUserClient.channels.deleteSlackToken("token_id");

    println(response);
}
```

## listTeamsTokens

Lists all Teams tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.

- HTTP Method: `GET`
- Endpoint: `/channels/teams/tokens`

**Parameters**

| Name              | Type                                                                | Required | Description               |
| :---------------- | :------------------------------------------------------------------ | :------- | :------------------------ |
| requestParameters | [ListTeamsTokensParameters](../models/ListTeamsTokensParameters.md) | ❌       | Request Parameters Object |

**Return Type**

`TeamsTokenCollection`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.ListTeamsTokensParameters;
import com.magicbell.magicbelluserclient.models.TeamsTokenCollection;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val requestParameters: ListTeamsTokensParameters = ListTeamsTokensParameters.builder()
			.limit(4L)
			.startingAfter("starting_after")
			.endingBefore("ending_before")
			.build();

    val response: TeamsTokenCollection = magicbellUserClient.channels.listTeamsTokens(requestParameters);

    println(response);
}
```

## saveTeamsToken

Saves the Teams token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.

- HTTP Method: `PUT`
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

## fetchTeamsToken

Fetches details of a specific Teams token belonging to the authenticated user. Returns information about the token's status, creation date, and any associated metadata. Users can only access their own tokens.

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

    val response: TeamsToken = magicbellUserClient.channels.fetchTeamsToken("token_id");

    println(response);
}
```

## deleteTeamsToken

Deletes one of the authenticated user's Teams tokens. This permanently invalidates the specified token, preventing it from being used for future channel access. This action cannot be undone. Users can only revoke their own tokens.

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

    val response: DiscardResult = magicbellUserClient.channels.deleteTeamsToken("token_id");

    println(response);
}
```

## fetchUserPreferences

Fetch a user's channel delivery preferences.

- HTTP Method: `GET`
- Endpoint: `/channels/user_preferences`

**Return Type**

`UserPreferences`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.UserPreferences;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val response: UserPreferences = magicbellUserClient.channels.fetchUserPreferences();

    println(response);
}
```

## saveUserPreferences

Save a user's channel preferences.

- HTTP Method: `PUT`
- Endpoint: `/channels/user_preferences`

**Parameters**

| Name            | Type                                            | Required | Description  |
| :-------------- | :---------------------------------------------- | :------- | :----------- |
| userPreferences | [UserPreferences](../models/UserPreferences.md) | ❌       | Request Body |

**Example Usage Code Snippet**

```kotlin
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.Categories;
import com.magicbell.magicbelluserclient.models.Channels;
import com.magicbell.magicbelluserclient.models.UserPreferences;
import java.util.Arrays;
import java.util.List;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val channels: Channels = Channels.builder()
			.enabled(true)
			.name("name")
			.build();

		val channels: List<Channels> = Arrays.asList(channels);

		val categories: Categories = Categories.builder()
			.channels(channels)
			.key("key")
			.label("label")
			.build();

		val categories: List<Categories> = Arrays.asList(categories);

		val userPreferences: UserPreferences = UserPreferences.builder()
			.categories(categories)
			.build();

    magicbellUserClient.channels.saveUserPreferences(userPreferences);
}
```

## listWebPushTokens

Lists all Web Push tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.

- HTTP Method: `GET`
- Endpoint: `/channels/web_push/tokens`

**Parameters**

| Name              | Type                                                                    | Required | Description               |
| :---------------- | :---------------------------------------------------------------------- | :------- | :------------------------ |
| requestParameters | [ListWebPushTokensParameters](../models/ListWebPushTokensParameters.md) | ❌       | Request Parameters Object |

**Return Type**

`WebPushTokenCollection`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.ListWebPushTokensParameters;
import com.magicbell.magicbelluserclient.models.WebPushTokenCollection;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val requestParameters: ListWebPushTokensParameters = ListWebPushTokensParameters.builder()
			.limit(9L)
			.startingAfter("starting_after")
			.endingBefore("ending_before")
			.build();

    val response: WebPushTokenCollection = magicbellUserClient.channels.listWebPushTokens(requestParameters);

    println(response);
}
```

## saveWebPushToken

Saves the Web Push token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.

- HTTP Method: `PUT`
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

## fetchWebPushToken

Fetches details of a specific Web Push token belonging to the authenticated user. Returns information about the token's status, creation date, and any associated metadata. Users can only access their own tokens.

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

    val response: WebPushToken = magicbellUserClient.channels.fetchWebPushToken("token_id");

    println(response);
}
```

## deleteWebPushToken

Deletes one of the authenticated user's Web Push tokens. This permanently invalidates the specified token, preventing it from being used for future channel access. This action cannot be undone. Users can only revoke their own tokens.

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

    val response: DiscardResult = magicbellUserClient.channels.deleteWebPushToken("token_id");

    println(response);
}
```
