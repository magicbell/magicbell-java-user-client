# MagicbellUserClient Java SDK 0.3.0

Welcome to the MagicbellUserClient SDK documentation. This guide will help you get started with integrating and using the MagicbellUserClient SDK in your project.

[![This SDK was generated by liblab](https://public-liblab-readme-assets.s3.us-east-1.amazonaws.com/built-by-liblab-icon.svg)](https://liblab.com/?utm_source=readme)

## Versions

- API version: `2.0.0`
- SDK version: `0.3.0`

## About the API

OpenAPI 3.0.3 Specification for MagicBell API.

## Table of Contents

- [Setup & Configuration](#setup--configuration)
  - [Supported Language Versions](#supported-language-versions)
  - [Installation](#installation)
- [Authentication](#authentication)
  - [Access Token Authentication](#access-token-authentication)
- [Setting a Custom Timeout](#setting-a-custom-timeout)
- [Sample Usage](#sample-usage)
- [Services](#services)
- [Models](#models)
- [License](#license)

# Setup & Configuration

## Supported Language Versions

This SDK is compatible with the following versions: `Java >= 1.8`

## Installation

If you use Maven, place the following within the _dependency_ tag in your `pom.xml` file:

```XML
<dependency>
    <groupId>com.magicbell</groupId>
    <artifactId>magicbell-user-client</artifactId>
    <version>0.3.0</version>
</dependency>
```

If you use Gradle, paste the next line inside the _dependencies_ block of your `build.gradle` file:

```Gradle
implementation group: com.magicbell, name: magicbell-user-client, version: 0.3.0
```

If you use JAR files, package the SDK by running the following command:

```shell
mvn compile assembly:single
```

Then, add the JAR file to your project's classpath.

## Authentication

### Access Token Authentication

The MagicbellUserClient API uses an Access Token for authentication.

This token must be provided to authenticate your requests to the API.

#### Setting the Access Token

When you initialize the SDK, you can set the access token as follows:

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);
  }
}

```

If you need to set or update the access token after initializing the SDK, you can use:

```java
magicbellUserClient.setAccessToken('YOUR_ACCESS_TOKEN');
```

## Setting a Custom Timeout

You can set a custom timeout for the SDK's HTTP requests as follows:

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().timeout(10000).build();
    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);
  }
}

```

# Sample Usage

Below is a comprehensive example demonstrating how to authenticate and call a simple endpoint:

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

## Services

The SDK provides various services to interact with the API.

<details> 
<summary>Below is a list of all available services with links to their detailed documentation:</summary>

| Name                                                                                                                                      |
| :---------------------------------------------------------------------------------------------------------------------------------------- |
| ChannelsService: [[Java](documentation/services/ChannelsService.md)] [[Kotlin](documentation/services/ChannelsService.kt.md)]             |
| IntegrationsService: [[Java](documentation/services/IntegrationsService.md)] [[Kotlin](documentation/services/IntegrationsService.kt.md)] |

</details>

## Models

The SDK includes several models that represent the data structures used in API requests and responses. These models help in organizing and managing the data efficiently.

<details> 
<summary>Below is a list of all available models with links to their detailed documentation:</summary>

| Name                                                                                           | Description |
| :--------------------------------------------------------------------------------------------- | :---------- |
| [ArrayOfMetadataApnsTokens](documentation/models/ArrayOfMetadataApnsTokens.md)                 |             |
| [ApnsToken](documentation/models/ApnsToken.md)                                                 |             |
| [MetadataApnsToken](documentation/models/MetadataApnsToken.md)                                 |             |
| [DiscardResult](documentation/models/DiscardResult.md)                                         |             |
| [ArrayOfMetadataExpoTokens](documentation/models/ArrayOfMetadataExpoTokens.md)                 |             |
| [ExpoToken](documentation/models/ExpoToken.md)                                                 |             |
| [MetadataExpoToken](documentation/models/MetadataExpoToken.md)                                 |             |
| [ArrayOfMetadataFcmTokens](documentation/models/ArrayOfMetadataFcmTokens.md)                   |             |
| [FcmToken](documentation/models/FcmToken.md)                                                   |             |
| [MetadataFcmToken](documentation/models/MetadataFcmToken.md)                                   |             |
| [ArrayOfMetadataSlackTokens](documentation/models/ArrayOfMetadataSlackTokens.md)               |             |
| [SlackToken](documentation/models/SlackToken.md)                                               |             |
| [MetadataSlackToken](documentation/models/MetadataSlackToken.md)                               |             |
| [ArrayOfMetadataTeamsTokens](documentation/models/ArrayOfMetadataTeamsTokens.md)               |             |
| [TeamsToken](documentation/models/TeamsToken.md)                                               |             |
| [MetadataTeamsToken](documentation/models/MetadataTeamsToken.md)                               |             |
| [ArrayOfMetadataWebPushTokens](documentation/models/ArrayOfMetadataWebPushTokens.md)           |             |
| [WebPushToken](documentation/models/WebPushToken.md)                                           |             |
| [MetadataWebPushToken](documentation/models/MetadataWebPushToken.md)                           |             |
| [InboxConfig](documentation/models/InboxConfig.md)                                             |             |
| [SlackInstallation](documentation/models/SlackInstallation.md)                                 |             |
| [SlackFinishInstallResponse](documentation/models/SlackFinishInstallResponse.md)               |             |
| [SlackStartInstall](documentation/models/SlackStartInstall.md)                                 |             |
| [SlackStartInstallResponseContent](documentation/models/SlackStartInstallResponseContent.md)   |             |
| [TemplatesInstallation](documentation/models/TemplatesInstallation.md)                         |             |
| [WebPushStartInstallationResponse](documentation/models/WebPushStartInstallationResponse.md)   |             |
| [Links](documentation/models/Links.md)                                                         |             |
| [TokenMetadata](documentation/models/TokenMetadata.md)                                         |             |
| [GetMobilePushApnsTokensParameters](documentation/models/GetMobilePushApnsTokensParameters.md) |             |
| [GetMobilePushExpoTokensParameters](documentation/models/GetMobilePushExpoTokensParameters.md) |             |
| [GetMobilePushFcmTokensParameters](documentation/models/GetMobilePushFcmTokensParameters.md)   |             |
| [GetSlackTokensParameters](documentation/models/GetSlackTokensParameters.md)                   |             |
| [GetTeamsTokensParameters](documentation/models/GetTeamsTokensParameters.md)                   |             |
| [GetWebPushTokensParameters](documentation/models/GetWebPushTokensParameters.md)               |             |

</details>

## License

This SDK is licensed under the MIT License.

See the [LICENSE](LICENSE) file for more details.
