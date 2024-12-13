package com.magicbell.client.magicbelljavaclient.validation.validators.modelValidators;

import com.magicbell.client.magicbelljavaclient.models.SlackInstallation;
import com.magicbell.client.magicbelljavaclient.validation.Violation;
import com.magicbell.client.magicbelljavaclient.validation.ViolationAggregator;
import com.magicbell.client.magicbelljavaclient.validation.validators.StringValidator;

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
