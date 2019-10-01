package com.gildedrose.model;

import com.gildedrose.Item;

public class Conjured extends DefaultItem {
    private static final int CONJURED_INCREMENT = -2;
    public static final String CONJURED = "Conjured";

    public Conjured(Item item) {
        super(item);
    }

    @Override
    protected int getIncrement() {
        return CONJURED_INCREMENT;
    }
}
