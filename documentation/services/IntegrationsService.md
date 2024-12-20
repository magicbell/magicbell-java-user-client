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

```java
import com.magicbell.userclient.MagicbellJavaUserClient;
import com.magicbell.userclient.config.MagicbellJavaUserClientConfig;
import com.magicbell.userclient.models.Banner;
import com.magicbell.userclient.models.DefaultHover;
import com.magicbell.userclient.models.DefaultState;
import com.magicbell.userclient.models.Default_;
import com.magicbell.userclient.models.Dialog;
import com.magicbell.userclient.models.Footer;
import com.magicbell.userclient.models.Header;
import com.magicbell.userclient.models.Icon;
import com.magicbell.userclient.models.Images;
import com.magicbell.userclient.models.InboxConfig;
import com.magicbell.userclient.models.Notification;
import com.magicbell.userclient.models.Theme;
import com.magicbell.userclient.models.Unread;
import com.magicbell.userclient.models.UnreadHover;
import com.magicbell.userclient.models.UnreadState;
import com.magicbell.userclient.models.Unseen;
import com.magicbell.userclient.models.UnseenBadge;
import com.magicbell.userclient.models.UnseenHover;
import com.magicbell.userclient.models.UnseenState;

public class Main {

  public static void main(String[] args) {
    MagicbellJavaUserClientConfig config = MagicbellJavaUserClientConfig
      .builder()
      .accessToken("YOUR_ACCESS_TOKEN")
      .build();

    MagicbellJavaUserClient magicbellJavaUserClient = new MagicbellJavaUserClient(config);

    Images images = Images.builder().emptyInboxUrl("emptyInboxUrl").build();

    Banner banner = Banner
      .builder()
      .backgroundColor("backgroundColor")
      .backgroundOpacity(2.68D)
      .fontSize("fontSize")
      .textColor("textColor")
      .build();

    Dialog dialog = Dialog
      .builder()
      .accentColor("accentColor")
      .backgroundColor("backgroundColor")
      .textColor("textColor")
      .build();

    Footer footer = Footer
      .builder()
      .backgroundColor("backgroundColor")
      .borderRadius("borderRadius")
      .fontSize("fontSize")
      .textColor("textColor")
      .build();

    Header header = Header
      .builder()
      .backgroundColor("backgroundColor")
      .borderRadius("borderRadius")
      .fontFamily("fontFamily")
      .fontSize("fontSize")
      .textColor("textColor")
      .build();

    Icon icon = Icon.builder().borderColor("borderColor").width("width").build();

    DefaultHover defaultHover = DefaultHover.builder().backgroundColor("backgroundColor").build();

    DefaultState defaultState = DefaultState.builder().color("color").build();

    Default_ default_ = Default_
      .builder()
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

    Unread unread = Unread
      .builder()
      .backgroundColor("backgroundColor")
      .hover(unreadHover)
      .state(unreadState)
      .textColor("textColor")
      .build();

    UnseenHover unseenHover = UnseenHover.builder().backgroundColor("backgroundColor").build();

    UnseenState unseenState = UnseenState.builder().color("color").build();

    Unseen unseen = Unseen
      .builder()
      .backgroundColor("backgroundColor")
      .hover(unseenHover)
      .state(unseenState)
      .textColor("textColor")
      .build();

    Notification notification = Notification.builder().default_(default_).unread(unread).unseen(unseen).build();

    UnseenBadge unseenBadge = UnseenBadge.builder().backgroundColor("backgroundColor").build();

    Theme theme = Theme
      .builder()
      .banner(banner)
      .dialog(dialog)
      .footer(footer)
      .header(header)
      .icon(icon)
      .notification(notification)
      .unseenBadge(unseenBadge)
      .build();

    InboxConfig inboxConfig = InboxConfig.builder().images(images).locale("locale").theme(theme).build();

    InboxConfig response = magicbellJavaUserClient.integrations.saveInboxInstallation(inboxConfig);

    System.out.println(response);
  }
}

```

## startInboxInstallation

Initiates the installation flow for a inbox integration. This is the first step in a multi-step installation process where user authorization or external service configuration may be required.

- HTTP Method: `POST`
- Endpoint: `/integrations/inbox/installations/start`

**Return Type**

`InboxConfig`

**Example Usage Code Snippet**

