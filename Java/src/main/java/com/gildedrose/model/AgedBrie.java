package com.gildedrose.model;

import com.gildedrose.Item;

public class AgedBrie extends DefaultItem {
    private static final int AGED_BRIE_INCREMENT = 1;
    public static final String AGED_BRIE = "Aged Brie";

    public AgedBrie(Item item) {
        super(item);
    }

    @Override
    protected int getIncrement() {
        return AGED_BRIE_INCREMENT;
    }
}
