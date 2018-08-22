package model;

import java.util.Arrays;

public class Sorter {

	public Sorter(int[] array, int roof, int floor, double percentOrder) {
		this.array = array;
		this.roof = roof;
		this.floor = floor;
		this.percentOrder = percentOrder;
	}

	private int[] array;
	private int roof;
	private int floor;
	private double percentOrder;
	
	public int[] getArray()
	{
		return array;
	}
	
	public void sort()
	{
		boolean bigNums = false;
		boolean almostOrdered = false;
		boolean bigInterval = false;
		if(floor>100)
		{
			bigNums = true;
		}
		if(percentOrder<0.1)
		{
			almostOrdered = true;
		}
		if((roof-floor)>100)
		{
			bigInterval = true;
		}
		if(bigNums&&!bigInterval)
		{
			countingsort(array);
		}
		else if(bigInterval&&!bigNums)
		{
			radixsort(array, array.length);
		}
		else if(bigInterval&&bigNums&&!almostOrdered)
		{
			quicksort(array, 0, array.length-1);
		}
		else
		{
			radixsort(array, array.length);
		}
		
	}
	
	private int getMax(int arr[], int n)
	{
		int mx = arr[0];
		for (int i = 1; i < n; i++)
			if (arr[i] > mx)
				mx = arr[i];
		return mx;
	}
	
	private void countSort(int arr[], int n, int exp)
	{
		int output[] = new int[n];
		int i;
		int count[] = new int[10];
		Arrays.fill(count,0);
		
		for (i = 0; i < n; i++)
			count[ (arr[i]/exp)%10 ]++;
 
		for (i = 1; i < 10; i++)
			count[i] += count[i - 1];
		
		for (i = n - 1; i >= 0; i--)
		{
			output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
            count[ (arr[i]/exp)%10 ]--;
		}
		
		for (i = 0; i < n; i++)
			arr[i] = output[i];
	}
	
	private void radixsort(int arr[], int n)
	{
		int m = getMax(arr, n);
		for (int exp = 1; m/exp > 0; exp *= 10)
			countSort(arr, n, exp);
	}
	
	public void quicksort(int array[], int left, int right) 
	{
		int pivot=array[left];
		int i=left;
		int j=right;
		int aux;
		
		while(i<j)
		{            
			while(array[i]<=pivot && i<j)
			{
				i++;
			}
			while(array[j]>pivot)
			{
				j--;         
			}
			if (i<j)
			{                      
				aux= array[i];                  
				array[i]=array[j];
				array[j]=aux;
			}
		}
		array[left]=array[j];
		array[j]=pivot;
		if(left<j-1)
		{
			quicksort(array,left,j-1);
		}
		if(j+1 <right)
		{
			quicksort(array,j+1,right);
		}
	}

	private void countingsort(int[] array) {
		int[] aux = new int[array.length];

		int min = array[0];
		int max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
			} else if (array[i] > max) {
				max = array[i];
			}
		}
	 
		int[] counts = new int[max - min + 1];

		for (int i = 0;  i < array.length; i++) {
			counts[array[i] - min]++;
		}
	 
		counts[0]--;
		for (int i = 1; i < counts.length; i++) {
			counts[i] = counts[i] + counts[i-1];
		}
	    
		for (int i = array.length - 1; i >= 0; i--) {
			aux[counts[array[i] - min]--] = array[i];
		}
		
		this.array = aux;
	}
}
