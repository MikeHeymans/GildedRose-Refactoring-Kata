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
        item.quality = Sellable.updateQuality(item.quality, getIncrement());
        if (item.sellIn < Sellable.DOUBLE_INCREMENT_SELL_IN_POINT) {
            item.quality = Sellable.updateQuality(item.quality, getIncrement());
        }
    }

    protected int getIncrement() {
        return DEFAULT_INCREMENT;
    }
}
