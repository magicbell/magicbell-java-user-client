package com.magicbell.magicbelluserclient.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.exceptions.ApiException;
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
import com.magicbell.magicbelluserclient.models.GetInAppInboxTokensParameters;
import com.magicbell.magicbelluserclient.models.GetMobilePushApnsTokensParameters;
import com.magicbell.magicbelluserclient.models.GetMobilePushExpoTokensParameters;
import com.magicbell.magicbelluserclient.models.GetMobilePushFcmTokensParameters;
import com.magicbell.magicbelluserclient.models.GetSlackTokensParameters;
import com.magicbell.magicbelluserclient.models.GetTeamsTokensParameters;
import com.magicbell.magicbelluserclient.models.GetWebPushTokensParameters;
import com.magicbell.magicbelluserclient.models.InboxToken;
import com.magicbell.magicbelluserclient.models.InboxTokenResponse;
import com.magicbell.magicbelluserclient.models.InboxTokenResponseCollection;
import com.magicbell.magicbelluserclient.models.SlackToken;
import com.magicbell.magicbelluserclient.models.SlackTokenCollection;
import com.magicbell.magicbelluserclient.models.SlackTokenPayload;
import com.magicbell.magicbelluserclient.models.TeamsToken;
import com.magicbell.magicbelluserclient.models.TeamsTokenCollection;
import com.magicbell.magicbelluserclient.models.TeamsTokenPayload;
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

  public ChannelsService(@NonNull OkHttpClient httpClient, MagicbellUserClientConfig config) {
    super(httpClient, config);
  }

  /**
   * Lists all in_app tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.
   *
   * @return response of {@code InboxTokenResponseCollection}
   */
  public InboxTokenResponseCollection getInAppInboxTokens() throws ApiException {
    return this.getInAppInboxTokens(GetInAppInboxTokensParameters.builder().build());
  }

  /**
   * Lists all in_app tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.
   *
   * @param requestParameters {@link GetInAppInboxTokensParameters} Request Parameters Object
   * @return response of {@code InboxTokenResponseCollection}
   */
  public InboxTokenResponseCollection getInAppInboxTokens(@NonNull GetInAppInboxTokensParameters requestParameters)
    throws ApiException {
    Request request = this.buildGetInAppInboxTokensRequest(requestParameters);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<InboxTokenResponseCollection>() {});
  }

  /**
   * Lists all in_app tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.
   *
   * @return response of {@code CompletableFuture<InboxTokenResponseCollection>}
   */
  public CompletableFuture<InboxTokenResponseCollection> getInAppInboxTokensAsync() throws ApiException {
    return this.getInAppInboxTokensAsync(GetInAppInboxTokensParameters.builder().build());
  }

  /**
   * Lists all in_app tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.
   *
   * @param requestParameters {@link GetInAppInboxTokensParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<InboxTokenResponseCollection>}
   */
  public CompletableFuture<InboxTokenResponseCollection> getInAppInboxTokensAsync(
    @NonNull GetInAppInboxTokensParameters requestParameters
  ) throws ApiException {
    Request request = this.buildGetInAppInboxTokensRequest(requestParameters);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<InboxTokenResponseCollection>() {})
    );
  }

  private Request buildGetInAppInboxTokensRequest(@NonNull GetInAppInboxTokensParameters requestParameters) {
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
   * Saves a in_app token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.
   *
   * @return response of {@code InboxToken}
   */
  public InboxToken saveInAppInboxToken() throws ApiException, ValidationException {
    return this.saveInAppInboxToken(InboxToken.builder().build());
  }

  /**
   * Saves a in_app token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.
   *
   * @param inboxToken {@link InboxToken} Request Body
   * @return response of {@code InboxToken}
   */
  public InboxToken saveInAppInboxToken(@NonNull InboxToken inboxToken) throws ApiException, ValidationException {
    Request request = this.buildSaveInAppInboxTokenRequest(inboxToken);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<InboxToken>() {});
  }

  /**
   * Saves a in_app token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.
   *
   * @return response of {@code CompletableFuture<InboxToken>}
   */
  public CompletableFuture<InboxToken> saveInAppInboxTokenAsync() throws ApiException, ValidationException {
    return this.saveInAppInboxTokenAsync(InboxToken.builder().build());
  }

  /**
   * Saves a in_app token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.
   *
   * @param inboxToken {@link InboxToken} Request Body
   * @return response of {@code CompletableFuture<InboxToken>}
   */
  public CompletableFuture<InboxToken> saveInAppInboxTokenAsync(@NonNull InboxToken inboxToken)
    throws ApiException, ValidationException {
    Request request = this.buildSaveInAppInboxTokenRequest(inboxToken);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<InboxToken>() {})
    );
  }

  private Request buildSaveInAppInboxTokenRequest(@NonNull InboxToken inboxToken) throws ValidationException {
    new ViolationAggregator().add(new InboxTokenValidator("inboxToken").optional().validate(inboxToken)).validateAll();
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "channels/in_app/inbox/tokens"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setJsonContent(inboxToken)
      .build();
  }

  /**
   * Retrieves details of a specific in_app token belonging to the authenticated user. Returns information about the token's status, creation date, and any associated metadata. Users can only access their own tokens.
   *
   * @param tokenId String
   * @return response of {@code InboxTokenResponse}
   */
  public InboxTokenResponse getInAppInboxToken(@NonNull String tokenId) throws ApiException {
    Request request = this.buildGetInAppInboxTokenRequest(tokenId);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<InboxTokenResponse>() {});
  }

  /**
   * Retrieves details of a specific in_app token belonging to the authenticated user. Returns information about the token's status, creation date, and any associated metadata. Users can only access their own tokens.
   *
   * @param tokenId String
   * @return response of {@code CompletableFuture<InboxTokenResponse>}
   */
  public CompletableFuture<InboxTokenResponse> getInAppInboxTokenAsync(@NonNull String tokenId) throws ApiException {
    Request request = this.buildGetInAppInboxTokenRequest(tokenId);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<InboxTokenResponse>() {})
    );
  }

  private Request buildGetInAppInboxTokenRequest(@NonNull String tokenId) {
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
   * Revokes one of the authenticated user's in_app tokens. This permanently invalidates the specified token, preventing it from being used for future channel access. This action cannot be undone. Users can only revoke their own tokens.
   *
   * @param tokenId String
   * @return response of {@code DiscardResult}
   */
  public DiscardResult discardInAppInboxToken(@NonNull String tokenId) throws ApiException {
    Request request = this.buildDiscardInAppInboxTokenRequest(tokenId);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<DiscardResult>() {});
  }

  /**
   * Revokes one of the authenticated user's in_app tokens. This permanently invalidates the specified token, preventing it from being used for future channel access. This action cannot be undone. Users can only revoke their own tokens.
   *
   * @param tokenId String
   * @return response of {@code CompletableFuture<DiscardResult>}
   */
  public CompletableFuture<DiscardResult> discardInAppInboxTokenAsync(@NonNull String tokenId) throws ApiException {
    Request request = this.buildDiscardInAppInboxTokenRequest(tokenId);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<DiscardResult>() {})
    );
  }

  private Request buildDiscardInAppInboxTokenRequest(@NonNull String tokenId) {
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
   * Lists all mobile_push tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.
   *
   * @return response of {@code ApnsTokenCollection}
   */
  public ApnsTokenCollection getMobilePushApnsTokens() throws ApiException {
    return this.getMobilePushApnsTokens(GetMobilePushApnsTokensParameters.builder().build());
  }

  /**
   * Lists all mobile_push tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.
   *
   * @param requestParameters {@link GetMobilePushApnsTokensParameters} Request Parameters Object
   * @return response of {@code ApnsTokenCollection}
   */
  public ApnsTokenCollection getMobilePushApnsTokens(@NonNull GetMobilePushApnsTokensParameters requestParameters)
    throws ApiException {
    Request request = this.buildGetMobilePushApnsTokensRequest(requestParameters);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<ApnsTokenCollection>() {});
  }

  /**
   * Lists all mobile_push tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.
   *
   * @return response of {@code CompletableFuture<ApnsTokenCollection>}
   */
  public CompletableFuture<ApnsTokenCollection> getMobilePushApnsTokensAsync() throws ApiException {
    return this.getMobilePushApnsTokensAsync(GetMobilePushApnsTokensParameters.builder().build());
  }

  /**
   * Lists all mobile_push tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.
   *
   * @param requestParameters {@link GetMobilePushApnsTokensParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<ApnsTokenCollection>}
   */
  public CompletableFuture<ApnsTokenCollection> getMobilePushApnsTokensAsync(
    @NonNull GetMobilePushApnsTokensParameters requestParameters
  ) throws ApiException {
    Request request = this.buildGetMobilePushApnsTokensRequest(requestParameters);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<ApnsTokenCollection>() {})
    );
  }

  private Request buildGetMobilePushApnsTokensRequest(@NonNull GetMobilePushApnsTokensParameters requestParameters) {
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
   * Saves a mobile_push token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.
   *
   * @return response of {@code ApnsTokenPayload}
   */
  public ApnsTokenPayload saveMobilePushApnsToken() throws ApiException, ValidationException {
    return this.saveMobilePushApnsToken(ApnsTokenPayload.builder().build());
  }

  /**
   * Saves a mobile_push token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.
   *
   * @param apnsTokenPayload {@link ApnsTokenPayload} Request Body
   * @return response of {@code ApnsTokenPayload}
   */
  public ApnsTokenPayload saveMobilePushApnsToken(@NonNull ApnsTokenPayload apnsTokenPayload)
    throws ApiException, ValidationException {
    Request request = this.buildSaveMobilePushApnsTokenRequest(apnsTokenPayload);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<ApnsTokenPayload>() {});
  }

  /**
   * Saves a mobile_push token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.
   *
   * @return response of {@code CompletableFuture<ApnsTokenPayload>}
   */
  public CompletableFuture<ApnsTokenPayload> saveMobilePushApnsTokenAsync() throws ApiException, ValidationException {
    return this.saveMobilePushApnsTokenAsync(ApnsTokenPayload.builder().build());
  }

  /**
   * Saves a mobile_push token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.
   *
   * @param apnsTokenPayload {@link ApnsTokenPayload} Request Body
   * @return response of {@code CompletableFuture<ApnsTokenPayload>}
   */
  public CompletableFuture<ApnsTokenPayload> saveMobilePushApnsTokenAsync(@NonNull ApnsTokenPayload apnsTokenPayload)
    throws ApiException, ValidationException {
    Request request = this.buildSaveMobilePushApnsTokenRequest(apnsTokenPayload);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<ApnsTokenPayload>() {})
    );
  }

  private Request buildSaveMobilePushApnsTokenRequest(@NonNull ApnsTokenPayload apnsTokenPayload)
    throws ValidationException {
    new ViolationAggregator()
      .add(new ApnsTokenPayloadValidator("apnsTokenPayload").optional().validate(apnsTokenPayload))
      .validateAll();
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "channels/mobile_push/apns/tokens"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setJsonContent(apnsTokenPayload)
      .build();
  }

  /**
   * Retrieves details of a specific mobile_push token belonging to the authenticated user. Returns information about the token's status, creation date, and any associated metadata. Users can only access their own tokens.
   *
   * @param tokenId String
   * @return response of {@code ApnsToken}
   */
  public ApnsToken getMobilePushApnsToken(@NonNull String tokenId) throws ApiException {
    Request request = this.buildGetMobilePushApnsTokenRequest(tokenId);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<ApnsToken>() {});
  }

  /**
   * Retrieves details of a specific mobile_push token belonging to the authenticated user. Returns information about the token's status, creation date, and any associated metadata. Users can only access their own tokens.
   *
   * @param tokenId String
   * @return response of {@code CompletableFuture<ApnsToken>}
   */
  public CompletableFuture<ApnsToken> getMobilePushApnsTokenAsync(@NonNull String tokenId) throws ApiException {
    Request request = this.buildGetMobilePushApnsTokenRequest(tokenId);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> ModelConverter.convert(response, new TypeReference<ApnsToken>() {})
    );
  }

  private Request buildGetMobilePushApnsTokenRequest(@NonNull String tokenId) {
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
   * Lists all mobile_push tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.
   *
   * @return response of {@code ExpoTokenCollection}
   */
  public ExpoTokenCollection getMobilePushExpoTokens() throws ApiException {
    return this.getMobilePushExpoTokens(GetMobilePushExpoTokensParameters.builder().build());
  }

  /**
   * Lists all mobile_push tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.
   *
   * @param requestParameters {@link GetMobilePushExpoTokensParameters} Request Parameters Object
   * @return response of {@code ExpoTokenCollection}
   */
  public ExpoTokenCollection getMobilePushExpoTokens(@NonNull GetMobilePushExpoTokensParameters requestParameters)
    throws ApiException {
    Request request = this.buildGetMobilePushExpoTokensRequest(requestParameters);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<ExpoTokenCollection>() {});
  }

  /**
   * Lists all mobile_push tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.
   *
   * @return response of {@code CompletableFuture<ExpoTokenCollection>}
   */
  public CompletableFuture<ExpoTokenCollection> getMobilePushExpoTokensAsync() throws ApiException {
    return this.getMobilePushExpoTokensAsync(GetMobilePushExpoTokensParameters.builder().build());
  }

  /**
   * Lists all mobile_push tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.
   *
   * @param requestParameters {@link GetMobilePushExpoTokensParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<ExpoTokenCollection>}
   */
  public CompletableFuture<ExpoTokenCollection> getMobilePushExpoTokensAsync(
    @NonNull GetMobilePushExpoTokensParameters requestParameters
  ) throws ApiException {
    Request request = this.buildGetMobilePushExpoTokensRequest(requestParameters);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<ExpoTokenCollection>() {})
    );
  }

  private Request buildGetMobilePushExpoTokensRequest(@NonNull GetMobilePushExpoTokensParameters requestParameters) {
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
   * Saves a mobile_push token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.
   *
   * @return response of {@code ExpoTokenPayload}
   */
  public ExpoTokenPayload saveMobilePushExpoToken() throws ApiException, ValidationException {
    return this.saveMobilePushExpoToken(ExpoTokenPayload.builder().build());
  }

  /**
   * Saves a mobile_push token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.
   *
   * @param expoTokenPayload {@link ExpoTokenPayload} Request Body
   * @return response of {@code ExpoTokenPayload}
   */
  public ExpoTokenPayload saveMobilePushExpoToken(@NonNull ExpoTokenPayload expoTokenPayload)
    throws ApiException, ValidationException {
    Request request = this.buildSaveMobilePushExpoTokenRequest(expoTokenPayload);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<ExpoTokenPayload>() {});
  }

  /**
   * Saves a mobile_push token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.
   *
   * @return response of {@code CompletableFuture<ExpoTokenPayload>}
   */
  public CompletableFuture<ExpoTokenPayload> saveMobilePushExpoTokenAsync() throws ApiException, ValidationException {
    return this.saveMobilePushExpoTokenAsync(ExpoTokenPayload.builder().build());
  }

  /**
   * Saves a mobile_push token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.
   *
   * @param expoTokenPayload {@link ExpoTokenPayload} Request Body
   * @return response of {@code CompletableFuture<ExpoTokenPayload>}
   */
  public CompletableFuture<ExpoTokenPayload> saveMobilePushExpoTokenAsync(@NonNull ExpoTokenPayload expoTokenPayload)
    throws ApiException, ValidationException {
    Request request = this.buildSaveMobilePushExpoTokenRequest(expoTokenPayload);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<ExpoTokenPayload>() {})
    );
  }

  private Request buildSaveMobilePushExpoTokenRequest(@NonNull ExpoTokenPayload expoTokenPayload)
    throws ValidationException {
    new ViolationAggregator()
      .add(new ExpoTokenPayloadValidator("expoTokenPayload").optional().validate(expoTokenPayload))
      .validateAll();
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "channels/mobile_push/expo/tokens"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setJsonContent(expoTokenPayload)
      .build();
  }

  /**
   * Retrieves details of a specific mobile_push token belonging to the authenticated user. Returns information about the token's status, creation date, and any associated metadata. Users can only access their own tokens.
   *
   * @param tokenId String
   * @return response of {@code ExpoToken}
   */
  public ExpoToken getMobilePushExpoToken(@NonNull String tokenId) throws ApiException {
    Request request = this.buildGetMobilePushExpoTokenRequest(tokenId);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<ExpoToken>() {});
  }

  /**
   * Retrieves details of a specific mobile_push token belonging to the authenticated user. Returns information about the token's status, creation date, and any associated metadata. Users can only access their own tokens.
   *
   * @param tokenId String
   * @return response of {@code CompletableFuture<ExpoToken>}
   */
  public CompletableFuture<ExpoToken> getMobilePushExpoTokenAsync(@NonNull String tokenId) throws ApiException {
    Request request = this.buildGetMobilePushExpoTokenRequest(tokenId);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> ModelConverter.convert(response, new TypeReference<ExpoToken>() {})
    );
  }

  private Request buildGetMobilePushExpoTokenRequest(@NonNull String tokenId) {
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
   * Lists all mobile_push tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.
   *
   * @return response of {@code FcmTokenCollection}
   */
  public FcmTokenCollection getMobilePushFcmTokens() throws ApiException {
    return this.getMobilePushFcmTokens(GetMobilePushFcmTokensParameters.builder().build());
  }

  /**
   * Lists all mobile_push tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.
   *
   * @param requestParameters {@link GetMobilePushFcmTokensParameters} Request Parameters Object
   * @return response of {@code FcmTokenCollection}
   */
  public FcmTokenCollection getMobilePushFcmTokens(@NonNull GetMobilePushFcmTokensParameters requestParameters)
    throws ApiException {
    Request request = this.buildGetMobilePushFcmTokensRequest(requestParameters);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<FcmTokenCollection>() {});
  }

  /**
   * Lists all mobile_push tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.
   *
   * @return response of {@code CompletableFuture<FcmTokenCollection>}
   */
  public CompletableFuture<FcmTokenCollection> getMobilePushFcmTokensAsync() throws ApiException {
    return this.getMobilePushFcmTokensAsync(GetMobilePushFcmTokensParameters.builder().build());
  }

  /**
   * Lists all mobile_push tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.
   *
   * @param requestParameters {@link GetMobilePushFcmTokensParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<FcmTokenCollection>}
   */
  public CompletableFuture<FcmTokenCollection> getMobilePushFcmTokensAsync(
    @NonNull GetMobilePushFcmTokensParameters requestParameters
  ) throws ApiException {
    Request request = this.buildGetMobilePushFcmTokensRequest(requestParameters);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<FcmTokenCollection>() {})
    );
  }

  private Request buildGetMobilePushFcmTokensRequest(@NonNull GetMobilePushFcmTokensParameters requestParameters) {
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
   * Saves a mobile_push token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.
   *
   * @return response of {@code FcmTokenPayload}
   */
  public FcmTokenPayload saveMobilePushFcmToken() throws ApiException, ValidationException {
    return this.saveMobilePushFcmToken(FcmTokenPayload.builder().build());
  }

  /**
   * Saves a mobile_push token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.
   *
   * @param fcmTokenPayload {@link FcmTokenPayload} Request Body
   * @return response of {@code FcmTokenPayload}
   */
  public FcmTokenPayload saveMobilePushFcmToken(@NonNull FcmTokenPayload fcmTokenPayload)
    throws ApiException, ValidationException {
    Request request = this.buildSaveMobilePushFcmTokenRequest(fcmTokenPayload);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<FcmTokenPayload>() {});
  }

  /**
   * Saves a mobile_push token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.
   *
   * @return response of {@code CompletableFuture<FcmTokenPayload>}
   */
  public CompletableFuture<FcmTokenPayload> saveMobilePushFcmTokenAsync() throws ApiException, ValidationException {
    return this.saveMobilePushFcmTokenAsync(FcmTokenPayload.builder().build());
  }

  /**
   * Saves a mobile_push token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.
   *
   * @param fcmTokenPayload {@link FcmTokenPayload} Request Body
   * @return response of {@code CompletableFuture<FcmTokenPayload>}
   */
  public CompletableFuture<FcmTokenPayload> saveMobilePushFcmTokenAsync(@NonNull FcmTokenPayload fcmTokenPayload)
    throws ApiException, ValidationException {
    Request request = this.buildSaveMobilePushFcmTokenRequest(fcmTokenPayload);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<FcmTokenPayload>() {})
    );
  }

  private Request buildSaveMobilePushFcmTokenRequest(@NonNull FcmTokenPayload fcmTokenPayload)
    throws ValidationException {
    new ViolationAggregator()
      .add(new FcmTokenPayloadValidator("fcmTokenPayload").optional().validate(fcmTokenPayload))
      .validateAll();
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "channels/mobile_push/fcm/tokens"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setJsonContent(fcmTokenPayload)
      .build();
  }

  /**
   * Retrieves details of a specific mobile_push token belonging to the authenticated user. Returns information about the token's status, creation date, and any associated metadata. Users can only access their own tokens.
   *
   * @param tokenId String
   * @return response of {@code FcmToken}
   */
  public FcmToken getMobilePushFcmToken(@NonNull String tokenId) throws ApiException {
    Request request = this.buildGetMobilePushFcmTokenRequest(tokenId);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<FcmToken>() {});
  }

  /**
   * Retrieves details of a specific mobile_push token belonging to the authenticated user. Returns information about the token's status, creation date, and any associated metadata. Users can only access their own tokens.
   *
   * @param tokenId String
   * @return response of {@code CompletableFuture<FcmToken>}
   */
  public CompletableFuture<FcmToken> getMobilePushFcmTokenAsync(@NonNull String tokenId) throws ApiException {
    Request request = this.buildGetMobilePushFcmTokenRequest(tokenId);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> ModelConverter.convert(response, new TypeReference<FcmToken>() {})
    );
  }

  private Request buildGetMobilePushFcmTokenRequest(@NonNull String tokenId) {
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
   * Lists all slack tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.
   *
   * @return response of {@code SlackTokenCollection}
   */
  public SlackTokenCollection getSlackTokens() throws ApiException {
    return this.getSlackTokens(GetSlackTokensParameters.builder().build());
  }

  /**
   * Lists all slack tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.
   *
   * @param requestParameters {@link GetSlackTokensParameters} Request Parameters Object
   * @return response of {@code SlackTokenCollection}
   */
  public SlackTokenCollection getSlackTokens(@NonNull GetSlackTokensParameters requestParameters) throws ApiException {
    Request request = this.buildGetSlackTokensRequest(requestParameters);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<SlackTokenCollection>() {});
  }

  /**
   * Lists all slack tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.
   *
   * @return response of {@code CompletableFuture<SlackTokenCollection>}
   */
  public CompletableFuture<SlackTokenCollection> getSlackTokensAsync() throws ApiException {
    return this.getSlackTokensAsync(GetSlackTokensParameters.builder().build());
  }

  /**
   * Lists all slack tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.
   *
   * @param requestParameters {@link GetSlackTokensParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<SlackTokenCollection>}
   */
  public CompletableFuture<SlackTokenCollection> getSlackTokensAsync(
    @NonNull GetSlackTokensParameters requestParameters
  ) throws ApiException {
    Request request = this.buildGetSlackTokensRequest(requestParameters);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<SlackTokenCollection>() {})
    );
  }

  private Request buildGetSlackTokensRequest(@NonNull GetSlackTokensParameters requestParameters) {
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
   * Saves a slack token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.
   *
   * @return response of {@code SlackTokenPayload}
   */
  public SlackTokenPayload saveSlackToken() throws ApiException, ValidationException {
    return this.saveSlackToken(SlackTokenPayload.builder().build());
  }

  /**
   * Saves a slack token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.
   *
   * @param slackTokenPayload {@link SlackTokenPayload} Request Body
   * @return response of {@code SlackTokenPayload}
   */
  public SlackTokenPayload saveSlackToken(@NonNull SlackTokenPayload slackTokenPayload)
    throws ApiException, ValidationException {
    Request request = this.buildSaveSlackTokenRequest(slackTokenPayload);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<SlackTokenPayload>() {});
  }

  /**
   * Saves a slack token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.
   *
   * @return response of {@code CompletableFuture<SlackTokenPayload>}
   */
  public CompletableFuture<SlackTokenPayload> saveSlackTokenAsync() throws ApiException, ValidationException {
    return this.saveSlackTokenAsync(SlackTokenPayload.builder().build());
  }

  /**
   * Saves a slack token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.
   *
   * @param slackTokenPayload {@link SlackTokenPayload} Request Body
   * @return response of {@code CompletableFuture<SlackTokenPayload>}
   */
  public CompletableFuture<SlackTokenPayload> saveSlackTokenAsync(@NonNull SlackTokenPayload slackTokenPayload)
    throws ApiException, ValidationException {
    Request request = this.buildSaveSlackTokenRequest(slackTokenPayload);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<SlackTokenPayload>() {})
    );
  }

  private Request buildSaveSlackTokenRequest(@NonNull SlackTokenPayload slackTokenPayload) throws ValidationException {
    new ViolationAggregator()
      .add(new SlackTokenPayloadValidator("slackTokenPayload").optional().validate(slackTokenPayload))
      .validateAll();
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "channels/slack/tokens"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setJsonContent(slackTokenPayload)
      .build();
  }

  /**
   * Retrieves details of a specific slack token belonging to the authenticated user. Returns information about the token's status, creation date, and any associated metadata. Users can only access their own tokens.
   *
   * @param tokenId String
   * @return response of {@code SlackToken}
   */
  public SlackToken getSlackToken(@NonNull String tokenId) throws ApiException {
    Request request = this.buildGetSlackTokenRequest(tokenId);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<SlackToken>() {});
  }

  /**
   * Retrieves details of a specific slack token belonging to the authenticated user. Returns information about the token's status, creation date, and any associated metadata. Users can only access their own tokens.
   *
   * @param tokenId String
   * @return response of {@code CompletableFuture<SlackToken>}
   */
  public CompletableFuture<SlackToken> getSlackTokenAsync(@NonNull String tokenId) throws ApiException {
    Request request = this.buildGetSlackTokenRequest(tokenId);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<SlackToken>() {})
    );
  }

  private Request buildGetSlackTokenRequest(@NonNull String tokenId) {
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
   * Lists all teams tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.
   *
   * @return response of {@code TeamsTokenCollection}
   */
  public TeamsTokenCollection getTeamsTokens() throws ApiException {
    return this.getTeamsTokens(GetTeamsTokensParameters.builder().build());
  }

  /**
   * Lists all teams tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.
   *
   * @param requestParameters {@link GetTeamsTokensParameters} Request Parameters Object
   * @return response of {@code TeamsTokenCollection}
   */
  public TeamsTokenCollection getTeamsTokens(@NonNull GetTeamsTokensParameters requestParameters) throws ApiException {
    Request request = this.buildGetTeamsTokensRequest(requestParameters);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<TeamsTokenCollection>() {});
  }

  /**
   * Lists all teams tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.
   *
   * @return response of {@code CompletableFuture<TeamsTokenCollection>}
   */
  public CompletableFuture<TeamsTokenCollection> getTeamsTokensAsync() throws ApiException {
    return this.getTeamsTokensAsync(GetTeamsTokensParameters.builder().build());
  }

  /**
   * Lists all teams tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.
   *
   * @param requestParameters {@link GetTeamsTokensParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<TeamsTokenCollection>}
   */
  public CompletableFuture<TeamsTokenCollection> getTeamsTokensAsync(
    @NonNull GetTeamsTokensParameters requestParameters
  ) throws ApiException {
    Request request = this.buildGetTeamsTokensRequest(requestParameters);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<TeamsTokenCollection>() {})
    );
  }

  private Request buildGetTeamsTokensRequest(@NonNull GetTeamsTokensParameters requestParameters) {
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
   * Saves a teams token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.
   *
   * @return response of {@code TeamsTokenPayload}
   */
  public TeamsTokenPayload saveTeamsToken() throws ApiException {
    return this.saveTeamsToken(TeamsTokenPayload.builder().build());
  }

  /**
   * Saves a teams token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.
   *
   * @param teamsTokenPayload {@link TeamsTokenPayload} Request Body
   * @return response of {@code TeamsTokenPayload}
   */
  public TeamsTokenPayload saveTeamsToken(@NonNull TeamsTokenPayload teamsTokenPayload) throws ApiException {
    Request request = this.buildSaveTeamsTokenRequest(teamsTokenPayload);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<TeamsTokenPayload>() {});
  }

  /**
   * Saves a teams token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.
   *
   * @return response of {@code CompletableFuture<TeamsTokenPayload>}
   */
  public CompletableFuture<TeamsTokenPayload> saveTeamsTokenAsync() throws ApiException {
    return this.saveTeamsTokenAsync(TeamsTokenPayload.builder().build());
  }

  /**
   * Saves a teams token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.
   *
   * @param teamsTokenPayload {@link TeamsTokenPayload} Request Body
   * @return response of {@code CompletableFuture<TeamsTokenPayload>}
   */
  public CompletableFuture<TeamsTokenPayload> saveTeamsTokenAsync(@NonNull TeamsTokenPayload teamsTokenPayload)
    throws ApiException {
    Request request = this.buildSaveTeamsTokenRequest(teamsTokenPayload);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<TeamsTokenPayload>() {})
    );
  }

  private Request buildSaveTeamsTokenRequest(@NonNull TeamsTokenPayload teamsTokenPayload) {
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "channels/teams/tokens"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setJsonContent(teamsTokenPayload)
      .build();
  }

  /**
   * Retrieves details of a specific teams token belonging to the authenticated user. Returns information about the token's status, creation date, and any associated metadata. Users can only access their own tokens.
   *
   * @param tokenId String
   * @return response of {@code TeamsToken}
   */
  public TeamsToken getTeamsToken(@NonNull String tokenId) throws ApiException {
    Request request = this.buildGetTeamsTokenRequest(tokenId);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<TeamsToken>() {});
  }

  /**
   * Retrieves details of a specific teams token belonging to the authenticated user. Returns information about the token's status, creation date, and any associated metadata. Users can only access their own tokens.
   *
   * @param tokenId String
   * @return response of {@code CompletableFuture<TeamsToken>}
   */
  public CompletableFuture<TeamsToken> getTeamsTokenAsync(@NonNull String tokenId) throws ApiException {
    Request request = this.buildGetTeamsTokenRequest(tokenId);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<TeamsToken>() {})
    );
  }

  private Request buildGetTeamsTokenRequest(@NonNull String tokenId) {
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
   * Lists all web_push tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.
   *
   * @return response of {@code WebPushTokenCollection}
   */
  public WebPushTokenCollection getWebPushTokens() throws ApiException {
    return this.getWebPushTokens(GetWebPushTokensParameters.builder().build());
  }

  /**
   * Lists all web_push tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.
   *
   * @param requestParameters {@link GetWebPushTokensParameters} Request Parameters Object
   * @return response of {@code WebPushTokenCollection}
   */
  public WebPushTokenCollection getWebPushTokens(@NonNull GetWebPushTokensParameters requestParameters)
    throws ApiException {
    Request request = this.buildGetWebPushTokensRequest(requestParameters);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<WebPushTokenCollection>() {});
  }

  /**
   * Lists all web_push tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.
   *
   * @return response of {@code CompletableFuture<WebPushTokenCollection>}
   */
  public CompletableFuture<WebPushTokenCollection> getWebPushTokensAsync() throws ApiException {
    return this.getWebPushTokensAsync(GetWebPushTokensParameters.builder().build());
  }

  /**
   * Lists all web_push tokens belonging to the authenticated user. Returns a paginated list of tokens, including their status, creation dates, and associated metadata.
   *
   * @param requestParameters {@link GetWebPushTokensParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<WebPushTokenCollection>}
   */
  public CompletableFuture<WebPushTokenCollection> getWebPushTokensAsync(
    @NonNull GetWebPushTokensParameters requestParameters
  ) throws ApiException {
    Request request = this.buildGetWebPushTokensRequest(requestParameters);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<WebPushTokenCollection>() {})
    );
  }

  private Request buildGetWebPushTokensRequest(@NonNull GetWebPushTokensParameters requestParameters) {
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
   * Saves a web_push token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.
   *
   * @return response of {@code WebPushTokenPayload}
   */
  public WebPushTokenPayload saveWebPushToken() throws ApiException {
    return this.saveWebPushToken(WebPushTokenPayload.builder().build());
  }

  /**
   * Saves a web_push token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.
   *
   * @param webPushTokenPayload {@link WebPushTokenPayload} Request Body
   * @return response of {@code WebPushTokenPayload}
   */
  public WebPushTokenPayload saveWebPushToken(@NonNull WebPushTokenPayload webPushTokenPayload) throws ApiException {
    Request request = this.buildSaveWebPushTokenRequest(webPushTokenPayload);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<WebPushTokenPayload>() {});
  }

  /**
   * Saves a web_push token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.
   *
   * @return response of {@code CompletableFuture<WebPushTokenPayload>}
   */
  public CompletableFuture<WebPushTokenPayload> saveWebPushTokenAsync() throws ApiException {
    return this.saveWebPushTokenAsync(WebPushTokenPayload.builder().build());
  }

  /**
   * Saves a web_push token for the authenticated user. This token serves as a credential for accessing channel-specific functionality. Each token is unique to the user and channel combination, allowing for direct communication with the user via the channel.
   *
   * @param webPushTokenPayload {@link WebPushTokenPayload} Request Body
   * @return response of {@code CompletableFuture<WebPushTokenPayload>}
   */
  public CompletableFuture<WebPushTokenPayload> saveWebPushTokenAsync(@NonNull WebPushTokenPayload webPushTokenPayload)
    throws ApiException {
    Request request = this.buildSaveWebPushTokenRequest(webPushTokenPayload);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<WebPushTokenPayload>() {})
    );
  }

  private Request buildSaveWebPushTokenRequest(@NonNull WebPushTokenPayload webPushTokenPayload) {
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "channels/web_push/tokens"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setJsonContent(webPushTokenPayload)
      .build();
  }

  /**
   * Retrieves details of a specific web_push token belonging to the authenticated user. Returns information about the token's status, creation date, and any associated metadata. Users can only access their own tokens.
   *
   * @param tokenId String
   * @return response of {@code WebPushToken}
   */
  public WebPushToken getWebPushToken(@NonNull String tokenId) throws ApiException {
    Request request = this.buildGetWebPushTokenRequest(tokenId);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<WebPushToken>() {});
  }

  /**
   * Retrieves details of a specific web_push token belonging to the authenticated user. Returns information about the token's status, creation date, and any associated metadata. Users can only access their own tokens.
   *
   * @param tokenId String
   * @return response of {@code CompletableFuture<WebPushToken>}
   */
  public CompletableFuture<WebPushToken> getWebPushTokenAsync(@NonNull String tokenId) throws ApiException {
    Request request = this.buildGetWebPushTokenRequest(tokenId);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<WebPushToken>() {})
    );
  }

  private Request buildGetWebPushTokenRequest(@NonNull String tokenId) {
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
