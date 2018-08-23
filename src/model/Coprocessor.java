package model;

public class Coprocessor {

	private Generator generator;
	private Sorter sorter;
	
	public Coprocessor()
	{
		generator = null;
		sorter = null;
	}

	public Generator getGenerator() {
		return generator;
	}

	public Sorter getSorter() {
		return sorter;
	}

	public void setGenerator(Generator generator) {
		this.generator = generator;
	}

	public void setSorter(Sorter sorter) {
		this.sorter = sorter;
	}
	
	public String concatenate(int[] arr)
	{
		String arreglo = "";
		for (int i = 0; i < arr.length; i++) {
			arreglo+=arr[i]+"-";
		}
		return arreglo;
	}
}
