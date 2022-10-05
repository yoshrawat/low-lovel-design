package com.yogesh.cache.factories;

import com.yogesh.cache.*;
import com.yogesh.cache.policies.*;
import com.yogesh.cache.storage.*;

public class CacheFactory<Key, Value> {

  public Cache<Key, Value> defaultCache(final int capacity) {
    return new Cache<Key, Value>(
        new LRUEvictionPolicy<Key>(), new HashMapBasedStorage<Key, Value>(capacity));
  }
}
