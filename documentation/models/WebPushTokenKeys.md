# WebPushTokenKeys

The encryption keys from the PushSubscription.getKey() method, needed to encrypt push messages for this subscription.

**Properties**

| Name   | Type   | Required | Description                                                                                                                     |
| :----- | :----- | :------- | :------------------------------------------------------------------------------------------------------------------------------ |
| auth   | String | ✅       | The authentication secret obtained from PushSubscription.getKey('auth'). Used to encrypt push messages for this subscription.   |
| p256dh | String | ✅       | The P-256 ECDH public key obtained from PushSubscription.getKey('p256dh'). Used to encrypt push messages for this subscription. |
