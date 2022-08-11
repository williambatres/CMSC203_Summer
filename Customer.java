
public class Customer {
	private String name;
	private int age;
	
	public Customer(String name, int age)
	{
		this.age = age;
		this.name = name;
	}
	
	public Customer(Customer c)
	{
		this.age = c.getAge();
		this.name = c.getName();
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString()
	{
		return this.name + " , " + "is " + this.age + " years old";
	}
}
