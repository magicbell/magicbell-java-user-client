package com.magicbell.magicbelluserclient.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.exceptions.ApiException;
import com.magicbell.magicbelluserclient.http.Environment;
import com.magicbell.magicbelluserclient.http.HttpMethod;
import com.magicbell.magicbelluserclient.http.ModelConverter;
import com.magicbell.magicbelluserclient.http.util.RequestBuilder;
import com.magicbell.magicbelluserclient.models.ListNotificationsParameters;
import com.magicbell.magicbelluserclient.models.NotificationCollection;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * NotificationsService Service
 */
public class NotificationsService extends BaseService {

  public NotificationsService(@NonNull OkHttpClient httpClient, MagicbellUserClientConfig config) {
    super(httpClient, config);
  }

  /**
   * Lists all notifications for a user.
   *
   * @return response of {@code NotificationCollection}
   */
  public NotificationCollection listNotifications() throws ApiException {
    return this.listNotifications(ListNotificationsParameters.builder().build());
  }

  /**
   * Lists all notifications for a user.
   *
   * @param requestParameters {@link ListNotificationsParameters} Request Parameters Object
   * @return response of {@code NotificationCollection}
   */
  public NotificationCollection listNotifications(@NonNull ListNotificationsParameters requestParameters)
    throws ApiException {
    Request request = this.buildListNotificationsRequest(requestParameters);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<NotificationCollection>() {});
  }

  /**
   * Lists all notifications for a user.
   *
   * @return response of {@code CompletableFuture<NotificationCollection>}
   */
  public CompletableFuture<NotificationCollection> listNotificationsAsync() throws ApiException {
    return this.listNotificationsAsync(ListNotificationsParameters.builder().build());
  }

  /**
   * Lists all notifications for a user.
   *
   * @param requestParameters {@link ListNotificationsParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<NotificationCollection>}
   */
  public CompletableFuture<NotificationCollection> listNotificationsAsync(
    @NonNull ListNotificationsParameters requestParameters
  ) throws ApiException {
    Request request = this.buildListNotificationsRequest(requestParameters);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<NotificationCollection>() {})
    );
  }

  private Request buildListNotificationsRequest(@NonNull ListNotificationsParameters requestParameters) {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "notifications"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setOptionalQueryParameter("limit", requestParameters.getLimit())
      .setOptionalQueryParameter("starting_after", requestParameters.getStartingAfter())
      .setOptionalQueryParameter("ending_before", requestParameters.getEndingBefore())
      .setOptionalQueryParameter("status", requestParameters.getStatus())
      .setOptionalQueryParameter("topic", requestParameters.getTopic())
      .build();
  }

  /**
   * Archives a notification.
   *
   * @param notificationId String
   * @return response of {@code void}
   */
  public void archiveNotification(@NonNull String notificationId) throws ApiException {
    Request request = this.buildArchiveNotificationRequest(notificationId);
    this.execute(request);
  }

  /**
   * Archives a notification.
   *
   * @param notificationId String
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> archiveNotificationAsync(@NonNull String notificationId) throws ApiException {
    Request request = this.buildArchiveNotificationRequest(notificationId);
    return this.executeAsync(request).thenApplyAsync(response -> null);
  }

  private Request buildArchiveNotificationRequest(@NonNull String notificationId) {
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "notifications/{notification_id}/archive"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("notification_id", notificationId)
      .build();
  }

  /**
   * Marks a notification as read.
   *
   * @param notificationId String
   * @return response of {@code void}
   */
  public void markNotificationRead(@NonNull String notificationId) throws ApiException {
    Request request = this.buildMarkNotificationReadRequest(notificationId);
    this.execute(request);
  }

  /**
   * Marks a notification as read.
   *
   * @param notificationId String
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> markNotificationReadAsync(@NonNull String notificationId) throws ApiException {
    Request request = this.buildMarkNotificationReadRequest(notificationId);
    return this.executeAsync(request).thenApplyAsync(response -> null);
  }

  private Request buildMarkNotificationReadRequest(@NonNull String notificationId) {
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "notifications/{notification_id}/read"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("notification_id", notificationId)
      .build();
  }

  /**
   * Unarchives a notification.
   *
   * @param notificationId String
   * @return response of {@code void}
   */
  public void unarchiveNotification(@NonNull String notificationId) throws ApiException {
    Request request = this.buildUnarchiveNotificationRequest(notificationId);
    this.execute(request);
  }

  /**
   * Unarchives a notification.
   *
   * @param notificationId String
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> unarchiveNotificationAsync(@NonNull String notificationId) throws ApiException {
    Request request = this.buildUnarchiveNotificationRequest(notificationId);
    return this.executeAsync(request).thenApplyAsync(response -> null);
  }

  private Request buildUnarchiveNotificationRequest(@NonNull String notificationId) {
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "notifications/{notification_id}/unarchive"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("notification_id", notificationId)
      .build();
  }

  /**
   * Marks a notification as unread.
   *
   * @param notificationId String
   * @return response of {@code void}
   */
  public void markNotificationUnread(@NonNull String notificationId) throws ApiException {
    Request request = this.buildMarkNotificationUnreadRequest(notificationId);
    this.execute(request);
  }

  /**
   * Marks a notification as unread.
   *
   * @param notificationId String
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> markNotificationUnreadAsync(@NonNull String notificationId) throws ApiException {
    Request request = this.buildMarkNotificationUnreadRequest(notificationId);
    return this.executeAsync(request).thenApplyAsync(response -> null);
  }

  private Request buildMarkNotificationUnreadRequest(@NonNull String notificationId) {
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "notifications/{notification_id}/unread"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("notification_id", notificationId)
      .build();
  }
}
