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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.ArrayOfMetadataApnsTokens;
import com.magicbell.magicbelluserclient.models.GetMobilePushApnsTokensParameters;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    GetMobilePushApnsTokensParameters requestParameters = GetMobilePushApnsTokensParameters
      .builder()
      .pageSize(8L)
      .pageAfter("page[after]")
      .pageBefore("page[before]")
      .build();

    ArrayOfMetadataApnsTokens response = magicbellUserClient.channels.getMobilePushApnsTokens(requestParameters);

    System.out.println(response);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.ApnsToken;
import com.magicbell.magicbelluserclient.models.ApnsTokenInstallationId;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    ApnsToken apnsToken = ApnsToken
      .builder()
      .appId("app_id")
      .deviceToken("fugiat ullamco ")
      .installationId(ApnsTokenInstallationId.DEVELOPMENT)
      .build();

    ApnsToken response = magicbellUserClient.channels.saveMobilePushApnsToken(apnsToken);

    System.out.println(response);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.MetadataApnsToken;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    MetadataApnsToken response = magicbellUserClient.channels.getMobilePushApnsToken("token_id");

    System.out.println(response);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.DiscardResult;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    DiscardResult response = magicbellUserClient.channels.discardMobilePushApnsToken("token_id");

    System.out.println(response);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.ArrayOfMetadataExpoTokens;
import com.magicbell.magicbelluserclient.models.GetMobilePushExpoTokensParameters;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    GetMobilePushExpoTokensParameters requestParameters = GetMobilePushExpoTokensParameters
      .builder()
      .pageSize(8L)
      .pageAfter("page[after]")
      .pageBefore("page[before]")
      .build();

    ArrayOfMetadataExpoTokens response = magicbellUserClient.channels.getMobilePushExpoTokens(requestParameters);

    System.out.println(response);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.ExpoToken;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    ExpoToken expoToken = ExpoToken.builder().deviceToken("device_token").build();

    ExpoToken response = magicbellUserClient.channels.saveMobilePushExpoToken(expoToken);

    System.out.println(response);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.MetadataExpoToken;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    MetadataExpoToken response = magicbellUserClient.channels.getMobilePushExpoToken("token_id");

    System.out.println(response);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.DiscardResult;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    DiscardResult response = magicbellUserClient.channels.discardMobilePushExpoToken("token_id");

    System.out.println(response);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.ArrayOfMetadataFcmTokens;
import com.magicbell.magicbelluserclient.models.GetMobilePushFcmTokensParameters;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    GetMobilePushFcmTokensParameters requestParameters = GetMobilePushFcmTokensParameters
      .builder()
      .pageSize(7L)
      .pageAfter("page[after]")
      .pageBefore("page[before]")
      .build();

    ArrayOfMetadataFcmTokens response = magicbellUserClient.channels.getMobilePushFcmTokens(requestParameters);

    System.out.println(response);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.FcmToken;
import com.magicbell.magicbelluserclient.models.FcmTokenInstallationId;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    FcmToken fcmToken = FcmToken
      .builder()
      .deviceToken("velit dolor adi")
      .installationId(FcmTokenInstallationId.DEVELOPMENT)
      .build();

    FcmToken response = magicbellUserClient.channels.saveMobilePushFcmToken(fcmToken);

    System.out.println(response);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.MetadataFcmToken;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    MetadataFcmToken response = magicbellUserClient.channels.getMobilePushFcmToken("token_id");

    System.out.println(response);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.DiscardResult;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    DiscardResult response = magicbellUserClient.channels.discardMobilePushFcmToken("token_id");

    System.out.println(response);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.ArrayOfMetadataSlackTokens;
import com.magicbell.magicbelluserclient.models.GetSlackTokensParameters;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    GetSlackTokensParameters requestParameters = GetSlackTokensParameters
      .builder()
      .pageSize(5L)
      .pageAfter("page[after]")
      .pageBefore("page[before]")
      .build();

    ArrayOfMetadataSlackTokens response = magicbellUserClient.channels.getSlackTokens(requestParameters);

    System.out.println(response);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.Oauth;
import com.magicbell.magicbelluserclient.models.SlackToken;
import com.magicbell.magicbelluserclient.models.SlackTokenWebhook;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    Oauth oauth = Oauth.builder().channelId("channel_id").installationId("installation_id").scope("scope").build();

    SlackTokenWebhook slackTokenWebhook = SlackTokenWebhook.builder().url("url").build();

    SlackToken slackToken = SlackToken.builder().oauth(oauth).webhook(slackTokenWebhook).build();

    SlackToken response = magicbellUserClient.channels.saveSlackToken(slackToken);

    System.out.println(response);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.MetadataSlackToken;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    MetadataSlackToken response = magicbellUserClient.channels.getSlackToken("token_id");

    System.out.println(response);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.DiscardResult;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    DiscardResult response = magicbellUserClient.channels.discardSlackToken("token_id");

    System.out.println(response);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.ArrayOfMetadataTeamsTokens;
import com.magicbell.magicbelluserclient.models.GetTeamsTokensParameters;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    GetTeamsTokensParameters requestParameters = GetTeamsTokensParameters
      .builder()
      .pageSize(6L)
      .pageAfter("page[after]")
      .pageBefore("page[before]")
      .build();

    ArrayOfMetadataTeamsTokens response = magicbellUserClient.channels.getTeamsTokens(requestParameters);

    System.out.println(response);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.TeamsToken;
import com.magicbell.magicbelluserclient.models.TeamsTokenWebhook;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    TeamsTokenWebhook teamsTokenWebhook = TeamsTokenWebhook.builder().url("url").build();

    TeamsToken teamsToken = TeamsToken.builder().webhook(teamsTokenWebhook).build();

    TeamsToken response = magicbellUserClient.channels.saveTeamsToken(teamsToken);

    System.out.println(response);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.MetadataTeamsToken;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    MetadataTeamsToken response = magicbellUserClient.channels.getTeamsToken("token_id");

    System.out.println(response);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.DiscardResult;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    DiscardResult response = magicbellUserClient.channels.discardTeamsToken("token_id");

    System.out.println(response);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.ArrayOfMetadataWebPushTokens;
import com.magicbell.magicbelluserclient.models.GetWebPushTokensParameters;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    GetWebPushTokensParameters requestParameters = GetWebPushTokensParameters
      .builder()
      .pageSize(6L)
      .pageAfter("page[after]")
      .pageBefore("page[before]")
      .build();

    ArrayOfMetadataWebPushTokens response = magicbellUserClient.channels.getWebPushTokens(requestParameters);

    System.out.println(response);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.Keys;
import com.magicbell.magicbelluserclient.models.WebPushToken;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    Keys keys = Keys.builder().auth("auth").p256dh("p256dh").build();

    WebPushToken webPushToken = WebPushToken.builder().endpoint("endpoint").keys(keys).build();

    WebPushToken response = magicbellUserClient.channels.saveWebPushToken(webPushToken);

    System.out.println(response);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.MetadataWebPushToken;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    MetadataWebPushToken response = magicbellUserClient.channels.getWebPushToken("token_id");

    System.out.println(response);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.DiscardResult;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    DiscardResult response = magicbellUserClient.channels.discardWebPushToken("token_id");

    System.out.println(response);
  }
}

```
