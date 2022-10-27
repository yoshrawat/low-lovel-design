package com.yogesh.ratelimitter.leakybucket;

import com.yogesh.ratelimitter.slidingwindow.*;

import java.util.*;

public class UserBucketCreator {
    private final Map<Integer, LeakyBucket> map;

    public UserBucketCreator(final int id) {
        map = new HashMap<>();
        map.put(id, new LeakyBucket(5));
    }

    void accessApplication(int id) {
        if (map.containsKey(id) && map.get(id).grantAccess()) {
            System.out.println(Thread.currentThread().getName() + " -> able to access the application");
        } else {
            System.out.println(Thread.currentThread().getName() + " -> Too many request, Please try after some time");
        }
    }
}
