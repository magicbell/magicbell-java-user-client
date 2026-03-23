# ApnsTokenPayload

**Properties**

| Name           | Type                           | Required | Description                                                                                                                                      |
| :------------- | :----------------------------- | :------- | :----------------------------------------------------------------------------------------------------------------------------------------------- |
| deviceToken    | String                         | ✅       | The APNs device token to register with MagicBell.                                                                                                |
| appId          | String                         | ❌       | The bundle identifier of the application registering this token. Use this to override the default identifier configured on the APNs integration. |
| installationId | ApnsTokenPayloadInstallationId | ❌       | The APNs environment this token belongs to. If omitted we assume it targets `production`.                                                        |
