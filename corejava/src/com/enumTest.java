package com;
enum Status
{
	NEW(0), REJECTED(1), ACCEPTED(2), COMPLETED(3);
	int value;
	Status(int val)
	{
		this.value=val;
	}
	
	public void setStatus(int value)
	{
		this.value=value;
	}
	
	public int getValue() 
	{
		return this.value;
	}
	
	public String toString ()
	{
		String s="";
		switch(this)
		{
			case NEW: s+="NEW: "+value; break;
			case REJECTED: s+="REJECTED: "+value; break;
			case ACCEPTED: s+="ACCEPTED: "+value; break;
			case COMPLETED: s+="COMPLETED: "+value; break;
		}
	return s;
	}
	
}

class Order
{
	Status s;
	
	private int orderId, quantity, price;
	private String name; 
    
	public Order(String name, int orderId,int  quantity, int price, Status type)
	{
		//s=Status.type;
		s=type;
		
		
		//s=new Status(type);
		this.name=name;
		this.orderId=orderId;
		this.quantity=quantity;
		this.price=price;
		
	}
	
	public String toString()
	{
		return "Name: "+name+"\nOrder ID: "+orderId+"\nQuantity: "+quantity+"\nPrice: "+price+"\n"+ s+"\n";
	}
	
}

public class enumTest
{
	public static void main(String [] a)
	{
		Order obj[]=new Order[4];
		obj[0]=new Order("a", 125, 2, 10000, Status.COMPLETED );
		obj[1]=new Order("b", 126, 3, 15000, Status.NEW );		
		obj[2]=new Order("c", 127, 4, 20000, Status.REJECTED );
		obj[3]=new Order("d", 128, 5, 30000, Status.ACCEPTED );
		
		for(int i=0; i<obj.length;i++)
			System.out.println(obj[i]);
	}
}