```java
import com.magicbell.userclient.MagicbellJavaUserClient;
import com.magicbell.userclient.config.MagicbellJavaUserClientConfig;
import com.magicbell.userclient.models.InboxConfig;

public class Main {

  public static void main(String[] args) {
    MagicbellJavaUserClientConfig config = MagicbellJavaUserClientConfig
      .builder()
      .accessToken("YOUR_ACCESS_TOKEN")
      .build();

    MagicbellJavaUserClient magicbellJavaUserClient = new MagicbellJavaUserClient(config);

    InboxConfig response = magicbellJavaUserClient.integrations.startInboxInstallation();

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
import com.magicbell.userclient.MagicbellJavaUserClient;
import com.magicbell.userclient.config.MagicbellJavaUserClientConfig;
import com.magicbell.userclient.models.AuthedUser;
import com.magicbell.userclient.models.Enterprise;
import com.magicbell.userclient.models.IncomingWebhook;
import com.magicbell.userclient.models.SlackInstallation;
import com.magicbell.userclient.models.Team;

public class Main {

  public static void main(String[] args) {
    MagicbellJavaUserClientConfig config = MagicbellJavaUserClientConfig
      .builder()
      .accessToken("YOUR_ACCESS_TOKEN")
      .build();

    MagicbellJavaUserClient magicbellJavaUserClient = new MagicbellJavaUserClient(config);

    AuthedUser authedUser = AuthedUser
      .builder()
      .accessToken("access_token")
      .expiresIn(0L)
      .id("id")
      .refreshToken("refresh_token")
      .scope("scope")
      .tokenType("token_type")
      .build();

    Enterprise enterprise = Enterprise.builder().id("id").name("name").build();

    IncomingWebhook incomingWebhook = IncomingWebhook
      .builder()
      .channel("channel")
      .configurationUrl("configuration_url")
      .url("url")
      .build();

    Team team = Team.builder().id("id").name("name").build();

    SlackInstallation slackInstallation = SlackInstallation
      .builder()
      .accessToken("access_token")
      .appId("app_id")
      .authedUser(authedUser)
      .botUserId("bot_user_id")
      .enterprise(enterprise)
      .expiresIn(10L)
      .id("0GKF")
      .incomingWebhook(incomingWebhook)
      .isEnterpriseInstall(false)
      .refreshToken("refresh_token")
      .scope("scope")
      .team(team)
      .tokenType("token_type")
      .build();

    SlackInstallation response = magicbellJavaUserClient.integrations.saveSlackInstallation(slackInstallation);

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
import com.magicbell.userclient.MagicbellJavaUserClient;
import com.magicbell.userclient.config.MagicbellJavaUserClientConfig;
import com.magicbell.userclient.models.SlackFinishInstallResponse;
import com.magicbell.userclient.models.SlackInstallation;

public class Main {

  public static void main(String[] args) {
    MagicbellJavaUserClientConfig config = MagicbellJavaUserClientConfig
      .builder()
      .accessToken("YOUR_ACCESS_TOKEN")
      .build();

    MagicbellJavaUserClient magicbellJavaUserClient = new MagicbellJavaUserClient(config);

    SlackFinishInstallResponse slackFinishInstallResponse = SlackFinishInstallResponse
      .builder()
      .appId("app_id")
      .code("code")
      .redirectUrl("redirect_url")
      .build();

    SlackInstallation response = magicbellJavaUserClient.integrations.finishSlackInstallation(
      slackFinishInstallResponse
    );

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
import com.magicbell.userclient.MagicbellJavaUserClient;
import com.magicbell.userclient.config.MagicbellJavaUserClientConfig;
import com.magicbell.userclient.models.SlackStartInstall;
import com.magicbell.userclient.models.SlackStartInstallResponseContent;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    MagicbellJavaUserClientConfig config = MagicbellJavaUserClientConfig
      .builder()
      .accessToken("YOUR_ACCESS_TOKEN")
      .build();

    MagicbellJavaUserClient magicbellJavaUserClient = new MagicbellJavaUserClient(config);

    List<String> extraScopes = Arrays.asList("extra_scopes");

    SlackStartInstall slackStartInstall = SlackStartInstall
      .builder()
      .appId("app_id")
      .authUrl("auth_url")
      .extraScopes(extraScopes)
      .redirectUrl("redirect_url")
      .build();

    SlackStartInstallResponseContent response = magicbellJavaUserClient.integrations.startSlackInstallation(
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
import com.magicbell.userclient.MagicbellJavaUserClient;
import com.magicbell.userclient.config.MagicbellJavaUserClientConfig;
import com.magicbell.userclient.models.TemplatesInstallation;

public class Main {

  public static void main(String[] args) {
    MagicbellJavaUserClientConfig config = MagicbellJavaUserClientConfig
      .builder()
      .accessToken("YOUR_ACCESS_TOKEN")
      .build();

    MagicbellJavaUserClient magicbellJavaUserClient = new MagicbellJavaUserClient(config);

    TemplatesInstallation templatesInstallation = TemplatesInstallation
      .builder()
      .category("category")
      .channel("channel")
      .text("text")
      .build();

    TemplatesInstallation response = magicbellJavaUserClient.integrations.saveTemplatesInstallation(
      templatesInstallation
    );

    System.out.println(response);
  }
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

```java
import com.magicbell.userclient.MagicbellJavaUserClient;
import com.magicbell.userclient.config.MagicbellJavaUserClientConfig;
import com.magicbell.userclient.models.Keys;
import com.magicbell.userclient.models.WebPushToken;

public class Main {

  public static void main(String[] args) {
    MagicbellJavaUserClientConfig config = MagicbellJavaUserClientConfig
      .builder()
      .accessToken("YOUR_ACCESS_TOKEN")
      .build();

    MagicbellJavaUserClient magicbellJavaUserClient = new MagicbellJavaUserClient(config);

    Keys keys = Keys.builder().auth("auth").p256dh("p256dh").build();

    WebPushToken webPushToken = WebPushToken.builder().endpoint("endpoint").keys(keys).build();

    WebPushToken response = magicbellJavaUserClient.integrations.saveWebPushInstallation(webPushToken);

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
import com.magicbell.userclient.MagicbellJavaUserClient;
import com.magicbell.userclient.config.MagicbellJavaUserClientConfig;
import com.magicbell.userclient.models.WebPushStartInstallationResponse;

public class Main {

  public static void main(String[] args) {
    MagicbellJavaUserClientConfig config = MagicbellJavaUserClientConfig
      .builder()
      .accessToken("YOUR_ACCESS_TOKEN")
      .build();

    MagicbellJavaUserClient magicbellJavaUserClient = new MagicbellJavaUserClient(config);

    WebPushStartInstallationResponse response = magicbellJavaUserClient.integrations.startWebPushInstallation();

    System.out.println(response);
  }
}

```
