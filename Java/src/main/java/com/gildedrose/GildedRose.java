package com.gildedrose;

import com.gildedrose.factory.SellableFactory;
import com.gildedrose.model.AgedBrie;
import com.gildedrose.model.BackstagePass;
import com.gildedrose.model.Conjured;
import com.gildedrose.model.Sulfuras;

import static com.gildedrose.model.AgedBrie.AGED_BRIE;
import static com.gildedrose.model.BackstagePass.BACKSTAGE_PASS;
import static com.gildedrose.model.Conjured.CONJURED;
import static com.gildedrose.model.Sulfuras.SULFURAS;

class GildedRose {
    Item[] items;

    static {
        SellableFactory.addSellable(BACKSTAGE_PASS, BackstagePass::new);
        SellableFactory.addSellable(AGED_BRIE, AgedBrie::new);
        SellableFactory.addSellable(CONJURED, Conjured::new);
        SellableFactory.addSellable(SULFURAS, Sulfuras::new);
    }

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            SellableFactory.getSellable(items[i]).update();
        }
    }
}