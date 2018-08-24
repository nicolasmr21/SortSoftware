package model;

/**

 * This class is in charge of the generation of both int and floating point
 * values ​​in the different modes that the company requests.
 * @author: Nicolas Martinez - Cristian Molina - Juan Manuel Castillo.
 * 

 * @version: 23/08/2018 A


 */

public class Generator {
	
	private int nElements; 			
	private int floor; 				
	private int roof; 				
	private double percent;
	private int[] array;
	
	/**
	 * This method is in charge of giving construction to a new generation of values ​​with nelements, 
	 * a floor and a roof.
	 * 
	 * @param nElements of type int with the amount of values to generate 
	 * @param floor of type int with the smallest value of the generated
	 * @param roof of type int with the largest value of the generated
	 */
	
	public Generator(int nElements, int floor, int roof) {
		this.nElements = nElements;
		this.floor = floor;
		this.roof = roof;
	}
	
	/**
	 * This method is in charge of giving construction to a new generation of values ​​with nelements, 
	 * a floor and a roof and the percentage of disorder.
	 * 
	 * @param nElements of type int with the amount of values to generate 
	 * @param floor of type int with the smallest value of the generated
	 * @param roof of type int with the largest value of the generated
	 * @param percentage of double type with the characteristic of indicating the disorder of the values
	 */
	
	public Generator(int nElements, int floor, int roof, double percent) {
		this.nElements = nElements;
		this.floor = floor;
		this.roof = roof;
		this.percent = percent;
	}
	
	/**
	 * This method is responsible for generating int and floating-point values in an orderly fashion
	 *  by returning an array with the ordering performed.
	 *  @return array of type array
	 */
	
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
	
	/**
	 * This method is responsible for generating int and floating point values in an orderly manner 
	 * with the possibility of repeating an array returning with the ordering performed.
	 *  @return array of type array
	 */
	
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
	
	/**
	 * This method is responsible for generating int and floating point values in an orderly manner 
	 * inversely returning an array with the ordering performed.
	 *  @return array of type array
	 */
	
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
	
	/**
	 * This method is responsible for generating int and floating point values in an order inversely 
	 * with the possibility of repeating values by returning an array with the ordering performed.
	 *  @return array of type array
	 */
	
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
	
	/**
	 * This method is responsible for generating int and floating point values in a random way with the 
	 * possibility of repeating values by returning an array with the ordering performed.
	 *  @return array of type array
	 */
	
	public int[] randomOrderedRepeated()
	{
		int[] array = new int[nElements];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int)(Math.random()*(roof-floor))+floor;
		}
		return array;
	}
	
	/**
	 * This method is responsible for generating int and floating point values in a random way by returning 
	 * an array with the ordering made.
	 *  @return array of type array
	 */
	
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
	
	/**
	 * This method is responsible for generating int and floating point values in an orderly manner with a 
	 * percentage of disorder in the values returning an array with the ordering performed.
	 * 
	 * @param percentage of double type with the characteristic of indicating the disorder of the values.
	 *  @return array of type array.
	 */
	
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
	
	/**
	 * This method is responsible for generating int and floating point values in an orderly manner with 
	 * a percentage of clutter with the possibility of repeating the values, returning an array with the 
	 * ordering performed.
	 * 
	 * @param percentage of double type with the characteristic of indicating the disorder of the values.
	 * @return array of type array
	 */
	
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



	public int getnElements() {
		return nElements;
	}


	

	public double getPercent() {
		return percent;
	}



	public void setPercent(double percent) {
		this.percent = percent;
	}



	public int getFloor() {
		return floor;
	}



	public int getRoof() {
		return roof;
	}
}
