import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AirlineMgmt {
	Scanner sc= new Scanner(System.in);
	ArrayList<Flight> flightlist = new ArrayList<Flight>();
	ArrayList<Customer> customerlist= new ArrayList<Customer>();
	ArrayList<Booking> bookinglist= new ArrayList<Booking>();
	private static Scanner sc2;
	
	//	function to add a flight
	public void addFlight() {
		String source, destination;
		int fno;
		float price;
		Date date;
		
		System.out.println("-- ADD A FLIGHT --");
		
		System.out.println("Enter Flight number: ");
		fno=sc.nextInt();
		System.out.println("Enter Source and destination from the given places: ");
		int i =1;
		for (Flight.Place p : Flight.Place.values()) {
			  System.out.println(i+". "+p);
			  i++;
			}
//		Validation for source and destination
		while(true) {
			try {
			System.out.println("Source: ");
			sc=new Scanner(System.in);
			source=sc.next();
			Flight.Place.valueOf(source);
			break;
			}
			catch(Exception e) {
			System.out.println("Invalid! Enter again. ");
			}
			
			}
		
		while(true) {
		try {
		System.out.println("Destination: ");
		sc=new Scanner(System.in);
		destination=sc.next();
		Flight.Place.valueOf(destination);
		break;
		}
		catch(Exception e) {
		System.out.println("Invalid! Enetr again. ");
		}
		}
		
		//Error handling for Date
		while(true) {
		try {
		    //Parsing the String
			System.out.println("Enter the Date ");
			sc=new Scanner(System.in);
			String dateinput = sc.next();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			date=null;
		    date = dateFormat.parse(dateinput);
		    break;
		} catch (Exception e) {
			System.out.println("Incorrect! Enter again!");
		}
		}
		
		System.out.println("Enter price: ");
		price= sc.nextFloat();
		Flight ob= new Flight(fno, source , destination ,date,  price);
		
		flightlist.add(ob);
		
	
		
	}
	
// Display all the flights	
	
	public void displayFlights() {
		System.out.println("-- ALL FLIGHTS --");
		System.out.printf("%10s %10s %10s %40s %5s \n","Flight Number","Source","Destination","Date","Price");
		for(int j=0; j<flightlist.size();j++ ) {
				flightlist.get(j).display();
		}
	}
	
//	Display flights by Customer
	public void displayFlightByCustomer() {
		//Display flight by customer
		System.out.println("--FLIGHT BY CUSTOMER--");
		System.out.println("Enter Customer ID: ");
		int cid = sc.nextInt();
		boolean flag=true;
		for(int j=0; j<bookinglist.size();j++ ) {
			if(bookinglist.get(j).getId()==cid) {
				System.out.printf("%10s %10s %5s %10s %10s %10s %40s %5s \n","CustomerID",
						"Name","Age","Flight Number","Source",
						"Destination","Date","Price");
				bookinglist.get(j).display();
				flag=false;
			}
		}
		if(flag) {
			System.out.println("No bookings by this user!");
		}
		else {
			System.out.println("---");
		}
		
	}
	
//	Add customer
	public void addCustomer() {
		
		//taking input 
		System.out.println("-- ADD CUSTOMER--");
		System.out.println("Enter name: ");
		String name=sc.next();
		System.out.println("Enter age: ");
		int age = sc.nextInt();
		
		//Object of class customer
		Customer customer = new Customer(name, age);
		
		//Adding to the list
		customerlist.add(customer);
		System.out.println("Added customer !");
	}
	
//	Display all customers
	public void displayCustomers() {
		System.out.println("-- ALL USERS --");
		System.out.printf("%10s %10s %5s\n", "CustomerID","NAME", "AGE");
		for(int j=0; j<customerlist.size();j++ ) {
			customerlist.get(j).display();
		}
	}
	
//	Display customers by flight
	public void displayCustomersByFlight() {
		
		System.out.println("--BOOKINGS OF FLIGHT--");
		System.out.println("Enter Flight number: ");
		int fid = sc.nextInt();
		boolean flag=true;
		for(int j=0; j<bookinglist.size();j++ ) {
			if(bookinglist.get(j).getN()==fid) {
				System.out.printf("%10s %10s %5s %10s %10s %10s %40s %5s \n","CustomerID",
						"Name","Age","Flight Number","Source",
						"Destination","Date","Price");
				bookinglist.get(j).display();
				flag=false;
			}
		}
		if(flag) {
			System.out.println("No bookings on this flight!");
		}
		else {
			System.out.println("---");
		}
	}
	
//	Book ticket
	public void book() {
		//Book tickets
		String name="", source, destination;
		int id, fid, age=0;
		float price=0.0f;
		Date date=null;
		System.out.println("--Book Ticket--");
		
			// input 
		System.out.println("Enter Customer ID");
		id=sc.nextInt();
		boolean flag=false;
		//check if the customer exists
		k:for(int j=0; j<customerlist.size();j++ ) {
			int cid = customerlist.get(j).getId();
			if(cid==id) {
				// match found
				name = customerlist.get(j).getName();
				age = customerlist.get(j).getAge();
				flag=true;
				break k;
			}
		}
		if(flag){
			System.out.println("Enter Source and destination from the given places: ");
			int i =1;
			for (Flight.Place p : Flight.Place.values()) {
				  System.out.println(i+". "+p);
				  i++;
				}
			
//			Validation for source and destination
			while(true) {
				try {
				System.out.println("Source: ");
				sc=new Scanner(System.in);
				source=sc.next();
				Flight.Place.valueOf(source);
				break;
				}
				catch(Exception e) {
				System.out.println("Invalid! Enter again. ");
				}
				
				}
			
			while(true) {
			try {
			System.out.println("Destination: ");
			sc=new Scanner(System.in);
			destination=sc.next();
			Flight.Place.valueOf(destination);
			break;
			}
			catch(Exception e) {
			System.out.println("Invalid! Enter again. ");
			}
			}
			
			// check if flight exists
			boolean fflag=false;
			for(int j=0; j<flightlist.size();j++ ) {
				String f = flightlist.get(j).getF();
				String t = flightlist.get(j).getT();
				if(f.equals(source) && t.equals(destination)) {
					// match found
					fflag=true;
					flightlist.get(j).display();
					break;
				}
			}
			if(fflag) {
				System.out.println("Please enter the flight number you want to book: ");
				fid=sc.nextInt();
				for(int j=0; j<flightlist.size();j++ ) {
					Flight fob= flightlist.get(j);
					if(fid==fob.getN()) {
						date  = fob.getD();
						price = fob.getP();
						break;
					}
				}
				Booking bob=new Booking(id, name, age, fid, source, destination, date
						, price);
				bookinglist.add(bob);
				System.out.println("Booked!");
				
			}
			else {
				System.out.println("Sorry no flights available !");
			}
			
			
		}
		else {
			System.out.println("Doesn't exist");
			
		}
		
		
	}
	
//	Cancel ticket
	public void cancel() {
		System.out.println("--CANCELLATION--");
		System.out.println("Enter Customer ID: ");
		int cid = sc.nextInt();
		boolean flag=true;
		for(int j=0; j<bookinglist.size();j++ ) {
			if(bookinglist.get(j).getId()==cid) {
				System.out.printf("%10s %10s %5s %10s %10s %10s %40s %5s \n","CustomerID",
						"Name","Age","Flight Number","Source",
						"Destination","Date","Price");
				bookinglist.get(j).display();
				flag=false;
			}
		}
		if(flag) {
			System.out.println("No bookings by this user!");
		}
		else {
			System.out.println("Enter the flight number you want to cancel: ");
			int fid = sc.nextInt();
			for(int j=0; j<bookinglist.size();j++ ) {
				Booking bob= bookinglist.get(j);
				if(bob.getN()==fid) {
					bookinglist.remove(bob);
					System.out.println("Your booking with flight number "+bob.getN()
					+" is CANCELLED! ");
				}
			}
		}
		
	}
	
	
//	Show all bookings
	public void displayBooking() {
		System.out.println("-- ALL BOOKINGS --");
		for(int j=0; j<bookinglist.size();j++ ) {
			bookinglist.get(j).display();
		}
	}

public static void main(String[] args) {
	sc2 = new Scanner(System.in);
	AirlineMgmt ob= new AirlineMgmt();
	boolean e=true;
	while(e) {
	System.out.println("\n************************************");
	System.out.println("1. Add flight \n2. Display all flights\n"
			+ "3. Display flights by Customer\n"
			+ "4. Add a customer\n5. Display all Users\n"
			+ "6. Display customers by flight\n"
			+ "7. Book ticket\n8. Cancel booking\n9. Display all bookings\n10. Exit");
	
	System.out.println("\nEnter your choice: ");
	int choice= sc2.nextInt();
	
	switch(choice) {
	case 1: //add a flight
			ob.addFlight();
			break;
			
	case 2:// Display all flights
			ob.displayFlights();
			break;
	
	case 3: // Display flight booked by a particular user
			ob.displayFlightByCustomer();
			break;
			
	case 4: //Add a customer
			ob.addCustomer();
			break;
			
	case 5: //Display all customers
			ob.displayCustomers();
			break;
			
	case 6: // Display customer by flight
			ob.displayCustomersByFlight();
			break;
			
	case 7: //booking ticket
			ob.book();
			break;
			
	case 8: //cancel booking
			ob.cancel();
			break;
			
	case 9: //Display all bookings
			ob.displayBooking();
			break;
			
	case 10: //Exit
			e=false;
			break;
			
	default: System.out.println("Incorrect response!!");
	
	}
	}
	
	
	
}
}
