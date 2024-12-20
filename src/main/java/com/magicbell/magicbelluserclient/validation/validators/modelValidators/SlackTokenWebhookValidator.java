package com.magicbell.magicbelluserclient.validation.validators.modelValidators;

import com.magicbell.magicbelluserclient.models.SlackTokenWebhook;
import com.magicbell.magicbelluserclient.validation.Violation;
import com.magicbell.magicbelluserclient.validation.ViolationAggregator;
import com.magicbell.magicbelluserclient.validation.validators.StringValidator;

public class SlackTokenWebhookValidator extends AbstractModelValidator<SlackTokenWebhook> {

  public SlackTokenWebhookValidator(String fieldName) {
    super(fieldName);
  }

  public SlackTokenWebhookValidator() {}

  @Override
  protected Violation[] validateModel(SlackTokenWebhook slackTokenWebhook) {
    return new ViolationAggregator()
      .add(new StringValidator("url").minLength(1).required().validate(slackTokenWebhook.getUrl()))
      .aggregate();
  }
}
