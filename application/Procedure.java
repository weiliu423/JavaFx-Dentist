package application;

import java.io.Serializable;

public class Procedure implements Serializable{

	int procNo = 0;
	String procName = "";
	double procCost = 0;

	public Procedure(String pN, double pC){
		this.procName = pN;
		this.procCost = pC;
		
	}
	
	public String getprocName(){
		return procName;
	}
	public void setprocName(String pN){
		this.procName = pN;
	}
	public double getprocCost(){
		return procCost;
	}
	public void setprocCost(double pC){
		this.procCost = pC;
	}
	public String toString(){
		return ("\nProcedure Number: " + procNo + "\nProcedure Name : "+procName +"\nProcedure Cost: "+procCost);
	}
	public void print(){
		System.out.print(toString());
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
