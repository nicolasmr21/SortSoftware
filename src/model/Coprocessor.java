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
}
