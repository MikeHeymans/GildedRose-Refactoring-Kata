package com.gildedrose.model;

import com.gildedrose.Item;

public class AgedBrie implements Sellable {
    public static final String AGED_BRIE = "Aged Brie";
    private final Item item;

    public AgedBrie(Item item) {
        this.item = item;
    }

    @Override
    public void update() {
        item.sellIn--;
        if (item.sellIn < 0) {
            item.quality = Sellable.validateQuality(item.quality + 2);
        } else {
            item.quality = Sellable.validateQuality(item.quality + 1);
        }
    }
}
