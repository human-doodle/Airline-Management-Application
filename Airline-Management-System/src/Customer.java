
import java.lang.String;

public class Customer {
	private static int sid=0;
	private String name;
	private int id,age;
	Customer(String name, int age){
		this.name=name;
		this.age=age;
		sid=sid+1;
		this.id=sid;
		System.out.println("Adding Customer with customerID: "+this.id+"...");
	}
	
	public void display() {
//		System.out.println("Customer ID: "+id+ "\n"+"Name: "+this.name+"\n"+"Age: "+
//				this.age+"\n");
		
		System.out.format("%10d %10s %5d\n", this.id,this.name,this.age);
	}
	
	public int getId() {
		return this.id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}


}
