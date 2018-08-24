package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Generator;
import model.Sorter;

class SorterTest {

	private Sorter s;
	
	private void scene1() {
		Generator g = new Generator(100, 1, 998);
		int[] a = g.reverseOrdered();
		s = new Sorter(a, g.getRoof(), g.getFloor(), 0);
	}
	
	private void scene2() {
		Generator g = new Generator(1000, 2, 10000);
		int[] a = g.alreadyOrdered();
		s = new Sorter(a, g.getRoof(), g.getFloor(), 0);
	}
	
	private void scene3() {
		Generator g = new Generator(100000, 3, 1000000);
		int[] a = g.randomOrdered();
		s = new Sorter(a, g.getRoof(), g.getFloor(), 0);
	}
	
	private void scene4() {
		Generator g = new Generator(100, 4, 999);
		int[] a = g.percentOrder(0.1);
		s = new Sorter(a, g.getRoof(), g.getFloor(), 0);
	}
	
	
	
	@Test
	void testCalculateFloor() {
		scene1();
		assertTrue(s.calculateFloor(s.getArray())>=1);
		scene2();
		assertTrue(s.calculateFloor(s.getArray())>=2);
		scene3();
		assertTrue(s.calculateFloor(s.getArray())>=3);
		scene4();
		assertTrue(s.calculateFloor(s.getArray())>=4);
		
	}
	
	@Test
	void testCalculateRoof() {
		scene1();
		assertTrue(s.calculateRoof(s.getArray())<=998);
		scene2();
		assertTrue(s.calculateRoof(s.getArray())<=10000);
		scene3();
		assertTrue(s.calculateRoof(s.getArray())<=1000000);
		scene4();
		assertTrue(s.calculateRoof(s.getArray())<=999);
		
	}
	
	@Test
	void testSort() {
		scene1();
		s.sort();
		int[] a = s.getArray();
		for (int i = 0; i < a.length-1; i++) {
			assertTrue(a[i]<a[i+1]);
		}
		scene2();
		s.sort();
		a = s.getArray();
		for (int i = 0; i < a.length-1; i++) {
			assertTrue(a[i]<a[i+1]);
		}
		scene3();
		s.sort();
		a = s.getArray();
		for (int i = 0; i < a.length-1; i++) {
			assertTrue(a[i]<a[i+1]);
		}
		scene4();
		s.sort();
		a = s.getArray();
		for (int i = 0; i < a.length-1; i++) {
			assertTrue(a[i]<a[i+1]);
		}
	}
	
	@Test
	void testQuickSort() {
		scene1();
		s.quicksort(s.getArray(), 0, s.getArray().length-1);;
		int[] a = s.getArray();
		for (int i = 0; i < a.length-1; i++) {
			assertTrue(a[i]<a[i+1]);
		}
		scene2();
		s.quicksort(s.getArray(), 0, s.getArray().length-1);;
		a = s.getArray();
		for (int i = 0; i < a.length-1; i++) {
			assertTrue(a[i]<a[i+1]);
		}
		scene3();
		s.quicksort(s.getArray(), 0, s.getArray().length-1);;
		a = s.getArray();
		for (int i = 0; i < a.length-1; i++) {
			assertTrue(a[i]<a[i+1]);
		}
		scene4();
		s.quicksort(s.getArray(), 0, s.getArray().length-1);;
		a = s.getArray();
		for (int i = 0; i < a.length-1; i++) {
			assertTrue(a[i]<a[i+1]);
		}
		
		
	}
	
	@Test
	void testCountingSort() {
		scene1();
		s.countingsort(s.getArray());
		int[] a = s.getArray();
		for (int i = 0; i < a.length-1; i++) {
			assertTrue(a[i]<a[i+1]);
		}
		scene2();
		s.countingsort(s.getArray());
		a = s.getArray();
		for (int i = 0; i < a.length-1; i++) {
			assertTrue(a[i]<a[i+1]);
		}
		scene3();
		s.countingsort(s.getArray());
		a = s.getArray();
		for (int i = 0; i < a.length-1; i++) {
			assertTrue(a[i]<a[i+1]);
		}
		scene4();
		s.countingsort(s.getArray());
		a = s.getArray();
		for (int i = 0; i < a.length-1; i++) {
			assertTrue(a[i]<a[i+1]);
		}
		
		
		
	}
	
	@Test
	void testRadixSort() {
		
		scene1();
		s.radixsort(s.getArray(), s.getArray().length);
		int[] a = s.getArray();
		for (int i = 0; i < a.length-1; i++) {
			assertTrue(a[i]<a[i+1]);
		}
		scene2();
		s.radixsort(s.getArray(), s.getArray().length);
		a = s.getArray();
		for (int i = 0; i < a.length-1; i++) {
			assertTrue(a[i]<a[i+1]);
		}
		scene3();
		s.radixsort(s.getArray(), s.getArray().length);
		a = s.getArray();
		for (int i = 0; i < a.length-1; i++) {
			assertTrue(a[i]<a[i+1]);
		}
		scene4();
		s.radixsort(s.getArray(), s.getArray().length);
		a = s.getArray();
		for (int i = 0; i < a.length-1; i++) {
			assertTrue(a[i]<a[i+1]);
		}
		
		
		
	}

}
