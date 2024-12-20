package com.magicbell.user_client.magicbelljavauserclient.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class Theme {

  private Banner banner;

  private Dialog dialog;

  private Footer footer;

  private Header header;

  private Icon icon;

  private Notification notification;

  private UnseenBadge unseenBadge;
}
