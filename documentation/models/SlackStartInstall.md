# SlackStartInstall

**Properties**

| Name        | Type         | Required | Description                                                         |
| :---------- | :----------- | :------- | :------------------------------------------------------------------ |
| appId       | String       | ✅       | Slack app ID that the installation flow should use.                 |
| authUrl     | String       | ❌       | Optional override for the authorization URL returned to the client. |
| extraScopes | List<String> | ❌       | Additional OAuth scopes to request during installation.             |
| redirectUrl | String       | ❌       | Custom redirect URL to use after OAuth completes.                   |
