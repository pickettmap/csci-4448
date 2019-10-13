import java.util.*;

public class Test
{
	public static void main(String args[])
	{
	
	}
}

class Customer
{
	Protected String name_;
	Protected int days_;
	Protected List<Tool> rentals_;
	Protected int num_tools_;
	
	Public Customer()
	{
		
	}
}

class CasualCustomer extends Customer
{
	public CasualCustomer()
	{
	}
}


// class CustomerFactory(String type)
// {
// 	Customer customer = null;
	
// 	if(type.equals("casual"))
// 	{
// 		customer = new CasualCustomer();
// 	}
// 	else if (type.equals("business"))
// 	{
// 		customer = new BusinessCustomer();
// 	}
// 	else if (type.equals("regular"))
// 	{
// 		customer = new RegularCustomer();
// 	}
// 	return customer;
		
// }