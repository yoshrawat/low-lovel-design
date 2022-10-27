package com.yogesh.ratelimitter.tokenbucket;

import com.yogesh.ratelimitter.slidingwindow.*;

import java.util.*;

public class UserBucketCreator {
    private final Map<Integer, TokenBucket> bucket;

    public UserBucketCreator(int id) {
        bucket = new HashMap<>();
        bucket.put(id, new TokenBucket(10, 5));
    }

    void accessApplication(int id) {
        if (bucket.get(id).grantAccess()) {
            System.out.println(Thread.currentThread().getName() + " -> able to access the application");
        } else {
            System.out.println(Thread.currentThread().getName() + " -> Too many request, Please try after some time");
        }
    }
}
