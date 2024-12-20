package com.magicbell.userclient.validation.validators.modelValidators;

import com.magicbell.userclient.models.SlackInstallation;
import com.magicbell.userclient.validation.Violation;
import com.magicbell.userclient.validation.ViolationAggregator;
import com.magicbell.userclient.validation.validators.StringValidator;

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
