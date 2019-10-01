package com.gildedrose.model;

import com.gildedrose.Item;

public class BackstagePass implements Sellable {
    private static final int BACKSTAGE_PASS_INCREMENT = 1;
    private static final int DISTANT_FUTURE_THRESHOLD = 10;
    private static final int NEAR_FUTURE_THRESHOLD = 5;
    public static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
    private final Item item;

    public BackstagePass(Item item) {
        this.item = item;
    }

    @Override
    public void update() {
        item.sellIn--;
        if (item.sellIn < 0) {
            item.quality = 0;
        } else {
            item.quality = Sellable.updateQuality(item.quality, BACKSTAGE_PASS_INCREMENT);
            if (item.sellIn < DISTANT_FUTURE_THRESHOLD) {
                item.quality = Sellable.updateQuality(item.quality, BACKSTAGE_PASS_INCREMENT);
            }
            if (item.sellIn < NEAR_FUTURE_THRESHOLD) {
                item.quality = Sellable.updateQuality(item.quality, BACKSTAGE_PASS_INCREMENT);
            }
        }
    }
}
