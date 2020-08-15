
import java.util.Date;

public class Booking{
	
	private int id, age, n;
	private String name,  t, f;
	private float p;
	private Date d;
	
	Booking(int id, String name, int age, int n,String f,String t, Date d, float p){
		this.id=id;
		this.name=name;
		this.age=age;
		this.n=n;
		this.f=f;
		this.t=t;
		this.d=d;
		this.p=p;
		System.out.println("Booking...");
	}
	
	public void display() {
//		System.out.println("Customer ID: "+id+ "\n"+"Name: "+this.name+"\n"+"Age: "+
//				this.age+"\n"+"Flight number: "+this.n+ "\n"+"Source: "+this.f+"\n"+"Destination: "+
//				this.t+"\n"+"Date: "+this.d+"\n"+"\n"+"Price: "+this.p+"\n");
		
		System.out.printf("%10d %10s %5d %10s %10s %10s %40s %5f \n",id,this.name,
				this.age,this.n,this.f,
				this.t,this.d.toString(),this.p);
	}

	public int getId() {
		return id;
	}

	public int getAge() {
		return age;
	}

	public int getN() {
		return n;
	}

	public String getName() {
		return name;
	}

	public String getT() {
		return t;
	}

	public String getF() {
		return f;
	}

	public float getP() {
		return p;
	}

	public Date getD() {
		return d;
	}
	
	
}
