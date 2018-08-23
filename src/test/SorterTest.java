package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Generator;
import model.Sorter;

class SorterTest {

	private Sorter s;
	
	private void scene1() {
		Generator g = new Generator(100, 0, 1000);
		int[] a = g.reverseOrdered();
		s = new Sorter(a, g.getRoof(), g.getFloor(), 0);
	}
	
	private void scene2() {
		Generator g = new Generator(1000, 0, 10000);
		int[] a = g.alreadyOrdered();
		s = new Sorter(a, g.getRoof(), g.getFloor(), 0);
	}
	
	private void scene3() {
		Generator g = new Generator(100000, 0, 10000000);
		int[] a = g.randomOrdered();
		s = new Sorter(a, g.getRoof(), g.getFloor(), 0);
	}
	
	private void scene4() {
		Generator g = new Generator(100, 0, 1000);
		int[] a = g.percentOrder(0.1);
		s = new Sorter(a, g.getRoof(), g.getFloor(), 0);
	}
	
	
	
	@Test
	void test() {
	}

}
