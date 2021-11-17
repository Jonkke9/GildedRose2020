package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;
import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;

public class GildedRoseTest {

	@Test
	public void testTheTruth() {
		assertTrue(true);
	}
	
	@Test
	public void testGildedRose_test1() {
		GildedRose gildedrose = new GildedRose();
		gildedrose.main(null);
	}
}
