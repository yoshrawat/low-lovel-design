package com.yogesh.cabbooking.strategies;

import com.yogesh.cabbooking.model.*;

public interface PricingStrategy {
    Double findPrice(Location fromPoint, Location toPoint);
}
