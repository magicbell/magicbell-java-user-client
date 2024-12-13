package com.magicbell.client.magicbelljavaclient.validation.validators.modelValidators;

import com.magicbell.client.magicbelljavaclient.models.SlackToken;
import com.magicbell.client.magicbelljavaclient.validation.Violation;
import com.magicbell.client.magicbelljavaclient.validation.ViolationAggregator;

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
