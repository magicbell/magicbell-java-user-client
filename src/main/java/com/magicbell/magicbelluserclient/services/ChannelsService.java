package com.magicbell.magicbelluserclient.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.exceptions.ApiError;
import com.magicbell.magicbelluserclient.http.Environment;
import com.magicbell.magicbelluserclient.http.HttpMethod;
import com.magicbell.magicbelluserclient.http.ModelConverter;
import com.magicbell.magicbelluserclient.http.util.RequestBuilder;
import com.magicbell.magicbelluserclient.models.ApnsToken;
import com.magicbell.magicbelluserclient.models.ApnsTokenCollection;
import com.magicbell.magicbelluserclient.models.ApnsTokenPayload;
import com.magicbell.magicbelluserclient.models.DiscardResult;
import com.magicbell.magicbelluserclient.models.ExpoToken;
import com.magicbell.magicbelluserclient.models.ExpoTokenCollection;
import com.magicbell.magicbelluserclient.models.ExpoTokenPayload;
import com.magicbell.magicbelluserclient.models.FcmToken;
import com.magicbell.magicbelluserclient.models.FcmTokenCollection;
import com.magicbell.magicbelluserclient.models.FcmTokenPayload;
import com.magicbell.magicbelluserclient.models.InboxToken;
import com.magicbell.magicbelluserclient.models.InboxTokenResponse;
import com.magicbell.magicbelluserclient.models.InboxTokenResponseCollection;
import com.magicbell.magicbelluserclient.models.ListApnsTokensParameters;
import com.magicbell.magicbelluserclient.models.ListExpoTokensParameters;
import com.magicbell.magicbelluserclient.models.ListFcmTokensParameters;
import com.magicbell.magicbelluserclient.models.ListInboxTokensParameters;
import com.magicbell.magicbelluserclient.models.ListMagicbellSlackbotTokensParameters;
import com.magicbell.magicbelluserclient.models.ListSlackTokensParameters;
import com.magicbell.magicbelluserclient.models.ListTeamsTokensParameters;
import com.magicbell.magicbelluserclient.models.ListWebPushTokensParameters;
import com.magicbell.magicbelluserclient.models.SlackToken;
import com.magicbell.magicbelluserclient.models.SlackTokenCollection;
import com.magicbell.magicbelluserclient.models.SlackTokenPayload;
import com.magicbell.magicbelluserclient.models.TeamsToken;
import com.magicbell.magicbelluserclient.models.TeamsTokenCollection;
import com.magicbell.magicbelluserclient.models.TeamsTokenPayload;
import com.magicbell.magicbelluserclient.models.UserPreferences;
import com.magicbell.magicbelluserclient.models.WebPushToken;
import com.magicbell.magicbelluserclient.models.WebPushTokenCollection;
import com.magicbell.magicbelluserclient.models.WebPushTokenPayload;
import com.magicbell.magicbelluserclient.validation.ViolationAggregator;
import com.magicbell.magicbelluserclient.validation.exceptions.ValidationException;
import com.magicbell.magicbelluserclient.validation.validators.modelValidators.ApnsTokenPayloadValidator;
import com.magicbell.magicbelluserclient.validation.validators.modelValidators.ExpoTokenPayloadValidator;
import com.magicbell.magicbelluserclient.validation.validators.modelValidators.FcmTokenPayloadValidator;
import com.magicbell.magicbelluserclient.validation.validators.modelValidators.InboxTokenValidator;
import com.magicbell.magicbelluserclient.validation.validators.modelValidators.SlackTokenPayloadValidator;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * ChannelsService Service
 */
public class ChannelsService extends BaseService {

  /**
   * Constructs a new instance of ChannelsService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public ChannelsService(@NonNull OkHttpClient httpClient, MagicbellUserClientConfig config) {
    super(httpClient, config);
  }

  /**
   * List all Inbox tokens
   *
   * @return response of {@code InboxTokenResponseCollection}
   */
  public InboxTokenResponseCollection listInboxTokens() throws ApiError {
    return this.listInboxTokens(ListInboxTokensParameters.builder().build());
  }

