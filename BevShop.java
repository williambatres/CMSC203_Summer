import java.util.ArrayList;

public class BevShop implements BevShopInterface{

	private int numberOfAlcholicDrinks;
	private int currentOrder;
	private ArrayList<Order> orders = new ArrayList<Order>();
	
	public int getMinAgeForAlcohol()
	{
		return this.MIN_AGE_FOR_ALCOHOL;
	}
	
	public int getMaxOrderForAlcohol()
	{
		return this.MAX_ORDER_FOR_ALCOHOL;
	}
	
	public int getMIN_TIME()
	{
		return this.MIN_TIME;
	}
	
	public int getMAX_TIME()
	{
		return this.MAX_TIME;
	}
	public int getMAX_FRUIT()
	{
		return this.MAX_FRUIT;
	}
	
	
	public int getNumOfAlcoholDrink() {
		return numberOfAlcholicDrinks;
	}

	public void setNumberOfAlcholicDrinks(int numberOfAlcholicDrinks) {
		this.numberOfAlcholicDrinks = numberOfAlcholicDrinks;
	}

	public Order getCurrentOrder() {
		for(int i = 0; i < orders.size(); i++)
		{
			if(orders.get(i).getOrderNo() == this.currentOrder)
				return orders.get(i);
		}
		return orders.get(currentOrder);
	}

	public void setCurrentOrder(int currentOrder) {
		this.currentOrder = currentOrder;
	}

	public ArrayList<Order> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}

	@Override
	public boolean validTime(int time) {
		if(time >= MIN_TIME && time <= MAX_TIME)
			return true;
		return false;
	}

	@Override
	public boolean eligibleForMore() {
		if(numberOfAlcholicDrinks < MAX_ORDER_FOR_ALCOHOL)
			return true;
		return false;
	}

	@Override
	public boolean validAge(int age) {
		if(age > MIN_AGE_FOR_ALCOHOL)
			return true;
		return false;
	}

	@Override
	public void startNewOrder(int time, DAY day, String customerName, int customerAge) {
		Customer c = new Customer(customerName,customerAge);
		Order o = new Order(time,day,c);
		orders.add(o);
		currentOrder = orders.indexOf(o);
		numberOfAlcholicDrinks = 0;
		
	}

	@Override
	public void processCoffeeOrder(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		orders.get(currentOrder).addNewBeverage(bevName, size, extraShot, extraSyrup);
		
	}

	@Override
	public void processAlcoholOrder(String bevName, SIZE size) {
		orders.get(currentOrder).addNewBeverage(bevName, size);
		numberOfAlcholicDrinks++;
		
	}

	@Override
	public void processSmoothieOrder(String bevName, SIZE size, int numOfFruits, boolean addProtien) {
		orders.get(currentOrder).addNewBeverage(bevName, size, numOfFruits, addProtien);
		
	}

	@Override
	public int findOrder(int orderNo) {
		for(int i = 0; i < orders.size(); i++)
		{
			if(orders.get(i).getOrderNo() == orderNo)
				return i;
		}
		return -1;
	}

	@Override
	public double totalOrderPrice(int orderNo) {
		double tempTotal = 0;
		for(int i = 0; i < orders.size(); i++)
		{
			if(orders.get(i) != null)
			{
				if(orders.get(i).getOrderNo() == orderNo)
					for(int x = 0; x < orders.get(i).getBeverages().size() ; x++)
					{
						tempTotal += orders.get(i).getBeverage(x).calcPrice();
					}
			}
		}
		
		return tempTotal;
	}

	@Override
	public double totalMonthlySale() {
		double tempTotal = 0;
		for(int i = 0; i < orders.size(); i++)
		{
			if(orders.get(i) != null)
					tempTotal += orders.get(i).calcOrderTotal();
				
		}
		
		return tempTotal;
	}

	@Override
	public void sortOrders() {
		for(int i = 0; i < orders.size();i++ )
		{
			int minCounter = i;
			for(int t = i + 1; t < orders.size(); t++)
			{
				if(orders.get(t).getOrderNo() < orders.get(i).getOrderNo())
					minCounter = t;
			}
			Order Temp = orders.get(minCounter);
			orders.set(minCounter, orders.get(i));
			orders.set(i, Temp);
		}
		
	}

	@Override
	public Order getOrderAtIndex(int index) {
		
		return orders.get(index);
	}
	
	public int totalNumOfMonthlyOrders()
	{
		return orders.size();
	}
	
	public boolean isMaxFruit(int x)
	{
		if(x > this.MAX_FRUIT)
			return true;
		return false;
	}
	@Override
	public String toString()
	{
		String tempString = "Monthly orders: ";
		for(int i = 0; i < orders.size(); i++)
		{
			if(orders.get(i) != null)
					tempString += orders.get(i).toString();
				
		}
		tempString += "\nTotal sales: " + totalMonthlySale();
		return tempString;
	}
	

}
