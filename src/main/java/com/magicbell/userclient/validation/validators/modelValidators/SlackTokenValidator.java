package com.magicbell.userclient.validation.validators.modelValidators;

import com.magicbell.userclient.models.SlackToken;
import com.magicbell.userclient.validation.Violation;
import com.magicbell.userclient.validation.ViolationAggregator;

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
