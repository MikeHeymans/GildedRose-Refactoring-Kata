package com.gildedrose.model;

import com.gildedrose.Item;

public class Conjured implements Sellable {
    public static final String CONJURED = "Conjured";
    private final Item item;

    public Conjured(Item item) {
        this.item = item;
    }

    @Override
    public void update() {
        item.sellIn--;
        if (item.sellIn < 0) {
            item.quality = Sellable.validateQuality(item.quality - 4);
        } else {
            item.quality = Sellable.validateQuality(item.quality - 2);
        }
    }
}
