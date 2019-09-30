package com.gildedrose.model;

import com.gildedrose.Item;

public class Sulfuras implements Sellable {
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private final Item item;

    public Sulfuras(Item item) {
        this.item = item;
    }
}
