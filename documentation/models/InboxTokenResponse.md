# InboxTokenResponse

**Properties**

| Name         | Type   | Required | Description                                                                |
| :----------- | :----- | :------- | :------------------------------------------------------------------------- |
| createdAt    | String | ✅       | The timestamp when the token was created.                                  |
| id           | String | ✅       | The unique identifier for the token.                                       |
| token        | String | ✅       | The in-app inbox token generated for this user.                            |
| connectionId | String | ❌       | Realtime connection ID to restrict delivery to a specific Ably connection. |
| discardedAt  | String | ❌       | The timestamp when the token was discarded, if applicable.                 |
| updatedAt    | String | ❌       | The timestamp when the token metadata last changed.                        |
