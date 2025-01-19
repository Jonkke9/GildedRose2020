package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;
import java.util.List;
import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;
import org.junit.Before;
import org.junit.Test;

public class GildedRoseTest {

	private GildedRose inn;

	@Before
	public void setUp() {
		inn = new GildedRose();
	}

	@Test
	public void testNormalItemQualityDecrease() {
		final Item item = new Item("item", 10, 10);
		inn.setItem(item);
		inn.oneDay();
		assertEquals(9, item.getQuality());
	}

	@Test
	public void testNormalSellInDecrease() {
		final Item item = new Item("item", 10, 10);
		inn.setItem(item);
		inn.oneDay();
		assertEquals(9, item.getSellIn());
	}

	@Test
	public void testNormalItemQualityDecreaseAfterSellin() {
		final Item item = new Item("item", -1, 10);
		inn.setItem(item);
		inn.oneDay();
		assertEquals(8, item.getQuality());
	}

	@Test
	public void testNormalItemQualityCantGoUnder0() {
		final Item item = new Item("item", -1, 0);
		inn.setItem(item);
		inn.oneDay();
		assertEquals(0, item.getQuality());
	}

	@Test
	public void testPassQualityIncreaseBy1() {
		final Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 0);
		inn.setItem(item);
		inn.oneDay();
		assertEquals(1, item.getQuality());
	}


	@Test
	public void testPassQualityIncreaseBy2() {
		final Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 6, 0);
		inn.setItem(item);
		inn.oneDay();
		assertEquals(2, item.getQuality());
	}

	@Test
	public void testPassQualityIncreaseBy3() {
		final Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 0);
		inn.setItem(item);
		inn.oneDay();
		assertEquals(3, item.getQuality());
	}

	@Test
	public void testPassQualityDropTo0() {
		final Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10);
		inn.setItem(item);
		inn.oneDay();
		assertEquals(0, item.getQuality());
	}

	@Test
	public void testQualityCantGoOver50() {
		final Item pass = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 50);
		final Item pass1 = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 49);
		final Item brie = new Item("Aged Brie", 0, 50);
		inn.setItem(pass);
		inn.setItem(brie);
		inn.setItem(pass1);
		inn.oneDay();

		assertEquals(50, pass.getQuality());
		assertEquals(50, pass1.getQuality());
		assertEquals(50, brie.getQuality());
	}

	@Test
	public void testSulfurasQualityCantChange() {
		final Item sulfuras1 = new Item("Sulfuras, Hand of Ragnaros", 1, 80);
		final Item sulfuras2 = new Item("Sulfuras, Hand of Ragnaros", -1, 80);
		inn.setItem(sulfuras1);
		inn.setItem(sulfuras2);
		inn.oneDay();
		assertEquals(80, sulfuras1.getQuality());
		assertEquals(80, sulfuras2.getQuality());
	}

	@Test
	public void testAgedBrieQualityIncreaseBy1() {
		final Item item = new Item("Aged Brie", 1, 0);
		inn.setItem(item);
		inn.oneDay();
		assertEquals(1, item.getQuality());
	}

	@Test
	public void testAgedBrieQualityIncreaseBy2() {
		final Item item = new Item("Aged Brie", 0, 0);
		inn.setItem(item);
		inn.oneDay();
		assertEquals(2, item.getQuality());
	}

	@Test
	public void testSetGetItems() {
		final Item item = new Item("Aged Brie", 0, 0);
		inn.setItem(item);
		assertEquals(true, item == inn.getItems().get(0));
	}
}
