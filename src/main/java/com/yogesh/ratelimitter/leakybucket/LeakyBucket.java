package com.yogesh.ratelimitter.leakybucket;

import com.yogesh.ratelimitter.*;

import java.util.concurrent.*;

public class LeakyBucket implements RateLimiter {
    private final BlockingQueue<Integer> queue;

    public LeakyBucket(final int capacity) {
        this.queue = new LinkedBlockingDeque<>(capacity);
    }

    @Override
    public boolean grantAccess() {
        if (queue.remainingCapacity() > 0) {
            queue.add(1);
            return true;
        }
        return false;
    }
}
