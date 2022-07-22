
public class ManagementCompany {

	//constants variables
	private final int MAX_PROPERTY = 5;
	private final int MGMT_WIDTH = 10;
	private final int MGMT_DEPTH = 10;
	private int counter = 0; 
	
	//variables
	private double mgmFeePer;
	private String name;
	private Property[] propertys;
	private String taxID;
	private Plot plot;
	
	
	public ManagementCompany()
	{
		this.mgmFeePer = 0;
		this.name = "";
		this.taxID = "";
		this.plot = new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
		this.propertys = new Property[MAX_PROPERTY];
		
	}
	
	
	public ManagementCompany(String name, String taxID, double mgmFee)
	{
		this.mgmFeePer = mgmFee;
		this.name = name;
		this.taxID = taxID;
		this.plot = new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
		this.propertys = new Property[MAX_PROPERTY];
	}
	
	public ManagementCompany(String name, String taxID, double mgmFee, int x,
			int y, int width, int depth)
	{
		this.mgmFeePer = mgmFee;
		this.name = name;
		this.taxID = taxID;
		this.plot = new Plot(0,0,width,depth);
		this.propertys = new Property[MAX_PROPERTY];
	}
	
	public ManagementCompany(ManagementCompany mc)
	{
		this.mgmFeePer = mc.mgmFeePer;
		this.name = mc.name;
		this.taxID = mc.taxID;
		this.plot = new Plot(mc.plot);
		
		for(int i = 0 ; i < mc.propertys.length; i++)
		{
			if(mc.propertys[i] != null)
				this.propertys[i] = new Property(mc.propertys[i]);
		}
	}


	public int getMaxProperty() {
		return MAX_PROPERTY;
	}
	

	
	public int addProperty(String name, String city, double rent, String owner)
	{
		Property tempProperty = new Property(name,city,rent,owner);
		int currentIndex = 0;
		if(tempProperty == null)
			return -2;
		if(this.plot.encompasses(tempProperty.getPlot()) == true)
		{
			return -3;
		}
		for(int i = 0 ; i < MAX_PROPERTY; i ++)
		{
			
			if(propertys[i] != null && tempProperty.getPlot().overlaps(propertys[i].getPlot()) == false)
			{
				return -4;
			}
			else if(propertys[i] != null && i == 4)
				return -1;
			else if(propertys[i] == null)
			{
				propertys[i] = tempProperty;
				currentIndex = i;
				return i;
			}
		}
		return currentIndex;
	}
	

	public int addProperty(String name, String city, double rent, String owner,int x, int y, 
			int width, int depth)
	{
		Property tempProperty = new Property(name,city,rent,owner,x,y,width,depth);
		int currentIndex = 0;
		if(tempProperty == null)
			return -2;
		if(this.plot.encompasses(tempProperty.getPlot()) == false)
		{
			return -3;
		}
		for(int i = 0 ; i < MAX_PROPERTY; i ++)
		{
			
			if(propertys[i] != null && tempProperty.getPlot().overlaps(propertys[i].getPlot())== true )
			{
				return -4;
			}
			else if(propertys[i] != null && i == 4)
				return -1;
			else if(propertys[i] == null)
			{
				propertys[i] = tempProperty;
				currentIndex = i;
				return i;
			}
		}
		return currentIndex;
	}
	
	
	public int addProperty(Property property)
	{
		int currentIndex = 0;
		if(property == null)
			return -2;
		if(this.plot.encompasses(property.getPlot()) == false)
		{
			return -3;
		}
		for(int i = 0 ; i < MAX_PROPERTY; i ++)
		{
			
			if(propertys[i] != null && property.getPlot().overlaps(propertys[i].getPlot()) == true)
			{
				return -4;
			}
			else if(propertys[i] != null && i == 4)
				return -1;
			else if(propertys[i] == null)
			{
				propertys[i] = new Property(property);
				currentIndex = i;
				return i;
				
			}
		}
		return currentIndex;
	}
	
	public double totalRent()
	{
		double totalRentAmount= 0;
		for(int i = 0;i < propertys.length; i++)
		{
			if(!(this.propertys[i] == null))
				totalRentAmount += this.propertys[i].getRentAmount();	
		}

		return totalRentAmount;
	}
	
	public double maxRentProp()
	{
		double temp = 0;
		int counterFlagMax = 0;
		for(int i = 0;i < propertys.length; i++)
		{ 
			if(propertys[i] != null)
			{
				if(propertys[i].getRentAmount() > temp)
				{
					temp = propertys[i].getRentAmount();
					counterFlagMax = i;
				}
			}
			else
				i++;

		}
	
		return (double)propertys[counterFlagMax].getRentAmount();

	}
	
	public int maxRentPropIndex()
	{
		double temp = 0;
		int counterFlagMax = 0;
		for(int i = 0;i < propertys.length; i++)
		{ 
			if(propertys[i].getRentAmount() >= temp)
			{
				temp = propertys[i].getRentAmount();
				counterFlagMax = i;
			}

		}
		
		return counterFlagMax;
	}
	
	public String displayPropertyAtIndex(int i)
	{
		return propertys[i].toString();
	}
	
	
	


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Plot getPlot() {
		return plot;
	}


	public void setPlot(Plot plot) {
		this.plot = plot;
	}


	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
	}


	@Override
	public String toString()
	{
		String line = "";
		for(int i = 0; i < 25 ; i++)
		{
			line += "-";
		}
		
		String returnTotalString ="";
		
		returnTotalString += "List of the properties for" + this.name + ", taxID: " + this.taxID 
				+ "\n" + line + "\n";
		
		for(int i = 0 ; i < propertys.length; i++)
		{
			returnTotalString += "\n" +this.propertys[i].toString();
		}
		returnTotalString += "\n" + line + "\n" + "total management Fee: " +
				(this.totalRent() * (this.mgmFeePer * 0.01));
		
		return returnTotalString;
		
	}
	
	
	
	
}
