package com.gildedrose;

class GildedRose {

    static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    static final String TICKET = "Backstage passes to a TAFKAL80ETC concert";
    static final String CONJURED = "Conjured";
    static final String BRIE = "Aged Brie";

    Item[] items;
    ItemWrapper[] wrappedItems;

    public GildedRose(Item[] items) {
        this.items = items;
        this.wrappedItems = new ItemWrapper[items.length];
        for (int i = 0; i < items.length; i++) {
            if (items[i].name.equals(SULFURAS)) {
                this.wrappedItems[i] = new Sulfuras();
            } else if (items[i].name.equals(TICKET)) {
                this.wrappedItems[i] = new Ticket(items[i]);
            } else if (items[i].name.equals(CONJURED)) {
                this.wrappedItems[i] = new Conjured(items[i]);
                // } else if (items[i].name.equals(BRIE)) {
                // this.wrappedItems[i] = new ItemWrapper(items[i]);
            } else {
                this.wrappedItems[i] = new ItemWrapper(items[i]);
            }
        }
    }

    public void updateQuality() {
        for (int i = 0; i < wrappedItems.length; i++) {
            if (wrappedItems[i].name.equals(BRIE) && (wrappedItems[i].sellIn >= 0)) {
                wrappedItems[i].quality = wrappedItems[i].quality + 2;
            }

            wrappedItems[i].ageByOneDay();
        }
    }
}
