package com.magicbell.magicbelluserclient.validation.validators.modelValidators;

import com.magicbell.magicbelluserclient.models.SlackInstallation;
import com.magicbell.magicbelluserclient.validation.Violation;
import com.magicbell.magicbelluserclient.validation.ViolationAggregator;
import com.magicbell.magicbelluserclient.validation.validators.StringValidator;

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
