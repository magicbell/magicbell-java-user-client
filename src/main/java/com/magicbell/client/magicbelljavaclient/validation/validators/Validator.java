package com.magicbell.client.magicbelljavaclient.validation.validators;

import com.magicbell.client.magicbelljavaclient.validation.Violation;

public interface Validator<T> {
  Violation[] validate(T value);
}
