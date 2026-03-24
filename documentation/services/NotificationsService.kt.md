# NotificationsService

A list of all methods in the `NotificationsService` service. Click on the method name to view detailed information about that method.

| Methods                                                         | Description                                                                                     |
| :-------------------------------------------------------------- | :---------------------------------------------------------------------------------------------- |
| [listNotifications](#listnotifications)                         | Lists all notifications for a user.                                                             |
| [archiveAllNotifications](#archiveallnotifications)             | Archive all notifications.                                                                      |
| [markAllNotificationsRead](#markallnotificationsread)           | Marks all notifications as read.                                                                |
| [fetchUnreadNotificationsCount](#fetchunreadnotificationscount) | Returns the count of unread notifications for a user. Supports filtering by category and topic. |
| [fetchNotification](#fetchnotification)                         | Gets a notification by ID.                                                                      |
| [archiveNotification](#archivenotification)                     | Archive a notification.                                                                         |
| [markNotificationRead](#marknotificationread)                   | Marks a notification as read.                                                                   |
| [unarchiveNotification](#unarchivenotification)                 | Unarchives a notification.                                                                      |
| [markNotificationUnread](#marknotificationunread)               | Marks a notification as unread.                                                                 |

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
			.limit(5L)
			.startingAfter("starting_after")
			.endingBefore("ending_before")
			.status("status")
			.category("category")
			.topic("topic")
			.build();

    val response: NotificationCollection = magicbellUserClient.notifications.listNotifications(requestParameters);

    println(response);
}
```

## archiveAllNotifications

Archive all notifications.

- HTTP Method: `POST`
- Endpoint: `/notifications/archive`

**Parameters**

| Name              | Type                                                                                | Required | Description               |
| :---------------- | :---------------------------------------------------------------------------------- | :------- | :------------------------ |
| requestParameters | [ArchiveAllNotificationsParameters](../models/ArchiveAllNotificationsParameters.md) | ❌       | Request Parameters Object |

**Example Usage Code Snippet**

```kotlin
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.ArchiveAllNotificationsParameters;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val requestParameters: ArchiveAllNotificationsParameters = ArchiveAllNotificationsParameters.builder()
			.category("category")
			.topic("topic")
			.build();

    magicbellUserClient.notifications.archiveAllNotifications(requestParameters);
}
```

## markAllNotificationsRead

Marks all notifications as read.

- HTTP Method: `POST`
- Endpoint: `/notifications/read`

**Parameters**

| Name              | Type                                                                                  | Required | Description               |
| :---------------- | :------------------------------------------------------------------------------------ | :------- | :------------------------ |
| requestParameters | [MarkAllNotificationsReadParameters](../models/MarkAllNotificationsReadParameters.md) | ❌       | Request Parameters Object |

**Example Usage Code Snippet**

```kotlin
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.MarkAllNotificationsReadParameters;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val requestParameters: MarkAllNotificationsReadParameters = MarkAllNotificationsReadParameters.builder()
			.category("category")
			.topic("topic")
			.build();

    magicbellUserClient.notifications.markAllNotificationsRead(requestParameters);
}
```

## fetchUnreadNotificationsCount

Returns the count of unread notifications for a user. Supports filtering by category and topic.

- HTTP Method: `GET`
- Endpoint: `/notifications/unread/count`

**Parameters**

| Name              | Type                                                                                            | Required | Description               |
| :---------------- | :---------------------------------------------------------------------------------------------- | :------- | :------------------------ |
| requestParameters | [FetchUnreadNotificationsCountParameters](../models/FetchUnreadNotificationsCountParameters.md) | ❌       | Request Parameters Object |

**Return Type**

`CountResponse`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.CountResponse;
import com.magicbell.magicbelluserclient.models.FetchUnreadNotificationsCountParameters;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val requestParameters: FetchUnreadNotificationsCountParameters = FetchUnreadNotificationsCountParameters.builder()
			.category("category")
			.topic("topic")
			.build();

    val response: CountResponse = magicbellUserClient.notifications.fetchUnreadNotificationsCount(requestParameters);

    println(response);
}
```

## fetchNotification

Gets a notification by ID.

- HTTP Method: `GET`
- Endpoint: `/notifications/{notification_id}`

**Parameters**

| Name           | Type   | Required | Description |
| :------------- | :----- | :------- | :---------- |
| notificationId | String | ✅       |             |

**Return Type**

`Notification`

**Example Usage Code Snippet**

```kotlin
import com.magicbell.magicbelluserclient.MagicbellUserClient;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.models.Notification;

fun main() {
	val config: MagicbellUserClientConfig = MagicbellUserClientConfig.builder()
			.accessToken("YOUR_ACCESS_TOKEN")
			.build();

    val magicbellUserClient: MagicbellUserClient = MagicbellUserClient(config);

    val response: Notification = magicbellUserClient.notifications.fetchNotification("notification_id");

    println(response);
}
```

## archiveNotification

Archive a notification.

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
