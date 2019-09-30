package com.gildedrose.model;

import com.gildedrose.Item;

public class DefaultItem implements Sellable {
    private final Item item;

    public DefaultItem(Item item) {
        this.item = item;
    }

    @Override
    public void update() {
        item.sellIn--;
        if (item.sellIn < 0) {
            item.quality = Sellable.validateQuality(item.quality - 2);
        } else {
            item.quality = Sellable.validateQuality(item.quality - 1);
        }
    }
}
