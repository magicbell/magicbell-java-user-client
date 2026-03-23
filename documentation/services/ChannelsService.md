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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.InboxTokenResponseCollection;
import com.magicbell.magicbelluserclient.models.ListInboxTokensParameters;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    ListInboxTokensParameters requestParameters = ListInboxTokensParameters.builder()
      .limit(8L)
      .startingAfter("starting_after")
      .endingBefore("ending_before")
      .build();

    InboxTokenResponseCollection response = magicbellUserClient.channels.listInboxTokens(requestParameters);

    System.out.println(response);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.InboxToken;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    InboxToken inboxToken = InboxToken.builder().connectionId("connection_id").token("ipsum nulla mag").build();

    InboxToken response = magicbellUserClient.channels.saveInboxToken(inboxToken);

    System.out.println(response);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.InboxTokenResponse;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    InboxTokenResponse response = magicbellUserClient.channels.fetchInboxToken("token_id");

    System.out.println(response);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.DiscardResult;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    DiscardResult response = magicbellUserClient.channels.deleteInboxToken("token_id");

    System.out.println(response);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.ApnsTokenCollection;
import com.magicbell.magicbelluserclient.models.ListApnsTokensParameters;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    ListApnsTokensParameters requestParameters = ListApnsTokensParameters.builder()
      .limit(7L)
      .startingAfter("starting_after")
      .endingBefore("ending_before")
      .build();

    ApnsTokenCollection response = magicbellUserClient.channels.listApnsTokens(requestParameters);

    System.out.println(response);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.ApnsTokenPayload;
import com.magicbell.magicbelluserclient.models.ApnsTokenPayloadInstallationId;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    ApnsTokenPayload apnsTokenPayload = ApnsTokenPayload.builder()
      .appId("app_id")
      .deviceToken("sit culpa incid")
      .installationId(ApnsTokenPayloadInstallationId.DEVELOPMENT)
      .build();

    ApnsTokenPayload response = magicbellUserClient.channels.saveApnsToken(apnsTokenPayload);

    System.out.println(response);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.ApnsToken;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    ApnsToken response = magicbellUserClient.channels.fetchApnsToken("token_id");

    System.out.println(response);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.DiscardResult;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    DiscardResult response = magicbellUserClient.channels.deleteApnsToken("token_id");

    System.out.println(response);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.ExpoTokenCollection;
import com.magicbell.magicbelluserclient.models.ListExpoTokensParameters;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    ListExpoTokensParameters requestParameters = ListExpoTokensParameters.builder()
      .limit(8L)
      .startingAfter("starting_after")
      .endingBefore("ending_before")
      .build();

    ExpoTokenCollection response = magicbellUserClient.channels.listExpoTokens(requestParameters);

    System.out.println(response);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.ExpoTokenPayload;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    ExpoTokenPayload expoTokenPayload = ExpoTokenPayload.builder().deviceToken("device_token").build();

    ExpoTokenPayload response = magicbellUserClient.channels.saveExpoToken(expoTokenPayload);

    System.out.println(response);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.ExpoToken;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    ExpoToken response = magicbellUserClient.channels.fetchExpoToken("token_id");

    System.out.println(response);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.DiscardResult;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    DiscardResult response = magicbellUserClient.channels.deleteExpoToken("token_id");

    System.out.println(response);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.FcmTokenCollection;
import com.magicbell.magicbelluserclient.models.ListFcmTokensParameters;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    ListFcmTokensParameters requestParameters = ListFcmTokensParameters.builder()
      .limit(6L)
      .startingAfter("starting_after")
      .endingBefore("ending_before")
      .build();

    FcmTokenCollection response = magicbellUserClient.channels.listFcmTokens(requestParameters);

    System.out.println(response);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.FcmTokenPayload;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    FcmTokenPayload fcmTokenPayload = FcmTokenPayload.builder().deviceToken("estminim adipis").build();

    FcmTokenPayload response = magicbellUserClient.channels.saveFcmToken(fcmTokenPayload);

    System.out.println(response);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.FcmToken;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    FcmToken response = magicbellUserClient.channels.fetchFcmToken("token_id");

    System.out.println(response);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.DiscardResult;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    DiscardResult response = magicbellUserClient.channels.deleteFcmToken("token_id");

    System.out.println(response);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.ListMagicbellSlackbotTokensParameters;
import com.magicbell.magicbelluserclient.models.SlackTokenCollection;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    ListMagicbellSlackbotTokensParameters requestParameters = ListMagicbellSlackbotTokensParameters.builder()
      .limit(7L)
      .startingAfter("starting_after")
      .endingBefore("ending_before")
      .build();

    SlackTokenCollection response = magicbellUserClient.channels.listMagicbellSlackbotTokens(requestParameters);

    System.out.println(response);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.SlackTokenPayload;
import com.magicbell.magicbelluserclient.models.SlackTokenPayloadOauth;
import com.magicbell.magicbelluserclient.models.SlackTokenPayloadWebhook;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    SlackTokenPayloadOauth slackTokenPayloadOauth = SlackTokenPayloadOauth.builder()
      .channelId("channel_id")
      .installationId("installation_id")
      .scope("scope")
      .build();

    SlackTokenPayloadWebhook slackTokenPayloadWebhook = SlackTokenPayloadWebhook.builder().url("url").build();

    SlackTokenPayload slackTokenPayload = SlackTokenPayload.builder()
      .oauth(slackTokenPayloadOauth)
      .webhook(slackTokenPayloadWebhook)
      .build();

    SlackTokenPayload response = magicbellUserClient.channels.saveMagicbellSlackbotToken(slackTokenPayload);

    System.out.println(response);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.SlackToken;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    SlackToken response = magicbellUserClient.channels.fetchMagicbellSlackbotToken("token_id");

    System.out.println(response);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.DiscardResult;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    DiscardResult response = magicbellUserClient.channels.deleteMagicbellSlackbotToken("token_id");

    System.out.println(response);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.ListSlackTokensParameters;
