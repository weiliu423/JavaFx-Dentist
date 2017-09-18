package application;
import java.io.Serializable;
import java.util.*;

public class Payment implements Serializable{

int paymentNo = 0;
double paymentAmt = 0;
Date paymentDate; 

Payment(Date paymentDate, double pAmt){
	this.paymentDate = new Date();
	this.paymentAmt = pAmt;
}
public int getpaymentNo(){
	return paymentNo;
}
public void setpaymentNo(int py){
	this.paymentNo = py;
}
public double getpaymentAmt(){
	return paymentAmt;
}
public void setpaymentAmt(double Amt){
	this.paymentAmt = Amt;
}
public String toString(){
	return ("\nPayment: "+paymentNo +"\nPayment amounts: "+paymentAmt+"\nPayment Date: "+ paymentDate+"\n");
}
public void print(){
	System.out.print(toString());
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
