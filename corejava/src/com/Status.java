package com;
enum Statuss {
    NEW(2), REJECTED(4), ACCEPTED(6), COMPLETED(8);
	int value;
    Statuss(int value){
		this.value=value;
	}
	public int getValue() {
		return this.value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String toString() {

		switch(this) {
			case NEW: return " NEW=" + value;
			case REJECTED: return "REJECTED=" + value;
			case ACCEPTED: return "ACCEPTED=" + value;
			case COMPLETED: return "COMPLETED=" + value;
			default: return "Invalid STATUS TYPE";
		}
	}	
};
class OrderEnum{
	String orderid;
	String name;
	int quantity;
	int price;
	int value;
	Statuss s;	
	OrderEnum(String orderid,String name,int quantity,int price,Statuss s){
		this.orderid = orderid;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.s=s;
	}
	public String toString() {
		return "ORDER ID :"+this.orderid+"NAME :"+this.name+"QUANTITY :"+this.quantity+"PRICE :"+this.price+"STATUS TYPE"+s;
		
	}
}
class EnumOrderTest{
	public static void main(String args[]){
		Statuss s=Statuss.ACCEPTED;
		OrderEnum or=new OrderEnum("B1","Anish",5,250,s);
		System.out.println(or);
		
	}
}