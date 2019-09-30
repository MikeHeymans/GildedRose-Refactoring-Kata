package com.gildedrose.model;

public interface Sellable {
    int DEFAULT_MAX_QUALITY = 50;
    int DEFAULT_MIN_QUALITY = 0;

    static int validateQuality(int quality) {
        return Math.max(DEFAULT_MIN_QUALITY, Math.min(quality, DEFAULT_MAX_QUALITY));
    }

    default void update() {
        // do nothing
    }
}
