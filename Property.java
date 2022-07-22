/**
 * This class defines a Property object and its private feilds to hold
 * the values of what defines a Property
 * @author William Batres
 *
 */
public class Property {
	

	private String city;
	private String owner;
	private String propertyName;
	private double rentAmount;
	private Plot plot;
	
	/**
	 * No Arg-Constructor that assigns default values 
	 */
	public Property()
	{
		this.city ="";
		this.owner = "";
		this.propertyName = "";
		this.rentAmount = 0.0;
		this.plot = new Plot();
	}
	/**
	 * Constructor that takes a Property object and assgin's that objects values to the 
	 * values of the new property created 
	 * @param p A property object with its own preassigned values
	 */
	
	public Property(Property p)
	{
		this.city = p.city;
		this.owner = p.owner;
		this.propertyName = p.propertyName;
		this.rentAmount = p.rentAmount;
		this.plot = new Plot(p.getPlot());
		
	}
	/**
	 * Constructor that takes 4 arguments and assigns them to a new property object and creates 
	 * a default plot
	 * @param propertyName The name of the property as a String
	 * @param city The name of the city as a String 
	 * @param rentAmount the amount of rent for the property as a double
	 * @param Owner The name of the owner of the property
	 */
	
	public Property(String propertyName, String city, 
			double rentAmount,String Owner)
	{
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = Owner;
		this.plot = new Plot();
		
	}
	/**
	 * Constructor that takes 8 argument and creates a new plot object with the 
	 * last 4 integer arguments
	 * @param propertyName The name of the property as a String
	 * @param city The name of the city as a String
	 * @param rentAmount The amount of rent for the property as a double
	 * @param Owner The name of the owner of the property
	 * @param x X coordinate of the plot
	 * @param y Y coordinate of the plot
	 * @param width Length of X coordinate of the plot
	 * @param depth Length of Y coordinate of the plot
	 */
	public Property(String propertyName, String city, double rentAmount
			,String Owner, int x, int y, int width, int depth)
	{
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = Owner;
		this.plot = new Plot(x,y,width,depth);
	}
		
	/**
	 * Returns the name of the city from the corresponding object
	 * @return String variable that is he name of the City
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * Takes a String variable and assigns that value as that corresponding 
	 * objects city
	 * @param city String that will be assigned to the name of the city
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * Returns the name of the property owner form the corresponding object
	 * @return String variable that is the name of the property owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * Takes a String variable and assigns that value as that corresponding 
	 * objects property owner
	 * @param owner String variable that will be assigned to the owners name
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * Returns the name of the Property
	 * @return String variable that is the name of the property name 
	 */
	public String getPropertyName() {
		return propertyName;
	}

	/**
	 * Takes a String variable and assigns that value as that corresponding 
	 * objects property name
	 * @param propertyName String variable that will be assigned to the property's name
	 */
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	/**
	 * Returns the rent amount of the property
	 * @return Double variable of the rent amount for the property
	 */
	public double getRentAmount() {
		return rentAmount;
	}
	
	/**
	 * Takes a double variable and assign's that arguments value
	 * to the property's rent amount 
	 * @param rentAmount Double variable that will be assigned to the property's rent amount
	 */
	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}

	/**
	 * Returns the plot object of that property
	 * @return A plot object
	 */
	public Plot getPlot() {
		return plot;
	}
	
	/**
	 * takes a plot object as an argument and takes all the x,y,width 
	 * and length of that plot and sets a new plot's values to the arguments plot values
	 * @param plot A plot object
	 */
	public void setPlot(Plot plot) {
		this.plot.setX(plot.getX()); 
		this.plot.setY(plot.getY()); 
		this.plot.setDepth(plot.getDepth());
		this.plot.setWidth(plot.getWidth());
	}
	/**
	 * Overridden method that takes the individual x,y,width and length values 
	 * and assigns them to the plots values
	 * @param x X coordinate
	 * @param y Y coordinate
	 * @param width Length of X coordinate
	 * @param depth Length of Y coordinate
	 */
	public void setPlot(int x, int y, int width, int depth) {
		this.plot.setX(x); 
		this.plot.setY(y); 
		this.plot.setDepth(depth);
		this.plot.setWidth(width);
	}
	/**
	 * To-String method to format the information of a property by the name, property name,
	 * city, owner and rent amount
	 */
	@Override
	public String toString() {
		return "Property Name: " + this.propertyName + "\n" + "Located in: " + this.city
				+ "\n" + "Belonging to: " + this.owner +  "\n" + "Rent Amount: "
				+ this.rentAmount + "\n";
	}
	
	
	
	
	
	
	
}
