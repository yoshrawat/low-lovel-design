package com.yogesh.ratelimitter.leakybucket;

import com.yogesh.ratelimitter.slidingwindow.UserBucketCreator;

import java.util.concurrent.*;

public class Application {
    public static void main(String[] args) {
        UserBucketCreator userBucketCreator = new UserBucketCreator(1);
        ExecutorService executors = Executors.newFixedThreadPool(12);
        for (int i = 0; i < 12; i++) {
            executors.execute(() -> userBucketCreator.accessApplication(1));

        }
        executors.shutdown();
    }
}
