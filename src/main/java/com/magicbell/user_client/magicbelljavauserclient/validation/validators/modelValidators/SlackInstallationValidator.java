package com.magicbell.user_client.magicbelljavauserclient.validation.validators.modelValidators;

import com.magicbell.user_client.magicbelljavauserclient.models.SlackInstallation;
import com.magicbell.user_client.magicbelljavauserclient.validation.Violation;
import com.magicbell.user_client.magicbelljavauserclient.validation.ViolationAggregator;
import com.magicbell.user_client.magicbelljavauserclient.validation.validators.StringValidator;

public class SlackInstallationValidator extends AbstractModelValidator<SlackInstallation> {

  public SlackInstallationValidator(String fieldName) {
    super(fieldName);
  }

  public SlackInstallationValidator() {}

  @Override
  protected Violation[] validateModel(SlackInstallation slackInstallation) {
    return new ViolationAggregator()
      .add(new StringValidator("id").pattern("^[A-Z0-9/]*$").optional().validate(slackInstallation.getId()))
      .aggregate();
  }
}
