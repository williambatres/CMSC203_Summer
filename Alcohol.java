

public class Alcohol extends Beverage {

	private boolean offeredOnWeekend;
	private static final double OFFEREDONWEEKEND_COST = .60;
	
	public Alcohol(String name, SIZE size, boolean offeredOnWeekend)
	{
		super(name, TYPE.ALCOHOL , size);
		this.offeredOnWeekend = offeredOnWeekend;
	}
	
	
	public boolean isOfferedOnWeekend() {
		return offeredOnWeekend;
	}


	public void setOfferedOnWeekend(boolean offeredOnWeekend) {
		this.offeredOnWeekend = offeredOnWeekend;
	}


	@Override
	public String toString()
	{
		String s1 = "";
		
		s1 += "Alcohol name: " + getBevName() + " size: " +
				getSize();
		
		if(offeredOnWeekend == true)
			s1 += " Extra syrup ";
		s1 += " $ " + this.calcPrice();
		return s1;
	}
	
	@Override
	public boolean equals(Object o)
	{
		Alcohol temp = (Alcohol) o;
		return(super.equals(temp) && this.offeredOnWeekend == temp.isOfferedOnWeekend());
		
	}

	@Override
	public double calcPrice() {
		double price =super.BASEPRICE;
		
		if(super.getSize() == SIZE.MEDIUM )
			price += super.SIZEPRICE;
		
		if(super.getSize() == SIZE.LARGE )
			price += 2 * super.SIZEPRICE;
		
		if(offeredOnWeekend == true)
			price += this.OFFEREDONWEEKEND_COST;
		
		return price;
	
	}
	public double getBasePrice()
	{
		return super.getBaseprice();
	}
	
	
}
