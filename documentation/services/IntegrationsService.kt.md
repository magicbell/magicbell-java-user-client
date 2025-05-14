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

| Name               | Type                                                  | Required | Description  |
| :----------------- | :---------------------------------------------------- | :------- | :----------- |
| inboxConfigPayload | [InboxConfigPayload](../models/InboxConfigPayload.md) | ❌       | Request Body |

**Return Type**

`InboxConfigPayload`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.Banner;
import com.magicbell.magicbelluserclient.models.DefaultHover;
import com.magicbell.magicbelluserclient.models.DefaultState;
import com.magicbell.magicbelluserclient.models.Default_;
import com.magicbell.magicbelluserclient.models.Dialog;
import com.magicbell.magicbelluserclient.models.Footer;
import com.magicbell.magicbelluserclient.models.Header;
import com.magicbell.magicbelluserclient.models.Icon;
import com.magicbell.magicbelluserclient.models.Images;
import com.magicbell.magicbelluserclient.models.InboxConfigPayload;
import com.magicbell.magicbelluserclient.models.Theme;
import com.magicbell.magicbelluserclient.models.ThemeNotification;
import com.magicbell.magicbelluserclient.models.Unread;
import com.magicbell.magicbelluserclient.models.UnreadHover;
import com.magicbell.magicbelluserclient.models.UnreadState;
import com.magicbell.magicbelluserclient.models.Unseen;
import com.magicbell.magicbelluserclient.models.UnseenBadge;
import com.magicbell.magicbelluserclient.models.UnseenHover;
import com.magicbell.magicbelluserclient.models.UnseenState;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val images: Images = Images.builder()
			.emptyInboxUrl("emptyInboxUrl")
			.build();

		val banner: Banner = Banner.builder()
			.backgroundColor("backgroundColor")
			.backgroundOpacity(0.97D)
			.fontSize("fontSize")
			.textColor("textColor")
			.build();

		val dialog: Dialog = Dialog.builder()
			.accentColor("accentColor")
			.backgroundColor("backgroundColor")
			.textColor("textColor")
			.build();

		val footer: Footer = Footer.builder()
			.backgroundColor("backgroundColor")
			.borderRadius("borderRadius")
			.fontSize("fontSize")
			.textColor("textColor")
			.build();

		val header: Header = Header.builder()
			.backgroundColor("backgroundColor")
			.borderRadius("borderRadius")
			.fontFamily("fontFamily")
			.fontSize("fontSize")
			.textColor("textColor")
			.build();

		val icon: Icon = Icon.builder()
			.borderColor("borderColor")
			.width("width")
			.build();

		val defaultHover: DefaultHover = DefaultHover.builder()
			.backgroundColor("backgroundColor")
			.build();

		val defaultState: DefaultState = DefaultState.builder()
			.color("color")
			.build();

		val default_: Default_ = Default_.builder()
			.backgroundColor("backgroundColor")
			.borderRadius("borderRadius")
			.fontFamily("fontFamily")
			.fontSize("fontSize")
			.hover(defaultHover)
			.margin("margin")
			.state(defaultState)
			.textColor("textColor")
			.build();

		val unreadHover: UnreadHover = UnreadHover.builder()
			.backgroundColor("backgroundColor")
			.build();

		val unreadState: UnreadState = UnreadState.builder()
			.color("color")
			.build();

		val unread: Unread = Unread.builder()
			.backgroundColor("backgroundColor")
			.hover(unreadHover)
			.state(unreadState)
			.textColor("textColor")
			.build();

		val unseenHover: UnseenHover = UnseenHover.builder()
			.backgroundColor("backgroundColor")
			.build();

		val unseenState: UnseenState = UnseenState.builder()
			.color("color")
			.build();

		val unseen: Unseen = Unseen.builder()
			.backgroundColor("backgroundColor")
			.hover(unseenHover)
			.state(unseenState)
			.textColor("textColor")
			.build();

		val themeNotification: ThemeNotification = ThemeNotification.builder()
			.default_(default_)
			.unread(unread)
			.unseen(unseen)
			.build();

		val unseenBadge: UnseenBadge = UnseenBadge.builder()
			.backgroundColor("backgroundColor")
			.build();

		val theme: Theme = Theme.builder()
			.banner(banner)
			.dialog(dialog)
			.footer(footer)
			.header(header)
			.icon(icon)
			.notification(themeNotification)
			.unseenBadge(unseenBadge)
			.build();

		val inboxConfigPayload: InboxConfigPayload = InboxConfigPayload.builder()
			.images(images)
			.locale("locale")
			.theme(theme)
			.build();

    val response: InboxConfigPayload = magicbellUserClient.integrations.saveInboxInstallation(inboxConfigPayload);

    println(response);
}
```

## startInboxInstallation

Initiates the installation flow for a inbox integration. This is the first step in a multi-step installation process where user authorization or external service configuration may be required.

- HTTP Method: `POST`
- Endpoint: `/integrations/inbox/installations/start`

**Return Type**

`InboxConfigPayload`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.InboxConfigPayload;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val response: InboxConfigPayload = magicbellUserClient.integrations.startInboxInstallation();

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
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.AuthedUser;
import com.magicbell.magicbelluserclient.models.Enterprise;
import com.magicbell.magicbelluserclient.models.IncomingWebhook;
import com.magicbell.magicbelluserclient.models.SlackInstallation;
import com.magicbell.magicbelluserclient.models.Team;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val authedUser: AuthedUser = AuthedUser.builder()
			.accessToken("access_token")
			.expiresIn(0L)
			.id("id")
			.refreshToken("refresh_token")
			.scope("scope")
			.tokenType("token_type")
			.build();

		val enterprise: Enterprise = Enterprise.builder()
			.id("id")
			.name("name")
			.build();

		val incomingWebhook: IncomingWebhook = IncomingWebhook.builder()
			.channel("channel")
			.configurationUrl("configuration_url")
			.url("url")
			.build();

		val team: Team = Team.builder()
			.id("id")
			.name("name")
			.build();

		val slackInstallation: SlackInstallation = SlackInstallation.builder()
			.accessToken("access_token")
			.appId("app_id")
			.authedUser(authedUser)
			.botUserId("bot_user_id")
			.enterprise(enterprise)
			.expiresIn(6L)
			.id("FFPMPE-+")
			.incomingWebhook(incomingWebhook)
			.isEnterpriseInstall(true)
			.refreshToken("refresh_token")
			.scope("scope")
			.team(team)
			.tokenType("token_type")
			.build();

    val response: SlackInstallation = magicbellUserClient.integrations.saveSlackInstallation(slackInstallation);

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
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.SlackFinishInstallResponse;
import com.magicbell.magicbelluserclient.models.SlackInstallation;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val slackFinishInstallResponse: SlackFinishInstallResponse = SlackFinishInstallResponse.builder()
			.appId("app_id")
			.code("code")
			.redirectUrl("redirect_url")
			.build();

    val response: SlackInstallation = magicbellUserClient.integrations.finishSlackInstallation(slackFinishInstallResponse);

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
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.SlackStartInstall;
import com.magicbell.magicbelluserclient.models.SlackStartInstallResponseContent;
import java.util.Arrays;
import java.util.List;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val extraScopes: List<String> = Arrays.asList("extra_scopes");

		val slackStartInstall: SlackStartInstall = SlackStartInstall.builder()
			.appId("app_id")
			.authUrl("auth_url")
			.extraScopes(extraScopes)
			.redirectUrl("redirect_url")
			.build();

    val response: SlackStartInstallResponseContent = magicbellUserClient.integrations.startSlackInstallation(slackStartInstall);

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
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.TemplatesInstallation;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val templatesInstallation: TemplatesInstallation = TemplatesInstallation.builder()
			.category("category")
			.channel("channel")
			.text("text")
			.build();

    val response: TemplatesInstallation = magicbellUserClient.integrations.saveTemplatesInstallation(templatesInstallation);

    println(response);
}
```

## saveWebPushInstallation

Creates a new installation of a web_push integration for a user. This endpoint is used when an integration needs to be set up with user-specific credentials or configuration.

- HTTP Method: `POST`
- Endpoint: `/integrations/web_push/installations`

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

    val response: WebPushTokenPayload = magicbellUserClient.integrations.saveWebPushInstallation(webPushTokenPayload);

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
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.WebPushStartInstallationResponse;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val response: WebPushStartInstallationResponse = magicbellUserClient.integrations.startWebPushInstallation();

    println(response);
}
```
