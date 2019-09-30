package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    @Test
    public void test_WhenAgedBrie_ThenIncreaseQuality() {
        final String name = "Aged Brie";

        Item[] items = new Item[]{new Item(name, 10, 5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(name, app.items[0].name);
        assertEquals(6, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    public void test_WhenAgedBrieHasSellInOfOne_ThenIncreaseQuality() {
        final String name = "Aged Brie";

        Item[] items = new Item[]{new Item(name, 1, 5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(name, app.items[0].name);
        assertEquals(6, app.items[0].quality);
        assertEquals(0, app.items[0].sellIn);
    }

    @Test
    public void test_WhenAgedBriePastSellIn_ThenIncreaseQualityTwice() {
        final String name = "Aged Brie";

        Item[] items = new Item[]{new Item(name, -2, 5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(name, app.items[0].name);
        assertEquals(7, app.items[0].quality);
        assertEquals(-3, app.items[0].sellIn);
    }

    @Test
    public void test_WhenAgedBrieHasSellInOfZero_ThenIncreaseQualityTwice() {
        final String name = "Aged Brie";

        Item[] items = new Item[]{new Item(name, 0, 5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(name, app.items[0].name);
        assertEquals(7, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    public void test_WhenAgedBrieQualityIsFifty_ThenDontIncrease() {
        final String name = "Aged Brie";

        Item[] items = new Item[]{new Item(name, 0, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(name, app.items[0].name);
        assertEquals(50, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    public void test_WhenDefaultItem_ThenDecreaseQuality() {
        final String name = "Some other item";

        Item[] items = new Item[]{new Item(name, 10, 5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(name, app.items[0].name);
        assertEquals(4, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    public void test_WhenDefaultItemPastSellIn_ThenDecreaseQualityTwice() {
        final String name = "Some other item";

        Item[] items = new Item[]{new Item(name, -2, 5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(name, app.items[0].name);
        assertEquals(3, app.items[0].quality);
        assertEquals(-3, app.items[0].sellIn);
    }

    @Test
    public void test_WhenDefaultItemZeroQuality_ThenQualityStaysZero() {
        final String name = "Some other item";

        Item[] items = new Item[]{new Item(name, -2, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(name, app.items[0].name);
        assertEquals(0, app.items[0].quality);
        assertEquals(-3, app.items[0].sellIn);
    }

    @Test
    public void test_WhenDefaultItemOneQuality_AndDecreasesTwice_ThenQualityIsZero() {
        final String name = "Some other item";

        Item[] items = new Item[]{new Item(name, -2, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(name, app.items[0].name);
        assertEquals(0, app.items[0].quality);
        assertEquals(-3, app.items[0].sellIn);
    }

    @Test
    public void test_WhenSulfurasBeforeSellIn_ThenQualityStays() {
        final String name = "Sulfuras, Hand of Ragnaros";

        Item[] items = new Item[]{new Item(name, 5, 70)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(name, app.items[0].name);
        assertEquals(70, app.items[0].quality);
        assertEquals(5, app.items[0].sellIn);
    }

    @Test
    public void test_WhenSulfurasPastSellIn_ThenQualityStays() {
        final String name = "Sulfuras, Hand of Ragnaros";

        Item[] items = new Item[]{new Item(name, -2, 70)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(name, app.items[0].name);
        assertEquals(70, app.items[0].quality);
        assertEquals(-2, app.items[0].sellIn);
    }

    @Test
    public void test_WhenBackStagePassPastSellIn_ThenQualityIsZero() {
        final String name = "Backstage passes to a TAFKAL80ETC concert";

        Item[] items = new Item[]{new Item(name, 0, 40)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(name, app.items[0].name);
        assertEquals(0, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    public void test_WhenBackStagePassSellInOverTen_ThenQualityIsIncreased() {
        final String name = "Backstage passes to a TAFKAL80ETC concert";

        Item[] items = new Item[]{new Item(name, 11, 40)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(name, app.items[0].name);
        assertEquals(41, app.items[0].quality);
        assertEquals(10, app.items[0].sellIn);
    }

    @Test
    public void test_WhenBackStagePassSellInIsTen_ThenQualityIsIncreasedTwice() {
        final String name = "Backstage passes to a TAFKAL80ETC concert";

        Item[] items = new Item[]{new Item(name, 10, 40)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(name, app.items[0].name);
        assertEquals(42, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    public void test_WhenBackStagePassSellInIsSix_ThenQualityIsIncreasedTwice() {
        final String name = "Backstage passes to a TAFKAL80ETC concert";

        Item[] items = new Item[]{new Item(name, 6, 40)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(name, app.items[0].name);
        assertEquals(42, app.items[0].quality);
        assertEquals(5, app.items[0].sellIn);
    }

    @Test
    public void test_WhenBackStagePassSellInIsFive_ThenQualityIsIncreasedThreeTimes() {
        final String name = "Backstage passes to a TAFKAL80ETC concert";

        Item[] items = new Item[]{new Item(name, 5, 40)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(name, app.items[0].name);
        assertEquals(43, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
    }

    @Test
    public void test_WhenBackStageIsQualityFifty_ThenQualityStays() {
        final String name = "Backstage passes to a TAFKAL80ETC concert";

        Item[] items = new Item[]{new Item(name, 5, 49)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(name, app.items[0].name);
        assertEquals(50, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
    }

    @Test
    public void test_WhenConjuredSellInIsPositive_ThenQualityIsDecreasedTwice() {
        final String name = "Conjured";

        Item[] items = new Item[]{new Item(name, 1, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(name, app.items[0].name);
        assertEquals(18, app.items[0].quality);
        assertEquals(0, app.items[0].sellIn);
    }

    @Test
    public void test_WhenConjuredSellInIsNegative_ThenQualityIsDecreasedFourTimes() {
        final String name = "Conjured";

        Item[] items = new Item[]{new Item(name, 0, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(name, app.items[0].name);
        assertEquals(16, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    public void test_WhenConjuredQualityIsZero_ThenQualityStays() {
        final String name = "Conjured";

        Item[] items = new Item[]{new Item(name, 1, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(name, app.items[0].name);
        assertEquals(0, app.items[0].quality);
        assertEquals(0, app.items[0].sellIn);
    }
}
