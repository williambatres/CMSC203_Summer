

public class Smoothie extends Beverage {

	private int numOfFruits;
	private boolean hasProteinPowder;
	private static final double PROTEINPOWDER_COST = 1.5;
	private static final double FRIUTS_COST = 0.5;
	
	public Smoothie(String name, SIZE size,int numberOfFruits, boolean hasProteinPowder)
	{
		super(name, TYPE.SMOOTHIE , size);
		this.hasProteinPowder = hasProteinPowder;
		this.numOfFruits = numberOfFruits;
	}
	
	public int getNumOfFruits() {
		return numOfFruits;
	}

	public void setNumbOfFruits(int numOfFruits) {
		this.numOfFruits = numOfFruits;
	}

	public boolean getAddProtien() {
		return hasProteinPowder;
	}

	public void setHasProteinPowder(boolean hasProteinPowder) {
		this.hasProteinPowder = hasProteinPowder;
	}

	@Override
	public double calcPrice() {
		double price =super.BASEPRICE;
		
		if(super.getSize() == SIZE.MEDIUM )
			price += super.SIZEPRICE;
		
		if(super.getSize() == SIZE.LARGE )
			price += 2 * super.SIZEPRICE;
		
		if(hasProteinPowder == true)
			price += this.PROTEINPOWDER_COST;
		
		if(numOfFruits > 0)
		{
		for(int i = 0; i < numOfFruits; i++)
			price += FRIUTS_COST;
		}
		
		
		return price;
	
	}
	
	@Override
	public String toString()
	{	
		return "Smoothie name: " + getBevName() + " size: " +
				getSize() + " has protein powder: " + hasProteinPowder
				+ " number of fruits: " + numOfFruits + " $ " + this.calcPrice();
	
	}
	
	@Override
	public boolean equals(Object o)
	{
		Smoothie temp = (Smoothie) o;
		return(super.equals(temp) && this.hasProteinPowder == temp.getAddProtien()
				&& this.numOfFruits == temp.numOfFruits);
		
	}
	public double getBasePrice()
	{
		return super.getBaseprice();
	}


}
