package com.gildedrose;

public class Ticket extends ItemWrapper {

    public Ticket(int sellIn, int quality) {
        super("Ticket", sellIn, quality);
    }

    public Ticket(Item item) {
        this(item.sellIn, item.quality);
    }

    @Override
    public void ageByOneDay() {
        quality++;
        if (sellIn < 11) {
            quality++;
        }
        if (sellIn < 6) {
            quality++;
        }
        if (sellIn <= 0) {
            quality = 0;
        }
    }

}
