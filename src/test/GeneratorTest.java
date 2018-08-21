package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Generator;

class GeneratorTest {

	private Generator g;
	
	
	private void scene1() {
		g = new Generator(1000, 0, 10000);
	}
	
	private void scene2() {
		g = new Generator(10, 0, 100);
	}
	
	private void scene3() {
		g = new Generator(100000, 0, 1000000);
	}
	
	@Test
	void testAlreadyOrdered() {
		int[] array;
		
		scene1();
		array = g.alreadyOrdered();
		assertNotNull(array);
		
		
		
		array = null;
		
		scene2();
		array = g.alreadyOrdered();
		assertNotNull(array);

		array = null;

		scene3();
		array = g.alreadyOrdered();
		assertNotNull(array);
		
		
		for (int i = 0; i < array.length-1; i++) {
			assertTrue(array[i]<array[i+1]);
		}

		
	}
	
	@Test
	void testAlreadyOrderedRepeated() {
		int[] array;
		
		scene1();
		array = g.alreadyOrderedRepeated();
		assertNotNull(array);
		
		array = null;
		
		scene2();
		array = g.alreadyOrderedRepeated();
		assertNotNull(array);

		array = null;

		scene3();
		array = g.alreadyOrderedRepeated();
		assertNotNull(array);
		
		for (int i = 0; i < array.length-1; i++) {
			assertTrue(array[i]<=array[i+1]);
		}

		
	}
	
	
	void testReverseOrdered() {
		int[] array;
		
		scene1();
		array = g.reverseOrdered();
		assertNotNull(array);
		
		array = null;
		
		scene2();
		array = g.reverseOrdered();
		assertNotNull(array);

		array = null;

		scene3();
		array = g.reverseOrdered();
		assertNotNull(array);

		for (int i = 0; i < array.length-1; i++) {
			assertTrue(array[i]>array[i+1]);
		}
		
	}
	
	@Test
	void testReverseOrderedRepeated() {
		int[] array;
		
		scene1();
		array = g.reverseOrderedRepeated();
		assertNotNull(array);
		
		array = null;
		
		scene2();
		array = g.reverseOrderedRepeated();
		assertNotNull(array);

		array = null;

		scene3();
		array = g.reverseOrderedRepeated();
		assertNotNull(array);

		for (int i = 0; i < array.length-1; i++) {
			assertTrue(array[i]>=array[i+1]);
		}
	}
	
	@Test
	void testRandomOrdered() {
		int[] array;
		
		scene1();
		array = g.randomOrdered();
		assertNotNull(array);
		
		array = null;
		
		scene2();
		array = g.randomOrdered();
		assertNotNull(array);

		array = null;

		scene3();
		array = g.randomOrdered();
		assertNotNull(array);

		
	}
	
	@Test
	void testRandomRepeated() {
		int[] array;
		
		scene1();
		array = g.randomOrderedRepeated();
		assertNotNull(array);
		
		array = null;
		
		scene2();
		array = g.randomOrderedRepeated();
		assertNotNull(array);

		array = null;

		scene3();
		array = g.randomOrderedRepeated();
		assertNotNull(array);

		
	}
	
	@Test
	void testPercentOrdered() {
		int[] array;
		
		scene1();
		array = g.percentOrder(0.1);
		assertNotNull(array);
		
		array = null;
		
		scene2();
		array = g.percentOrder(0.5);
		assertNotNull(array);

		array = null;

		scene3();
		array = g.percentOrder(0.9);
		assertNotNull(array);

		
	}
	
	@Test
	void testPercentOrderedRepeated() {
		int[] array;
		
		scene1();
		array = g.percentOrderRepeated(0.1);
		assertNotNull(array);
		
		array = null;
		
		scene2();
		array = g.percentOrderRepeated(0.5);
		assertNotNull(array);

		array = null;

		scene3();
		array = g.percentOrderRepeated(0.9);
		assertNotNull(array);

		
	}

}
