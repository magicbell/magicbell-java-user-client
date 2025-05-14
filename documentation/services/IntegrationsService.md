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

```java
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

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    Images images = Images.builder().emptyInboxUrl("emptyInboxUrl").build();

    Banner banner = Banner.builder()
      .backgroundColor("backgroundColor")
      .backgroundOpacity(0.97D)
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

    Icon icon = Icon.builder().borderColor("borderColor").width("width").build();

    DefaultHover defaultHover = DefaultHover.builder().backgroundColor("backgroundColor").build();

    DefaultState defaultState = DefaultState.builder().color("color").build();

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

    UnreadHover unreadHover = UnreadHover.builder().backgroundColor("backgroundColor").build();

    UnreadState unreadState = UnreadState.builder().color("color").build();

    Unread unread = Unread.builder()
      .backgroundColor("backgroundColor")
      .hover(unreadHover)
      .state(unreadState)
      .textColor("textColor")
      .build();

    UnseenHover unseenHover = UnseenHover.builder().backgroundColor("backgroundColor").build();

    UnseenState unseenState = UnseenState.builder().color("color").build();

    Unseen unseen = Unseen.builder()
      .backgroundColor("backgroundColor")
      .hover(unseenHover)
      .state(unseenState)
      .textColor("textColor")
      .build();

    ThemeNotification themeNotification = ThemeNotification.builder()
      .default_(default_)
      .unread(unread)
      .unseen(unseen)
      .build();

    UnseenBadge unseenBadge = UnseenBadge.builder().backgroundColor("backgroundColor").build();

    Theme theme = Theme.builder()
      .banner(banner)
      .dialog(dialog)
      .footer(footer)
      .header(header)
      .icon(icon)
      .notification(themeNotification)
      .unseenBadge(unseenBadge)
      .build();

    InboxConfigPayload inboxConfigPayload = InboxConfigPayload.builder()
      .images(images)
      .locale("locale")
      .theme(theme)
      .build();

    InboxConfigPayload response = magicbellUserClient.integrations.saveInboxInstallation(inboxConfigPayload);

    System.out.println(response);
  }
}

```

## startInboxInstallation

Initiates the installation flow for a inbox integration. This is the first step in a multi-step installation process where user authorization or external service configuration may be required.

- HTTP Method: `POST`
- Endpoint: `/integrations/inbox/installations/start`

**Return Type**

`InboxConfigPayload`

**Example Usage Code Snippet**

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.InboxConfigPayload;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    InboxConfigPayload response = magicbellUserClient.integrations.startInboxInstallation();

    System.out.println(response);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.AuthedUser;
import com.magicbell.magicbelluserclient.models.Enterprise;
import com.magicbell.magicbelluserclient.models.IncomingWebhook;
import com.magicbell.magicbelluserclient.models.SlackInstallation;
import com.magicbell.magicbelluserclient.models.Team;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    AuthedUser authedUser = AuthedUser.builder()
      .accessToken("access_token")
      .expiresIn(0L)
      .id("id")
      .refreshToken("refresh_token")
      .scope("scope")
      .tokenType("token_type")
      .build();

    Enterprise enterprise = Enterprise.builder().id("id").name("name").build();

    IncomingWebhook incomingWebhook = IncomingWebhook.builder()
      .channel("channel")
      .configurationUrl("configuration_url")
      .url("url")
      .build();

    Team team = Team.builder().id("id").name("name").build();

    SlackInstallation slackInstallation = SlackInstallation.builder()
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

    SlackInstallation response = magicbellUserClient.integrations.saveSlackInstallation(slackInstallation);

    System.out.println(response);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.SlackFinishInstallResponse;
import com.magicbell.magicbelluserclient.models.SlackInstallation;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    SlackFinishInstallResponse slackFinishInstallResponse = SlackFinishInstallResponse.builder()
      .appId("app_id")
      .code("code")
      .redirectUrl("redirect_url")
      .build();

    SlackInstallation response = magicbellUserClient.integrations.finishSlackInstallation(slackFinishInstallResponse);

    System.out.println(response);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.SlackStartInstall;
import com.magicbell.magicbelluserclient.models.SlackStartInstallResponseContent;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    List<String> extraScopesList = Arrays.asList("extra_scopes");

    SlackStartInstall slackStartInstall = SlackStartInstall.builder()
      .appId("app_id")
      .authUrl("auth_url")
      .extraScopes(extraScopesList)
      .redirectUrl("redirect_url")
      .build();

    SlackStartInstallResponseContent response = magicbellUserClient.integrations.startSlackInstallation(
      slackStartInstall
    );

    System.out.println(response);
  }
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

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.TemplatesInstallation;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    TemplatesInstallation templatesInstallation = TemplatesInstallation.builder()
      .category("category")
      .channel("channel")
      .text("text")
      .build();

    TemplatesInstallation response = magicbellUserClient.integrations.saveTemplatesInstallation(templatesInstallation);

    System.out.println(response);
  }
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

    WebPushTokenPayload response = magicbellUserClient.integrations.saveWebPushInstallation(webPushTokenPayload);

    System.out.println(response);
  }
}

```

## startWebPushInstallation

Initiates the installation flow for a web_push integration. This is the first step in a multi-step installation process where user authorization or external service configuration may be required.

- HTTP Method: `POST`
- Endpoint: `/integrations/web_push/installations/start`

**Return Type**

`WebPushStartInstallationResponse`

**Example Usage Code Snippet**

```java
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.WebPushStartInstallationResponse;

public class Main {

  public static void main(String[] args) {
    MagicbellUserClientConfig config = MagicbellUserClientConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    MagicbellUserClient magicbellUserClient = new MagicbellUserClient(config);

    WebPushStartInstallationResponse response = magicbellUserClient.integrations.startWebPushInstallation();

    System.out.println(response);
  }
}

```
