package com.magicbell.magicbelluserclient.validation.validators.modelValidators;

import com.magicbell.magicbelluserclient.models.SlackToken;
import com.magicbell.magicbelluserclient.validation.Violation;
import com.magicbell.magicbelluserclient.validation.ViolationAggregator;

public class SlackTokenValidator extends AbstractModelValidator<SlackToken> {

  public SlackTokenValidator(String fieldName) {
    super(fieldName);
  }

  public SlackTokenValidator() {}

  @Override
  protected Violation[] validateModel(SlackToken slackToken) {
    return new ViolationAggregator()
      .add(new SlackTokenWebhookValidator("webhook").optional().validate(slackToken.getWebhook()))
      .aggregate();
  }
}
