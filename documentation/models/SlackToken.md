# SlackToken

**Properties**

| Name        | Type              | Required | Description                                                                                         |
| :---------- | :---------------- | :------- | :-------------------------------------------------------------------------------------------------- |
| createdAt   | String            | ✅       | The timestamp when the token was created.                                                           |
| id          | String            | ✅       | The unique identifier for the token.                                                                |
| discardedAt | String            | ❌       | The timestamp when the token was discarded, if applicable.                                          |
| oauth       | SlackTokenOauth   | ❌       |                                                                                                     |
| updatedAt   | String            | ❌       | The timestamp when the token metadata last changed.                                                 |
| webhook     | SlackTokenWebhook | ❌       | Obtained directly from the incoming_webhook object in the installation response from the Slack API. |
