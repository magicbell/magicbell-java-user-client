package com.magicbell.magicbelluserclient.services;

import com.magicbell.magicbelluserclient.config.MagicbellUserClientConfig;
import com.magicbell.magicbelluserclient.exceptions.ApiException;
import com.magicbell.magicbelluserclient.http.Environment;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

public class BaseService {

  protected OkHttpClient httpClient;
  protected MagicbellUserClientConfig config;

  public BaseService(OkHttpClient httpClient, MagicbellUserClientConfig config) {
    this.httpClient = httpClient;
    this.config = config;
  }

  public void setBaseUrl(String baseUrl) {
    this.config.setBaseUrl(baseUrl);
  }

  public void setEnvironment(Environment environment) {
    this.config.setEnvironment(environment);
  }

  protected Response execute(Request request) throws ApiException {
    Response response;
    try {
      response = this.httpClient.newCall(request).execute();
    } catch (IOException e) {
      throw new ApiException(e.getMessage());
    }
    if (response.isSuccessful()) {
      return response;
    } else {
      throw new ApiException(response.code());
    }
  }

  protected CompletableFuture<Response> executeAsync(Request request) {
    CompletableFuture<Response> future = new CompletableFuture<>();
    this.httpClient.newCall(request).enqueue(
        new Callback() {
          @Override
          public void onResponse(@NotNull Call call, @NotNull Response response) {
            if (!response.isSuccessful()) {
              ApiException apiException = new ApiException(response.code());
              future.completeExceptionally(apiException);
              return;
            }

            future.complete(response);
          }

          @Override
          public void onFailure(@NotNull Call call, @NotNull IOException e) {
            ApiException apiException = new ApiException(e.getMessage());
            future.completeExceptionally(apiException);
          }
        }
      );
    return future;
  }
}
