# FcmToken

**Properties**

| Name        | Type   | Required | Description                                                                        |
| :---------- | :----- | :------- | :--------------------------------------------------------------------------------- |
| createdAt   | String | ✅       | The timestamp when the token was created.                                          |
| deviceToken | String | ✅       | The Firebase Cloud Messaging device registration token to associate with the user. |
| id          | String | ✅       | The unique identifier for the token.                                               |
| discardedAt | String | ❌       | The timestamp when the token was discarded, if applicable.                         |
| updatedAt   | String | ❌       | The timestamp when the token metadata last changed.                                |
