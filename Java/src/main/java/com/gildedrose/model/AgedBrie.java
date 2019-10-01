package com.gildedrose.model;

import com.gildedrose.Item;

public class AgedBrie implements Sellable {
    private static final int DEFAULT_INCREMENT = 1;
    public static final String AGED_BRIE = "Aged Brie";
    private final Item item;

    public AgedBrie(Item item) {
        this.item = item;
    }

    @Override
    public void update() {
        item.sellIn--;
        item.quality = Sellable.updateQuality(item.quality, DEFAULT_INCREMENT);
        if (item.sellIn < 0) {
            item.quality = Sellable.updateQuality(item.quality, DEFAULT_INCREMENT);
        }
    }
}
