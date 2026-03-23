# SlackInstallation

**Properties**

| Name                | Type            | Required | Description                                                        |
| :------------------ | :-------------- | :------- | :----------------------------------------------------------------- |
| accessToken         | String          | ✅       | Bot token returned from the Slack OAuth exchange.                  |
| appId               | String          | ✅       | Slack app identifier for the installed app.                        |
| authedUser          | AuthedUser      | ✅       |                                                                    |
| team                | Team            | ✅       |                                                                    |
| botUserId           | String          | ❌       | Slack user ID of the installed bot.                                |
| enterprise          | Enterprise      | ❌       |                                                                    |
| expiresIn           | Long            | ❌       | Seconds until the bot access token expires.                        |
| id                  | String          | ❌       | Unique identifier MagicBell assigns to the Slack installation.     |
| incomingWebhook     | IncomingWebhook | ❌       |                                                                    |
| isEnterpriseInstall | Boolean         | ❌       | Indicates whether the installation occurred on an enterprise grid. |
| refreshToken        | String          | ❌       | Refresh token for regenerating the bot access token.               |
| scope               | String          | ❌       | Space-delimited OAuth scopes granted to the bot token.             |
| tokenType           | String          | ❌       | Type of bot token returned by Slack.                               |
