package com.filehandling;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.NotSerializableException;

class Date implements Serializable{
	private int dob;
	public Date() {
		this.dob=15;
	}
	public Date(int dob) {
		super();
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "Date [dob=" + dob + "]";
	}
	
	
	
}
class Account implements Serializable{
	
	private static final long serialVersionUID = 1L; //2L to check serialization fails
	/*transient*/ private int accno;
	Date dob;
	public Account() {
		super();
		this.accno=1542;
	}
	public Account(int accno, Date dob) {
		super();
		this.accno = accno;
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Account [accno=" + accno + ", dob=" + dob + "]";
	}
}
public class TestSerializable {
	public static void Serialize(Account a)throws Exception {
		File f=new File("B:\\Test File handling\\ff.dat");
		FileOutputStream fos=new FileOutputStream(f);
		ObjectOutputStream out = new ObjectOutputStream(fos);
		out.writeObject(a);
		out.flush();
		fos.flush();
		out.close();
		fos.close();
	}
	public static void Deserialize(Account a)throws Exception {
		File f=new File("B:\\Test File handling\\ff.dat");
		FileInputStream fis=new FileInputStream(f);
		ObjectInputStream in = new ObjectInputStream(fis);
		 Account ac= (Account)in.readObject();
		System.out.println("Account Details = " + ac);
		in.close();
		fis.close();
	}
	public static void main(String[] args) throws Exception {
		Date d=new Date(25);
		Account a=new Account(5555,new Date());
		Serialize(a);
		Deserialize(a);
	}

}
