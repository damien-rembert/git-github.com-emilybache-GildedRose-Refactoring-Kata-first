package com.gildedrose;

public class ItemWrapper extends Item {

    public ItemWrapper(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public ItemWrapper(Item item) {
        this(item.name, item.sellIn, item.quality);
    }

    public void ageByOneDay() {
        sellIn--;
        quality--;
        adjust();
    }

    private void adjust() {
        if (sellIn < 0) {
            quality--;
        }
        if (quality > 50) {
            quality = 50;
        }
        if (quality < 0) {
            quality = 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        ItemWrapper otherWrapper = (ItemWrapper) obj;
        return this.name.equals(otherWrapper.name);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}
