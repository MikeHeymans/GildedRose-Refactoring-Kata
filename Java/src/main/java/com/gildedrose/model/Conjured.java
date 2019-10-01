package com.gildedrose.model;

import com.gildedrose.Item;

public class Conjured implements Sellable {
    private static final int DEFAULT_INCREMENT = -2;
    public static final String CONJURED = "Conjured";
    private final Item item;

    public Conjured(Item item) {
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
