# Notification

**Properties**

| Name             | Type   | Required | Description                                             |
| :--------------- | :----- | :------- | :------------------------------------------------------ |
| createdAt        | String | ✅       | The timestamp when the notification was created.        |
| id               | String | ✅       | The unique identifier for the notification.             |
| title            | String | ✅       | The title that is displayed to recipients.              |
| updatedAt        | String | ✅       | The timestamp when the notification was last updated.   |
| userId           | String | ✅       | The user that should receive the notification.          |
| actionUrl        | String | ❌       | The link associated with the notification.              |
| archivedAt       | String | ❌       | The timestamp when the notification was archived.       |
| category         | String | ❌       | The category grouping for the notification.             |
| content          | String | ❌       | The body content of the notification.                   |
| customAttributes | Object | ❌       | The custom data stored with the notification.           |
| discardedAt      | String | ❌       | The timestamp when the notification was discarded.      |
| readAt           | String | ❌       | The timestamp when the notification was marked as read. |
| seenAt           | String | ❌       | The timestamp when the notification was seen.           |
| sentAt           | String | ❌       | The timestamp when the notification was sent.           |
| topic            | String | ❌       | The topic for additional classification.                |
