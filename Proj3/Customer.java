import java.util.*;

//----------------------------Abstract Customer class----------------------------

//This is our Observer
public abstract class Customer {
	public String name;
	public boolean canRent;
	//public List<Rental> rentals = List<Rental>();
	protected HardwareStore store;
	
	public Customer(String name) {
		this.name = name;
	}
	
	//Helper method for doing a rental
	public abstract void rent();
	
	//TODO
	public void returnRental() {
		
	}
	
	//Observer update method TODO
	public void update(int newState) {
		//decrease days of rentals, return rentals with 0 days left, if state is 1 then rent new things
	}
	
}

//----------------------------Concrete Customer classes----------------------------

class BusinessCustomer extends Customer {
	public BusinessCustomer(String name) {
		super(name);
	}
	//Rent 3 random tools for 7 nights TODO
	public void rent() {
		
	}
}

class CasualCustomer extends Customer {
	public CasualCustomer(String name) {
		super(name);
	}
	//Rent 1-2 random tools for 1-2 nights (random) TODO
	public void rent() {
		
	}
}

class RegularCustomer extends Customer {
	public RegularCustomer(String name) {
		super(name);
	}
	//Rent 1-3 random tools for 3-5 nights (random) TODO
	public void rent() {
		
	}
}

//----------------------------Rental class----------------------------

class Rental {
	private List<Tool> tools;
	private int days;
	public int remainingDays;
	
	public Rental(List<Tool> tools, int days) {
		this.tools = tools;
		this.days = days;
	}
	
	public void printRental() {
		
	}
	
}




