package com.magicbell.client.magicbelljavaclient.validation.validators.modelValidators;

import com.magicbell.client.magicbelljavaclient.models.SlackTokenWebhook;
import com.magicbell.client.magicbelljavaclient.validation.Violation;
import com.magicbell.client.magicbelljavaclient.validation.ViolationAggregator;
import com.magicbell.client.magicbelljavaclient.validation.validators.StringValidator;

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
