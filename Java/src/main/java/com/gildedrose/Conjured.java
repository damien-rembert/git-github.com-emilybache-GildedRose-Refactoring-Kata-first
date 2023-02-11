package com.gildedrose;

public class Conjured extends ItemWrapper {

    public Conjured(int sellIn, int quality) {
        super("Conjured", sellIn, quality);
    }

    public Conjured(Item item) {
        this(item.sellIn, item.quality);
    }

    @Override
    public void ageByOneDay() {
        quality = quality - 2;
        sellIn = sellIn - 1;
    }
}
