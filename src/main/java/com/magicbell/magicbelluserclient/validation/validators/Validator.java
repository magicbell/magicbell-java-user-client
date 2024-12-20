package com.magicbell.magicbelluserclient.validation.validators;

import com.magicbell.magicbelluserclient.validation.Violation;

public interface Validator<T> {
  Violation[] validate(T value);
}
