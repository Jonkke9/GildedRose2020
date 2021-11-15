package fi.oulu.tol.sqat;

import java.util.ArrayList;
import java.util.List;

public class GildedRose {

	private static List<Item> items = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("OMGHAI!");

		items = new ArrayList<Item>();
		items.add(new Item("+5 Dexterity Vest", 10, -1));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Aged Brie", 2, 51));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 0));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 150, 0));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 49));
        items.add(new Item("Conjured Mana Cake", 3, 6));
        

        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", -1, 49));
        items.add(new Item("Aged Brie", -1, 40));
        items.add(new Item("Aged Brie", -1, 51));
        items.add(new Item("Elixir of the Mongoose", -1, -1));
        items.add(new Item("Elixir of the Mongoose", -10, 10));
        items.add(new Item("Sulfuras, Hand of Ragnaros", -1, 80));

		updateQuality();
	}

	public static void updateQuality() {
		for (int i = 0; i < items.size(); i++) {
			
			
			// If item is not "Aged Brie" or "Backstage passes to a TEFKAL80ETC concert"
			if ((!"Aged Brie".equals(items.get(i).getName()))
					&& !"Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).getName())) {
				// and items quality is over 0
				if (items.get(i).getQuality() > 0) {
					// and it is not "Sulfuras, Hand of Ragnaros"
					if (!"Sulfuras, Hand of Ragnaros".equals(items.get(i).getName())) {
						// subtract quality by 1
						items.get(i).setQuality(items.get(i).getQuality() - 1);
					}
				}
			// If item is "Aged brie" or "Backstage passes to a TEFKAL80ETC concert"
			} else {
				// and its quality is less than 50
				if (items.get(i).getQuality() < 50) {
					// increment quality by one
					items.get(i).setQuality(items.get(i).getQuality() + 1);

					// if its name is "Backstage passes to a TEFKAL80ETC concert"
					if ("Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).getName())) {
						// and its sellIn is less than 11
						if (items.get(i).getSellIn() < 11) {
							//and its quality is less than 50
							if (items.get(i).getQuality() < 50) {
								// increment quality by one
								items.get(i).setQuality(items.get(i).getQuality() + 1);
							}
						}
						
						// and its sellIn is less than 6
						if (items.get(i).getSellIn() < 6) {
							// and its quality is less than 50
							if (items.get(i).getQuality() < 50) {
								// increment quality by one
								items.get(i).setQuality(items.get(i).getQuality() + 1);
							}
						}
					}
				}
			}
			
			
			
			
			// if the item is not "Sulfuras, Hand of Ragnaros"
			if (!"Sulfuras, Hand of Ragnaros".equals(items.get(i).getName())) {
				// decrement items sellIn by one
				items.get(i).setSellIn(items.get(i).getSellIn() - 1);
			}

			// if items sellIn is lower than 0
			if (items.get(i).getSellIn() < 0) {
				// and the item is not "Aged Brie"
				if (!"Aged Brie".equals(items.get(i).getName())) {
					// nor "Backstage passes to a TAFKAL80ETC concert"
					if (!"Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).getName())) {
						// and its quality is more than 0
						if (items.get(i).getQuality() > 0) {
							// and the item is not "Sulfuras, Hand of Ragnaros"
							if (!"Sulfuras, Hand of Ragnaros".equals(items.get(i).getName())) {
								// decrement the quality by one
								items.get(i).setQuality(items.get(i).getQuality() - 1);
							}
						}
					// if the item is "Backstage passes to a TAFKAL80ETC concert"
					} else {
						// set quality to 0
						items.get(i).setQuality(items.get(i).getQuality() - items.get(i).getQuality());
					}
				// if the item is "Aged brie"
				} else {
					// and its quality is less then 50
					if (items.get(i).getQuality() < 50) {
						// increment the quality by one
						items.get(i).setQuality(items.get(i).getQuality() + 1);
					}
				}
			}
		}
	}
}
