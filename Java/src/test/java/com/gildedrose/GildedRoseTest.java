package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    final String BRIE = "Aged Brie";
    final String TICKET = "Backstage passes to a TAFKAL80ETC concert";
    final String CONJURED = "Conjured";

    @Test
    void fooItem() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.wrappedItems[0].name);
    }

    @Test
    void updateQuality_runOnce_itemQualityGoesDown() {
        Item[] items = new Item[] { new Item("foo", 5, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.wrappedItems[0].quality);
    }

    @Test
    void updateQuality_runOncePastSellBy_qualityDoesNotGoNegative() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.wrappedItems[0].quality);
    }

    @Test
    void updateQuality_runOncePastSellBy_qualityDropsTwice() {
        Item[] items = new Item[] { new Item("foo", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.wrappedItems[0].quality);
    }

    @Test
    void updateQuality_runOnce_itemAgedByOne() {
        Item[] items = new Item[] { new Item("foo", 5, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.wrappedItems[0].quality);
        assertEquals(4, app.wrappedItems[0].sellIn);
    }

    @Test
    void updateQuality_runOnce_agedBrieQualityImproves() {
        Item[] items = new Item[] { new Item(BRIE, 2, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.wrappedItems[0].quality);
    }

    @Test
    void updateQuality_runOnce_agedBrieQualityCannotBeOver50() {
        Item[] items = new Item[] { new Item(BRIE, 2, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.wrappedItems[0].quality);
    }

    @Test
    void updateQuality_runOnce_sulfurasRemainsUnchanged() {
        Item[] items = new Item[] { new Sulfuras() };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.wrappedItems[0].quality);
        assertEquals(666, app.wrappedItems[0].sellIn);
        assertEquals(SULFURAS, app.wrappedItems[0].name);
    }

    @Test
    void updateQuality_runOnceWhenSellInUnder10_ticketQualityImprovesBy2() {
        Item[] items = new Item[] { new Item(TICKET, 9, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.wrappedItems[0].quality);
    }

    @Test
    void updateQuality_runOnceWhenSellInAt10_ticketQualityImprovesBy2() {
        Item[] items = new Item[] { new Item(TICKET, 10, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.wrappedItems[0].quality);
    }

    @Test
    void updateQuality_runOnceWhenSellInAt5_ticketQualityImprovesBy3() {
        Item[] items = new Item[] { new Item(TICKET, 5, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.wrappedItems[0].quality);
    }

    @Test
    void updateQuality_runOnceWhenSellInUnder5_ticketQualityImprovesBy3() {
        Item[] items = new Item[] { new Item(TICKET, 2, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.wrappedItems[0].quality);
    }

    @Test
    void updateQuality_runOnceWhenSellInAt0_ticketQualityDropsToZero() {
        Item[] items = new Item[] { new Item(TICKET, 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.wrappedItems[0].quality);
    }

    @Test
    void updateQuality_runOnce_conjuredItemDropsByTwo() {
        Item[] items = new Item[] { new Conjured(10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.wrappedItems[0].quality);
    }
}
