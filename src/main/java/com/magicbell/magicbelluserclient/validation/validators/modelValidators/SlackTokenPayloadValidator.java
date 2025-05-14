package com.magicbell.magicbelluserclient.validation.validators.modelValidators;

import com.magicbell.magicbelluserclient.models.SlackTokenPayload;
import com.magicbell.magicbelluserclient.validation.Violation;
import com.magicbell.magicbelluserclient.validation.ViolationAggregator;

public class SlackTokenPayloadValidator extends AbstractModelValidator<SlackTokenPayload> {

  public SlackTokenPayloadValidator(String fieldName) {
    super(fieldName);
  }

  public SlackTokenPayloadValidator() {}

  @Override
  protected Violation[] validateModel(SlackTokenPayload slackTokenPayload) {
    return new ViolationAggregator()
      .add(new SlackTokenPayloadWebhookValidator("webhook").optional().validate(slackTokenPayload.getWebhook()))
      .aggregate();
  }
}
