
import java.util.Date;


public class Flight {
	enum Place{
		BOM,
		BBSR,
		LKO
		
	}
	
	private int n;
	private float p;
	String t,f;
	private Date d;
	Flight(int n,String f,String t, Date d,float p){
		this.n=n;
		this.f=f;
		this.t=t;
		this.d=d;
		this.p=p;
		System.out.println("Flight Added !");
	}
	
	public void display() {
//		System.out.println("Flight number: "+this.n+ "\n"+"Source: "+this.f+"\n"+"Destination: "+
//				this.t+"\n"+"Date: "+this.d+"\n"+"Price: "+this.p+"\n");
		

		System.out.printf("%10d %10s %10s %40s %5f \n",this.n,this.f,
				this.t,this.d.toString(),this.p);
	}

	public int getN() {
		return n;
	}

	public float getP() {
		return p;
	}

	public String getT() {
		return t;
	}

	public String getF() {
		return f;
	}

	public Date getD() {
		return d;
	}
	
	
	
	
		
		
}

