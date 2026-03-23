# ListNotificationsParameters

**Properties**

| Name          | Type   | Required | Description                                                                       |
| :------------ | :----- | :------- | :-------------------------------------------------------------------------------- |
| limit         | Long   | ❌       | defines the maximum number of items to return per page (default: 50)              |
| startingAfter | String | ❌       | a cursor for use in pagination, points to the last ID in previous page            |
| endingBefore  | String | ❌       | a cursor for use in pagination, points to the first ID in next page               |
| status        | String | ❌       | filter notifications by their read state, one of 'unread' \| 'read' \| 'archived' |
| category      | String | ❌       | filter notifications by their category                                            |
| topic         | String | ❌       | filter notifications by their topic                                               |
