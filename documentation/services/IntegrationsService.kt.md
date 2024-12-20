# IntegrationsService

A list of all methods in the `IntegrationsService` service. Click on the method name to view detailed information about that method.

| Methods                                                 | Description                                                                                                                                                                                         |
| :------------------------------------------------------ | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| [saveInboxInstallation](#saveinboxinstallation)         | Creates a new installation of a inbox integration for a user. This endpoint is used when an integration needs to be set up with user-specific credentials or configuration.                         |
| [startInboxInstallation](#startinboxinstallation)       | Initiates the installation flow for a inbox integration. This is the first step in a multi-step installation process where user authorization or external service configuration may be required.    |
| [saveSlackInstallation](#saveslackinstallation)         | Creates a new installation of a slack integration for a user. This endpoint is used when an integration needs to be set up with user-specific credentials or configuration.                         |
| [finishSlackInstallation](#finishslackinstallation)     | Completes the installation flow for a slack integration. This endpoint is typically called after the user has completed any required authorization steps with slack.                                |
| [startSlackInstallation](#startslackinstallation)       | Initiates the installation flow for a slack integration. This is the first step in a multi-step installation process where user authorization or external service configuration may be required.    |
| [saveTemplatesInstallation](#savetemplatesinstallation) | Creates a new installation of a templates integration for a user. This endpoint is used when an integration needs to be set up with user-specific credentials or configuration.                     |
| [saveWebPushInstallation](#savewebpushinstallation)     | Creates a new installation of a web_push integration for a user. This endpoint is used when an integration needs to be set up with user-specific credentials or configuration.                      |
| [startWebPushInstallation](#startwebpushinstallation)   | Initiates the installation flow for a web_push integration. This is the first step in a multi-step installation process where user authorization or external service configuration may be required. |

## saveInboxInstallation

Creates a new installation of a inbox integration for a user. This endpoint is used when an integration needs to be set up with user-specific credentials or configuration.

- HTTP Method: `POST`
- Endpoint: `/integrations/inbox/installations`

**Parameters**

| Name        | Type                                    | Required | Description  |
| :---------- | :-------------------------------------- | :------- | :----------- |
| inboxConfig | [InboxConfig](../models/InboxConfig.md) | ❌       | Request Body |

**Return Type**

`InboxConfig`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.user_client.magicbelljavauserclient.MagicbellJavaUserClient;
import com.magicbell.user_client.magicbelljavauserclient.config.MagicbellJavaUserClientConfig;
import com.magicbell.user_client.magicbelljavauserclient.models.Banner;
import com.magicbell.user_client.magicbelljavauserclient.models.DefaultHover;
import com.magicbell.user_client.magicbelljavauserclient.models.DefaultState;
import com.magicbell.user_client.magicbelljavauserclient.models.Default_;
import com.magicbell.user_client.magicbelljavauserclient.models.Dialog;
import com.magicbell.user_client.magicbelljavauserclient.models.Footer;
import com.magicbell.user_client.magicbelljavauserclient.models.Header;
import com.magicbell.user_client.magicbelljavauserclient.models.Icon;
import com.magicbell.user_client.magicbelljavauserclient.models.Images;
import com.magicbell.user_client.magicbelljavauserclient.models.InboxConfig;
import com.magicbell.user_client.magicbelljavauserclient.models.Notification;
import com.magicbell.user_client.magicbelljavauserclient.models.Theme;
import com.magicbell.user_client.magicbelljavauserclient.models.Unread;
import com.magicbell.user_client.magicbelljavauserclient.models.UnreadHover;
import com.magicbell.user_client.magicbelljavauserclient.models.UnreadState;
import com.magicbell.user_client.magicbelljavauserclient.models.Unseen;
import com.magicbell.user_client.magicbelljavauserclient.models.UnseenBadge;
import com.magicbell.user_client.magicbelljavauserclient.models.UnseenHover;
import com.magicbell.user_client.magicbelljavauserclient.models.UnseenState;

fun main() {
	val config: MagicbellJavaUserClientConfig = MagicbellJavaUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellJavaUserClient: MagicbellJavaUserClient = MagicbellJavaUserClient(config);

    Images images = Images.builder()
			.emptyInboxUrl("emptyInboxUrl")
			.build();

		Banner banner = Banner.builder()
			.backgroundColor("backgroundColor")
			.backgroundOpacity(8.96D)
			.fontSize("fontSize")
			.textColor("textColor")
			.build();

		Dialog dialog = Dialog.builder()
			.accentColor("accentColor")
			.backgroundColor("backgroundColor")
			.textColor("textColor")
			.build();

		Footer footer = Footer.builder()
			.backgroundColor("backgroundColor")
			.borderRadius("borderRadius")
			.fontSize("fontSize")
			.textColor("textColor")
			.build();

		Header header = Header.builder()
			.backgroundColor("backgroundColor")
			.borderRadius("borderRadius")
			.fontFamily("fontFamily")
			.fontSize("fontSize")
			.textColor("textColor")
			.build();

		Icon icon = Icon.builder()
			.borderColor("borderColor")
			.width("width")
			.build();

		DefaultHover defaultHover = DefaultHover.builder()
			.backgroundColor("backgroundColor")
			.build();

		DefaultState defaultState = DefaultState.builder()
			.color("color")
			.build();

		Default_ default_ = Default_.builder()
			.backgroundColor("backgroundColor")
			.borderRadius("borderRadius")
			.fontFamily("fontFamily")
			.fontSize("fontSize")
			.hover(defaultHover)
			.margin("margin")
			.state(defaultState)
			.textColor("textColor")
			.build();

		UnreadHover unreadHover = UnreadHover.builder()
			.backgroundColor("backgroundColor")
			.build();

		UnreadState unreadState = UnreadState.builder()
			.color("color")
			.build();

		Unread unread = Unread.builder()
			.backgroundColor("backgroundColor")
			.hover(unreadHover)
			.state(unreadState)
			.textColor("textColor")
			.build();

		UnseenHover unseenHover = UnseenHover.builder()
			.backgroundColor("backgroundColor")
			.build();

		UnseenState unseenState = UnseenState.builder()
			.color("color")
			.build();

		Unseen unseen = Unseen.builder()
			.backgroundColor("backgroundColor")
			.hover(unseenHover)
			.state(unseenState)
			.textColor("textColor")
			.build();

		Notification notification = Notification.builder()
			.default_(default_)
			.unread(unread)
			.unseen(unseen)
			.build();

		UnseenBadge unseenBadge = UnseenBadge.builder()
			.backgroundColor("backgroundColor")
			.build();

		Theme theme = Theme.builder()
			.banner(banner)
			.dialog(dialog)
			.footer(footer)
			.header(header)
			.icon(icon)
			.notification(notification)
			.unseenBadge(unseenBadge)
			.build();

		InboxConfig inboxConfig = InboxConfig.builder()
			.images(images)
			.locale("locale")
			.theme(theme)
			.build();

    val response: InboxConfig = magicbellJavaUserClient.integrations.saveInboxInstallation(inboxConfig);

    println(response);
}
```

## startInboxInstallation

Initiates the installation flow for a inbox integration. This is the first step in a multi-step installation process where user authorization or external service configuration may be required.

- HTTP Method: `POST`
- Endpoint: `/integrations/inbox/installations/start`

**Return Type**

`InboxConfig`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.user_client.magicbelljavauserclient.MagicbellJavaUserClient;
import com.magicbell.user_client.magicbelljavauserclient.config.MagicbellJavaUserClientConfig;
import com.magicbell.user_client.magicbelljavauserclient.models.InboxConfig;

fun main() {
	val config: MagicbellJavaUserClientConfig = MagicbellJavaUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellJavaUserClient: MagicbellJavaUserClient = MagicbellJavaUserClient(config);

    val response: InboxConfig = magicbellJavaUserClient.integrations.startInboxInstallation();

    println(response);
}
```

## saveSlackInstallation

Creates a new installation of a slack integration for a user. This endpoint is used when an integration needs to be set up with user-specific credentials or configuration.

- HTTP Method: `POST`
- Endpoint: `/integrations/slack/installations`

**Parameters**

| Name              | Type                                                | Required | Description  |
| :---------------- | :-------------------------------------------------- | :------- | :----------- |
| slackInstallation | [SlackInstallation](../models/SlackInstallation.md) | ❌       | Request Body |

**Return Type**

`SlackInstallation`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.user_client.magicbelljavauserclient.MagicbellJavaUserClient;
import com.magicbell.user_client.magicbelljavauserclient.config.MagicbellJavaUserClientConfig;
import com.magicbell.user_client.magicbelljavauserclient.models.AuthedUser;
import com.magicbell.user_client.magicbelljavauserclient.models.Enterprise;
import com.magicbell.user_client.magicbelljavauserclient.models.IncomingWebhook;
import com.magicbell.user_client.magicbelljavauserclient.models.SlackInstallation;
import com.magicbell.user_client.magicbelljavauserclient.models.Team;

fun main() {
	val config: MagicbellJavaUserClientConfig = MagicbellJavaUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellJavaUserClient: MagicbellJavaUserClient = MagicbellJavaUserClient(config);

    AuthedUser authedUser = AuthedUser.builder()
			.accessToken("access_token")
			.expiresIn(5L)
			.id("id")
			.refreshToken("refresh_token")
			.scope("scope")
			.tokenType("token_type")
			.build();

		Enterprise enterprise = Enterprise.builder()
			.id("id")
			.name("name")
			.build();

		IncomingWebhook incomingWebhook = IncomingWebhook.builder()
			.channel("channel")
			.configurationUrl("configuration_url")
			.url("url")
			.build();

		Team team = Team.builder()
			.id("id")
			.name("name")
			.build();

		SlackInstallation slackInstallation = SlackInstallation.builder()
			.accessToken("access_token")
			.appId("app_id")
			.authedUser(authedUser)
			.botUserId("bot_user_id")
			.enterprise(enterprise)
			.expiresIn(10L)
			.id("626")
			.incomingWebhook(incomingWebhook)
			.isEnterpriseInstall(false)
			.refreshToken("refresh_token")
			.scope("scope")
			.team(team)
			.tokenType("token_type")
			.build();

    val response: SlackInstallation = magicbellJavaUserClient.integrations.saveSlackInstallation(slackInstallation);

    println(response);
}
```

## finishSlackInstallation

Completes the installation flow for a slack integration. This endpoint is typically called after the user has completed any required authorization steps with slack.

- HTTP Method: `POST`
- Endpoint: `/integrations/slack/installations/finish`

**Parameters**

| Name                       | Type                                                                  | Required | Description  |
| :------------------------- | :-------------------------------------------------------------------- | :------- | :----------- |
| slackFinishInstallResponse | [SlackFinishInstallResponse](../models/SlackFinishInstallResponse.md) | ❌       | Request Body |

**Return Type**

`SlackInstallation`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.user_client.magicbelljavauserclient.MagicbellJavaUserClient;
import com.magicbell.user_client.magicbelljavauserclient.config.MagicbellJavaUserClientConfig;
import com.magicbell.user_client.magicbelljavauserclient.models.SlackFinishInstallResponse;
import com.magicbell.user_client.magicbelljavauserclient.models.SlackInstallation;

fun main() {
	val config: MagicbellJavaUserClientConfig = MagicbellJavaUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellJavaUserClient: MagicbellJavaUserClient = MagicbellJavaUserClient(config);

    SlackFinishInstallResponse slackFinishInstallResponse = SlackFinishInstallResponse.builder()
			.appId("app_id")
			.code("code")
			.redirectUrl("redirect_url")
			.build();

    val response: SlackInstallation = magicbellJavaUserClient.integrations.finishSlackInstallation(slackFinishInstallResponse);

    println(response);
}
```

## startSlackInstallation

Initiates the installation flow for a slack integration. This is the first step in a multi-step installation process where user authorization or external service configuration may be required.

- HTTP Method: `POST`
- Endpoint: `/integrations/slack/installations/start`

**Parameters**

| Name              | Type                                                | Required | Description  |
| :---------------- | :-------------------------------------------------- | :------- | :----------- |
| slackStartInstall | [SlackStartInstall](../models/SlackStartInstall.md) | ❌       | Request Body |

**Return Type**

`SlackStartInstallResponseContent`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.user_client.magicbelljavauserclient.MagicbellJavaUserClient;
import com.magicbell.user_client.magicbelljavauserclient.config.MagicbellJavaUserClientConfig;
import com.magicbell.user_client.magicbelljavauserclient.models.SlackStartInstall;
import com.magicbell.user_client.magicbelljavauserclient.models.SlackStartInstallResponseContent;
import java.util.Arrays;
import java.util.List;

fun main() {
	val config: MagicbellJavaUserClientConfig = MagicbellJavaUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellJavaUserClient: MagicbellJavaUserClient = MagicbellJavaUserClient(config);

    List<String> extraScopes = Arrays.asList("extra_scopes");

		SlackStartInstall slackStartInstall = SlackStartInstall.builder()
			.appId("app_id")
			.authUrl("auth_url")
			.extraScopes(extraScopes)
			.redirectUrl("redirect_url")
			.build();

    val response: SlackStartInstallResponseContent = magicbellJavaUserClient.integrations.startSlackInstallation(slackStartInstall);

    println(response);
}
```

## saveTemplatesInstallation

Creates a new installation of a templates integration for a user. This endpoint is used when an integration needs to be set up with user-specific credentials or configuration.

- HTTP Method: `POST`
- Endpoint: `/integrations/templates/installations`

**Parameters**

| Name                  | Type                                                        | Required | Description  |
| :-------------------- | :---------------------------------------------------------- | :------- | :----------- |
| templatesInstallation | [TemplatesInstallation](../models/TemplatesInstallation.md) | ❌       | Request Body |

**Return Type**

`TemplatesInstallation`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.user_client.magicbelljavauserclient.MagicbellJavaUserClient;
import com.magicbell.user_client.magicbelljavauserclient.config.MagicbellJavaUserClientConfig;
import com.magicbell.user_client.magicbelljavauserclient.models.TemplatesInstallation;

fun main() {
	val config: MagicbellJavaUserClientConfig = MagicbellJavaUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellJavaUserClient: MagicbellJavaUserClient = MagicbellJavaUserClient(config);

    TemplatesInstallation templatesInstallation = TemplatesInstallation.builder()
			.category("category")
			.channel("channel")
			.text("text")
			.build();

    val response: TemplatesInstallation = magicbellJavaUserClient.integrations.saveTemplatesInstallation(templatesInstallation);

    println(response);
}
```

## saveWebPushInstallation

Creates a new installation of a web_push integration for a user. This endpoint is used when an integration needs to be set up with user-specific credentials or configuration.

- HTTP Method: `POST`
- Endpoint: `/integrations/web_push/installations`

**Parameters**

| Name         | Type                                      | Required | Description  |
| :----------- | :---------------------------------------- | :------- | :----------- |
| webPushToken | [WebPushToken](../models/WebPushToken.md) | ❌       | Request Body |

**Return Type**

`WebPushToken`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.user_client.magicbelljavauserclient.MagicbellJavaUserClient;
import com.magicbell.user_client.magicbelljavauserclient.config.MagicbellJavaUserClientConfig;
import com.magicbell.user_client.magicbelljavauserclient.models.Keys;
import com.magicbell.user_client.magicbelljavauserclient.models.WebPushToken;

fun main() {
	val config: MagicbellJavaUserClientConfig = MagicbellJavaUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellJavaUserClient: MagicbellJavaUserClient = MagicbellJavaUserClient(config);

    Keys keys = Keys.builder()
			.auth("auth")
			.p256dh("p256dh")
			.build();

		WebPushToken webPushToken = WebPushToken.builder()
			.endpoint("endpoint")
			.keys(keys)
			.build();

    val response: WebPushToken = magicbellJavaUserClient.integrations.saveWebPushInstallation(webPushToken);

    println(response);
}
```

## startWebPushInstallation

Initiates the installation flow for a web_push integration. This is the first step in a multi-step installation process where user authorization or external service configuration may be required.

- HTTP Method: `POST`
- Endpoint: `/integrations/web_push/installations/start`

**Return Type**

`WebPushStartInstallationResponse`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.user_client.magicbelljavauserclient.MagicbellJavaUserClient;
import com.magicbell.user_client.magicbelljavauserclient.config.MagicbellJavaUserClientConfig;
import com.magicbell.user_client.magicbelljavauserclient.models.WebPushStartInstallationResponse;

fun main() {
	val config: MagicbellJavaUserClientConfig = MagicbellJavaUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellJavaUserClient: MagicbellJavaUserClient = MagicbellJavaUserClient(config);

    val response: WebPushStartInstallationResponse = magicbellJavaUserClient.integrations.startWebPushInstallation();

    println(response);
}
```
