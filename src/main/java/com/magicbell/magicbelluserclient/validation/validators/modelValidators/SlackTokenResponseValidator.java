package com.magicbell.magicbelluserclient.validation.validators.modelValidators;

import com.magicbell.magicbelluserclient.models.SlackTokenResponse;
import com.magicbell.magicbelluserclient.validation.Violation;
import com.magicbell.magicbelluserclient.validation.ViolationAggregator;

public class SlackTokenResponseValidator extends AbstractModelValidator<SlackTokenResponse> {

  public SlackTokenResponseValidator(String fieldName) {
    super(fieldName);
  }

  public SlackTokenResponseValidator() {}

  @Override
  protected Violation[] validateModel(SlackTokenResponse slackTokenResponse) {
    return new ViolationAggregator()
      .add(new SlackTokenResponseWebhookValidator("webhook").optional().validate(slackTokenResponse.getWebhook()))
      .aggregate();
  }
}
