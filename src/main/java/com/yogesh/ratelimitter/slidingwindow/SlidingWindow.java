package com.yogesh.ratelimitter.slidingwindow;

import com.yogesh.ratelimitter.*;

import java.util.*;
import java.util.concurrent.*;

public class SlidingWindow implements RateLimiter {
    private final Queue<Long> slidingWindow;
    private final int timeWindowInSeconds;
    private final int queueCapacity;

    public SlidingWindow(int timeWindowInSeconds, int queueCapacity) {
        this.timeWindowInSeconds = timeWindowInSeconds;
        this.queueCapacity = queueCapacity;
        slidingWindow = new ConcurrentLinkedQueue<>();
    }

    @Override
    public boolean grantAccess() {
        long currentTime = System.currentTimeMillis();
        checkAndUpdateQueue(currentTime);
        if (slidingWindow.size() < queueCapacity) {
            slidingWindow.offer(currentTime);
            return true;
        }
        return false;
    }

    private void checkAndUpdateQueue(long currentTime) {
        if (slidingWindow.isEmpty()) return;

        long calculatedTime = (currentTime - slidingWindow.peek()) / 1000;
        while (calculatedTime >= timeWindowInSeconds) {
            slidingWindow.poll();
            if (slidingWindow.isEmpty()) break;
            calculatedTime = (currentTime - slidingWindow.peek()) / 1000;
        }
    }
}
