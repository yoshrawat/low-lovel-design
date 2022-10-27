package com.yogesh.ratelimitter.slidingwindow;

import java.util.*;

public class UserBucketCreator {
    Map<Integer, SlidingWindow> bucket;

    public UserBucketCreator(int id) {
        bucket = new HashMap<>();
        bucket.put(id, new SlidingWindow(1, 5));
    }

    public void accessApplication(int id) {
        if (bucket.get(id).grantAccess()) {
            System.out.println(Thread.currentThread().getName() + " -> able to access the application");
        } else {
            System.out.println(Thread.currentThread().getName() + " -> Too many request, Please try after some time");
        }
    }
}
