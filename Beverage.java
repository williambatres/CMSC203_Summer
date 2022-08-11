
public abstract class Beverage {
	
	//Instance variables 
	private String bevName; 
	private TYPE type;
	private SIZE size;
	
	//Constants
	public static final double BASEPRICE = 2.0;
	public static final double SIZEPRICE = 1.0;
	
	
	//Getters and Setters
	public Beverage(String name, TYPE type, SIZE size)
	{
		this.bevName = name;
		this.size = size;
		this.type = type;
	}
	
	public String getBevName() {
		return bevName;
	}

	public void setName(String name) {
		this.bevName = name;
	}
	
	public TYPE getType() {
		return type;
	}

	public void setType(TYPE type) {
		this.type = type;
	}

	public SIZE getSize() {
		return size;
	}

	public void setSize(SIZE size) {
		this.size = size;
	}



	public static double getSizeprice() {
		return SIZEPRICE;
	}

	public static double getBaseprice() {
		return BASEPRICE;
	}

	//Abstract class
	public abstract double calcPrice();
	
	//Overriden Methods 
	@Override
	public String toString()
	{
		return "Beverage Name: " + this.bevName
				+ " Beverage Size: " + this.size;
	}
	
	@Override
	public boolean equals(Object B)
	{
		Beverage temp = (Beverage) B;
		if(this.bevName.equals(temp.getBevName())&&
				this.size == temp.getSize() && this.type
				== temp.getType())
					return true;
		return false;
	}


	
	
}
