package com.magicbell.user_client.magicbelljavauserclient.validation.validators.modelValidators;

import com.magicbell.user_client.magicbelljavauserclient.models.SlackToken;
import com.magicbell.user_client.magicbelljavauserclient.validation.Violation;
import com.magicbell.user_client.magicbelljavauserclient.validation.ViolationAggregator;

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
