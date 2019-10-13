import java.util.*;

public class HardwareStore {
	
	public List<Tool> inventory;
	public List<Customer> customers = new ArrayList<>();
	public List<Rental> completedRentals = new ArrayList<>();
	public int numCurrentRentals;
	public int currentDay;
	public int revenue;
	public int casualRentCount;
	public int businessRentCount;
	public int regularRentCount;
	
	public HardwareStore(List<Tool> inventory) {
		this.inventory = inventory;
		this.numCurrentRentals = 0;
		this.currentDay = 35;
		this.casualRentCount = 0;
		this.businessRentCount = 0;
		this.regularRentCount = 0;
	}
	
	//Decrease day count/print day, call 'printCompletedRentals', Notify observers TODO
	public void doDay() {

	}
	
	//prints completed rentals TODO
	public void printCompletedRentals() {
		
	}
	
	//Add a customer (observer) TODO
	public void addCustomer() {
		
	}
	
	//Run for loop for each day TODO
	public void runSimulation() {
		
	}
	
	
	
}
