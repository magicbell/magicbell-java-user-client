package com.magicbell.userclient.validation.validators;

import com.magicbell.userclient.validation.Violation;

public interface Validator<T> {
  Violation[] validate(T value);
}
