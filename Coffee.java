
public class Coffee extends Beverage {

	private boolean extraShot, extraSyrup;
	private static final double EXTRASHOTCOST = .5;
	private static final double EXTRASYRUPCOSE = .5;
	
	
	
	public Coffee(String name, SIZE size, boolean extraShot, boolean extraSyrup)
	{
		super(name, TYPE.COFFEE , size);
		this.extraShot = extraShot;
		this.extraSyrup = extraSyrup;
	}
	
	
	
	public boolean getExtraShot() {
		return extraShot;
	}



	public void setExtraShot(boolean extraShot) {
		this.extraShot = extraShot;
	}



	public boolean getExtraSyrup() {
		return extraSyrup;
	}



	public void setExtraSyrup(boolean extraSyrup) {
		this.extraSyrup = extraSyrup;
	}



	@Override
	public String toString()
	{
		String s1 = "";
		
		s1 += "Coffee name: " + getBevName() + " size: " +
				getSize();
		
		if(extraShot == true)
			s1 += " Extra shot ";
		
		if(extraSyrup == true)
			s1 += " Extra syrup ";
		s1 += " $ " + this.calcPrice();
		return s1;
	}

	@Override
	public double calcPrice() {
		double price =super.BASEPRICE;
		
		if(super.getSize() == SIZE.MEDIUM )
			price += super.SIZEPRICE;
		
		if(super.getSize() == SIZE.LARGE )
			price += 2 * super.SIZEPRICE;
		
		if(extraShot == true)
			price += this.EXTRASHOTCOST;
		
		if(extraSyrup == true)
			price += this.EXTRASYRUPCOSE;
		
		return price;
	}
	
	

	
	@Override
	public boolean equals(Object o)
	{
		Coffee temp = (Coffee) o;
		if(super.equals(temp) && this.extraShot == temp.getExtraSyrup() && this.extraSyrup
				== temp.getExtraSyrup())
			return true;
		
		return false;
	
	}
	public double getBasePrice()
	{
		return super.getBaseprice();
	}

}
