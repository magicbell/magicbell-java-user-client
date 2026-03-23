package com.magicbell.magicbelluserclient.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.exceptions.ApiError;
import com.magicbell.magicbelluserclient.http.Environment;
import com.magicbell.magicbelluserclient.http.HttpMethod;
import com.magicbell.magicbelluserclient.http.ModelConverter;
import com.magicbell.magicbelluserclient.http.util.RequestBuilder;
import com.magicbell.magicbelluserclient.models.ArchiveAllNotificationsParameters;
import com.magicbell.magicbelluserclient.models.CountResponse;
import com.magicbell.magicbelluserclient.models.FetchUnreadNotificationsCountParameters;
import com.magicbell.magicbelluserclient.models.ListNotificationsParameters;
import com.magicbell.magicbelluserclient.models.MarkAllNotificationsReadParameters;
import com.magicbell.magicbelluserclient.models.Notification;
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

  /**
   * Constructs a new instance of NotificationsService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public NotificationsService(@NonNull OkHttpClient httpClient, MagicbellUserClientConfig config) {
    super(httpClient, config);
  }

  /**
   * List all notifications
   *
   * @return response of {@code NotificationCollection}
   */
  public NotificationCollection listNotifications() throws ApiError {
    return this.listNotifications(ListNotificationsParameters.builder().build());
  }

  /**
   * List all notifications
   *
   * @param requestParameters {@link ListNotificationsParameters} Request Parameters Object
   * @return response of {@code NotificationCollection}
   */
  public NotificationCollection listNotifications(@NonNull ListNotificationsParameters requestParameters)
    throws ApiError {
    Request request = this.buildListNotificationsRequest(requestParameters);
    Response response = this.execute(request);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<NotificationCollection>() {});
  }

  /**
   * List all notifications
   *
   * @return response of {@code CompletableFuture<NotificationCollection>}
   */
  public CompletableFuture<NotificationCollection> listNotificationsAsync() throws ApiError {
    return this.listNotificationsAsync(ListNotificationsParameters.builder().build());
  }

  /**
   * List all notifications
   *
   * @param requestParameters {@link ListNotificationsParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<NotificationCollection>}
   */
  public CompletableFuture<NotificationCollection> listNotificationsAsync(
    @NonNull ListNotificationsParameters requestParameters
  ) throws ApiError {
    Request request = this.buildListNotificationsRequest(requestParameters);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<NotificationCollection>() {});
    });
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
      .setOptionalQueryParameter("category", requestParameters.getCategory())
      .setOptionalQueryParameter("topic", requestParameters.getTopic())
      .build();
  }

  /**
   * Archive all notifications
   *
   * @return response of {@code void}
   */
  public void archiveAllNotifications() throws ApiError {
    this.archiveAllNotifications(ArchiveAllNotificationsParameters.builder().build());
  }

  /**
   * Archive all notifications
   *
   * @param requestParameters {@link ArchiveAllNotificationsParameters} Request Parameters Object
   * @return response of {@code void}
   */
  public void archiveAllNotifications(@NonNull ArchiveAllNotificationsParameters requestParameters) throws ApiError {
    Request request = this.buildArchiveAllNotificationsRequest(requestParameters);
    this.execute(request);
  }

  /**
   * Archive all notifications
   *
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> archiveAllNotificationsAsync() throws ApiError {
    return this.archiveAllNotificationsAsync(ArchiveAllNotificationsParameters.builder().build());
  }

  /**
   * Archive all notifications
   *
   * @param requestParameters {@link ArchiveAllNotificationsParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> archiveAllNotificationsAsync(
    @NonNull ArchiveAllNotificationsParameters requestParameters
  ) throws ApiError {
    Request request = this.buildArchiveAllNotificationsRequest(requestParameters);
    return this.executeAsync(request).thenApplyAsync(response -> null);
  }

  private Request buildArchiveAllNotificationsRequest(@NonNull ArchiveAllNotificationsParameters requestParameters) {
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "notifications/archive"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setOptionalQueryParameter("category", requestParameters.getCategory())
      .setOptionalQueryParameter("topic", requestParameters.getTopic())
      .build();
  }

  /**
   * Mark all notifications read
   *
   * @return response of {@code void}
   */
  public void markAllNotificationsRead() throws ApiError {
    this.markAllNotificationsRead(MarkAllNotificationsReadParameters.builder().build());
  }

  /**
   * Mark all notifications read
   *
   * @param requestParameters {@link MarkAllNotificationsReadParameters} Request Parameters Object
   * @return response of {@code void}
   */
  public void markAllNotificationsRead(@NonNull MarkAllNotificationsReadParameters requestParameters) throws ApiError {
    Request request = this.buildMarkAllNotificationsReadRequest(requestParameters);
    this.execute(request);
  }

  /**
   * Mark all notifications read
   *
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> markAllNotificationsReadAsync() throws ApiError {
    return this.markAllNotificationsReadAsync(MarkAllNotificationsReadParameters.builder().build());
  }

  /**
   * Mark all notifications read
   *
   * @param requestParameters {@link MarkAllNotificationsReadParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> markAllNotificationsReadAsync(
    @NonNull MarkAllNotificationsReadParameters requestParameters
  ) throws ApiError {
    Request request = this.buildMarkAllNotificationsReadRequest(requestParameters);
    return this.executeAsync(request).thenApplyAsync(response -> null);
  }

  private Request buildMarkAllNotificationsReadRequest(@NonNull MarkAllNotificationsReadParameters requestParameters) {
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "notifications/read"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setOptionalQueryParameter("category", requestParameters.getCategory())
      .setOptionalQueryParameter("topic", requestParameters.getTopic())
      .build();
  }

  /**
   * Count unread notifications
   *
   * @return response of {@code CountResponse}
   */
  public CountResponse fetchUnreadNotificationsCount() throws ApiError {
    return this.fetchUnreadNotificationsCount(FetchUnreadNotificationsCountParameters.builder().build());
  }

  /**
   * Count unread notifications
   *
   * @param requestParameters {@link FetchUnreadNotificationsCountParameters} Request Parameters Object
   * @return response of {@code CountResponse}
   */
  public CountResponse fetchUnreadNotificationsCount(
    @NonNull FetchUnreadNotificationsCountParameters requestParameters
  ) throws ApiError {
    Request request = this.buildFetchUnreadNotificationsCountRequest(requestParameters);
    Response response = this.execute(request);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<CountResponse>() {});
  }

  /**
   * Count unread notifications
   *
   * @return response of {@code CompletableFuture<CountResponse>}
   */
  public CompletableFuture<CountResponse> fetchUnreadNotificationsCountAsync() throws ApiError {
    return this.fetchUnreadNotificationsCountAsync(FetchUnreadNotificationsCountParameters.builder().build());
  }

  /**
   * Count unread notifications
   *
   * @param requestParameters {@link FetchUnreadNotificationsCountParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<CountResponse>}
   */
  public CompletableFuture<CountResponse> fetchUnreadNotificationsCountAsync(
    @NonNull FetchUnreadNotificationsCountParameters requestParameters
  ) throws ApiError {
    Request request = this.buildFetchUnreadNotificationsCountRequest(requestParameters);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<CountResponse>() {});
    });
  }

  private Request buildFetchUnreadNotificationsCountRequest(
    @NonNull FetchUnreadNotificationsCountParameters requestParameters
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "notifications/unread/count"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setOptionalQueryParameter("category", requestParameters.getCategory())
      .setOptionalQueryParameter("topic", requestParameters.getTopic())
      .build();
  }

  /**
   * Fetch a notification
   *
   * @param notificationId String
   * @return response of {@code Notification}
   */
  public Notification fetchNotification(@NonNull String notificationId) throws ApiError {
    Request request = this.buildFetchNotificationRequest(notificationId);
    Response response = this.execute(request);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Notification>() {});
  }

  /**
   * Fetch a notification
   *
   * @param notificationId String
   * @return response of {@code CompletableFuture<Notification>}
   */
  public CompletableFuture<Notification> fetchNotificationAsync(@NonNull String notificationId) throws ApiError {
    Request request = this.buildFetchNotificationRequest(notificationId);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Notification>() {});
    });
  }

  private Request buildFetchNotificationRequest(@NonNull String notificationId) {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "notifications/{notification_id}"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("notification_id", notificationId)
      .build();
  }

  /**
   * Archive a notification
   *
   * @param notificationId String
   * @return response of {@code void}
   */
  public void archiveNotification(@NonNull String notificationId) throws ApiError {
    Request request = this.buildArchiveNotificationRequest(notificationId);
    this.execute(request);
  }

  /**
   * Archive a notification
   *
   * @param notificationId String
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> archiveNotificationAsync(@NonNull String notificationId) throws ApiError {
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
   * Mark a notification read
   *
   * @param notificationId String
   * @return response of {@code void}
   */
  public void markNotificationRead(@NonNull String notificationId) throws ApiError {
    Request request = this.buildMarkNotificationReadRequest(notificationId);
    this.execute(request);
  }

  /**
   * Mark a notification read
   *
   * @param notificationId String
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> markNotificationReadAsync(@NonNull String notificationId) throws ApiError {
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
   * Unarchive a notification
   *
   * @param notificationId String
   * @return response of {@code void}
   */
  public void unarchiveNotification(@NonNull String notificationId) throws ApiError {
    Request request = this.buildUnarchiveNotificationRequest(notificationId);
    this.execute(request);
  }

  /**
   * Unarchive a notification
   *
   * @param notificationId String
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> unarchiveNotificationAsync(@NonNull String notificationId) throws ApiError {
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
   * Mark a notification unread
   *
   * @param notificationId String
   * @return response of {@code void}
   */
  public void markNotificationUnread(@NonNull String notificationId) throws ApiError {
    Request request = this.buildMarkNotificationUnreadRequest(notificationId);
    this.execute(request);
  }

  /**
   * Mark a notification unread
   *
   * @param notificationId String
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> markNotificationUnreadAsync(@NonNull String notificationId) throws ApiError {
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
