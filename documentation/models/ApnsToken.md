# ApnsToken

**Properties**

| Name           | Type                    | Required | Description                                                                                                                                      |
| :------------- | :---------------------- | :------- | :----------------------------------------------------------------------------------------------------------------------------------------------- |
| createdAt      | String                  | ✅       | The timestamp when the token was created.                                                                                                        |
| deviceToken    | String                  | ✅       | The APNs device token to register with MagicBell.                                                                                                |
| id             | String                  | ✅       | The unique identifier for the token.                                                                                                             |
| appId          | String                  | ❌       | The bundle identifier of the application registering this token. Use this to override the default identifier configured on the APNs integration. |
| discardedAt    | String                  | ❌       | The timestamp when the token was discarded, if applicable.                                                                                       |
| installationId | ApnsTokenInstallationId | ❌       | The APNs environment this token belongs to. If omitted we assume it targets `production`.                                                        |
| updatedAt      | String                  | ❌       | The timestamp when the token metadata last changed.                                                                                              |
