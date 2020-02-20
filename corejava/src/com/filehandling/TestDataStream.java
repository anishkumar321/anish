package com.filehandling;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;

class A{
	int accno;
	String name;
	double balance;
	public A() {
		this.accno=5555;
		this.name="Jay";
		this.balance=6500;
	}
	public A(int accno,String name,double balance) {
		this.accno=accno;
		this.name=name;
		this.balance=balance;
	}
	public void write() throws IOException {
		File file= new File("B:\\Test File handling\\datainput.txt");
		FileOutputStream fos= new FileOutputStream(file);
		DataOutputStream dos = new DataOutputStream(fos);
		dos.writeInt(this.accno);
		dos.writeUTF(this.name);
		dos.writeDouble(this.balance);
		dos.flush();
		fos.flush();
		dos.close();
		fos.close();
	}
	public void read() throws IOException {
		File f= new File("B:\\Test File handling\\datainput.txt");
		FileInputStream fis= new FileInputStream(f);
		DataInputStream dis = new DataInputStream(fis);
		int id = dis.readInt();
		String n = dis.readUTF();
		double b = dis.readDouble();
		dis.close();
		fis.close();
		System.out.println("Id : "+id);
		System.out.println("Name : "+n);
		System.out.println("Balance : "+b);
	}
}	


public class TestDataStream {

	public static void main(String[] args) throws IOException{
		A a[]=new A[3];
		a[0]=new A(5214,"Anish",5500);
		a[1]=new A(5215,"Manish",6500);
		a[2]=new A(5216,"Ram",7500);
		
		a[0].write();
		a[0].read();
		a[1].write();
		a[1].read();
		a[2].write();
		a[2].read();
	}

}
