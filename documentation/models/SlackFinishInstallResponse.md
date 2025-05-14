# SlackFinishInstallResponse

**Properties**

| Name        | Type   | Required | Description                                                                                        |
| :---------- | :----- | :------- | :------------------------------------------------------------------------------------------------- |
| appId       | String | ✅       | The app ID of the Slack app that was originally configured at the project-level.                   |
| code        | String | ✅       | The code that was returned from the OAuth flow, and found in the query string of the redirect URL. |
| redirectUrl | String | ❌       |                                                                                                    |
