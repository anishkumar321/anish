package com.lamdaexpressions;

import java.util.function.Consumer;
import java.util.function.Predicate;

class Order{
	int id;
	String OrderName;
	int price;
	String status;
	public Order(int id, String orderName, int price, String status) {
		super();
		this.id = id;
		this.OrderName = orderName;
		this.price = price;
		this.status = status;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderName() {
		return OrderName;
	}

	public void setOrderName(String orderName) {
		OrderName = orderName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", OrderName=" + OrderName + ", price=" + price + ", Status=" + status + "]";
	}
	
}
public class OrderCheck {

	public static void main(String[] args) throws Exception{
		boolean result;
		Order or[]=new Order[5];
		or[0]=new Order(1,"BED",15000,"COMPLETED");
		or[1]=new Order(2,"SOFA",90000,"ACCEPTED");
		or[2]=new Order(3,"SHELF",5000,"COMPLETED");
		or[3]=new Order(4,"FRIDGE",50000,"NOT COMPLETED");
		or[4]=new Order(5,"CAR",11000,"ACCEPTED");
		
		Predicate<Order> checkOrder=(Order o)->
		{if(o.getPrice()>10000 )
			if(o.getStatus().equals("COMPLETED")||o.getStatus().equals("ACCEPTED"))
				return true;
		else
		return false;
		return false;};
		Consumer<Order> printOrder=(Order o)->System.out.println(o);
		for(int i=0;i<or.length;i++) {
			result=checkOrder.test(or[i]);
			if(result==true) {
				printOrder.accept(or[i]);
			}
		}
		
	}

}
