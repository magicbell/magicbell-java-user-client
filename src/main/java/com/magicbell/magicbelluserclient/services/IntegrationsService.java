package com.magicbell.magicbelluserclient.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.exceptions.ApiError;
import com.magicbell.magicbelluserclient.http.Environment;
import com.magicbell.magicbelluserclient.http.HttpMethod;
import com.magicbell.magicbelluserclient.http.ModelConverter;
import com.magicbell.magicbelluserclient.http.util.RequestBuilder;
import com.magicbell.magicbelluserclient.models.InboxConfigPayload;
import com.magicbell.magicbelluserclient.models.SlackFinishInstallResponse;
import com.magicbell.magicbelluserclient.models.SlackInstallation;
import com.magicbell.magicbelluserclient.models.SlackStartInstall;
import com.magicbell.magicbelluserclient.models.SlackStartInstallResponseContent;
import com.magicbell.magicbelluserclient.models.WebPushStartInstallationResponse;
import com.magicbell.magicbelluserclient.models.WebPushTokenPayload;
import com.magicbell.magicbelluserclient.validation.ViolationAggregator;
import com.magicbell.magicbelluserclient.validation.exceptions.ValidationException;
import com.magicbell.magicbelluserclient.validation.validators.modelValidators.InboxConfigPayloadValidator;
import com.magicbell.magicbelluserclient.validation.validators.modelValidators.SlackInstallationValidator;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * IntegrationsService Service
 */
public class IntegrationsService extends BaseService {

  /**
   * Constructs a new instance of IntegrationsService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public IntegrationsService(@NonNull OkHttpClient httpClient, MagicbellUserClientConfig config) {
    super(httpClient, config);
  }

  /**
   * Save an Inbox installation
   *
   * @return response of {@code InboxConfigPayload}
   */
  public InboxConfigPayload saveInboxInstallation() throws ApiError, ValidationException {
    return this.saveInboxInstallation(InboxConfigPayload.builder().build());
  }

