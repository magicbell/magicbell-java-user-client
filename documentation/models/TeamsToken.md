# TeamsToken

**Properties**

| Name        | Type              | Required | Description                                                |
| :---------- | :---------------- | :------- | :--------------------------------------------------------- |
| createdAt   | String            | ✅       | The timestamp when the token was created.                  |
| id          | String            | ✅       | The unique identifier for the token.                       |
| discardedAt | String            | ❌       | The timestamp when the token was discarded, if applicable. |
| updatedAt   | String            | ❌       | The timestamp when the token metadata last changed.        |
| webhook     | TeamsTokenWebhook | ❌       |                                                            |
