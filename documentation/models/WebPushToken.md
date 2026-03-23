# WebPushToken

**Properties**

| Name        | Type             | Required | Description                                                                                                                                                                                      |
| :---------- | :--------------- | :------- | :----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| createdAt   | String           | ✅       | The timestamp when the token was created.                                                                                                                                                        |
| endpoint    | String           | ✅       | The push subscription URL obtained from PushSubscription.endpoint after calling registration.pushManager.subscribe(). This is the unique URL for this device that push messages will be sent to. |
| id          | String           | ✅       | The unique identifier for the token.                                                                                                                                                             |
| keys        | WebPushTokenKeys | ✅       | The encryption keys from the PushSubscription.getKey() method, needed to encrypt push messages for this subscription.                                                                            |
| discardedAt | String           | ❌       | The timestamp when the token was discarded, if applicable.                                                                                                                                       |
| updatedAt   | String           | ❌       | The timestamp when the token metadata last changed.                                                                                                                                              |
