package model;

public class Generator {
	
	private int nElements; 			// # of elements
	private int floor; 				// Interval's beginning 
	private int roof; 				// Interval's end
	private int[] array;
	
	public Generator(int nElements, int floor, int roof) {
		this.nElements = nElements;
		this.floor = floor;
		this.roof = roof;
	}
	

	
	public int[] alreadyOrdered()
	{
		double jumpFactor = (roof-floor)/nElements;
		int[] array = new int[nElements];
		int sum = (int)(Math.random()*jumpFactor);
		array[0] = floor + sum;		
		for (int i = 1; i < array.length; i++) {
			sum = (int)(Math.random()*(jumpFactor-1))+1;
			array[i] = array[i-1]+sum;
		}
		return array;
	}
	
	public int[] alreadyOrderedRepeated()
	{
		double jumpFactor = (roof-floor)/nElements;
		int[] array = new int[nElements];
		int sum = (int)(Math.random()*jumpFactor);
		array[0] = floor + sum;		
		for (int i = 1; i < array.length; i++) {
			sum = (int)(Math.random()*jumpFactor);
			array[i] = array[i-1]+sum;
		}
		return array;
	}
	
	public int[] reverseOrdered()
	{
		double jumpFactor = (roof-floor)/nElements;
		int[] array = new int[nElements];
		int sum = (int)(Math.random()*jumpFactor);
		array[array.length-1] = floor + sum;
		for (int i = array.length-2; i > -1; i--) {
			sum = (int)(Math.random()*(jumpFactor-1))+1;
			array[i] = array[i+1]+sum;
		}
		return array;
	}
	
	public int[] reverseOrderedRepeated()
	{
		double jumpFactor = (roof-floor)/nElements;
		int[] array = new int[nElements];
		int sum = (int)(Math.random()*jumpFactor);
		array[array.length-1] = floor + sum;
		for (int i = array.length-2; i > -1; i--) {
			sum = (int)(Math.random()*jumpFactor);
			array[i] = array[i+1]+sum;
		}
		return array;
	}
	
	public int[] randomOrderedRepeated()
	{
		int[] array = new int[nElements];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int)(Math.random()*(roof-floor))+floor;
		}
		return array;
	}
	
	public int[] randomOrdered()
	{
		int[] array = new int[nElements];
		array[0] = (int)(Math.random()*(roof-floor))+floor;
		for (int i = 0; i < array.length; i++) {
			int k = (int)(Math.random()*(roof-floor))+floor;
			boolean found = false;
			for (int j = 0; j < i ; j++) {
				if(array[j]==k)
				{
					j = i;
					found = true;
				}
			}
			if(!found)
			{
				array[i] = k;
			}
			else
			{
				i--;
			}
		}
		return array;
	}
	
	public String concatenar(int[] arr)
	{
		String arreglo = "";
		for (int i = 0; i < arr.length; i++) {
			arreglo+=arr[i]+"-";
		}
		return arreglo;
	}
	
	public int[] percentOrder(double percentage)
	{
		int[] array = alreadyOrdered();
		int pairs = (int)(array.length*percentage)/2;
		for (int i = 0; i < pairs; i++) {
			int temp = array[i];
			array[i] = array[array.length-i-1];
			array[array.length-i-1] = temp;
		}
		return array;
	}
	
	public int[] percentOrderRepeated(double percentage)
	{
		int[] array = alreadyOrderedRepeated();
		int pairs = (int)(array.length*percentage)/2;
		for (int i = 0; i < pairs; i++) {
			int temp = array[i];
			array[i] = array[array.length-i-1];
			array[array.length-i-1] = temp;
		}
		return array;
	}



	public int[] getArray() {
		return array;
	}



	public void setArray(int[] array) {
		this.array = array;
	}
}
