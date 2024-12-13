# ApnsToken

**Properties**

| Name           | Type                    | Required | Description                                                                                                                                                                       |
| :------------- | :---------------------- | :------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| deviceToken    | String                  | ✅       |                                                                                                                                                                                   |
| appId          | String                  | ❌       | (Optional) The bundle identifier of the application that is registering this token. Use this field to override the default identifier specified in the projects APNs integration. |
| installationId | ApnsTokenInstallationId | ❌       | (Optional) The APNs environment the token is registered for. If none is provided we assume the token is used in `production`.                                                     |
