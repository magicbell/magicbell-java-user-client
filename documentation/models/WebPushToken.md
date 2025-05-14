# WebPushToken

**Properties**

| Name        | Type             | Required | Description                                                                                                                                                                                      |
| :---------- | :--------------- | :------- | :----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| createdAt   | String           | ✅       |                                                                                                                                                                                                  |
| endpoint    | String           | ✅       | The push subscription URL obtained from PushSubscription.endpoint after calling registration.pushManager.subscribe(). This is the unique URL for this device that push messages will be sent to. |
| id          | String           | ✅       |                                                                                                                                                                                                  |
| keys        | WebPushTokenKeys | ✅       | The encryption keys from the PushSubscription.getKey() method, needed to encrypt push messages for this subscription.                                                                            |
| discardedAt | String           | ❌       |                                                                                                                                                                                                  |
| updatedAt   | String           | ❌       |                                                                                                                                                                                                  |