  /**
   * Save an Inbox installation
   *
   * @param inboxConfigPayload {@link InboxConfigPayload} Request Body
   * @return response of {@code InboxConfigPayload}
   */
  public InboxConfigPayload saveInboxInstallation(@NonNull InboxConfigPayload inboxConfigPayload)
    throws ApiError, ValidationException {
    Request request = this.buildSaveInboxInstallationRequest(inboxConfigPayload);
    Response response = this.execute(request);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<InboxConfigPayload>() {});
  }

  /**
   * Save an Inbox installation
   *
   * @return response of {@code CompletableFuture<InboxConfigPayload>}
   */
  public CompletableFuture<InboxConfigPayload> saveInboxInstallationAsync() throws ApiError, ValidationException {
    return this.saveInboxInstallationAsync(InboxConfigPayload.builder().build());
  }

  /**
   * Save an Inbox installation
   *
   * @param inboxConfigPayload {@link InboxConfigPayload} Request Body
   * @return response of {@code CompletableFuture<InboxConfigPayload>}
   */
  public CompletableFuture<InboxConfigPayload> saveInboxInstallationAsync(
    @NonNull InboxConfigPayload inboxConfigPayload
  ) throws ApiError, ValidationException {
    Request request = this.buildSaveInboxInstallationRequest(inboxConfigPayload);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<InboxConfigPayload>() {});
    });
  }

  private Request buildSaveInboxInstallationRequest(@NonNull InboxConfigPayload inboxConfigPayload)
    throws ValidationException {
    new ViolationAggregator()
      .add(new InboxConfigPayloadValidator("inboxConfigPayload").optional().validate(inboxConfigPayload))
      .validateAll();
    return new RequestBuilder(
      HttpMethod.PUT,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "integrations/inbox/installations"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setJsonContent(inboxConfigPayload)
      .build();
  }

  /**
   * Start an Inbox installation
   *
   * @return response of {@code InboxConfigPayload}
   */
  public InboxConfigPayload startInboxInstallation() throws ApiError {
    Request request = this.buildStartInboxInstallationRequest();
    Response response = this.execute(request);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<InboxConfigPayload>() {});
  }

  /**
   * Start an Inbox installation
   *
   * @return response of {@code CompletableFuture<InboxConfigPayload>}
   */
  public CompletableFuture<InboxConfigPayload> startInboxInstallationAsync() throws ApiError {
    Request request = this.buildStartInboxInstallationRequest();
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<InboxConfigPayload>() {});
    });
  }

  private Request buildStartInboxInstallationRequest() {
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "integrations/inbox/installations/start"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .build();
  }

  /**
   * Save a MagicBell SlackBot installation
   *
   * @return response of {@code SlackInstallation}
   */
  public SlackInstallation saveMagicbellSlackbotInstallation() throws ApiError, ValidationException {
    return this.saveMagicbellSlackbotInstallation(SlackInstallation.builder().build());
  }

  /**
   * Save a MagicBell SlackBot installation
   *
   * @param slackInstallation {@link SlackInstallation} Request Body
   * @return response of {@code SlackInstallation}
   */
  public SlackInstallation saveMagicbellSlackbotInstallation(@NonNull SlackInstallation slackInstallation)
    throws ApiError, ValidationException {
    Request request = this.buildSaveMagicbellSlackbotInstallationRequest(slackInstallation);
    Response response = this.execute(request);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<SlackInstallation>() {});
  }

  /**
   * Save a MagicBell SlackBot installation
   *
   * @return response of {@code CompletableFuture<SlackInstallation>}
   */
  public CompletableFuture<SlackInstallation> saveMagicbellSlackbotInstallationAsync()
    throws ApiError, ValidationException {
    return this.saveMagicbellSlackbotInstallationAsync(SlackInstallation.builder().build());
  }

  /**
   * Save a MagicBell SlackBot installation
   *
   * @param slackInstallation {@link SlackInstallation} Request Body
   * @return response of {@code CompletableFuture<SlackInstallation>}
   */
  public CompletableFuture<SlackInstallation> saveMagicbellSlackbotInstallationAsync(
    @NonNull SlackInstallation slackInstallation
  ) throws ApiError, ValidationException {
    Request request = this.buildSaveMagicbellSlackbotInstallationRequest(slackInstallation);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<SlackInstallation>() {});
    });
  }

  private Request buildSaveMagicbellSlackbotInstallationRequest(@NonNull SlackInstallation slackInstallation)
    throws ValidationException {
    new ViolationAggregator()
      .add(new SlackInstallationValidator("slackInstallation").optional().validate(slackInstallation))
      .validateAll();
    return new RequestBuilder(
      HttpMethod.PUT,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "integrations/magicbell_slackbot/installations"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setJsonContent(slackInstallation)
      .build();
  }

  /**
   * Finish a MagicBell SlackBot installation
   *
   * @return response of {@code SlackInstallation}
   */
  public SlackInstallation finishMagicbellSlackbotInstallation() throws ApiError {
    return this.finishMagicbellSlackbotInstallation(SlackFinishInstallResponse.builder().build());
  }

  /**
   * Finish a MagicBell SlackBot installation
   *
   * @param slackFinishInstallResponse {@link SlackFinishInstallResponse} Request Body
   * @return response of {@code SlackInstallation}
   */
  public SlackInstallation finishMagicbellSlackbotInstallation(
    @NonNull SlackFinishInstallResponse slackFinishInstallResponse
  ) throws ApiError {
    Request request = this.buildFinishMagicbellSlackbotInstallationRequest(slackFinishInstallResponse);
    Response response = this.execute(request);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<SlackInstallation>() {});
  }

  /**
   * Finish a MagicBell SlackBot installation
   *
   * @return response of {@code CompletableFuture<SlackInstallation>}
   */
  public CompletableFuture<SlackInstallation> finishMagicbellSlackbotInstallationAsync() throws ApiError {
    return this.finishMagicbellSlackbotInstallationAsync(SlackFinishInstallResponse.builder().build());
  }

  /**
   * Finish a MagicBell SlackBot installation
   *
   * @param slackFinishInstallResponse {@link SlackFinishInstallResponse} Request Body
   * @return response of {@code CompletableFuture<SlackInstallation>}
   */
  public CompletableFuture<SlackInstallation> finishMagicbellSlackbotInstallationAsync(
    @NonNull SlackFinishInstallResponse slackFinishInstallResponse
  ) throws ApiError {
    Request request = this.buildFinishMagicbellSlackbotInstallationRequest(slackFinishInstallResponse);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<SlackInstallation>() {});
    });
  }

  private Request buildFinishMagicbellSlackbotInstallationRequest(
    @NonNull SlackFinishInstallResponse slackFinishInstallResponse
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "integrations/magicbell_slackbot/installations/finish"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setJsonContent(slackFinishInstallResponse)
      .build();
  }

  /**
   * Start a MagicBell SlackBot installation
   *
   * @return response of {@code SlackStartInstallResponseContent}
   */
  public SlackStartInstallResponseContent startMagicbellSlackbotInstallation() throws ApiError {
    return this.startMagicbellSlackbotInstallation(SlackStartInstall.builder().build());
  }

  /**
   * Start a MagicBell SlackBot installation
   *
   * @param slackStartInstall {@link SlackStartInstall} Request Body
   * @return response of {@code SlackStartInstallResponseContent}
   */
  public SlackStartInstallResponseContent startMagicbellSlackbotInstallation(
    @NonNull SlackStartInstall slackStartInstall
  ) throws ApiError {
    Request request = this.buildStartMagicbellSlackbotInstallationRequest(slackStartInstall);
    Response response = this.execute(request);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<SlackStartInstallResponseContent>() {});
  }

  /**
   * Start a MagicBell SlackBot installation
   *
   * @return response of {@code CompletableFuture<SlackStartInstallResponseContent>}
   */
  public CompletableFuture<SlackStartInstallResponseContent> startMagicbellSlackbotInstallationAsync() throws ApiError {
    return this.startMagicbellSlackbotInstallationAsync(SlackStartInstall.builder().build());
  }

  /**
   * Start a MagicBell SlackBot installation
   *
   * @param slackStartInstall {@link SlackStartInstall} Request Body
   * @return response of {@code CompletableFuture<SlackStartInstallResponseContent>}
   */
  public CompletableFuture<SlackStartInstallResponseContent> startMagicbellSlackbotInstallationAsync(
    @NonNull SlackStartInstall slackStartInstall
  ) throws ApiError {
    Request request = this.buildStartMagicbellSlackbotInstallationRequest(slackStartInstall);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<SlackStartInstallResponseContent>() {});
    });
  }

  private Request buildStartMagicbellSlackbotInstallationRequest(@NonNull SlackStartInstall slackStartInstall) {
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "integrations/magicbell_slackbot/installations/start"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setJsonContent(slackStartInstall)
      .build();
  }

  /**
   * Save a Slack installation
   *
   * @return response of {@code SlackInstallation}
   */
  public SlackInstallation saveSlackInstallation() throws ApiError, ValidationException {
    return this.saveSlackInstallation(SlackInstallation.builder().build());
  }

  /**
   * Save a Slack installation
   *
   * @param slackInstallation {@link SlackInstallation} Request Body
   * @return response of {@code SlackInstallation}
   */
  public SlackInstallation saveSlackInstallation(@NonNull SlackInstallation slackInstallation)
    throws ApiError, ValidationException {
    Request request = this.buildSaveSlackInstallationRequest(slackInstallation);
    Response response = this.execute(request);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<SlackInstallation>() {});
  }

  /**
   * Save a Slack installation
   *
   * @return response of {@code CompletableFuture<SlackInstallation>}
   */
  public CompletableFuture<SlackInstallation> saveSlackInstallationAsync() throws ApiError, ValidationException {
    return this.saveSlackInstallationAsync(SlackInstallation.builder().build());
  }

  /**
   * Save a Slack installation
   *
   * @param slackInstallation {@link SlackInstallation} Request Body
   * @return response of {@code CompletableFuture<SlackInstallation>}
   */
  public CompletableFuture<SlackInstallation> saveSlackInstallationAsync(@NonNull SlackInstallation slackInstallation)
    throws ApiError, ValidationException {
    Request request = this.buildSaveSlackInstallationRequest(slackInstallation);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<SlackInstallation>() {});
    });
  }

  private Request buildSaveSlackInstallationRequest(@NonNull SlackInstallation slackInstallation)
    throws ValidationException {
    new ViolationAggregator()
      .add(new SlackInstallationValidator("slackInstallation").optional().validate(slackInstallation))
      .validateAll();
    return new RequestBuilder(
      HttpMethod.PUT,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "integrations/slack/installations"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setJsonContent(slackInstallation)
      .build();
  }

  /**
   * Finish a Slack installation
   *
   * @return response of {@code SlackInstallation}
   */
  public SlackInstallation finishSlackInstallation() throws ApiError {
    return this.finishSlackInstallation(SlackFinishInstallResponse.builder().build());
  }

  /**
   * Finish a Slack installation
   *
   * @param slackFinishInstallResponse {@link SlackFinishInstallResponse} Request Body
   * @return response of {@code SlackInstallation}
   */
  public SlackInstallation finishSlackInstallation(@NonNull SlackFinishInstallResponse slackFinishInstallResponse)
    throws ApiError {
    Request request = this.buildFinishSlackInstallationRequest(slackFinishInstallResponse);
    Response response = this.execute(request);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<SlackInstallation>() {});
  }

  /**
   * Finish a Slack installation
   *
   * @return response of {@code CompletableFuture<SlackInstallation>}
   */
  public CompletableFuture<SlackInstallation> finishSlackInstallationAsync() throws ApiError {
    return this.finishSlackInstallationAsync(SlackFinishInstallResponse.builder().build());
  }

  /**
   * Finish a Slack installation
   *
   * @param slackFinishInstallResponse {@link SlackFinishInstallResponse} Request Body
   * @return response of {@code CompletableFuture<SlackInstallation>}
   */
  public CompletableFuture<SlackInstallation> finishSlackInstallationAsync(
    @NonNull SlackFinishInstallResponse slackFinishInstallResponse
  ) throws ApiError {
    Request request = this.buildFinishSlackInstallationRequest(slackFinishInstallResponse);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<SlackInstallation>() {});
    });
  }

  private Request buildFinishSlackInstallationRequest(@NonNull SlackFinishInstallResponse slackFinishInstallResponse) {
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "integrations/slack/installations/finish"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setJsonContent(slackFinishInstallResponse)
      .build();
  }

  /**
   * Start a Slack installation
   *
   * @return response of {@code SlackStartInstallResponseContent}
   */
  public SlackStartInstallResponseContent startSlackInstallation() throws ApiError {
    return this.startSlackInstallation(SlackStartInstall.builder().build());
  }

  /**
   * Start a Slack installation
   *
   * @param slackStartInstall {@link SlackStartInstall} Request Body
   * @return response of {@code SlackStartInstallResponseContent}
   */
  public SlackStartInstallResponseContent startSlackInstallation(@NonNull SlackStartInstall slackStartInstall)
    throws ApiError {
    Request request = this.buildStartSlackInstallationRequest(slackStartInstall);
    Response response = this.execute(request);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<SlackStartInstallResponseContent>() {});
  }

  /**
   * Start a Slack installation
   *
   * @return response of {@code CompletableFuture<SlackStartInstallResponseContent>}
   */
  public CompletableFuture<SlackStartInstallResponseContent> startSlackInstallationAsync() throws ApiError {
    return this.startSlackInstallationAsync(SlackStartInstall.builder().build());
  }

  /**
   * Start a Slack installation
   *
   * @param slackStartInstall {@link SlackStartInstall} Request Body
   * @return response of {@code CompletableFuture<SlackStartInstallResponseContent>}
   */
  public CompletableFuture<SlackStartInstallResponseContent> startSlackInstallationAsync(
    @NonNull SlackStartInstall slackStartInstall
  ) throws ApiError {
    Request request = this.buildStartSlackInstallationRequest(slackStartInstall);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<SlackStartInstallResponseContent>() {});
    });
  }

  private Request buildStartSlackInstallationRequest(@NonNull SlackStartInstall slackStartInstall) {
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "integrations/slack/installations/start"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setJsonContent(slackStartInstall)
      .build();
  }

  /**
   * Save a Web Push installation
   *
   * @return response of {@code WebPushTokenPayload}
   */
  public WebPushTokenPayload saveWebPushInstallation() throws ApiError {
    return this.saveWebPushInstallation(WebPushTokenPayload.builder().build());
  }

  /**
   * Save a Web Push installation
   *
   * @param webPushTokenPayload {@link WebPushTokenPayload} Request Body
   * @return response of {@code WebPushTokenPayload}
   */
  public WebPushTokenPayload saveWebPushInstallation(@NonNull WebPushTokenPayload webPushTokenPayload) throws ApiError {
    Request request = this.buildSaveWebPushInstallationRequest(webPushTokenPayload);
    Response response = this.execute(request);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<WebPushTokenPayload>() {});
  }

  /**
   * Save a Web Push installation
   *
   * @return response of {@code CompletableFuture<WebPushTokenPayload>}
   */
  public CompletableFuture<WebPushTokenPayload> saveWebPushInstallationAsync() throws ApiError {
    return this.saveWebPushInstallationAsync(WebPushTokenPayload.builder().build());
  }

  /**
   * Save a Web Push installation
   *
   * @param webPushTokenPayload {@link WebPushTokenPayload} Request Body
   * @return response of {@code CompletableFuture<WebPushTokenPayload>}
   */
  public CompletableFuture<WebPushTokenPayload> saveWebPushInstallationAsync(
    @NonNull WebPushTokenPayload webPushTokenPayload
  ) throws ApiError {
    Request request = this.buildSaveWebPushInstallationRequest(webPushTokenPayload);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<WebPushTokenPayload>() {});
    });
  }

  private Request buildSaveWebPushInstallationRequest(@NonNull WebPushTokenPayload webPushTokenPayload) {
    return new RequestBuilder(
      HttpMethod.PUT,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "integrations/web_push/installations"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setJsonContent(webPushTokenPayload)
      .build();
  }

  /**
   * Start a Web Push installation
   *
   * @return response of {@code WebPushStartInstallationResponse}
   */
  public WebPushStartInstallationResponse startWebPushInstallation() throws ApiError {
    Request request = this.buildStartWebPushInstallationRequest();
    Response response = this.execute(request);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<WebPushStartInstallationResponse>() {});
  }

  /**
   * Start a Web Push installation
   *
   * @return response of {@code CompletableFuture<WebPushStartInstallationResponse>}
   */
  public CompletableFuture<WebPushStartInstallationResponse> startWebPushInstallationAsync() throws ApiError {
    Request request = this.buildStartWebPushInstallationRequest();
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<WebPushStartInstallationResponse>() {});
    });
  }

  private Request buildStartWebPushInstallationRequest() {
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "integrations/web_push/installations/start"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .build();
  }
}
