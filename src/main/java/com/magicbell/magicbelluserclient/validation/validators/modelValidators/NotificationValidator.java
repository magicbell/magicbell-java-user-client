package com.magicbell.magicbelluserclient.validation.validators.modelValidators;

import com.magicbell.magicbelluserclient.models.Notification;
import com.magicbell.magicbelluserclient.validation.Violation;
import com.magicbell.magicbelluserclient.validation.ViolationAggregator;
import com.magicbell.magicbelluserclient.validation.validators.StringValidator;

/**
 * Validator implementation for Notification model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class NotificationValidator extends AbstractModelValidator<Notification> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public NotificationValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public NotificationValidator() {}

  /**
   * Validates the Notification model's fields and constraints.
   *
   * @param notification The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(Notification notification) {
    return new ViolationAggregator()
      .add(new StringValidator("title").minLength(1).maxLength(255).required().validate(notification.getTitle()))
      .add(new StringValidator("actionUrl").maxLength(2048).optional().validate(notification.getActionUrl()))
      .add(new StringValidator("category").maxLength(100).optional().validate(notification.getCategory()))
      .add(new StringValidator("content").maxLength(10485760).optional().validate(notification.getContent()))
      .add(new StringValidator("topic").maxLength(100).optional().validate(notification.getTopic()))
      .aggregate();
  }
}
