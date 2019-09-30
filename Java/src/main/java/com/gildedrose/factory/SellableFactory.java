package com.gildedrose.factory;

import com.gildedrose.Item;
import com.gildedrose.model.DefaultItem;
import com.gildedrose.model.Sellable;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class SellableFactory {
    private static final Map<String, Function<Item, Sellable>> registeredSellables = new HashMap<>();

    private SellableFactory() {
    }

    public static Sellable getSellable(Item item) {
        return registeredSellables.getOrDefault(item.name, DefaultItem::new).apply(item);
    }

    public static void addSellable(String name, Function<Item, Sellable> createSellableFunction) {
        registeredSellables.put(name, createSellableFunction);
    }
}
