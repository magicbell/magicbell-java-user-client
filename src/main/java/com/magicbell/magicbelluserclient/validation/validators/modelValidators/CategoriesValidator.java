package com.magicbell.magicbelluserclient.validation.validators.modelValidators;

import com.magicbell.magicbelluserclient.models.Categories;
import com.magicbell.magicbelluserclient.validation.Violation;
import com.magicbell.magicbelluserclient.validation.ViolationAggregator;
import com.magicbell.magicbelluserclient.validation.validators.StringValidator;

/**
 * Validator implementation for Categories model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class CategoriesValidator extends AbstractModelValidator<Categories> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public CategoriesValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public CategoriesValidator() {}

  /**
   * Validates the Categories model's fields and constraints.
   *
   * @param categories The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(Categories categories) {
    return new ViolationAggregator()
      .add(
        new StringValidator("key")
          .maxLength(255)
          .pattern("^[A-Za-z0-9_\\.\\-/:]+$")
          .optional()
          .validate(categories.getKey())
      )
      .add(new StringValidator("label").maxLength(255).optional().validate(categories.getLabel()))
      .aggregate();
  }
}
