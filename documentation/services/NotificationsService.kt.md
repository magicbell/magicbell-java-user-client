# NotificationsService

A list of all methods in the `NotificationsService` service. Click on the method name to view detailed information about that method.

| Methods                                           | Description                         |
| :------------------------------------------------ | :---------------------------------- |
| [listNotifications](#listnotifications)           | Lists all notifications for a user. |
| [archiveNotification](#archivenotification)       | Archives a notification.            |
| [markNotificationRead](#marknotificationread)     | Marks a notification as read.       |
| [unarchiveNotification](#unarchivenotification)   | Unarchives a notification.          |
| [markNotificationUnread](#marknotificationunread) | Marks a notification as unread.     |

## listNotifications

Lists all notifications for a user.

- HTTP Method: `GET`
- Endpoint: `/notifications`

**Parameters**

| Name              | Type                                                                    | Required | Description               |
| :---------------- | :---------------------------------------------------------------------- | :------- | :------------------------ |
| requestParameters | [ListNotificationsParameters](../models/ListNotificationsParameters.md) | ❌       | Request Parameters Object |

**Return Type**

`NotificationCollection`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.ListNotificationsParameters;
import com.magicbell.magicbelluserclient.models.NotificationCollection;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val requestParameters: ListNotificationsParameters = ListNotificationsParameters.builder()
			.limit(7L)
			.startingAfter("starting_after")
			.endingBefore("ending_before")
			.status("status")
			.topic("topic")
			.build();

    val response: NotificationCollection = magicbellUserClient.notifications.listNotifications(requestParameters);

    println(response);
}
```

## archiveNotification

Archives a notification.

- HTTP Method: `POST`
- Endpoint: `/notifications/{notification_id}/archive`

**Parameters**

| Name           | Type   | Required | Description |
| :------------- | :----- | :------- | :---------- |
| notificationId | String | ✅       |             |

**Example Usage Code Snippet**

```kotlin
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    magicbellUserClient.notifications.archiveNotification("notification_id");
}
```

## markNotificationRead

Marks a notification as read.

- HTTP Method: `POST`
- Endpoint: `/notifications/{notification_id}/read`

**Parameters**

| Name           | Type   | Required | Description |
| :------------- | :----- | :------- | :---------- |
| notificationId | String | ✅       |             |

**Example Usage Code Snippet**

```kotlin
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    magicbellUserClient.notifications.markNotificationRead("notification_id");
}
```

## unarchiveNotification

Unarchives a notification.

- HTTP Method: `POST`
- Endpoint: `/notifications/{notification_id}/unarchive`

**Parameters**

| Name           | Type   | Required | Description |
| :------------- | :----- | :------- | :---------- |
| notificationId | String | ✅       |             |

**Example Usage Code Snippet**

```kotlin
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    magicbellUserClient.notifications.unarchiveNotification("notification_id");
}
```

## markNotificationUnread

Marks a notification as unread.

- HTTP Method: `POST`
- Endpoint: `/notifications/{notification_id}/unread`

**Parameters**

| Name           | Type   | Required | Description |
| :------------- | :----- | :------- | :---------- |
| notificationId | String | ✅       |             |

**Example Usage Code Snippet**

```kotlin
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    magicbellUserClient.notifications.markNotificationUnread("notification_id");
}
```
