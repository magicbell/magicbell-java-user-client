# SlackToken

**Properties**

| Name        | Type              | Required | Description                                                                                         |
| :---------- | :---------------- | :------- | :-------------------------------------------------------------------------------------------------- |
| createdAt   | String            | ✅       |                                                                                                     |
| id          | String            | ✅       |                                                                                                     |
| discardedAt | String            | ❌       |                                                                                                     |
| oauth       | SlackTokenOauth   | ❌       |                                                                                                     |
| updatedAt   | String            | ❌       |                                                                                                     |
| webhook     | SlackTokenWebhook | ❌       | Obtained directly from the incoming_webhook object in the installation response from the Slack API. |
