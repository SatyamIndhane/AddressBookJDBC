package com.bridgelabz.AddressBook;

public class Create
{
	 String fname;
	 String lname;
	 String address;
	 String city;
	 String state;
	 int zip;
	 int ph;
	 String email;
	
	Create(String fname, String lname, String address, String city, String state, int zip, int ph,
			String email)
	{
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.ph = ph;
		this.email = email;
	}
	
	
	public String toString()
	{
		return "\rFirst name : "+this.fname+"\rLast name : "+this.lname+"\rAddress :" +this.address+"\rcity : "
				+this.city+"\rstate : "+this.state+"\rzip : "+this.zip+"\rph : "+this.ph+"\remail : "
				+this.email+"\r";
	}
	
}
