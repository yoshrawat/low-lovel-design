package com.yogesh.cache.storage;

import com.yogesh.cache.exceptions.*;

public interface Storage<Key, Value> {
  public void add(Key key, Value value) throws StorageFullException;

  void remove(Key key) throws NotFoundException;

  Value get(Key key) throws NotFoundException;
}