  /**
   * List all Inbox tokens
   *
   * @param requestParameters {@link ListInboxTokensParameters} Request Parameters Object
   * @return response of {@code InboxTokenResponseCollection}
   */
  public InboxTokenResponseCollection listInboxTokens(@NonNull ListInboxTokensParameters requestParameters)
    throws ApiError {
    Request request = this.buildListInboxTokensRequest(requestParameters);
    Response response = this.execute(request);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<InboxTokenResponseCollection>() {});
  }

  /**
   * List all Inbox tokens
   *
   * @return response of {@code CompletableFuture<InboxTokenResponseCollection>}
   */
  public CompletableFuture<InboxTokenResponseCollection> listInboxTokensAsync() throws ApiError {
    return this.listInboxTokensAsync(ListInboxTokensParameters.builder().build());
  }

  /**
   * List all Inbox tokens
   *
   * @param requestParameters {@link ListInboxTokensParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<InboxTokenResponseCollection>}
   */
  public CompletableFuture<InboxTokenResponseCollection> listInboxTokensAsync(
    @NonNull ListInboxTokensParameters requestParameters
  ) throws ApiError {
    Request request = this.buildListInboxTokensRequest(requestParameters);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<InboxTokenResponseCollection>() {});
    });
  }

  private Request buildListInboxTokensRequest(@NonNull ListInboxTokensParameters requestParameters) {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "channels/in_app/inbox/tokens"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setOptionalQueryParameter("limit", requestParameters.getLimit())
      .setOptionalQueryParameter("starting_after", requestParameters.getStartingAfter())
      .setOptionalQueryParameter("ending_before", requestParameters.getEndingBefore())
      .build();
  }

  /**
   * Save an Inbox token
   *
   * @return response of {@code InboxToken}
   */
  public InboxToken saveInboxToken() throws ApiError, ValidationException {
    return this.saveInboxToken(InboxToken.builder().build());
  }

  /**
   * Save an Inbox token
   *
   * @param inboxToken {@link InboxToken} Request Body
   * @return response of {@code InboxToken}
   */
  public InboxToken saveInboxToken(@NonNull InboxToken inboxToken) throws ApiError, ValidationException {
    Request request = this.buildSaveInboxTokenRequest(inboxToken);
    Response response = this.execute(request);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<InboxToken>() {});
  }

  /**
   * Save an Inbox token
   *
   * @return response of {@code CompletableFuture<InboxToken>}
   */
  public CompletableFuture<InboxToken> saveInboxTokenAsync() throws ApiError, ValidationException {
    return this.saveInboxTokenAsync(InboxToken.builder().build());
  }

  /**
   * Save an Inbox token
   *
   * @param inboxToken {@link InboxToken} Request Body
   * @return response of {@code CompletableFuture<InboxToken>}
   */
  public CompletableFuture<InboxToken> saveInboxTokenAsync(@NonNull InboxToken inboxToken)
    throws ApiError, ValidationException {
    Request request = this.buildSaveInboxTokenRequest(inboxToken);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<InboxToken>() {});
    });
  }

  private Request buildSaveInboxTokenRequest(@NonNull InboxToken inboxToken) throws ValidationException {
    new ViolationAggregator().add(new InboxTokenValidator("inboxToken").optional().validate(inboxToken)).validateAll();
    return new RequestBuilder(
      HttpMethod.PUT,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "channels/in_app/inbox/tokens"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setJsonContent(inboxToken)
      .build();
  }

  /**
   * Fetch an Inbox token
   *
   * @param tokenId String
   * @return response of {@code InboxTokenResponse}
   */
  public InboxTokenResponse fetchInboxToken(@NonNull String tokenId) throws ApiError {
    Request request = this.buildFetchInboxTokenRequest(tokenId);
    Response response = this.execute(request);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<InboxTokenResponse>() {});
  }

  /**
   * Fetch an Inbox token
   *
   * @param tokenId String
   * @return response of {@code CompletableFuture<InboxTokenResponse>}
   */
  public CompletableFuture<InboxTokenResponse> fetchInboxTokenAsync(@NonNull String tokenId) throws ApiError {
    Request request = this.buildFetchInboxTokenRequest(tokenId);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<InboxTokenResponse>() {});
    });
  }

  private Request buildFetchInboxTokenRequest(@NonNull String tokenId) {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "channels/in_app/inbox/tokens/{token_id}"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("token_id", tokenId)
      .build();
  }

  /**
   * Delete an Inbox token
   *
   * @param tokenId String
   * @return response of {@code DiscardResult}
   */
  public DiscardResult deleteInboxToken(@NonNull String tokenId) throws ApiError {
    Request request = this.buildDeleteInboxTokenRequest(tokenId);
    Response response = this.execute(request);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<DiscardResult>() {});
  }

  /**
   * Delete an Inbox token
   *
   * @param tokenId String
   * @return response of {@code CompletableFuture<DiscardResult>}
   */
  public CompletableFuture<DiscardResult> deleteInboxTokenAsync(@NonNull String tokenId) throws ApiError {
    Request request = this.buildDeleteInboxTokenRequest(tokenId);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<DiscardResult>() {});
    });
  }

  private Request buildDeleteInboxTokenRequest(@NonNull String tokenId) {
    return new RequestBuilder(
      HttpMethod.DELETE,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "channels/in_app/inbox/tokens/{token_id}"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("token_id", tokenId)
      .build();
  }

  /**
   * List all APNs tokens
   *
   * @return response of {@code ApnsTokenCollection}
   */
  public ApnsTokenCollection listApnsTokens() throws ApiError {
    return this.listApnsTokens(ListApnsTokensParameters.builder().build());
  }

  /**
   * List all APNs tokens
   *
   * @param requestParameters {@link ListApnsTokensParameters} Request Parameters Object
   * @return response of {@code ApnsTokenCollection}
   */
  public ApnsTokenCollection listApnsTokens(@NonNull ListApnsTokensParameters requestParameters) throws ApiError {
    Request request = this.buildListApnsTokensRequest(requestParameters);
    Response response = this.execute(request);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<ApnsTokenCollection>() {});
  }

  /**
   * List all APNs tokens
   *
   * @return response of {@code CompletableFuture<ApnsTokenCollection>}
   */
  public CompletableFuture<ApnsTokenCollection> listApnsTokensAsync() throws ApiError {
    return this.listApnsTokensAsync(ListApnsTokensParameters.builder().build());
  }

  /**
   * List all APNs tokens
   *
   * @param requestParameters {@link ListApnsTokensParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<ApnsTokenCollection>}
   */
  public CompletableFuture<ApnsTokenCollection> listApnsTokensAsync(
    @NonNull ListApnsTokensParameters requestParameters
  ) throws ApiError {
    Request request = this.buildListApnsTokensRequest(requestParameters);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<ApnsTokenCollection>() {});
    });
  }

  private Request buildListApnsTokensRequest(@NonNull ListApnsTokensParameters requestParameters) {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "channels/mobile_push/apns/tokens"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setOptionalQueryParameter("limit", requestParameters.getLimit())
      .setOptionalQueryParameter("starting_after", requestParameters.getStartingAfter())
      .setOptionalQueryParameter("ending_before", requestParameters.getEndingBefore())
      .build();
  }

  /**
   * Save an APNs token
   *
   * @return response of {@code ApnsTokenPayload}
   */
  public ApnsTokenPayload saveApnsToken() throws ApiError, ValidationException {
    return this.saveApnsToken(ApnsTokenPayload.builder().build());
  }

  /**
   * Save an APNs token
   *
   * @param apnsTokenPayload {@link ApnsTokenPayload} Request Body
   * @return response of {@code ApnsTokenPayload}
   */
  public ApnsTokenPayload saveApnsToken(@NonNull ApnsTokenPayload apnsTokenPayload)
    throws ApiError, ValidationException {
    Request request = this.buildSaveApnsTokenRequest(apnsTokenPayload);
    Response response = this.execute(request);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<ApnsTokenPayload>() {});
  }

  /**
   * Save an APNs token
   *
   * @return response of {@code CompletableFuture<ApnsTokenPayload>}
   */
  public CompletableFuture<ApnsTokenPayload> saveApnsTokenAsync() throws ApiError, ValidationException {
    return this.saveApnsTokenAsync(ApnsTokenPayload.builder().build());
  }

  /**
   * Save an APNs token
   *
   * @param apnsTokenPayload {@link ApnsTokenPayload} Request Body
   * @return response of {@code CompletableFuture<ApnsTokenPayload>}
   */
  public CompletableFuture<ApnsTokenPayload> saveApnsTokenAsync(@NonNull ApnsTokenPayload apnsTokenPayload)
    throws ApiError, ValidationException {
    Request request = this.buildSaveApnsTokenRequest(apnsTokenPayload);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<ApnsTokenPayload>() {});
    });
  }

  private Request buildSaveApnsTokenRequest(@NonNull ApnsTokenPayload apnsTokenPayload) throws ValidationException {
    new ViolationAggregator()
      .add(new ApnsTokenPayloadValidator("apnsTokenPayload").optional().validate(apnsTokenPayload))
      .validateAll();
    return new RequestBuilder(
      HttpMethod.PUT,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "channels/mobile_push/apns/tokens"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setJsonContent(apnsTokenPayload)
      .build();
  }

  /**
   * Fetch an APNs token
   *
   * @param tokenId String
   * @return response of {@code ApnsToken}
   */
  public ApnsToken fetchApnsToken(@NonNull String tokenId) throws ApiError {
    Request request = this.buildFetchApnsTokenRequest(tokenId);
    Response response = this.execute(request);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<ApnsToken>() {});
  }

  /**
   * Fetch an APNs token
   *
   * @param tokenId String
   * @return response of {@code CompletableFuture<ApnsToken>}
   */
  public CompletableFuture<ApnsToken> fetchApnsTokenAsync(@NonNull String tokenId) throws ApiError {
    Request request = this.buildFetchApnsTokenRequest(tokenId);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<ApnsToken>() {});
    });
  }

  private Request buildFetchApnsTokenRequest(@NonNull String tokenId) {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "channels/mobile_push/apns/tokens/{token_id}"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("token_id", tokenId)
      .build();
  }

  /**
   * Delete an APNs token
   *
   * @param tokenId String
   * @return response of {@code DiscardResult}
   */
  public DiscardResult deleteApnsToken(@NonNull String tokenId) throws ApiError {
    Request request = this.buildDeleteApnsTokenRequest(tokenId);
    Response response = this.execute(request);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<DiscardResult>() {});
  }

  /**
   * Delete an APNs token
   *
   * @param tokenId String
   * @return response of {@code CompletableFuture<DiscardResult>}
   */
  public CompletableFuture<DiscardResult> deleteApnsTokenAsync(@NonNull String tokenId) throws ApiError {
    Request request = this.buildDeleteApnsTokenRequest(tokenId);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<DiscardResult>() {});
    });
  }

  private Request buildDeleteApnsTokenRequest(@NonNull String tokenId) {
    return new RequestBuilder(
      HttpMethod.DELETE,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "channels/mobile_push/apns/tokens/{token_id}"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("token_id", tokenId)
      .build();
  }

  /**
   * List all Expo tokens
   *
   * @return response of {@code ExpoTokenCollection}
   */
  public ExpoTokenCollection listExpoTokens() throws ApiError {
    return this.listExpoTokens(ListExpoTokensParameters.builder().build());
  }

  /**
   * List all Expo tokens
   *
   * @param requestParameters {@link ListExpoTokensParameters} Request Parameters Object
   * @return response of {@code ExpoTokenCollection}
   */
  public ExpoTokenCollection listExpoTokens(@NonNull ListExpoTokensParameters requestParameters) throws ApiError {
    Request request = this.buildListExpoTokensRequest(requestParameters);
    Response response = this.execute(request);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<ExpoTokenCollection>() {});
  }

  /**
   * List all Expo tokens
   *
   * @return response of {@code CompletableFuture<ExpoTokenCollection>}
   */
  public CompletableFuture<ExpoTokenCollection> listExpoTokensAsync() throws ApiError {
    return this.listExpoTokensAsync(ListExpoTokensParameters.builder().build());
  }

  /**
   * List all Expo tokens
   *
   * @param requestParameters {@link ListExpoTokensParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<ExpoTokenCollection>}
   */
  public CompletableFuture<ExpoTokenCollection> listExpoTokensAsync(
    @NonNull ListExpoTokensParameters requestParameters
  ) throws ApiError {
    Request request = this.buildListExpoTokensRequest(requestParameters);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<ExpoTokenCollection>() {});
    });
  }

  private Request buildListExpoTokensRequest(@NonNull ListExpoTokensParameters requestParameters) {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "channels/mobile_push/expo/tokens"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setOptionalQueryParameter("limit", requestParameters.getLimit())
      .setOptionalQueryParameter("starting_after", requestParameters.getStartingAfter())
      .setOptionalQueryParameter("ending_before", requestParameters.getEndingBefore())
      .build();
  }

  /**
   * Save an Expo token
   *
   * @return response of {@code ExpoTokenPayload}
   */
  public ExpoTokenPayload saveExpoToken() throws ApiError, ValidationException {
    return this.saveExpoToken(ExpoTokenPayload.builder().build());
  }

  /**
   * Save an Expo token
   *
   * @param expoTokenPayload {@link ExpoTokenPayload} Request Body
   * @return response of {@code ExpoTokenPayload}
   */
  public ExpoTokenPayload saveExpoToken(@NonNull ExpoTokenPayload expoTokenPayload)
    throws ApiError, ValidationException {
    Request request = this.buildSaveExpoTokenRequest(expoTokenPayload);
    Response response = this.execute(request);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<ExpoTokenPayload>() {});
  }

  /**
   * Save an Expo token
   *
   * @return response of {@code CompletableFuture<ExpoTokenPayload>}
   */
  public CompletableFuture<ExpoTokenPayload> saveExpoTokenAsync() throws ApiError, ValidationException {
    return this.saveExpoTokenAsync(ExpoTokenPayload.builder().build());
  }

  /**
   * Save an Expo token
   *
   * @param expoTokenPayload {@link ExpoTokenPayload} Request Body
   * @return response of {@code CompletableFuture<ExpoTokenPayload>}
   */
  public CompletableFuture<ExpoTokenPayload> saveExpoTokenAsync(@NonNull ExpoTokenPayload expoTokenPayload)
    throws ApiError, ValidationException {
    Request request = this.buildSaveExpoTokenRequest(expoTokenPayload);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<ExpoTokenPayload>() {});
    });
  }

  private Request buildSaveExpoTokenRequest(@NonNull ExpoTokenPayload expoTokenPayload) throws ValidationException {
    new ViolationAggregator()
      .add(new ExpoTokenPayloadValidator("expoTokenPayload").optional().validate(expoTokenPayload))
      .validateAll();
    return new RequestBuilder(
      HttpMethod.PUT,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "channels/mobile_push/expo/tokens"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setJsonContent(expoTokenPayload)
      .build();
  }

  /**
   * Fetch an Expo token
   *
   * @param tokenId String
   * @return response of {@code ExpoToken}
   */
  public ExpoToken fetchExpoToken(@NonNull String tokenId) throws ApiError {
    Request request = this.buildFetchExpoTokenRequest(tokenId);
    Response response = this.execute(request);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<ExpoToken>() {});
  }

  /**
   * Fetch an Expo token
   *
   * @param tokenId String
   * @return response of {@code CompletableFuture<ExpoToken>}
   */
  public CompletableFuture<ExpoToken> fetchExpoTokenAsync(@NonNull String tokenId) throws ApiError {
    Request request = this.buildFetchExpoTokenRequest(tokenId);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<ExpoToken>() {});
    });
  }

  private Request buildFetchExpoTokenRequest(@NonNull String tokenId) {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "channels/mobile_push/expo/tokens/{token_id}"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("token_id", tokenId)
      .build();
  }

  /**
   * Delete an Expo token
   *
   * @param tokenId String
   * @return response of {@code DiscardResult}
   */
  public DiscardResult deleteExpoToken(@NonNull String tokenId) throws ApiError {
    Request request = this.buildDeleteExpoTokenRequest(tokenId);
    Response response = this.execute(request);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<DiscardResult>() {});
  }

  /**
   * Delete an Expo token
   *
   * @param tokenId String
   * @return response of {@code CompletableFuture<DiscardResult>}
   */
  public CompletableFuture<DiscardResult> deleteExpoTokenAsync(@NonNull String tokenId) throws ApiError {
    Request request = this.buildDeleteExpoTokenRequest(tokenId);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<DiscardResult>() {});
    });
  }

  private Request buildDeleteExpoTokenRequest(@NonNull String tokenId) {
    return new RequestBuilder(
      HttpMethod.DELETE,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "channels/mobile_push/expo/tokens/{token_id}"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("token_id", tokenId)
      .build();
  }

  /**
   * List all FCM tokens
   *
   * @return response of {@code FcmTokenCollection}
   */
  public FcmTokenCollection listFcmTokens() throws ApiError {
    return this.listFcmTokens(ListFcmTokensParameters.builder().build());
  }

  /**
   * List all FCM tokens
   *
   * @param requestParameters {@link ListFcmTokensParameters} Request Parameters Object
   * @return response of {@code FcmTokenCollection}
   */
  public FcmTokenCollection listFcmTokens(@NonNull ListFcmTokensParameters requestParameters) throws ApiError {
    Request request = this.buildListFcmTokensRequest(requestParameters);
    Response response = this.execute(request);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<FcmTokenCollection>() {});
  }

  /**
   * List all FCM tokens
   *
   * @return response of {@code CompletableFuture<FcmTokenCollection>}
   */
  public CompletableFuture<FcmTokenCollection> listFcmTokensAsync() throws ApiError {
    return this.listFcmTokensAsync(ListFcmTokensParameters.builder().build());
  }

  /**
   * List all FCM tokens
   *
   * @param requestParameters {@link ListFcmTokensParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<FcmTokenCollection>}
   */
  public CompletableFuture<FcmTokenCollection> listFcmTokensAsync(@NonNull ListFcmTokensParameters requestParameters)
    throws ApiError {
    Request request = this.buildListFcmTokensRequest(requestParameters);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<FcmTokenCollection>() {});
    });
  }

  private Request buildListFcmTokensRequest(@NonNull ListFcmTokensParameters requestParameters) {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "channels/mobile_push/fcm/tokens"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setOptionalQueryParameter("limit", requestParameters.getLimit())
      .setOptionalQueryParameter("starting_after", requestParameters.getStartingAfter())
      .setOptionalQueryParameter("ending_before", requestParameters.getEndingBefore())
      .build();
  }

  /**
   * Save a FCM token
   *
   * @return response of {@code FcmTokenPayload}
   */
  public FcmTokenPayload saveFcmToken() throws ApiError, ValidationException {
    return this.saveFcmToken(FcmTokenPayload.builder().build());
  }

  /**
   * Save a FCM token
   *
   * @param fcmTokenPayload {@link FcmTokenPayload} Request Body
   * @return response of {@code FcmTokenPayload}
   */
  public FcmTokenPayload saveFcmToken(@NonNull FcmTokenPayload fcmTokenPayload) throws ApiError, ValidationException {
    Request request = this.buildSaveFcmTokenRequest(fcmTokenPayload);
    Response response = this.execute(request);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<FcmTokenPayload>() {});
  }

  /**
   * Save a FCM token
   *
   * @return response of {@code CompletableFuture<FcmTokenPayload>}
   */
  public CompletableFuture<FcmTokenPayload> saveFcmTokenAsync() throws ApiError, ValidationException {
    return this.saveFcmTokenAsync(FcmTokenPayload.builder().build());
  }

  /**
   * Save a FCM token
   *
   * @param fcmTokenPayload {@link FcmTokenPayload} Request Body
   * @return response of {@code CompletableFuture<FcmTokenPayload>}
   */
  public CompletableFuture<FcmTokenPayload> saveFcmTokenAsync(@NonNull FcmTokenPayload fcmTokenPayload)
    throws ApiError, ValidationException {
    Request request = this.buildSaveFcmTokenRequest(fcmTokenPayload);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<FcmTokenPayload>() {});
    });
  }

  private Request buildSaveFcmTokenRequest(@NonNull FcmTokenPayload fcmTokenPayload) throws ValidationException {
    new ViolationAggregator()
      .add(new FcmTokenPayloadValidator("fcmTokenPayload").optional().validate(fcmTokenPayload))
      .validateAll();
    return new RequestBuilder(
      HttpMethod.PUT,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "channels/mobile_push/fcm/tokens"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setJsonContent(fcmTokenPayload)
      .build();
  }

  /**
   * Fetch a FCM token
   *
   * @param tokenId String
   * @return response of {@code FcmToken}
   */
  public FcmToken fetchFcmToken(@NonNull String tokenId) throws ApiError {
    Request request = this.buildFetchFcmTokenRequest(tokenId);
    Response response = this.execute(request);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<FcmToken>() {});
  }

  /**
   * Fetch a FCM token
   *
   * @param tokenId String
   * @return response of {@code CompletableFuture<FcmToken>}
   */
  public CompletableFuture<FcmToken> fetchFcmTokenAsync(@NonNull String tokenId) throws ApiError {
    Request request = this.buildFetchFcmTokenRequest(tokenId);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<FcmToken>() {});
    });
  }

  private Request buildFetchFcmTokenRequest(@NonNull String tokenId) {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "channels/mobile_push/fcm/tokens/{token_id}"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("token_id", tokenId)
      .build();
  }

  /**
   * Delete a FCM token
   *
   * @param tokenId String
   * @return response of {@code DiscardResult}
   */
  public DiscardResult deleteFcmToken(@NonNull String tokenId) throws ApiError {
    Request request = this.buildDeleteFcmTokenRequest(tokenId);
    Response response = this.execute(request);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<DiscardResult>() {});
  }

  /**
   * Delete a FCM token
   *
   * @param tokenId String
   * @return response of {@code CompletableFuture<DiscardResult>}
   */
  public CompletableFuture<DiscardResult> deleteFcmTokenAsync(@NonNull String tokenId) throws ApiError {
    Request request = this.buildDeleteFcmTokenRequest(tokenId);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<DiscardResult>() {});
    });
  }

  private Request buildDeleteFcmTokenRequest(@NonNull String tokenId) {
    return new RequestBuilder(
      HttpMethod.DELETE,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "channels/mobile_push/fcm/tokens/{token_id}"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("token_id", tokenId)
      .build();
  }

  /**
   * List all MagicBell SlackBot tokens
   *
   * @return response of {@code SlackTokenCollection}
   */
  public SlackTokenCollection listMagicbellSlackbotTokens() throws ApiError {
    return this.listMagicbellSlackbotTokens(ListMagicbellSlackbotTokensParameters.builder().build());
  }

  /**
   * List all MagicBell SlackBot tokens
   *
   * @param requestParameters {@link ListMagicbellSlackbotTokensParameters} Request Parameters Object
   * @return response of {@code SlackTokenCollection}
   */
  public SlackTokenCollection listMagicbellSlackbotTokens(
    @NonNull ListMagicbellSlackbotTokensParameters requestParameters
  ) throws ApiError {
    Request request = this.buildListMagicbellSlackbotTokensRequest(requestParameters);
    Response response = this.execute(request);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<SlackTokenCollection>() {});
  }

  /**
   * List all MagicBell SlackBot tokens
   *
   * @return response of {@code CompletableFuture<SlackTokenCollection>}
   */
  public CompletableFuture<SlackTokenCollection> listMagicbellSlackbotTokensAsync() throws ApiError {
    return this.listMagicbellSlackbotTokensAsync(ListMagicbellSlackbotTokensParameters.builder().build());
  }

  /**
   * List all MagicBell SlackBot tokens
   *
   * @param requestParameters {@link ListMagicbellSlackbotTokensParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<SlackTokenCollection>}
   */
  public CompletableFuture<SlackTokenCollection> listMagicbellSlackbotTokensAsync(
    @NonNull ListMagicbellSlackbotTokensParameters requestParameters
  ) throws ApiError {
    Request request = this.buildListMagicbellSlackbotTokensRequest(requestParameters);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<SlackTokenCollection>() {});
    });
  }

  private Request buildListMagicbellSlackbotTokensRequest(
    @NonNull ListMagicbellSlackbotTokensParameters requestParameters
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "channels/slack/magicbell_slackbot/tokens"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setOptionalQueryParameter("limit", requestParameters.getLimit())
      .setOptionalQueryParameter("starting_after", requestParameters.getStartingAfter())
      .setOptionalQueryParameter("ending_before", requestParameters.getEndingBefore())
      .build();
  }

  /**
   * Save a MagicBell SlackBot token
   *
   * @return response of {@code SlackTokenPayload}
   */
  public SlackTokenPayload saveMagicbellSlackbotToken() throws ApiError, ValidationException {
    return this.saveMagicbellSlackbotToken(SlackTokenPayload.builder().build());
  }

  /**
   * Save a MagicBell SlackBot token
   *
   * @param slackTokenPayload {@link SlackTokenPayload} Request Body
   * @return response of {@code SlackTokenPayload}
   */
  public SlackTokenPayload saveMagicbellSlackbotToken(@NonNull SlackTokenPayload slackTokenPayload)
    throws ApiError, ValidationException {
    Request request = this.buildSaveMagicbellSlackbotTokenRequest(slackTokenPayload);
    Response response = this.execute(request);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<SlackTokenPayload>() {});
  }

  /**
   * Save a MagicBell SlackBot token
   *
   * @return response of {@code CompletableFuture<SlackTokenPayload>}
   */
  public CompletableFuture<SlackTokenPayload> saveMagicbellSlackbotTokenAsync() throws ApiError, ValidationException {
    return this.saveMagicbellSlackbotTokenAsync(SlackTokenPayload.builder().build());
  }

  /**
   * Save a MagicBell SlackBot token
   *
   * @param slackTokenPayload {@link SlackTokenPayload} Request Body
   * @return response of {@code CompletableFuture<SlackTokenPayload>}
   */
  public CompletableFuture<SlackTokenPayload> saveMagicbellSlackbotTokenAsync(
    @NonNull SlackTokenPayload slackTokenPayload
  ) throws ApiError, ValidationException {
    Request request = this.buildSaveMagicbellSlackbotTokenRequest(slackTokenPayload);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<SlackTokenPayload>() {});
    });
  }

  private Request buildSaveMagicbellSlackbotTokenRequest(@NonNull SlackTokenPayload slackTokenPayload)
    throws ValidationException {
    new ViolationAggregator()
      .add(new SlackTokenPayloadValidator("slackTokenPayload").optional().validate(slackTokenPayload))
      .validateAll();
    return new RequestBuilder(
      HttpMethod.PUT,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "channels/slack/magicbell_slackbot/tokens"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setJsonContent(slackTokenPayload)
      .build();
  }

  /**
   * Fetch a MagicBell SlackBot token
   *
   * @param tokenId String
   * @return response of {@code SlackToken}
   */
  public SlackToken fetchMagicbellSlackbotToken(@NonNull String tokenId) throws ApiError {
    Request request = this.buildFetchMagicbellSlackbotTokenRequest(tokenId);
    Response response = this.execute(request);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<SlackToken>() {});
  }

  /**
   * Fetch a MagicBell SlackBot token
   *
   * @param tokenId String
   * @return response of {@code CompletableFuture<SlackToken>}
   */
  public CompletableFuture<SlackToken> fetchMagicbellSlackbotTokenAsync(@NonNull String tokenId) throws ApiError {
    Request request = this.buildFetchMagicbellSlackbotTokenRequest(tokenId);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<SlackToken>() {});
    });
  }

  private Request buildFetchMagicbellSlackbotTokenRequest(@NonNull String tokenId) {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "channels/slack/magicbell_slackbot/tokens/{token_id}"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("token_id", tokenId)
      .build();
  }

  /**
   * Delete a MagicBell SlackBot token
   *
   * @param tokenId String
   * @return response of {@code DiscardResult}
   */
  public DiscardResult deleteMagicbellSlackbotToken(@NonNull String tokenId) throws ApiError {
    Request request = this.buildDeleteMagicbellSlackbotTokenRequest(tokenId);
    Response response = this.execute(request);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<DiscardResult>() {});
  }

  /**
   * Delete a MagicBell SlackBot token
   *
   * @param tokenId String
   * @return response of {@code CompletableFuture<DiscardResult>}
   */
  public CompletableFuture<DiscardResult> deleteMagicbellSlackbotTokenAsync(@NonNull String tokenId) throws ApiError {
    Request request = this.buildDeleteMagicbellSlackbotTokenRequest(tokenId);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<DiscardResult>() {});
    });
  }

  private Request buildDeleteMagicbellSlackbotTokenRequest(@NonNull String tokenId) {
    return new RequestBuilder(
      HttpMethod.DELETE,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "channels/slack/magicbell_slackbot/tokens/{token_id}"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("token_id", tokenId)
      .build();
  }

  /**
   * List all Slack tokens
   *
   * @return response of {@code SlackTokenCollection}
   */
  public SlackTokenCollection listSlackTokens() throws ApiError {
    return this.listSlackTokens(ListSlackTokensParameters.builder().build());
  }

  /**
   * List all Slack tokens
   *
   * @param requestParameters {@link ListSlackTokensParameters} Request Parameters Object
   * @return response of {@code SlackTokenCollection}
   */
  public SlackTokenCollection listSlackTokens(@NonNull ListSlackTokensParameters requestParameters) throws ApiError {
    Request request = this.buildListSlackTokensRequest(requestParameters);
    Response response = this.execute(request);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<SlackTokenCollection>() {});
  }

  /**
   * List all Slack tokens
   *
   * @return response of {@code CompletableFuture<SlackTokenCollection>}
   */
  public CompletableFuture<SlackTokenCollection> listSlackTokensAsync() throws ApiError {
    return this.listSlackTokensAsync(ListSlackTokensParameters.builder().build());
  }

  /**
   * List all Slack tokens
   *
   * @param requestParameters {@link ListSlackTokensParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<SlackTokenCollection>}
   */
  public CompletableFuture<SlackTokenCollection> listSlackTokensAsync(
    @NonNull ListSlackTokensParameters requestParameters
  ) throws ApiError {
    Request request = this.buildListSlackTokensRequest(requestParameters);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<SlackTokenCollection>() {});
    });
  }

  private Request buildListSlackTokensRequest(@NonNull ListSlackTokensParameters requestParameters) {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "channels/slack/tokens"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setOptionalQueryParameter("limit", requestParameters.getLimit())
      .setOptionalQueryParameter("starting_after", requestParameters.getStartingAfter())
      .setOptionalQueryParameter("ending_before", requestParameters.getEndingBefore())
      .build();
  }

  /**
   * Save a Slack token
   *
   * @return response of {@code SlackTokenPayload}
   */
  public SlackTokenPayload saveSlackToken() throws ApiError, ValidationException {
    return this.saveSlackToken(SlackTokenPayload.builder().build());
  }

  /**
   * Save a Slack token
   *
   * @param slackTokenPayload {@link SlackTokenPayload} Request Body
   * @return response of {@code SlackTokenPayload}
   */
  public SlackTokenPayload saveSlackToken(@NonNull SlackTokenPayload slackTokenPayload)
    throws ApiError, ValidationException {
    Request request = this.buildSaveSlackTokenRequest(slackTokenPayload);
    Response response = this.execute(request);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<SlackTokenPayload>() {});
  }

  /**
   * Save a Slack token
   *
   * @return response of {@code CompletableFuture<SlackTokenPayload>}
   */
  public CompletableFuture<SlackTokenPayload> saveSlackTokenAsync() throws ApiError, ValidationException {
    return this.saveSlackTokenAsync(SlackTokenPayload.builder().build());
  }

  /**
   * Save a Slack token
   *
   * @param slackTokenPayload {@link SlackTokenPayload} Request Body
   * @return response of {@code CompletableFuture<SlackTokenPayload>}
   */
  public CompletableFuture<SlackTokenPayload> saveSlackTokenAsync(@NonNull SlackTokenPayload slackTokenPayload)
    throws ApiError, ValidationException {
    Request request = this.buildSaveSlackTokenRequest(slackTokenPayload);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<SlackTokenPayload>() {});
    });
  }

  private Request buildSaveSlackTokenRequest(@NonNull SlackTokenPayload slackTokenPayload) throws ValidationException {
    new ViolationAggregator()
      .add(new SlackTokenPayloadValidator("slackTokenPayload").optional().validate(slackTokenPayload))
      .validateAll();
    return new RequestBuilder(
      HttpMethod.PUT,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "channels/slack/tokens"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setJsonContent(slackTokenPayload)
      .build();
  }

  /**
   * Fetch a Slack token
   *
   * @param tokenId String
   * @return response of {@code SlackToken}
   */
  public SlackToken fetchSlackToken(@NonNull String tokenId) throws ApiError {
    Request request = this.buildFetchSlackTokenRequest(tokenId);
    Response response = this.execute(request);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<SlackToken>() {});
  }

  /**
   * Fetch a Slack token
   *
   * @param tokenId String
   * @return response of {@code CompletableFuture<SlackToken>}
   */
  public CompletableFuture<SlackToken> fetchSlackTokenAsync(@NonNull String tokenId) throws ApiError {
    Request request = this.buildFetchSlackTokenRequest(tokenId);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<SlackToken>() {});
    });
  }

  private Request buildFetchSlackTokenRequest(@NonNull String tokenId) {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "channels/slack/tokens/{token_id}"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("token_id", tokenId)
      .build();
  }

  /**
   * Delete a Slack token
   *
   * @param tokenId String
   * @return response of {@code DiscardResult}
   */
  public DiscardResult deleteSlackToken(@NonNull String tokenId) throws ApiError {
    Request request = this.buildDeleteSlackTokenRequest(tokenId);
    Response response = this.execute(request);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<DiscardResult>() {});
  }

  /**
   * Delete a Slack token
   *
   * @param tokenId String
   * @return response of {@code CompletableFuture<DiscardResult>}
   */
  public CompletableFuture<DiscardResult> deleteSlackTokenAsync(@NonNull String tokenId) throws ApiError {
    Request request = this.buildDeleteSlackTokenRequest(tokenId);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<DiscardResult>() {});
    });
  }

  private Request buildDeleteSlackTokenRequest(@NonNull String tokenId) {
    return new RequestBuilder(
      HttpMethod.DELETE,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "channels/slack/tokens/{token_id}"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("token_id", tokenId)
      .build();
  }

  /**
   * List all Teams tokens
   *
   * @return response of {@code TeamsTokenCollection}
   */
  public TeamsTokenCollection listTeamsTokens() throws ApiError {
    return this.listTeamsTokens(ListTeamsTokensParameters.builder().build());
  }

  /**
   * List all Teams tokens
   *
   * @param requestParameters {@link ListTeamsTokensParameters} Request Parameters Object
   * @return response of {@code TeamsTokenCollection}
   */
  public TeamsTokenCollection listTeamsTokens(@NonNull ListTeamsTokensParameters requestParameters) throws ApiError {
    Request request = this.buildListTeamsTokensRequest(requestParameters);
    Response response = this.execute(request);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<TeamsTokenCollection>() {});
  }

  /**
   * List all Teams tokens
   *
   * @return response of {@code CompletableFuture<TeamsTokenCollection>}
   */
  public CompletableFuture<TeamsTokenCollection> listTeamsTokensAsync() throws ApiError {
    return this.listTeamsTokensAsync(ListTeamsTokensParameters.builder().build());
  }

  /**
   * List all Teams tokens
   *
   * @param requestParameters {@link ListTeamsTokensParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<TeamsTokenCollection>}
   */
  public CompletableFuture<TeamsTokenCollection> listTeamsTokensAsync(
    @NonNull ListTeamsTokensParameters requestParameters
  ) throws ApiError {
    Request request = this.buildListTeamsTokensRequest(requestParameters);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<TeamsTokenCollection>() {});
    });
  }

  private Request buildListTeamsTokensRequest(@NonNull ListTeamsTokensParameters requestParameters) {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "channels/teams/tokens"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setOptionalQueryParameter("limit", requestParameters.getLimit())
      .setOptionalQueryParameter("starting_after", requestParameters.getStartingAfter())
      .setOptionalQueryParameter("ending_before", requestParameters.getEndingBefore())
      .build();
  }

  /**
   * Save a Teams token
   *
   * @return response of {@code TeamsTokenPayload}
   */
  public TeamsTokenPayload saveTeamsToken() throws ApiError {
    return this.saveTeamsToken(TeamsTokenPayload.builder().build());
  }

  /**
   * Save a Teams token
   *
   * @param teamsTokenPayload {@link TeamsTokenPayload} Request Body
   * @return response of {@code TeamsTokenPayload}
   */
  public TeamsTokenPayload saveTeamsToken(@NonNull TeamsTokenPayload teamsTokenPayload) throws ApiError {
    Request request = this.buildSaveTeamsTokenRequest(teamsTokenPayload);
    Response response = this.execute(request);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<TeamsTokenPayload>() {});
  }

  /**
   * Save a Teams token
   *
   * @return response of {@code CompletableFuture<TeamsTokenPayload>}
   */
  public CompletableFuture<TeamsTokenPayload> saveTeamsTokenAsync() throws ApiError {
    return this.saveTeamsTokenAsync(TeamsTokenPayload.builder().build());
  }

  /**
   * Save a Teams token
   *
   * @param teamsTokenPayload {@link TeamsTokenPayload} Request Body
   * @return response of {@code CompletableFuture<TeamsTokenPayload>}
   */
  public CompletableFuture<TeamsTokenPayload> saveTeamsTokenAsync(@NonNull TeamsTokenPayload teamsTokenPayload)
    throws ApiError {
    Request request = this.buildSaveTeamsTokenRequest(teamsTokenPayload);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<TeamsTokenPayload>() {});
    });
  }

  private Request buildSaveTeamsTokenRequest(@NonNull TeamsTokenPayload teamsTokenPayload) {
    return new RequestBuilder(
      HttpMethod.PUT,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "channels/teams/tokens"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setJsonContent(teamsTokenPayload)
      .build();
  }

  /**
   * Fetch a Teams token
   *
   * @param tokenId String
   * @return response of {@code TeamsToken}
   */
  public TeamsToken fetchTeamsToken(@NonNull String tokenId) throws ApiError {
    Request request = this.buildFetchTeamsTokenRequest(tokenId);
    Response response = this.execute(request);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<TeamsToken>() {});
  }

  /**
   * Fetch a Teams token
   *
   * @param tokenId String
   * @return response of {@code CompletableFuture<TeamsToken>}
   */
  public CompletableFuture<TeamsToken> fetchTeamsTokenAsync(@NonNull String tokenId) throws ApiError {
    Request request = this.buildFetchTeamsTokenRequest(tokenId);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<TeamsToken>() {});
    });
  }

  private Request buildFetchTeamsTokenRequest(@NonNull String tokenId) {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "channels/teams/tokens/{token_id}"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("token_id", tokenId)
      .build();
  }

  /**
   * Delete a Teams token
   *
   * @param tokenId String
   * @return response of {@code DiscardResult}
   */
  public DiscardResult deleteTeamsToken(@NonNull String tokenId) throws ApiError {
    Request request = this.buildDeleteTeamsTokenRequest(tokenId);
    Response response = this.execute(request);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<DiscardResult>() {});
  }

  /**
   * Delete a Teams token
   *
   * @param tokenId String
   * @return response of {@code CompletableFuture<DiscardResult>}
   */
  public CompletableFuture<DiscardResult> deleteTeamsTokenAsync(@NonNull String tokenId) throws ApiError {
    Request request = this.buildDeleteTeamsTokenRequest(tokenId);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<DiscardResult>() {});
    });
  }

  private Request buildDeleteTeamsTokenRequest(@NonNull String tokenId) {
    return new RequestBuilder(
      HttpMethod.DELETE,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "channels/teams/tokens/{token_id}"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("token_id", tokenId)
      .build();
  }

  /**
   * Fetch channel preferences
   *
   * @return response of {@code UserPreferences}
   */
  public UserPreferences fetchUserPreferences() throws ApiError {
    Request request = this.buildFetchUserPreferencesRequest();
    Response response = this.execute(request);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<UserPreferences>() {});
  }

  /**
   * Fetch channel preferences
   *
   * @return response of {@code CompletableFuture<UserPreferences>}
   */
  public CompletableFuture<UserPreferences> fetchUserPreferencesAsync() throws ApiError {
    Request request = this.buildFetchUserPreferencesRequest();
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<UserPreferences>() {});
    });
  }

  private Request buildFetchUserPreferencesRequest() {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "channels/user_preferences"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .build();
  }

  /**
   * Save channel preferences
   *
   * @return response of {@code void}
   */
  public void saveUserPreferences() throws ApiError {
    this.saveUserPreferences(UserPreferences.builder().build());
  }

  /**
   * Save channel preferences
   *
   * @param userPreferences {@link UserPreferences} Request Body
   * @return response of {@code void}
   */
  public void saveUserPreferences(@NonNull UserPreferences userPreferences) throws ApiError {
    Request request = this.buildSaveUserPreferencesRequest(userPreferences);
    this.execute(request);
  }

  /**
   * Save channel preferences
   *
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> saveUserPreferencesAsync() throws ApiError {
    return this.saveUserPreferencesAsync(UserPreferences.builder().build());
  }

  /**
   * Save channel preferences
   *
   * @param userPreferences {@link UserPreferences} Request Body
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> saveUserPreferencesAsync(@NonNull UserPreferences userPreferences) throws ApiError {
    Request request = this.buildSaveUserPreferencesRequest(userPreferences);
    return this.executeAsync(request).thenApplyAsync(response -> null);
  }

  private Request buildSaveUserPreferencesRequest(@NonNull UserPreferences userPreferences) {
    return new RequestBuilder(
      HttpMethod.PUT,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "channels/user_preferences"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setJsonContent(userPreferences)
      .build();
  }

  /**
   * List all Web Push tokens
   *
   * @return response of {@code WebPushTokenCollection}
   */
  public WebPushTokenCollection listWebPushTokens() throws ApiError {
    return this.listWebPushTokens(ListWebPushTokensParameters.builder().build());
  }

  /**
   * List all Web Push tokens
   *
   * @param requestParameters {@link ListWebPushTokensParameters} Request Parameters Object
   * @return response of {@code WebPushTokenCollection}
   */
  public WebPushTokenCollection listWebPushTokens(@NonNull ListWebPushTokensParameters requestParameters)
    throws ApiError {
    Request request = this.buildListWebPushTokensRequest(requestParameters);
    Response response = this.execute(request);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<WebPushTokenCollection>() {});
  }

  /**
   * List all Web Push tokens
   *
   * @return response of {@code CompletableFuture<WebPushTokenCollection>}
   */
  public CompletableFuture<WebPushTokenCollection> listWebPushTokensAsync() throws ApiError {
    return this.listWebPushTokensAsync(ListWebPushTokensParameters.builder().build());
  }

  /**
   * List all Web Push tokens
   *
   * @param requestParameters {@link ListWebPushTokensParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<WebPushTokenCollection>}
   */
  public CompletableFuture<WebPushTokenCollection> listWebPushTokensAsync(
    @NonNull ListWebPushTokensParameters requestParameters
  ) throws ApiError {
    Request request = this.buildListWebPushTokensRequest(requestParameters);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<WebPushTokenCollection>() {});
    });
  }

  private Request buildListWebPushTokensRequest(@NonNull ListWebPushTokensParameters requestParameters) {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "channels/web_push/tokens"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setOptionalQueryParameter("limit", requestParameters.getLimit())
      .setOptionalQueryParameter("starting_after", requestParameters.getStartingAfter())
      .setOptionalQueryParameter("ending_before", requestParameters.getEndingBefore())
      .build();
  }

  /**
   * Save a Web Push token
   *
   * @return response of {@code WebPushTokenPayload}
   */
  public WebPushTokenPayload saveWebPushToken() throws ApiError {
    return this.saveWebPushToken(WebPushTokenPayload.builder().build());
  }

  /**
   * Save a Web Push token
   *
   * @param webPushTokenPayload {@link WebPushTokenPayload} Request Body
   * @return response of {@code WebPushTokenPayload}
   */
  public WebPushTokenPayload saveWebPushToken(@NonNull WebPushTokenPayload webPushTokenPayload) throws ApiError {
    Request request = this.buildSaveWebPushTokenRequest(webPushTokenPayload);
    Response response = this.execute(request);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<WebPushTokenPayload>() {});
  }

  /**
   * Save a Web Push token
   *
   * @return response of {@code CompletableFuture<WebPushTokenPayload>}
   */
  public CompletableFuture<WebPushTokenPayload> saveWebPushTokenAsync() throws ApiError {
    return this.saveWebPushTokenAsync(WebPushTokenPayload.builder().build());
  }

  /**
   * Save a Web Push token
   *
   * @param webPushTokenPayload {@link WebPushTokenPayload} Request Body
   * @return response of {@code CompletableFuture<WebPushTokenPayload>}
   */
  public CompletableFuture<WebPushTokenPayload> saveWebPushTokenAsync(@NonNull WebPushTokenPayload webPushTokenPayload)
    throws ApiError {
    Request request = this.buildSaveWebPushTokenRequest(webPushTokenPayload);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<WebPushTokenPayload>() {});
    });
  }

  private Request buildSaveWebPushTokenRequest(@NonNull WebPushTokenPayload webPushTokenPayload) {
    return new RequestBuilder(
      HttpMethod.PUT,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "channels/web_push/tokens"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setJsonContent(webPushTokenPayload)
      .build();
  }

  /**
   * Fetch a Web Push token
   *
   * @param tokenId String
   * @return response of {@code WebPushToken}
   */
  public WebPushToken fetchWebPushToken(@NonNull String tokenId) throws ApiError {
    Request request = this.buildFetchWebPushTokenRequest(tokenId);
    Response response = this.execute(request);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<WebPushToken>() {});
  }

  /**
   * Fetch a Web Push token
   *
   * @param tokenId String
   * @return response of {@code CompletableFuture<WebPushToken>}
   */
  public CompletableFuture<WebPushToken> fetchWebPushTokenAsync(@NonNull String tokenId) throws ApiError {
    Request request = this.buildFetchWebPushTokenRequest(tokenId);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<WebPushToken>() {});
    });
  }

  private Request buildFetchWebPushTokenRequest(@NonNull String tokenId) {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "channels/web_push/tokens/{token_id}"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("token_id", tokenId)
      .build();
  }

  /**
   * Delete a Web Push token
   *
   * @param tokenId String
   * @return response of {@code DiscardResult}
   */
  public DiscardResult deleteWebPushToken(@NonNull String tokenId) throws ApiError {
    Request request = this.buildDeleteWebPushTokenRequest(tokenId);
    Response response = this.execute(request);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<DiscardResult>() {});
  }

  /**
   * Delete a Web Push token
   *
   * @param tokenId String
   * @return response of {@code CompletableFuture<DiscardResult>}
   */
  public CompletableFuture<DiscardResult> deleteWebPushTokenAsync(@NonNull String tokenId) throws ApiError {
    Request request = this.buildDeleteWebPushTokenRequest(tokenId);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<DiscardResult>() {});
    });
  }

  private Request buildDeleteWebPushTokenRequest(@NonNull String tokenId) {
    return new RequestBuilder(
      HttpMethod.DELETE,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "channels/web_push/tokens/{token_id}"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("token_id", tokenId)
      .build();
  }
}
