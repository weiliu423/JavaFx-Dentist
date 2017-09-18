package application;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;
public class Patient extends Person {



	public Patient(String name, String address) {
		super(name, address);
		
	}

Date Date;
int patientNo = 0;
private String password;
ArrayList<Invoice> p_invoiceList = new ArrayList<Invoice>();
Dentist d = new Dentist(password);

public String getName(){
	return Name;
}
public int getpatientNo()
{
	return patientNo;
}

public ArrayList<Invoice> getp_invoiceList(){
	return p_invoiceList;
}
public void setp_invoiceList(ArrayList<Invoice> list){
	this.p_invoiceList = list;
}
public void setInvoice(Invoice newone){
	this.p_invoiceList.add(newone);
}
public String getPassword(){
	return password;
}
public void setPassword(String pass){
	this.password = pass;
}
public String toString(){
	String list = Arrays.toString(p_invoiceList.toArray()).replace("[", "").replace("]", "");
	return ("\nPatient No: "+patientNo + "\nName: "+Name+"\nAddress: "+Address+"\nContact Number: "+contactNo+"\n" + list);
}
public void print(){
	System.out.print(toString());
}




















}
