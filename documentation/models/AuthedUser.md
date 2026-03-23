# AuthedUser

**Properties**

| Name         | Type   | Required | Description                                             |
| :----------- | :----- | :------- | :------------------------------------------------------ |
| id           | String | ✅       | Slack user ID for the installer.                        |
| accessToken  | String | ❌       | User token returned from the OAuth exchange.            |
| expiresIn    | Long   | ❌       | Seconds until the user token expires.                   |
| refreshToken | String | ❌       | Refresh token for the authed user.                      |
| scope        | String | ❌       | Space-delimited OAuth scopes granted to the user token. |
| tokenType    | String | ❌       | Token type value provided by Slack.                     |
