package com.magicbell.user_client.magicbelljavauserclient.http.serialization;

public enum PathSerializationStyle {
  SIMPLE(SerializationStyle.SIMPLE),
  LABEL(SerializationStyle.LABEL),
  MATRIX(SerializationStyle.MATRIX);

  public final SerializationStyle style;

  PathSerializationStyle(SerializationStyle style) {
    this.style = style;
  }
}