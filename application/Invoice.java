package application;

import java.util.*;
import java.io.*;
public class Invoice implements Serializable{

int	invoiceNo = 0;
double invoiceAmt = 0;
Date invoiceDate; 
boolean isPaid;

ArrayList<Procedure> in_procList = new ArrayList<Procedure>();
ArrayList<Payment> in_paymentList = new ArrayList<Payment>();

public Invoice(Date invoiceDate,double invoiceAmt) {
	this.invoiceDate = new Date();
	this.invoiceAmt = invoiceAmt;
	
	
}

public boolean getisPaid(){
	return isPaid;
}
public void setisPaid(boolean Pd)
{
	this.isPaid = Pd;
}
public int getinvoiceNo(){
	return invoiceNo;
}

public double getinvoiceAmt(){
	return invoiceAmt;
}
public void setinvoiceAmt(double Amt){
	this.invoiceAmt = Amt;
}
public Date getinvoiceDate(){
	return invoiceDate;
}
public void setinvoiceDate(Date d){
	this.invoiceDate = d;
}
public ArrayList<Payment> getin_paymentList(){
	return in_paymentList;
}
public void setin_paymentList(ArrayList<Payment> lists){
	this.in_paymentList = lists;
}
public void setPayment(Payment new1){
	this.in_paymentList.add(new1);
}
public ArrayList<Procedure> getin_procList(){
	return in_procList;
}
public void setin_procList(ArrayList<Procedure> list){
	this.in_procList = list;
}
public void setProc(Procedure new2){
	this.in_procList.add(new2);
	
}
public String toString(){
	String list = Arrays.toString(this.in_paymentList.toArray()).replace("[", "").replace("]", "");
	String list2 = Arrays.toString(this.in_procList.toArray()).replace("[", "").replace("]", "");
	return ("\nInvoice Number: "+invoiceNo +"\ninvoice amounts: "+invoiceAmt+"\nInvoice Date: "+ invoiceDate
			+"\nis Paid? : "+ isPaid+list2 +list);
}
public void print(){
	System.out.print(toString());
}






	
	
	
	
	
}
