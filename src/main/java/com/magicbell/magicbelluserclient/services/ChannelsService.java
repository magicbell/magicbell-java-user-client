package com.magicbell.magicbelluserclient.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.magicbell.magicbelluserclient.exceptions.ApiException;
import com.magicbell.magicbelluserclient.http.HttpMethod;
import com.magicbell.magicbelluserclient.http.ModelConverter;
import com.magicbell.magicbelluserclient.http.util.RequestBuilder;
import com.magicbell.magicbelluserclient.models.ApnsToken;
import com.magicbell.magicbelluserclient.models.ApnsTokenResponse;
import com.magicbell.magicbelluserclient.models.ArrayOfApnsTokenResponses;
import com.magicbell.magicbelluserclient.models.ArrayOfExpoTokenResponses;
import com.magicbell.magicbelluserclient.models.ArrayOfFcmTokenResponses;
import com.magicbell.magicbelluserclient.models.ArrayOfSlackTokenResponses;
import com.magicbell.magicbelluserclient.models.ArrayOfTeamsTokenResponses;
import com.magicbell.magicbelluserclient.models.ArrayOfWebPushTokenResponses;
import com.magicbell.magicbelluserclient.models.DiscardResult;
import com.magicbell.magicbelluserclient.models.ExpoToken;
import com.magicbell.magicbelluserclient.models.ExpoTokenResponse;
import com.magicbell.magicbelluserclient.models.FcmToken;
import com.magicbell.magicbelluserclient.models.FcmTokenResponse;
import com.magicbell.magicbelluserclient.models.GetMobilePushApnsTokensParameters;
import com.magicbell.magicbelluserclient.models.GetMobilePushExpoTokensParameters;
import com.magicbell.magicbelluserclient.models.GetMobilePushFcmTokensParameters;
import com.magicbell.magicbelluserclient.models.GetSlackTokensParameters;
import com.magicbell.magicbelluserclient.models.GetTeamsTokensParameters;
import com.magicbell.magicbelluserclient.models.GetWebPushTokensParameters;
import com.magicbell.magicbelluserclient.models.SlackToken;
import com.magicbell.magicbelluserclient.models.SlackTokenResponse;
import com.magicbell.magicbelluserclient.models.TeamsToken;
import com.magicbell.magicbelluserclient.models.TeamsTokenResponse;
import com.magicbell.magicbelluserclient.models.WebPushToken;
import com.magicbell.magicbelluserclient.models.WebPushTokenResponse;
import com.magicbell.magicbelluserclient.validation.ViolationAggregator;
import com.magicbell.magicbelluserclient.validation.exceptions.ValidationException;
import com.magicbell.magicbelluserclient.validation.validators.modelValidators.ApnsTokenValidator;
import com.magicbell.magicbelluserclient.validation.validators.modelValidators.ExpoTokenValidator;
import com.magicbell.magicbelluserclient.validation.validators.modelValidators.FcmTokenValidator;
import com.magicbell.magicbelluserclient.validation.validators.modelValidators.SlackTokenValidator;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * ChannelsService Service
 */
public class ChannelsService extends BaseService {

  public ChannelsService(@NonNull OkHttpClient httpClient, String serverUrl) {
    super(httpClient, serverUrl);
  }

  /**
   * Lists all mobile_push tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.
   *
   * @return response of {@code ArrayOfApnsTokenResponses}
   */
  public ArrayOfApnsTokenResponses getMobilePushApnsTokens() throws ApiException {
    return this.getMobilePushApnsTokens(GetMobilePushApnsTokensParameters.builder().build());
  }

