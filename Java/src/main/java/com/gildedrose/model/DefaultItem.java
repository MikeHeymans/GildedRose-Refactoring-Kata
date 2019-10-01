package com.gildedrose.model;

import com.gildedrose.Item;

public class DefaultItem implements Sellable {
    private static final int DEFAULT_INCREMENT = -1;
    private final Item item;

    public DefaultItem(Item item) {
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
