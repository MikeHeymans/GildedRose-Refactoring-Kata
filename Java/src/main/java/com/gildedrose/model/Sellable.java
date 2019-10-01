package com.gildedrose.model;

public interface Sellable {
    int DOUBLE_INCREMENT_SELL_IN_POINT = 0;
    int DEFAULT_MAX_QUALITY = 50;
    int DEFAULT_MIN_QUALITY = 0;

    static int updateQuality(int quality, int increment) {
        return Math.max(DEFAULT_MIN_QUALITY, Math.min(quality + increment, DEFAULT_MAX_QUALITY));
    }

    void update();
}
