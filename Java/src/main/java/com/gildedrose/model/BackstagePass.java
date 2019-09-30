package com.gildedrose.model;

import com.gildedrose.Item;

public class BackstagePass implements Sellable {
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
        } else if (item.sellIn < 5) {
            item.quality = Sellable.validateQuality(item.quality + 3);
        } else if (item.sellIn < 10) {
            item.quality = Sellable.validateQuality(item.quality + 2);
        } else {
            item.quality = Sellable.validateQuality(item.quality + 1);
        }
    }
}