import com.magicbell.magicbelluserclient.models.SlackTokenCollection;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    ListSlackTokensParameters requestParameters = ListSlackTokensParameters.builder()
      .limit(2L)
      .startingAfter("starting_after")
      .endingBefore("ending_before")
      .build();

    SlackTokenCollection response = magicbellUserClient.channels.listSlackTokens(requestParameters);

    System.out.println(response);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.SlackTokenPayload;
import com.magicbell.magicbelluserclient.models.SlackTokenPayloadOauth;
import com.magicbell.magicbelluserclient.models.SlackTokenPayloadWebhook;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    SlackTokenPayloadOauth slackTokenPayloadOauth = SlackTokenPayloadOauth.builder()
      .channelId("channel_id")
      .installationId("installation_id")
      .scope("scope")
      .build();

    SlackTokenPayloadWebhook slackTokenPayloadWebhook = SlackTokenPayloadWebhook.builder().url("url").build();

    SlackTokenPayload slackTokenPayload = SlackTokenPayload.builder()
      .oauth(slackTokenPayloadOauth)
      .webhook(slackTokenPayloadWebhook)
      .build();

    SlackTokenPayload response = magicbellUserClient.channels.saveSlackToken(slackTokenPayload);

    System.out.println(response);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.SlackToken;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    SlackToken response = magicbellUserClient.channels.fetchSlackToken("token_id");

    System.out.println(response);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.DiscardResult;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    DiscardResult response = magicbellUserClient.channels.deleteSlackToken("token_id");

    System.out.println(response);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.ListTeamsTokensParameters;
import com.magicbell.magicbelluserclient.models.TeamsTokenCollection;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    ListTeamsTokensParameters requestParameters = ListTeamsTokensParameters.builder()
      .limit(4L)
      .startingAfter("starting_after")
      .endingBefore("ending_before")
      .build();

    TeamsTokenCollection response = magicbellUserClient.channels.listTeamsTokens(requestParameters);

    System.out.println(response);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.TeamsTokenPayload;
import com.magicbell.magicbelluserclient.models.TeamsTokenPayloadWebhook;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    TeamsTokenPayloadWebhook teamsTokenPayloadWebhook = TeamsTokenPayloadWebhook.builder().url("url").build();

    TeamsTokenPayload teamsTokenPayload = TeamsTokenPayload.builder().webhook(teamsTokenPayloadWebhook).build();

    TeamsTokenPayload response = magicbellUserClient.channels.saveTeamsToken(teamsTokenPayload);

    System.out.println(response);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.TeamsToken;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    TeamsToken response = magicbellUserClient.channels.fetchTeamsToken("token_id");

    System.out.println(response);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.DiscardResult;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    DiscardResult response = magicbellUserClient.channels.deleteTeamsToken("token_id");

    System.out.println(response);
  }
}

```

## fetchUserPreferences

Fetch a user's channel delivery preferences.

- HTTP Method: `GET`
- Endpoint: `/channels/user_preferences`

**Return Type**

`UserPreferences`

**Example Usage Code Snippet**

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.UserPreferences;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    UserPreferences response = magicbellUserClient.channels.fetchUserPreferences();

    System.out.println(response);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.Categories;
import com.magicbell.magicbelluserclient.models.Channels;
import com.magicbell.magicbelluserclient.models.UserPreferences;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    Channels channels = Channels.builder().enabled(true).name("name").build();

    List<Channels> channelsList = Arrays.asList(channels);

    Categories categories = Categories.builder().channels(channelsList).key("key").label("label").build();

    List<Categories> categoriesList = Arrays.asList(categories);

    UserPreferences userPreferences = UserPreferences.builder().categories(categoriesList).build();

    magicbellUserClient.channels.saveUserPreferences(userPreferences);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.ListWebPushTokensParameters;
import com.magicbell.magicbelluserclient.models.WebPushTokenCollection;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    ListWebPushTokensParameters requestParameters = ListWebPushTokensParameters.builder()
      .limit(9L)
      .startingAfter("starting_after")
      .endingBefore("ending_before")
      .build();

    WebPushTokenCollection response = magicbellUserClient.channels.listWebPushTokens(requestParameters);

    System.out.println(response);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.WebPushTokenPayload;
import com.magicbell.magicbelluserclient.models.WebPushTokenPayloadKeys;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    WebPushTokenPayloadKeys webPushTokenPayloadKeys = WebPushTokenPayloadKeys.builder()
      .auth("auth")
      .p256dh("p256dh")
      .build();

    WebPushTokenPayload webPushTokenPayload = WebPushTokenPayload.builder()
      .endpoint("endpoint")
      .keys(webPushTokenPayloadKeys)
      .build();

    WebPushTokenPayload response = magicbellUserClient.channels.saveWebPushToken(webPushTokenPayload);

    System.out.println(response);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.WebPushToken;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    WebPushToken response = magicbellUserClient.channels.fetchWebPushToken("token_id");

    System.out.println(response);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.DiscardResult;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    DiscardResult response = magicbellUserClient.channels.deleteWebPushToken("token_id");

    System.out.println(response);
  }
}

```
