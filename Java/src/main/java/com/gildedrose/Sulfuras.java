package com.gildedrose;

public class Sulfuras extends ItemWrapper {

    public Sulfuras() {
        super("Sulfuras, Hand of Ragnaros", 666, 80);
    }

    @Override
    public void ageByOneDay() {
        this.sellIn = 666;
        this.quality = 80;
    }

}
