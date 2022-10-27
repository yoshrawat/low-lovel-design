package com.yogesh.ratelimitter.tokenbucket;

import com.yogesh.ratelimitter.*;

import java.util.concurrent.atomic.*;

public class TokenBucket implements RateLimiter {
    private final int bucketCapacity;
    private final int refreshRate;
    private final AtomicInteger currentCapacity;
    private final AtomicLong lastUpdateTime;

    public TokenBucket(final int bucketCapacity, final int refreshRate) {
        this.bucketCapacity = bucketCapacity;
        this.refreshRate = refreshRate;
        currentCapacity = new AtomicInteger(bucketCapacity);
        lastUpdateTime = new AtomicLong(System.currentTimeMillis());
    }

    @Override
    public boolean grantAccess() {
        fillBucket();
        if (currentCapacity.get() > 0) {
            currentCapacity.getAndDecrement();
            return true;
        }
        return false;
    }

    private void fillBucket() {
        long currentTime = System.currentTimeMillis();
        int additionalToken = (int) ((currentTime - lastUpdateTime.get()) / 1000 * refreshRate);
        int tempCurrentCapacity = Math.min(bucketCapacity, currentCapacity.get() + additionalToken);
        currentCapacity.getAndSet(tempCurrentCapacity);
        lastUpdateTime.getAndSet(currentTime);
    }
}
