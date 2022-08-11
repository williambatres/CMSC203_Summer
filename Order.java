import java.util.ArrayList;
import java.util.Random;

public class Order implements OrderInterface,Comparable {

	private int orderNo;
	private int time;
	private DAY day;
	private Customer customer;
	private ArrayList<Beverage> beverages;
	
	public Order(int time, DAY day, Customer c)
	{
		this.time = time;
		this.day = day;
		this.customer = c;
		beverages = new ArrayList<>();
		this.orderNo = generateRandomNumber();
	}
	
	
	public int generateRandomNumber()
	{
		Random rand = new Random();
		int randomNumb = rand.nextInt(90000 - 10000) + 10000;
		return randomNumb;
	}
	public int getTotalItems()
	{
		return beverages.size();
	}
	
	@Override
	public String toString()
	{
		String tempString = "";
	
		
		tempString += "Order Number: " + this.orderNo + " Time: " + this.time
				+ " Customer Name: " + this.customer.toString() + " ";
				
		for(int i = 0; i < beverages.size() ; i++)
			{
				tempString += beverages.get(i).toString();
			}
		
		tempString += "\n" + "Ordert Total: " + calcOrderTotal();	
		
		return tempString;
	}
	
	
	@Override
	public int compareTo(Object o) {
		Order temp = (Order) o;
		
		if(this.orderNo == temp.getOrderNo())
			return 0;
		
		if(this.orderNo > temp.getOrderNo())
			return 1;
		
		return -1;
	}

	@Override
	public boolean isWeekend() 
	{
		if(this.day == DAY.SUNDAY || this.day == DAY.SATURDAY)
			return true;
		return false;
	}

	@Override
	public Beverage getBeverage(int itemNo) {
		if(beverages.get(itemNo) != null)
			return beverages.get(itemNo);
		return null;
	}

	@Override
	public void addNewBeverage(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		Coffee c = new Coffee(bevName,size,extraShot,extraSyrup);
		beverages.add(c);
		
	}

	@Override
	public void addNewBeverage(String bevName, SIZE size) {
		Alcohol a = new Alcohol(bevName,size, isWeekend());
		beverages.add(a);
		
	}

	@Override
	public void addNewBeverage(String bevName, SIZE size, int numOfFruits, boolean addProtien) {
		Smoothie s = new Smoothie(bevName,size,numOfFruits,addProtien);
		beverages.add(s);
		
	}

	@Override
	public double calcOrderTotal() {
		
		double finalTotal = 0;
		
		for(int i = 0; i < beverages.size() ; i++)
		{
			finalTotal += beverages.get(i).calcPrice();
		}
		return finalTotal;
	}

	@Override
	public int findNumOfBeveType(TYPE type) {
		int counter = 0;
		for(int i = 0; i < beverages.size() ; i++)
		{
			if(beverages.get(i).getType() == type)
				counter++;
		}
		return counter;
	}


	


	public int getOrderNo() {
		return orderNo;
	}


	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}


	public int getOrderTime() {
		return time;
	}


	public void setTime(int time) {
		this.time = time;
	}


	public DAY getOrderDay() {
		return day;
	}


	public void setDay(DAY day) {
		this.day = day;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public ArrayList<Beverage> getBeverages() {
		return beverages;
	}


	public void setBeverages(ArrayList<Beverage> beverages) {
		this.beverages = beverages;
	}
	
	
	

}
