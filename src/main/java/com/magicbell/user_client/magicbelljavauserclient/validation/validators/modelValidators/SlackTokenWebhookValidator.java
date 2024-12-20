package com.magicbell.user_client.magicbelljavauserclient.validation.validators.modelValidators;

import com.magicbell.user_client.magicbelljavauserclient.models.SlackTokenWebhook;
import com.magicbell.user_client.magicbelljavauserclient.validation.Violation;
import com.magicbell.user_client.magicbelljavauserclient.validation.ViolationAggregator;
import com.magicbell.user_client.magicbelljavauserclient.validation.validators.StringValidator;

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
