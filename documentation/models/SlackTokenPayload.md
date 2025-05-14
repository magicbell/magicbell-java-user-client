# SlackTokenPayload

**Properties**

| Name    | Type                     | Required | Description                                                                                         |
| :------ | :----------------------- | :------- | :-------------------------------------------------------------------------------------------------- |
| oauth   | SlackTokenPayloadOauth   | ❌       |                                                                                                     |
| webhook | SlackTokenPayloadWebhook | ❌       | Obtained directly from the incoming_webhook object in the installation response from the Slack API. |
