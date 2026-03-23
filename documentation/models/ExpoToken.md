# ExpoToken

**Properties**

| Name        | Type   | Required | Description                                                |
| :---------- | :----- | :------- | :--------------------------------------------------------- |
| createdAt   | String | ✅       | The timestamp when the token was created.                  |
| deviceToken | String | ✅       | The Expo push token returned by the Expo client.           |
| id          | String | ✅       | The unique identifier for the token.                       |
| discardedAt | String | ❌       | The timestamp when the token was discarded, if applicable. |
| updatedAt   | String | ❌       | The timestamp when the token metadata last changed.        |
