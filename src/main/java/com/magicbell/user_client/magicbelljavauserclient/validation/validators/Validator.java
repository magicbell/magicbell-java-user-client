package com.magicbell.user_client.magicbelljavauserclient.validation.validators;

import com.magicbell.user_client.magicbelljavauserclient.validation.Violation;

public interface Validator<T> {
  Violation[] validate(T value);
}
