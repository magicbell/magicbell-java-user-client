package com.magicbell.user_client.magicbelljavauserclient.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.magicbell.user_client.magicbelljavauserclient.exceptions.ApiException;
import com.magicbell.user_client.magicbelljavauserclient.http.HttpMethod;
import com.magicbell.user_client.magicbelljavauserclient.http.ModelConverter;
import com.magicbell.user_client.magicbelljavauserclient.http.util.RequestBuilder;
import com.magicbell.user_client.magicbelljavauserclient.models.InboxConfig;
import com.magicbell.user_client.magicbelljavauserclient.models.SlackFinishInstallResponse;
import com.magicbell.user_client.magicbelljavauserclient.models.SlackInstallation;
import com.magicbell.user_client.magicbelljavauserclient.models.SlackStartInstall;
import com.magicbell.user_client.magicbelljavauserclient.models.SlackStartInstallResponseContent;
import com.magicbell.user_client.magicbelljavauserclient.models.TemplatesInstallation;
import com.magicbell.user_client.magicbelljavauserclient.models.WebPushStartInstallationResponse;
import com.magicbell.user_client.magicbelljavauserclient.models.WebPushToken;
import com.magicbell.user_client.magicbelljavauserclient.validation.ViolationAggregator;
import com.magicbell.user_client.magicbelljavauserclient.validation.exceptions.ValidationException;
import com.magicbell.user_client.magicbelljavauserclient.validation.validators.modelValidators.InboxConfigValidator;
import com.magicbell.user_client.magicbelljavauserclient.validation.validators.modelValidators.SlackInstallationValidator;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * IntegrationsService Service
 */
public class IntegrationsService extends BaseService {

  public IntegrationsService(@NonNull OkHttpClient httpClient, String serverUrl) {
    super(httpClient, serverUrl);
  }

  /**
   * Creates a new installation of a inbox integration for a user. This endpoint is used when an integration needs to be set up with user-specific credentials or configuration.
   *
   * @return response of {@code InboxConfig}
   */
  public InboxConfig saveInboxInstallation() throws ApiException, ValidationException {
    return this.saveInboxInstallation(InboxConfig.builder().build());
  }

