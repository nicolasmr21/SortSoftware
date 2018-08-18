package model;

public class Generator {

	public Generator(int nElements, int floor, int roof, boolean repeated) {
		this.nElements = nElements;
		this.floor = floor;
		this.roof = roof;
		this.repeated = repeated;
	}
	private int nElements; 			// # of elements
	private int floor; 				// Interval's beginning 
	private int roof; 				// Interval's end
	private boolean repeated;		// if the numbers can be repeated
	
	public int[] alreadyOrdered()
	{
		int jumpFactor = (roof-floor)/nElements;
		int[] array = new int[nElements];
		int sum = (int)(Math.random()*jumpFactor);
		array[0] = sum;
		System.out.println(array[0]);
		for (int i = 1; i < array.length; i++) {
			array[i] = array[i-1]+sum;
			sum = (int)(Math.random()*jumpFactor);
			System.out.println(array[i]);
		}
		return array;
	}
}