  /**
   * Lists all mobile_push tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.
   *
   * @param requestParameters {@link GetMobilePushApnsTokensParameters} Request Parameters Object
   * @return response of {@code ArrayOfApnsTokenResponses}
   */
  public ArrayOfApnsTokenResponses getMobilePushApnsTokens(
    @NonNull GetMobilePushApnsTokensParameters requestParameters
  ) throws ApiException {
    Request request = this.buildGetMobilePushApnsTokensRequest(requestParameters);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<ArrayOfApnsTokenResponses>() {});
  }

  /**
   * Lists all mobile_push tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.
   *
   * @return response of {@code CompletableFuture<ArrayOfApnsTokenResponses>}
   */
  public CompletableFuture<ArrayOfApnsTokenResponses> getMobilePushApnsTokensAsync() throws ApiException {
    return this.getMobilePushApnsTokensAsync(GetMobilePushApnsTokensParameters.builder().build());
  }

  /**
   * Lists all mobile_push tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.
   *
   * @param requestParameters {@link GetMobilePushApnsTokensParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<ArrayOfApnsTokenResponses>}
   */
  public CompletableFuture<ArrayOfApnsTokenResponses> getMobilePushApnsTokensAsync(
    @NonNull GetMobilePushApnsTokensParameters requestParameters
  ) throws ApiException {
    Request request = this.buildGetMobilePushApnsTokensRequest(requestParameters);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<ArrayOfApnsTokenResponses>() {})
    );
  }

  private Request buildGetMobilePushApnsTokensRequest(@NonNull GetMobilePushApnsTokensParameters requestParameters) {
    return new RequestBuilder(HttpMethod.GET, this.serverUrl, "channels/mobile_push/apns/tokens")
      .setOptionalQueryParameter("page[size]", requestParameters.getPageSize())
      .setOptionalQueryParameter("page[after]", requestParameters.getPageAfter())
      .setOptionalQueryParameter("page[before]", requestParameters.getPageBefore())
      .build();
  }

  /**
   * Saves a mobile_push token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.
   *
   * @return response of {@code ApnsToken}
   */
  public ApnsToken saveMobilePushApnsToken() throws ApiException, ValidationException {
    return this.saveMobilePushApnsToken(ApnsToken.builder().build());
  }

  /**
   * Saves a mobile_push token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.
   *
   * @param apnsToken {@link ApnsToken} Request Body
   * @return response of {@code ApnsToken}
   */
  public ApnsToken saveMobilePushApnsToken(@NonNull ApnsToken apnsToken) throws ApiException, ValidationException {
    Request request = this.buildSaveMobilePushApnsTokenRequest(apnsToken);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<ApnsToken>() {});
  }

  /**
   * Saves a mobile_push token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.
   *
   * @return response of {@code CompletableFuture<ApnsToken>}
   */
  public CompletableFuture<ApnsToken> saveMobilePushApnsTokenAsync() throws ApiException, ValidationException {
    return this.saveMobilePushApnsTokenAsync(ApnsToken.builder().build());
  }

  /**
   * Saves a mobile_push token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.
   *
   * @param apnsToken {@link ApnsToken} Request Body
   * @return response of {@code CompletableFuture<ApnsToken>}
   */
  public CompletableFuture<ApnsToken> saveMobilePushApnsTokenAsync(@NonNull ApnsToken apnsToken)
    throws ApiException, ValidationException {
    Request request = this.buildSaveMobilePushApnsTokenRequest(apnsToken);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> ModelConverter.convert(response, new TypeReference<ApnsToken>() {})
    );
  }

  private Request buildSaveMobilePushApnsTokenRequest(@NonNull ApnsToken apnsToken) throws ValidationException {
    new ViolationAggregator().add(new ApnsTokenValidator("apnsToken").optional().validate(apnsToken)).validateAll();
    return new RequestBuilder(HttpMethod.POST, this.serverUrl, "channels/mobile_push/apns/tokens")
      .setJsonContent(apnsToken)
      .build();
  }

  /**
   * Retrieves details of a specific mobile_push token belonging to the authenticated user. Returns information about the token's status, creation date, and any associated metadata. Users can only access their own tokens.
   *
   * @param tokenId String
   * @return response of {@code ApnsTokenResponse}
   */
  public ApnsTokenResponse getMobilePushApnsToken(@NonNull String tokenId) throws ApiException {
    Request request = this.buildGetMobilePushApnsTokenRequest(tokenId);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<ApnsTokenResponse>() {});
  }

  /**
   * Retrieves details of a specific mobile_push token belonging to the authenticated user. Returns information about the token's status, creation date, and any associated metadata. Users can only access their own tokens.
   *
   * @param tokenId String
   * @return response of {@code CompletableFuture<ApnsTokenResponse>}
   */
  public CompletableFuture<ApnsTokenResponse> getMobilePushApnsTokenAsync(@NonNull String tokenId) throws ApiException {
    Request request = this.buildGetMobilePushApnsTokenRequest(tokenId);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<ApnsTokenResponse>() {})
    );
  }

  private Request buildGetMobilePushApnsTokenRequest(@NonNull String tokenId) {
    return new RequestBuilder(HttpMethod.GET, this.serverUrl, "channels/mobile_push/apns/tokens/{token_id}")
      .setPathParameter("token_id", tokenId)
      .build();
  }

  /**
   * Revokes one of the authenticated user's mobile_push tokens. This permanently invalidates the specified token, preventing it from being used for future channel access. This action cannot be undone. Users can only revoke their own tokens.
   *
   * @param tokenId String
   * @return response of {@code DiscardResult}
   */
  public DiscardResult discardMobilePushApnsToken(@NonNull String tokenId) throws ApiException {
    Request request = this.buildDiscardMobilePushApnsTokenRequest(tokenId);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<DiscardResult>() {});
  }

  /**
   * Revokes one of the authenticated user's mobile_push tokens. This permanently invalidates the specified token, preventing it from being used for future channel access. This action cannot be undone. Users can only revoke their own tokens.
   *
   * @param tokenId String
   * @return response of {@code CompletableFuture<DiscardResult>}
   */
  public CompletableFuture<DiscardResult> discardMobilePushApnsTokenAsync(@NonNull String tokenId) throws ApiException {
    Request request = this.buildDiscardMobilePushApnsTokenRequest(tokenId);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<DiscardResult>() {})
    );
  }

  private Request buildDiscardMobilePushApnsTokenRequest(@NonNull String tokenId) {
    return new RequestBuilder(HttpMethod.DELETE, this.serverUrl, "channels/mobile_push/apns/tokens/{token_id}")
      .setPathParameter("token_id", tokenId)
      .build();
  }

  /**
   * Lists all mobile_push tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.
   *
   * @return response of {@code ArrayOfExpoTokenResponses}
   */
  public ArrayOfExpoTokenResponses getMobilePushExpoTokens() throws ApiException {
    return this.getMobilePushExpoTokens(GetMobilePushExpoTokensParameters.builder().build());
  }

  /**
   * Lists all mobile_push tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.
   *
   * @param requestParameters {@link GetMobilePushExpoTokensParameters} Request Parameters Object
   * @return response of {@code ArrayOfExpoTokenResponses}
   */
  public ArrayOfExpoTokenResponses getMobilePushExpoTokens(
    @NonNull GetMobilePushExpoTokensParameters requestParameters
  ) throws ApiException {
    Request request = this.buildGetMobilePushExpoTokensRequest(requestParameters);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<ArrayOfExpoTokenResponses>() {});
  }

  /**
   * Lists all mobile_push tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.
   *
   * @return response of {@code CompletableFuture<ArrayOfExpoTokenResponses>}
   */
  public CompletableFuture<ArrayOfExpoTokenResponses> getMobilePushExpoTokensAsync() throws ApiException {
    return this.getMobilePushExpoTokensAsync(GetMobilePushExpoTokensParameters.builder().build());
  }

  /**
   * Lists all mobile_push tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.
   *
   * @param requestParameters {@link GetMobilePushExpoTokensParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<ArrayOfExpoTokenResponses>}
   */
  public CompletableFuture<ArrayOfExpoTokenResponses> getMobilePushExpoTokensAsync(
    @NonNull GetMobilePushExpoTokensParameters requestParameters
  ) throws ApiException {
    Request request = this.buildGetMobilePushExpoTokensRequest(requestParameters);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<ArrayOfExpoTokenResponses>() {})
    );
  }

  private Request buildGetMobilePushExpoTokensRequest(@NonNull GetMobilePushExpoTokensParameters requestParameters) {
    return new RequestBuilder(HttpMethod.GET, this.serverUrl, "channels/mobile_push/expo/tokens")
      .setOptionalQueryParameter("page[size]", requestParameters.getPageSize())
      .setOptionalQueryParameter("page[after]", requestParameters.getPageAfter())
      .setOptionalQueryParameter("page[before]", requestParameters.getPageBefore())
      .build();
  }

  /**
   * Saves a mobile_push token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.
   *
   * @return response of {@code ExpoToken}
   */
  public ExpoToken saveMobilePushExpoToken() throws ApiException, ValidationException {
    return this.saveMobilePushExpoToken(ExpoToken.builder().build());
  }

  /**
   * Saves a mobile_push token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.
   *
   * @param expoToken {@link ExpoToken} Request Body
   * @return response of {@code ExpoToken}
   */
  public ExpoToken saveMobilePushExpoToken(@NonNull ExpoToken expoToken) throws ApiException, ValidationException {
    Request request = this.buildSaveMobilePushExpoTokenRequest(expoToken);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<ExpoToken>() {});
  }

  /**
   * Saves a mobile_push token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.
   *
   * @return response of {@code CompletableFuture<ExpoToken>}
   */
  public CompletableFuture<ExpoToken> saveMobilePushExpoTokenAsync() throws ApiException, ValidationException {
    return this.saveMobilePushExpoTokenAsync(ExpoToken.builder().build());
  }

  /**
   * Saves a mobile_push token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.
   *
   * @param expoToken {@link ExpoToken} Request Body
   * @return response of {@code CompletableFuture<ExpoToken>}
   */
  public CompletableFuture<ExpoToken> saveMobilePushExpoTokenAsync(@NonNull ExpoToken expoToken)
    throws ApiException, ValidationException {
    Request request = this.buildSaveMobilePushExpoTokenRequest(expoToken);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> ModelConverter.convert(response, new TypeReference<ExpoToken>() {})
    );
  }

  private Request buildSaveMobilePushExpoTokenRequest(@NonNull ExpoToken expoToken) throws ValidationException {
    new ViolationAggregator().add(new ExpoTokenValidator("expoToken").optional().validate(expoToken)).validateAll();
    return new RequestBuilder(HttpMethod.POST, this.serverUrl, "channels/mobile_push/expo/tokens")
      .setJsonContent(expoToken)
      .build();
  }

  /**
   * Retrieves details of a specific mobile_push token belonging to the authenticated user. Returns information about the token's status, creation date, and any associated metadata. Users can only access their own tokens.
   *
   * @param tokenId String
   * @return response of {@code ExpoTokenResponse}
   */
  public ExpoTokenResponse getMobilePushExpoToken(@NonNull String tokenId) throws ApiException {
    Request request = this.buildGetMobilePushExpoTokenRequest(tokenId);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<ExpoTokenResponse>() {});
  }

  /**
   * Retrieves details of a specific mobile_push token belonging to the authenticated user. Returns information about the token's status, creation date, and any associated metadata. Users can only access their own tokens.
   *
   * @param tokenId String
   * @return response of {@code CompletableFuture<ExpoTokenResponse>}
   */
  public CompletableFuture<ExpoTokenResponse> getMobilePushExpoTokenAsync(@NonNull String tokenId) throws ApiException {
    Request request = this.buildGetMobilePushExpoTokenRequest(tokenId);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<ExpoTokenResponse>() {})
    );
  }

  private Request buildGetMobilePushExpoTokenRequest(@NonNull String tokenId) {
    return new RequestBuilder(HttpMethod.GET, this.serverUrl, "channels/mobile_push/expo/tokens/{token_id}")
      .setPathParameter("token_id", tokenId)
      .build();
  }

  /**
   * Revokes one of the authenticated user's mobile_push tokens. This permanently invalidates the specified token, preventing it from being used for future channel access. This action cannot be undone. Users can only revoke their own tokens.
   *
   * @param tokenId String
   * @return response of {@code DiscardResult}
   */
  public DiscardResult discardMobilePushExpoToken(@NonNull String tokenId) throws ApiException {
    Request request = this.buildDiscardMobilePushExpoTokenRequest(tokenId);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<DiscardResult>() {});
  }

  /**
   * Revokes one of the authenticated user's mobile_push tokens. This permanently invalidates the specified token, preventing it from being used for future channel access. This action cannot be undone. Users can only revoke their own tokens.
   *
   * @param tokenId String
   * @return response of {@code CompletableFuture<DiscardResult>}
   */
  public CompletableFuture<DiscardResult> discardMobilePushExpoTokenAsync(@NonNull String tokenId) throws ApiException {
    Request request = this.buildDiscardMobilePushExpoTokenRequest(tokenId);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<DiscardResult>() {})
    );
  }

  private Request buildDiscardMobilePushExpoTokenRequest(@NonNull String tokenId) {
    return new RequestBuilder(HttpMethod.DELETE, this.serverUrl, "channels/mobile_push/expo/tokens/{token_id}")
      .setPathParameter("token_id", tokenId)
      .build();
  }

  /**
   * Lists all mobile_push tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.
   *
   * @return response of {@code ArrayOfFcmTokenResponses}
   */
  public ArrayOfFcmTokenResponses getMobilePushFcmTokens() throws ApiException {
    return this.getMobilePushFcmTokens(GetMobilePushFcmTokensParameters.builder().build());
  }

  /**
   * Lists all mobile_push tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.
   *
   * @param requestParameters {@link GetMobilePushFcmTokensParameters} Request Parameters Object
   * @return response of {@code ArrayOfFcmTokenResponses}
   */
  public ArrayOfFcmTokenResponses getMobilePushFcmTokens(@NonNull GetMobilePushFcmTokensParameters requestParameters)
    throws ApiException {
    Request request = this.buildGetMobilePushFcmTokensRequest(requestParameters);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<ArrayOfFcmTokenResponses>() {});
  }

  /**
   * Lists all mobile_push tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.
   *
   * @return response of {@code CompletableFuture<ArrayOfFcmTokenResponses>}
   */
  public CompletableFuture<ArrayOfFcmTokenResponses> getMobilePushFcmTokensAsync() throws ApiException {
    return this.getMobilePushFcmTokensAsync(GetMobilePushFcmTokensParameters.builder().build());
  }

  /**
   * Lists all mobile_push tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.
   *
   * @param requestParameters {@link GetMobilePushFcmTokensParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<ArrayOfFcmTokenResponses>}
   */
  public CompletableFuture<ArrayOfFcmTokenResponses> getMobilePushFcmTokensAsync(
    @NonNull GetMobilePushFcmTokensParameters requestParameters
  ) throws ApiException {
    Request request = this.buildGetMobilePushFcmTokensRequest(requestParameters);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<ArrayOfFcmTokenResponses>() {})
    );
  }

  private Request buildGetMobilePushFcmTokensRequest(@NonNull GetMobilePushFcmTokensParameters requestParameters) {
    return new RequestBuilder(HttpMethod.GET, this.serverUrl, "channels/mobile_push/fcm/tokens")
      .setOptionalQueryParameter("page[size]", requestParameters.getPageSize())
      .setOptionalQueryParameter("page[after]", requestParameters.getPageAfter())
      .setOptionalQueryParameter("page[before]", requestParameters.getPageBefore())
      .build();
  }

  /**
   * Saves a mobile_push token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.
   *
   * @return response of {@code FcmToken}
   */
  public FcmToken saveMobilePushFcmToken() throws ApiException, ValidationException {
    return this.saveMobilePushFcmToken(FcmToken.builder().build());
  }

  /**
   * Saves a mobile_push token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.
   *
   * @param fcmToken {@link FcmToken} Request Body
   * @return response of {@code FcmToken}
   */
  public FcmToken saveMobilePushFcmToken(@NonNull FcmToken fcmToken) throws ApiException, ValidationException {
    Request request = this.buildSaveMobilePushFcmTokenRequest(fcmToken);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<FcmToken>() {});
  }

  /**
   * Saves a mobile_push token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.
   *
   * @return response of {@code CompletableFuture<FcmToken>}
   */
  public CompletableFuture<FcmToken> saveMobilePushFcmTokenAsync() throws ApiException, ValidationException {
    return this.saveMobilePushFcmTokenAsync(FcmToken.builder().build());
  }

  /**
   * Saves a mobile_push token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.
   *
   * @param fcmToken {@link FcmToken} Request Body
   * @return response of {@code CompletableFuture<FcmToken>}
   */
  public CompletableFuture<FcmToken> saveMobilePushFcmTokenAsync(@NonNull FcmToken fcmToken)
    throws ApiException, ValidationException {
    Request request = this.buildSaveMobilePushFcmTokenRequest(fcmToken);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> ModelConverter.convert(response, new TypeReference<FcmToken>() {})
    );
  }

  private Request buildSaveMobilePushFcmTokenRequest(@NonNull FcmToken fcmToken) throws ValidationException {
    new ViolationAggregator().add(new FcmTokenValidator("fcmToken").optional().validate(fcmToken)).validateAll();
    return new RequestBuilder(HttpMethod.POST, this.serverUrl, "channels/mobile_push/fcm/tokens")
      .setJsonContent(fcmToken)
      .build();
  }

  /**
   * Retrieves details of a specific mobile_push token belonging to the authenticated user. Returns information about the token's status, creation date, and any associated metadata. Users can only access their own tokens.
   *
   * @param tokenId String
   * @return response of {@code FcmTokenResponse}
   */
  public FcmTokenResponse getMobilePushFcmToken(@NonNull String tokenId) throws ApiException {
    Request request = this.buildGetMobilePushFcmTokenRequest(tokenId);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<FcmTokenResponse>() {});
  }

  /**
   * Retrieves details of a specific mobile_push token belonging to the authenticated user. Returns information about the token's status, creation date, and any associated metadata. Users can only access their own tokens.
   *
   * @param tokenId String
   * @return response of {@code CompletableFuture<FcmTokenResponse>}
   */
  public CompletableFuture<FcmTokenResponse> getMobilePushFcmTokenAsync(@NonNull String tokenId) throws ApiException {
    Request request = this.buildGetMobilePushFcmTokenRequest(tokenId);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<FcmTokenResponse>() {})
    );
  }

  private Request buildGetMobilePushFcmTokenRequest(@NonNull String tokenId) {
    return new RequestBuilder(HttpMethod.GET, this.serverUrl, "channels/mobile_push/fcm/tokens/{token_id}")
      .setPathParameter("token_id", tokenId)
      .build();
  }

  /**
   * Revokes one of the authenticated user's mobile_push tokens. This permanently invalidates the specified token, preventing it from being used for future channel access. This action cannot be undone. Users can only revoke their own tokens.
   *
   * @param tokenId String
   * @return response of {@code DiscardResult}
   */
  public DiscardResult discardMobilePushFcmToken(@NonNull String tokenId) throws ApiException {
    Request request = this.buildDiscardMobilePushFcmTokenRequest(tokenId);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<DiscardResult>() {});
  }

  /**
   * Revokes one of the authenticated user's mobile_push tokens. This permanently invalidates the specified token, preventing it from being used for future channel access. This action cannot be undone. Users can only revoke their own tokens.
   *
   * @param tokenId String
   * @return response of {@code CompletableFuture<DiscardResult>}
   */
  public CompletableFuture<DiscardResult> discardMobilePushFcmTokenAsync(@NonNull String tokenId) throws ApiException {
    Request request = this.buildDiscardMobilePushFcmTokenRequest(tokenId);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<DiscardResult>() {})
    );
  }

  private Request buildDiscardMobilePushFcmTokenRequest(@NonNull String tokenId) {
    return new RequestBuilder(HttpMethod.DELETE, this.serverUrl, "channels/mobile_push/fcm/tokens/{token_id}")
      .setPathParameter("token_id", tokenId)
      .build();
  }

  /**
   * Lists all slack tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.
   *
   * @return response of {@code ArrayOfSlackTokenResponses}
   */
  public ArrayOfSlackTokenResponses getSlackTokens() throws ApiException {
    return this.getSlackTokens(GetSlackTokensParameters.builder().build());
  }

  /**
   * Lists all slack tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.
   *
   * @param requestParameters {@link GetSlackTokensParameters} Request Parameters Object
   * @return response of {@code ArrayOfSlackTokenResponses}
   */
  public ArrayOfSlackTokenResponses getSlackTokens(@NonNull GetSlackTokensParameters requestParameters)
    throws ApiException {
    Request request = this.buildGetSlackTokensRequest(requestParameters);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<ArrayOfSlackTokenResponses>() {});
  }

  /**
   * Lists all slack tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.
   *
   * @return response of {@code CompletableFuture<ArrayOfSlackTokenResponses>}
   */
  public CompletableFuture<ArrayOfSlackTokenResponses> getSlackTokensAsync() throws ApiException {
    return this.getSlackTokensAsync(GetSlackTokensParameters.builder().build());
  }

  /**
   * Lists all slack tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.
   *
   * @param requestParameters {@link GetSlackTokensParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<ArrayOfSlackTokenResponses>}
   */
  public CompletableFuture<ArrayOfSlackTokenResponses> getSlackTokensAsync(
    @NonNull GetSlackTokensParameters requestParameters
  ) throws ApiException {
    Request request = this.buildGetSlackTokensRequest(requestParameters);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<ArrayOfSlackTokenResponses>() {})
    );
  }

  private Request buildGetSlackTokensRequest(@NonNull GetSlackTokensParameters requestParameters) {
    return new RequestBuilder(HttpMethod.GET, this.serverUrl, "channels/slack/tokens")
      .setOptionalQueryParameter("page[size]", requestParameters.getPageSize())
      .setOptionalQueryParameter("page[after]", requestParameters.getPageAfter())
      .setOptionalQueryParameter("page[before]", requestParameters.getPageBefore())
      .build();
  }

  /**
   * Saves a slack token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.
   *
   * @return response of {@code SlackToken}
   */
  public SlackToken saveSlackToken() throws ApiException, ValidationException {
    return this.saveSlackToken(SlackToken.builder().build());
  }

  /**
   * Saves a slack token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.
   *
   * @param slackToken {@link SlackToken} Request Body
   * @return response of {@code SlackToken}
   */
  public SlackToken saveSlackToken(@NonNull SlackToken slackToken) throws ApiException, ValidationException {
    Request request = this.buildSaveSlackTokenRequest(slackToken);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<SlackToken>() {});
  }

  /**
   * Saves a slack token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.
   *
   * @return response of {@code CompletableFuture<SlackToken>}
   */
  public CompletableFuture<SlackToken> saveSlackTokenAsync() throws ApiException, ValidationException {
    return this.saveSlackTokenAsync(SlackToken.builder().build());
  }

  /**
   * Saves a slack token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.
   *
   * @param slackToken {@link SlackToken} Request Body
   * @return response of {@code CompletableFuture<SlackToken>}
   */
  public CompletableFuture<SlackToken> saveSlackTokenAsync(@NonNull SlackToken slackToken)
    throws ApiException, ValidationException {
    Request request = this.buildSaveSlackTokenRequest(slackToken);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<SlackToken>() {})
    );
  }

  private Request buildSaveSlackTokenRequest(@NonNull SlackToken slackToken) throws ValidationException {
    new ViolationAggregator().add(new SlackTokenValidator("slackToken").optional().validate(slackToken)).validateAll();
    return new RequestBuilder(HttpMethod.POST, this.serverUrl, "channels/slack/tokens")
      .setJsonContent(slackToken)
      .build();
  }

  /**
   * Retrieves details of a specific slack token belonging to the authenticated user. Returns information about the token's status, creation date, and any associated metadata. Users can only access their own tokens.
   *
   * @param tokenId String
   * @return response of {@code SlackTokenResponse}
   */
  public SlackTokenResponse getSlackToken(@NonNull String tokenId) throws ApiException {
    Request request = this.buildGetSlackTokenRequest(tokenId);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<SlackTokenResponse>() {});
  }

  /**
   * Retrieves details of a specific slack token belonging to the authenticated user. Returns information about the token's status, creation date, and any associated metadata. Users can only access their own tokens.
   *
   * @param tokenId String
   * @return response of {@code CompletableFuture<SlackTokenResponse>}
   */
  public CompletableFuture<SlackTokenResponse> getSlackTokenAsync(@NonNull String tokenId) throws ApiException {
    Request request = this.buildGetSlackTokenRequest(tokenId);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<SlackTokenResponse>() {})
    );
  }

  private Request buildGetSlackTokenRequest(@NonNull String tokenId) {
    return new RequestBuilder(HttpMethod.GET, this.serverUrl, "channels/slack/tokens/{token_id}")
      .setPathParameter("token_id", tokenId)
      .build();
  }

  /**
   * Revokes one of the authenticated user's slack tokens. This permanently invalidates the specified token, preventing it from being used for future channel access. This action cannot be undone. Users can only revoke their own tokens.
   *
   * @param tokenId String
   * @return response of {@code DiscardResult}
   */
  public DiscardResult discardSlackToken(@NonNull String tokenId) throws ApiException {
    Request request = this.buildDiscardSlackTokenRequest(tokenId);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<DiscardResult>() {});
  }

  /**
   * Revokes one of the authenticated user's slack tokens. This permanently invalidates the specified token, preventing it from being used for future channel access. This action cannot be undone. Users can only revoke their own tokens.
   *
   * @param tokenId String
   * @return response of {@code CompletableFuture<DiscardResult>}
   */
  public CompletableFuture<DiscardResult> discardSlackTokenAsync(@NonNull String tokenId) throws ApiException {
    Request request = this.buildDiscardSlackTokenRequest(tokenId);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<DiscardResult>() {})
    );
  }

  private Request buildDiscardSlackTokenRequest(@NonNull String tokenId) {
    return new RequestBuilder(HttpMethod.DELETE, this.serverUrl, "channels/slack/tokens/{token_id}")
      .setPathParameter("token_id", tokenId)
      .build();
  }

  /**
   * Lists all teams tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.
   *
   * @return response of {@code ArrayOfTeamsTokenResponses}
   */
  public ArrayOfTeamsTokenResponses getTeamsTokens() throws ApiException {
    return this.getTeamsTokens(GetTeamsTokensParameters.builder().build());
  }

  /**
   * Lists all teams tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.
   *
   * @param requestParameters {@link GetTeamsTokensParameters} Request Parameters Object
   * @return response of {@code ArrayOfTeamsTokenResponses}
   */
  public ArrayOfTeamsTokenResponses getTeamsTokens(@NonNull GetTeamsTokensParameters requestParameters)
    throws ApiException {
    Request request = this.buildGetTeamsTokensRequest(requestParameters);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<ArrayOfTeamsTokenResponses>() {});
  }

  /**
   * Lists all teams tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.
   *
   * @return response of {@code CompletableFuture<ArrayOfTeamsTokenResponses>}
   */
  public CompletableFuture<ArrayOfTeamsTokenResponses> getTeamsTokensAsync() throws ApiException {
    return this.getTeamsTokensAsync(GetTeamsTokensParameters.builder().build());
  }

  /**
   * Lists all teams tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.
   *
   * @param requestParameters {@link GetTeamsTokensParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<ArrayOfTeamsTokenResponses>}
   */
  public CompletableFuture<ArrayOfTeamsTokenResponses> getTeamsTokensAsync(
    @NonNull GetTeamsTokensParameters requestParameters
  ) throws ApiException {
    Request request = this.buildGetTeamsTokensRequest(requestParameters);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<ArrayOfTeamsTokenResponses>() {})
    );
  }

  private Request buildGetTeamsTokensRequest(@NonNull GetTeamsTokensParameters requestParameters) {
    return new RequestBuilder(HttpMethod.GET, this.serverUrl, "channels/teams/tokens")
      .setOptionalQueryParameter("page[size]", requestParameters.getPageSize())
      .setOptionalQueryParameter("page[after]", requestParameters.getPageAfter())
      .setOptionalQueryParameter("page[before]", requestParameters.getPageBefore())
      .build();
  }

  /**
   * Saves a teams token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.
   *
   * @return response of {@code TeamsToken}
   */
  public TeamsToken saveTeamsToken() throws ApiException {
    return this.saveTeamsToken(TeamsToken.builder().build());
  }

  /**
   * Saves a teams token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.
   *
   * @param teamsToken {@link TeamsToken} Request Body
   * @return response of {@code TeamsToken}
   */
  public TeamsToken saveTeamsToken(@NonNull TeamsToken teamsToken) throws ApiException {
    Request request = this.buildSaveTeamsTokenRequest(teamsToken);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<TeamsToken>() {});
  }

  /**
   * Saves a teams token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.
   *
   * @return response of {@code CompletableFuture<TeamsToken>}
   */
  public CompletableFuture<TeamsToken> saveTeamsTokenAsync() throws ApiException {
    return this.saveTeamsTokenAsync(TeamsToken.builder().build());
  }

  /**
   * Saves a teams token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.
   *
   * @param teamsToken {@link TeamsToken} Request Body
   * @return response of {@code CompletableFuture<TeamsToken>}
   */
  public CompletableFuture<TeamsToken> saveTeamsTokenAsync(@NonNull TeamsToken teamsToken) throws ApiException {
    Request request = this.buildSaveTeamsTokenRequest(teamsToken);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<TeamsToken>() {})
    );
  }

  private Request buildSaveTeamsTokenRequest(@NonNull TeamsToken teamsToken) {
    return new RequestBuilder(HttpMethod.POST, this.serverUrl, "channels/teams/tokens")
      .setJsonContent(teamsToken)
      .build();
  }

  /**
   * Retrieves details of a specific teams token belonging to the authenticated user. Returns information about the token's status, creation date, and any associated metadata. Users can only access their own tokens.
   *
   * @param tokenId String
   * @return response of {@code TeamsTokenResponse}
   */
  public TeamsTokenResponse getTeamsToken(@NonNull String tokenId) throws ApiException {
    Request request = this.buildGetTeamsTokenRequest(tokenId);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<TeamsTokenResponse>() {});
  }

  /**
   * Retrieves details of a specific teams token belonging to the authenticated user. Returns information about the token's status, creation date, and any associated metadata. Users can only access their own tokens.
   *
   * @param tokenId String
   * @return response of {@code CompletableFuture<TeamsTokenResponse>}
   */
  public CompletableFuture<TeamsTokenResponse> getTeamsTokenAsync(@NonNull String tokenId) throws ApiException {
    Request request = this.buildGetTeamsTokenRequest(tokenId);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<TeamsTokenResponse>() {})
    );
  }

  private Request buildGetTeamsTokenRequest(@NonNull String tokenId) {
    return new RequestBuilder(HttpMethod.GET, this.serverUrl, "channels/teams/tokens/{token_id}")
      .setPathParameter("token_id", tokenId)
      .build();
  }

  /**
   * Revokes one of the authenticated user's teams tokens. This permanently invalidates the specified token, preventing it from being used for future channel access. This action cannot be undone. Users can only revoke their own tokens.
   *
   * @param tokenId String
   * @return response of {@code DiscardResult}
   */
  public DiscardResult discardTeamsToken(@NonNull String tokenId) throws ApiException {
    Request request = this.buildDiscardTeamsTokenRequest(tokenId);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<DiscardResult>() {});
  }

  /**
   * Revokes one of the authenticated user's teams tokens. This permanently invalidates the specified token, preventing it from being used for future channel access. This action cannot be undone. Users can only revoke their own tokens.
   *
   * @param tokenId String
   * @return response of {@code CompletableFuture<DiscardResult>}
   */
  public CompletableFuture<DiscardResult> discardTeamsTokenAsync(@NonNull String tokenId) throws ApiException {
    Request request = this.buildDiscardTeamsTokenRequest(tokenId);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<DiscardResult>() {})
    );
  }

  private Request buildDiscardTeamsTokenRequest(@NonNull String tokenId) {
    return new RequestBuilder(HttpMethod.DELETE, this.serverUrl, "channels/teams/tokens/{token_id}")
      .setPathParameter("token_id", tokenId)
      .build();
  }

  /**
   * Lists all web_push tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.
   *
   * @return response of {@code ArrayOfWebPushTokenResponses}
   */
  public ArrayOfWebPushTokenResponses getWebPushTokens() throws ApiException {
    return this.getWebPushTokens(GetWebPushTokensParameters.builder().build());
  }

  /**
   * Lists all web_push tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.
   *
   * @param requestParameters {@link GetWebPushTokensParameters} Request Parameters Object
   * @return response of {@code ArrayOfWebPushTokenResponses}
   */
  public ArrayOfWebPushTokenResponses getWebPushTokens(@NonNull GetWebPushTokensParameters requestParameters)
    throws ApiException {
    Request request = this.buildGetWebPushTokensRequest(requestParameters);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<ArrayOfWebPushTokenResponses>() {});
  }

  /**
   * Lists all web_push tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.
   *
   * @return response of {@code CompletableFuture<ArrayOfWebPushTokenResponses>}
   */
  public CompletableFuture<ArrayOfWebPushTokenResponses> getWebPushTokensAsync() throws ApiException {
    return this.getWebPushTokensAsync(GetWebPushTokensParameters.builder().build());
  }

  /**
   * Lists all web_push tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.
   *
   * @param requestParameters {@link GetWebPushTokensParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<ArrayOfWebPushTokenResponses>}
   */
  public CompletableFuture<ArrayOfWebPushTokenResponses> getWebPushTokensAsync(
    @NonNull GetWebPushTokensParameters requestParameters
  ) throws ApiException {
    Request request = this.buildGetWebPushTokensRequest(requestParameters);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<ArrayOfWebPushTokenResponses>() {})
    );
  }

  private Request buildGetWebPushTokensRequest(@NonNull GetWebPushTokensParameters requestParameters) {
    return new RequestBuilder(HttpMethod.GET, this.serverUrl, "channels/web_push/tokens")
      .setOptionalQueryParameter("page[size]", requestParameters.getPageSize())
      .setOptionalQueryParameter("page[after]", requestParameters.getPageAfter())
      .setOptionalQueryParameter("page[before]", requestParameters.getPageBefore())
      .build();
  }

  /**
   * Saves a web_push token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.
   *
   * @return response of {@code WebPushToken}
   */
  public WebPushToken saveWebPushToken() throws ApiException {
    return this.saveWebPushToken(WebPushToken.builder().build());
  }

  /**
   * Saves a web_push token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.
   *
   * @param webPushToken {@link WebPushToken} Request Body
   * @return response of {@code WebPushToken}
   */
  public WebPushToken saveWebPushToken(@NonNull WebPushToken webPushToken) throws ApiException {
    Request request = this.buildSaveWebPushTokenRequest(webPushToken);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<WebPushToken>() {});
  }

  /**
   * Saves a web_push token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.
   *
   * @return response of {@code CompletableFuture<WebPushToken>}
   */
  public CompletableFuture<WebPushToken> saveWebPushTokenAsync() throws ApiException {
    return this.saveWebPushTokenAsync(WebPushToken.builder().build());
  }

  /**
   * Saves a web_push token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.
   *
   * @param webPushToken {@link WebPushToken} Request Body
   * @return response of {@code CompletableFuture<WebPushToken>}
   */
  public CompletableFuture<WebPushToken> saveWebPushTokenAsync(@NonNull WebPushToken webPushToken) throws ApiException {
    Request request = this.buildSaveWebPushTokenRequest(webPushToken);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<WebPushToken>() {})
    );
  }

  private Request buildSaveWebPushTokenRequest(@NonNull WebPushToken webPushToken) {
    return new RequestBuilder(HttpMethod.POST, this.serverUrl, "channels/web_push/tokens")
      .setJsonContent(webPushToken)
      .build();
  }

  /**
   * Retrieves details of a specific web_push token belonging to the authenticated user. Returns information about the token's status, creation date, and any associated metadata. Users can only access their own tokens.
   *
   * @param tokenId String
   * @return response of {@code WebPushTokenResponse}
   */
  public WebPushTokenResponse getWebPushToken(@NonNull String tokenId) throws ApiException {
    Request request = this.buildGetWebPushTokenRequest(tokenId);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<WebPushTokenResponse>() {});
  }

  /**
   * Retrieves details of a specific web_push token belonging to the authenticated user. Returns information about the token's status, creation date, and any associated metadata. Users can only access their own tokens.
   *
   * @param tokenId String
   * @return response of {@code CompletableFuture<WebPushTokenResponse>}
   */
  public CompletableFuture<WebPushTokenResponse> getWebPushTokenAsync(@NonNull String tokenId) throws ApiException {
    Request request = this.buildGetWebPushTokenRequest(tokenId);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<WebPushTokenResponse>() {})
    );
  }

  private Request buildGetWebPushTokenRequest(@NonNull String tokenId) {
    return new RequestBuilder(HttpMethod.GET, this.serverUrl, "channels/web_push/tokens/{token_id}")
      .setPathParameter("token_id", tokenId)
      .build();
  }

  /**
   * Revokes one of the authenticated user's web_push tokens. This permanently invalidates the specified token, preventing it from being used for future channel access. This action cannot be undone. Users can only revoke their own tokens.
   *
   * @param tokenId String
   * @return response of {@code DiscardResult}
   */
  public DiscardResult discardWebPushToken(@NonNull String tokenId) throws ApiException {
    Request request = this.buildDiscardWebPushTokenRequest(tokenId);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<DiscardResult>() {});
  }

  /**
   * Revokes one of the authenticated user's web_push tokens. This permanently invalidates the specified token, preventing it from being used for future channel access. This action cannot be undone. Users can only revoke their own tokens.
   *
   * @param tokenId String
   * @return response of {@code CompletableFuture<DiscardResult>}
   */
  public CompletableFuture<DiscardResult> discardWebPushTokenAsync(@NonNull String tokenId) throws ApiException {
    Request request = this.buildDiscardWebPushTokenRequest(tokenId);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<DiscardResult>() {})
    );
  }

  private Request buildDiscardWebPushTokenRequest(@NonNull String tokenId) {
    return new RequestBuilder(HttpMethod.DELETE, this.serverUrl, "channels/web_push/tokens/{token_id}")
      .setPathParameter("token_id", tokenId)
      .build();
  }
}
