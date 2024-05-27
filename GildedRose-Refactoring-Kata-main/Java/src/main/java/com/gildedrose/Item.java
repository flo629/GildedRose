public void updateItem() {
    boolean isAgedBrieOrBackstagePass = name.equals("Aged Brie") || name.equals("Backstage passes to a TAFKAL80ETC concert");
    boolean isBackstagePass = name.equals("Backstage passes to a TAFKAL80ETC concert");
    boolean isSulfuras = name.equals("Sulfuras, Hand of Ragnaros");

    if (!isAgedBrieOrBackstagePass) {
        if (quality > 0 && !isSulfuras) {
            quality--;
        }
    } else {
        if (quality < 50) {
            quality++;

            if (isBackstagePass) {
                if (sellIn < 11) {
                    if (quality < 50) {
                        quality++;
                    }
                }

                if (sellIn < 6) {
                    if (quality < 50) {
                        quality++;
                    }
                }
            }
        }
    }

    if (!isSulfuras) {
        sellIn--;
    }

    if (sellIn < 0) {
        if (!isAgedBrieOrBackstagePass) {
            if (quality > 0 && !isSulfuras) {
                quality--;
            }
        } else {
            if (isBackstagePass) {
                quality = 0;
            } else {
                if (quality < 50) {
                    quality++;
                }
            }
        }
    }
}
