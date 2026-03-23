# WebPushStartInstallationResponse

**Properties**

| Name      | Type   | Required | Description                                                |
| :-------- | :----- | :------- | :--------------------------------------------------------- |
| authToken | String | ✅       | Auth secret returned from PushSubscription.getKey('auth'). |
| publicKey | String | ✅       | VAPID public key generated for this web push installation. |