  /**
   * Creates a new installation of a inbox integration for a user. This endpoint is used when an integration needs to be set up with user-specific credentials or configuration.
   *
   * @param inboxConfig {@link InboxConfig} Request Body
   * @return response of {@code InboxConfig}
   */
  public InboxConfig saveInboxInstallation(@NonNull InboxConfig inboxConfig) throws ApiException, ValidationException {
    Request request = this.buildSaveInboxInstallationRequest(inboxConfig);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<InboxConfig>() {});
  }

  /**
   * Creates a new installation of a inbox integration for a user. This endpoint is used when an integration needs to be set up with user-specific credentials or configuration.
   *
   * @return response of {@code CompletableFuture<InboxConfig>}
   */
  public CompletableFuture<InboxConfig> saveInboxInstallationAsync() throws ApiException, ValidationException {
    return this.saveInboxInstallationAsync(InboxConfig.builder().build());
  }

  /**
   * Creates a new installation of a inbox integration for a user. This endpoint is used when an integration needs to be set up with user-specific credentials or configuration.
   *
   * @param inboxConfig {@link InboxConfig} Request Body
   * @return response of {@code CompletableFuture<InboxConfig>}
   */
  public CompletableFuture<InboxConfig> saveInboxInstallationAsync(@NonNull InboxConfig inboxConfig)
    throws ApiException, ValidationException {
    Request request = this.buildSaveInboxInstallationRequest(inboxConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<InboxConfig>() {})
    );
  }

  private Request buildSaveInboxInstallationRequest(@NonNull InboxConfig inboxConfig) throws ValidationException {
    new ViolationAggregator()
      .add(new InboxConfigValidator("inboxConfig").optional().validate(inboxConfig))
      .validateAll();
    return new RequestBuilder(HttpMethod.POST, this.serverUrl, "integrations/inbox/installations")
      .setJsonContent(inboxConfig)
      .build();
  }

  /**
   * Initiates the installation flow for a inbox integration. This is the first step in a multi-step installation process where user authorization or external service configuration may be required.
   *
   * @return response of {@code InboxConfig}
   */
  public InboxConfig startInboxInstallation() throws ApiException {
    Request request = this.buildStartInboxInstallationRequest();
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<InboxConfig>() {});
  }

  /**
   * Initiates the installation flow for a inbox integration. This is the first step in a multi-step installation process where user authorization or external service configuration may be required.
   *
   * @return response of {@code CompletableFuture<InboxConfig>}
   */
  public CompletableFuture<InboxConfig> startInboxInstallationAsync() throws ApiException {
    Request request = this.buildStartInboxInstallationRequest();
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<InboxConfig>() {})
    );
  }

  private Request buildStartInboxInstallationRequest() {
    return new RequestBuilder(HttpMethod.POST, this.serverUrl, "integrations/inbox/installations/start").build();
  }

  /**
   * Creates a new installation of a slack integration for a user. This endpoint is used when an integration needs to be set up with user-specific credentials or configuration.
   *
   * @return response of {@code SlackInstallation}
   */
  public SlackInstallation saveSlackInstallation() throws ApiException, ValidationException {
    return this.saveSlackInstallation(SlackInstallation.builder().build());
  }

  /**
   * Creates a new installation of a slack integration for a user. This endpoint is used when an integration needs to be set up with user-specific credentials or configuration.
   *
   * @param slackInstallation {@link SlackInstallation} Request Body
   * @return response of {@code SlackInstallation}
   */
  public SlackInstallation saveSlackInstallation(@NonNull SlackInstallation slackInstallation)
    throws ApiException, ValidationException {
    Request request = this.buildSaveSlackInstallationRequest(slackInstallation);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<SlackInstallation>() {});
  }

  /**
   * Creates a new installation of a slack integration for a user. This endpoint is used when an integration needs to be set up with user-specific credentials or configuration.
   *
   * @return response of {@code CompletableFuture<SlackInstallation>}
   */
  public CompletableFuture<SlackInstallation> saveSlackInstallationAsync() throws ApiException, ValidationException {
    return this.saveSlackInstallationAsync(SlackInstallation.builder().build());
  }

  /**
   * Creates a new installation of a slack integration for a user. This endpoint is used when an integration needs to be set up with user-specific credentials or configuration.
   *
   * @param slackInstallation {@link SlackInstallation} Request Body
   * @return response of {@code CompletableFuture<SlackInstallation>}
   */
  public CompletableFuture<SlackInstallation> saveSlackInstallationAsync(@NonNull SlackInstallation slackInstallation)
    throws ApiException, ValidationException {
    Request request = this.buildSaveSlackInstallationRequest(slackInstallation);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<SlackInstallation>() {})
    );
  }

  private Request buildSaveSlackInstallationRequest(@NonNull SlackInstallation slackInstallation)
    throws ValidationException {
    new ViolationAggregator()
      .add(new SlackInstallationValidator("slackInstallation").optional().validate(slackInstallation))
      .validateAll();
    return new RequestBuilder(HttpMethod.POST, this.serverUrl, "integrations/slack/installations")
      .setJsonContent(slackInstallation)
      .build();
  }

  /**
   * Completes the installation flow for a slack integration. This endpoint is typically called after the user has completed any required authorization steps with slack.
   *
   * @return response of {@code SlackInstallation}
   */
  public SlackInstallation finishSlackInstallation() throws ApiException {
    return this.finishSlackInstallation(SlackFinishInstallResponse.builder().build());
  }

  /**
   * Completes the installation flow for a slack integration. This endpoint is typically called after the user has completed any required authorization steps with slack.
   *
   * @param slackFinishInstallResponse {@link SlackFinishInstallResponse} Request Body
   * @return response of {@code SlackInstallation}
   */
  public SlackInstallation finishSlackInstallation(@NonNull SlackFinishInstallResponse slackFinishInstallResponse)
    throws ApiException {
    Request request = this.buildFinishSlackInstallationRequest(slackFinishInstallResponse);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<SlackInstallation>() {});
  }

  /**
   * Completes the installation flow for a slack integration. This endpoint is typically called after the user has completed any required authorization steps with slack.
   *
   * @return response of {@code CompletableFuture<SlackInstallation>}
   */
  public CompletableFuture<SlackInstallation> finishSlackInstallationAsync() throws ApiException {
    return this.finishSlackInstallationAsync(SlackFinishInstallResponse.builder().build());
  }

  /**
   * Completes the installation flow for a slack integration. This endpoint is typically called after the user has completed any required authorization steps with slack.
   *
   * @param slackFinishInstallResponse {@link SlackFinishInstallResponse} Request Body
   * @return response of {@code CompletableFuture<SlackInstallation>}
   */
  public CompletableFuture<SlackInstallation> finishSlackInstallationAsync(
    @NonNull SlackFinishInstallResponse slackFinishInstallResponse
  ) throws ApiException {
    Request request = this.buildFinishSlackInstallationRequest(slackFinishInstallResponse);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<SlackInstallation>() {})
    );
  }

  private Request buildFinishSlackInstallationRequest(@NonNull SlackFinishInstallResponse slackFinishInstallResponse) {
    return new RequestBuilder(HttpMethod.POST, this.serverUrl, "integrations/slack/installations/finish")
      .setJsonContent(slackFinishInstallResponse)
      .build();
  }

  /**
   * Initiates the installation flow for a slack integration. This is the first step in a multi-step installation process where user authorization or external service configuration may be required.
   *
   * @return response of {@code SlackStartInstallResponseContent}
   */
  public SlackStartInstallResponseContent startSlackInstallation() throws ApiException {
    return this.startSlackInstallation(SlackStartInstall.builder().build());
  }

  /**
   * Initiates the installation flow for a slack integration. This is the first step in a multi-step installation process where user authorization or external service configuration may be required.
   *
   * @param slackStartInstall {@link SlackStartInstall} Request Body
   * @return response of {@code SlackStartInstallResponseContent}
   */
  public SlackStartInstallResponseContent startSlackInstallation(@NonNull SlackStartInstall slackStartInstall)
    throws ApiException {
    Request request = this.buildStartSlackInstallationRequest(slackStartInstall);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<SlackStartInstallResponseContent>() {});
  }

  /**
   * Initiates the installation flow for a slack integration. This is the first step in a multi-step installation process where user authorization or external service configuration may be required.
   *
   * @return response of {@code CompletableFuture<SlackStartInstallResponseContent>}
   */
  public CompletableFuture<SlackStartInstallResponseContent> startSlackInstallationAsync() throws ApiException {
    return this.startSlackInstallationAsync(SlackStartInstall.builder().build());
  }

  /**
   * Initiates the installation flow for a slack integration. This is the first step in a multi-step installation process where user authorization or external service configuration may be required.
   *
   * @param slackStartInstall {@link SlackStartInstall} Request Body
   * @return response of {@code CompletableFuture<SlackStartInstallResponseContent>}
   */
  public CompletableFuture<SlackStartInstallResponseContent> startSlackInstallationAsync(
    @NonNull SlackStartInstall slackStartInstall
  ) throws ApiException {
    Request request = this.buildStartSlackInstallationRequest(slackStartInstall);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<SlackStartInstallResponseContent>() {})
    );
  }

  private Request buildStartSlackInstallationRequest(@NonNull SlackStartInstall slackStartInstall) {
    return new RequestBuilder(HttpMethod.POST, this.serverUrl, "integrations/slack/installations/start")
      .setJsonContent(slackStartInstall)
      .build();
  }

  /**
   * Creates a new installation of a templates integration for a user. This endpoint is used when an integration needs to be set up with user-specific credentials or configuration.
   *
   * @return response of {@code TemplatesInstallation}
   */
  public TemplatesInstallation saveTemplatesInstallation() throws ApiException {
    return this.saveTemplatesInstallation(TemplatesInstallation.builder().build());
  }

  /**
   * Creates a new installation of a templates integration for a user. This endpoint is used when an integration needs to be set up with user-specific credentials or configuration.
   *
   * @param templatesInstallation {@link TemplatesInstallation} Request Body
   * @return response of {@code TemplatesInstallation}
   */
  public TemplatesInstallation saveTemplatesInstallation(@NonNull TemplatesInstallation templatesInstallation)
    throws ApiException {
    Request request = this.buildSaveTemplatesInstallationRequest(templatesInstallation);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<TemplatesInstallation>() {});
  }

  /**
   * Creates a new installation of a templates integration for a user. This endpoint is used when an integration needs to be set up with user-specific credentials or configuration.
   *
   * @return response of {@code CompletableFuture<TemplatesInstallation>}
   */
  public CompletableFuture<TemplatesInstallation> saveTemplatesInstallationAsync() throws ApiException {
    return this.saveTemplatesInstallationAsync(TemplatesInstallation.builder().build());
  }

  /**
   * Creates a new installation of a templates integration for a user. This endpoint is used when an integration needs to be set up with user-specific credentials or configuration.
   *
   * @param templatesInstallation {@link TemplatesInstallation} Request Body
   * @return response of {@code CompletableFuture<TemplatesInstallation>}
   */
  public CompletableFuture<TemplatesInstallation> saveTemplatesInstallationAsync(
    @NonNull TemplatesInstallation templatesInstallation
  ) throws ApiException {
    Request request = this.buildSaveTemplatesInstallationRequest(templatesInstallation);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<TemplatesInstallation>() {})
    );
  }

  private Request buildSaveTemplatesInstallationRequest(@NonNull TemplatesInstallation templatesInstallation) {
    return new RequestBuilder(HttpMethod.POST, this.serverUrl, "integrations/templates/installations")
      .setJsonContent(templatesInstallation)
      .build();
  }

  /**
   * Creates a new installation of a web_push integration for a user. This endpoint is used when an integration needs to be set up with user-specific credentials or configuration.
   *
   * @return response of {@code WebPushToken}
   */
  public WebPushToken saveWebPushInstallation() throws ApiException {
    return this.saveWebPushInstallation(WebPushToken.builder().build());
  }

  /**
   * Creates a new installation of a web_push integration for a user. This endpoint is used when an integration needs to be set up with user-specific credentials or configuration.
   *
   * @param webPushToken {@link WebPushToken} Request Body
   * @return response of {@code WebPushToken}
   */
  public WebPushToken saveWebPushInstallation(@NonNull WebPushToken webPushToken) throws ApiException {
    Request request = this.buildSaveWebPushInstallationRequest(webPushToken);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<WebPushToken>() {});
  }

  /**
   * Creates a new installation of a web_push integration for a user. This endpoint is used when an integration needs to be set up with user-specific credentials or configuration.
   *
   * @return response of {@code CompletableFuture<WebPushToken>}
   */
  public CompletableFuture<WebPushToken> saveWebPushInstallationAsync() throws ApiException {
    return this.saveWebPushInstallationAsync(WebPushToken.builder().build());
  }

  /**
   * Creates a new installation of a web_push integration for a user. This endpoint is used when an integration needs to be set up with user-specific credentials or configuration.
   *
   * @param webPushToken {@link WebPushToken} Request Body
   * @return response of {@code CompletableFuture<WebPushToken>}
   */
  public CompletableFuture<WebPushToken> saveWebPushInstallationAsync(@NonNull WebPushToken webPushToken)
    throws ApiException {
    Request request = this.buildSaveWebPushInstallationRequest(webPushToken);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<WebPushToken>() {})
    );
  }

  private Request buildSaveWebPushInstallationRequest(@NonNull WebPushToken webPushToken) {
    return new RequestBuilder(HttpMethod.POST, this.serverUrl, "integrations/web_push/installations")
      .setJsonContent(webPushToken)
      .build();
  }

  /**
   * Initiates the installation flow for a web_push integration. This is the first step in a multi-step installation process where user authorization or external service configuration may be required.
   *
   * @return response of {@code WebPushStartInstallationResponse}
   */
  public WebPushStartInstallationResponse startWebPushInstallation() throws ApiException {
    Request request = this.buildStartWebPushInstallationRequest();
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<WebPushStartInstallationResponse>() {});
  }

  /**
   * Initiates the installation flow for a web_push integration. This is the first step in a multi-step installation process where user authorization or external service configuration may be required.
   *
   * @return response of {@code CompletableFuture<WebPushStartInstallationResponse>}
   */
  public CompletableFuture<WebPushStartInstallationResponse> startWebPushInstallationAsync() throws ApiException {
    Request request = this.buildStartWebPushInstallationRequest();
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<WebPushStartInstallationResponse>() {})
    );
  }

  private Request buildStartWebPushInstallationRequest() {
    return new RequestBuilder(HttpMethod.POST, this.serverUrl, "integrations/web_push/installations/start").build();
  }
}
