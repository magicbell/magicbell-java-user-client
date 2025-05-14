package com.magicbell.magicbelluserclient.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.exceptions.ApiException;
import com.magicbell.magicbelluserclient.http.Environment;
import com.magicbell.magicbelluserclient.http.HttpMethod;
import com.magicbell.magicbelluserclient.http.ModelConverter;
import com.magicbell.magicbelluserclient.http.util.RequestBuilder;
import com.magicbell.magicbelluserclient.models.InboxConfigPayload;
import com.magicbell.magicbelluserclient.models.SlackFinishInstallResponse;
import com.magicbell.magicbelluserclient.models.SlackInstallation;
import com.magicbell.magicbelluserclient.models.SlackStartInstall;
import com.magicbell.magicbelluserclient.models.SlackStartInstallResponseContent;
import com.magicbell.magicbelluserclient.models.TemplatesInstallation;
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

  public IntegrationsService(@NonNull OkHttpClient httpClient, MagicbellUserClientConfig config) {
    super(httpClient, config);
  }

  /**
   * Creates a new installation of a inbox integration for a user. This endpoint is used when an integration needs to be set up with user-specific credentials or configuration.
   *
   * @return response of {@code InboxConfigPayload}
   */
  public InboxConfigPayload saveInboxInstallation() throws ApiException, ValidationException {
    return this.saveInboxInstallation(InboxConfigPayload.builder().build());
  }

  /**
   * Creates a new installation of a inbox integration for a user. This endpoint is used when an integration needs to be set up with user-specific credentials or configuration.
   *
   * @param inboxConfigPayload {@link InboxConfigPayload} Request Body
   * @return response of {@code InboxConfigPayload}
   */
  public InboxConfigPayload saveInboxInstallation(@NonNull InboxConfigPayload inboxConfigPayload)
    throws ApiException, ValidationException {
    Request request = this.buildSaveInboxInstallationRequest(inboxConfigPayload);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<InboxConfigPayload>() {});
  }

  /**
   * Creates a new installation of a inbox integration for a user. This endpoint is used when an integration needs to be set up with user-specific credentials or configuration.
   *
   * @return response of {@code CompletableFuture<InboxConfigPayload>}
   */
  public CompletableFuture<InboxConfigPayload> saveInboxInstallationAsync() throws ApiException, ValidationException {
    return this.saveInboxInstallationAsync(InboxConfigPayload.builder().build());
  }

  /**
   * Creates a new installation of a inbox integration for a user. This endpoint is used when an integration needs to be set up with user-specific credentials or configuration.
   *
   * @param inboxConfigPayload {@link InboxConfigPayload} Request Body
   * @return response of {@code CompletableFuture<InboxConfigPayload>}
   */
  public CompletableFuture<InboxConfigPayload> saveInboxInstallationAsync(
    @NonNull InboxConfigPayload inboxConfigPayload
  ) throws ApiException, ValidationException {
    Request request = this.buildSaveInboxInstallationRequest(inboxConfigPayload);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<InboxConfigPayload>() {})
    );
  }

  private Request buildSaveInboxInstallationRequest(@NonNull InboxConfigPayload inboxConfigPayload)
    throws ValidationException {
    new ViolationAggregator()
      .add(new InboxConfigPayloadValidator("inboxConfigPayload").optional().validate(inboxConfigPayload))
      .validateAll();
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "integrations/inbox/installations"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setJsonContent(inboxConfigPayload)
      .build();
  }

  /**
   * Initiates the installation flow for a inbox integration. This is the first step in a multi-step installation process where user authorization or external service configuration may be required.
   *
   * @return response of {@code InboxConfigPayload}
   */
  public InboxConfigPayload startInboxInstallation() throws ApiException {
    Request request = this.buildStartInboxInstallationRequest();
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<InboxConfigPayload>() {});
  }

  /**
   * Initiates the installation flow for a inbox integration. This is the first step in a multi-step installation process where user authorization or external service configuration may be required.
   *
   * @return response of {@code CompletableFuture<InboxConfigPayload>}
   */
  public CompletableFuture<InboxConfigPayload> startInboxInstallationAsync() throws ApiException {
    Request request = this.buildStartInboxInstallationRequest();
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<InboxConfigPayload>() {})
    );
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
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "integrations/slack/installations"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
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
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "integrations/templates/installations"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setJsonContent(templatesInstallation)
      .build();
  }

  /**
   * Creates a new installation of a web_push integration for a user. This endpoint is used when an integration needs to be set up with user-specific credentials or configuration.
   *
   * @return response of {@code WebPushTokenPayload}
   */
  public WebPushTokenPayload saveWebPushInstallation() throws ApiException {
    return this.saveWebPushInstallation(WebPushTokenPayload.builder().build());
  }

  /**
   * Creates a new installation of a web_push integration for a user. This endpoint is used when an integration needs to be set up with user-specific credentials or configuration.
   *
   * @param webPushTokenPayload {@link WebPushTokenPayload} Request Body
   * @return response of {@code WebPushTokenPayload}
   */
  public WebPushTokenPayload saveWebPushInstallation(@NonNull WebPushTokenPayload webPushTokenPayload)
    throws ApiException {
    Request request = this.buildSaveWebPushInstallationRequest(webPushTokenPayload);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<WebPushTokenPayload>() {});
  }

  /**
   * Creates a new installation of a web_push integration for a user. This endpoint is used when an integration needs to be set up with user-specific credentials or configuration.
   *
   * @return response of {@code CompletableFuture<WebPushTokenPayload>}
   */
  public CompletableFuture<WebPushTokenPayload> saveWebPushInstallationAsync() throws ApiException {
    return this.saveWebPushInstallationAsync(WebPushTokenPayload.builder().build());
  }

  /**
   * Creates a new installation of a web_push integration for a user. This endpoint is used when an integration needs to be set up with user-specific credentials or configuration.
   *
   * @param webPushTokenPayload {@link WebPushTokenPayload} Request Body
   * @return response of {@code CompletableFuture<WebPushTokenPayload>}
   */
  public CompletableFuture<WebPushTokenPayload> saveWebPushInstallationAsync(
    @NonNull WebPushTokenPayload webPushTokenPayload
  ) throws ApiException {
    Request request = this.buildSaveWebPushInstallationRequest(webPushTokenPayload);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<WebPushTokenPayload>() {})
    );
  }

  private Request buildSaveWebPushInstallationRequest(@NonNull WebPushTokenPayload webPushTokenPayload) {
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "integrations/web_push/installations"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setJsonContent(webPushTokenPayload)
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
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "integrations/web_push/installations/start"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .build();
  }
}
