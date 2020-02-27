package com.generics;

class Date{
	int d;
	int m;
	int y;
	public Date(int d, int m, int y) {
		super();
		this.d = d;
		this.m = m;
		this.y = y;
	}
	@Override
	public String toString() {
		return "Date [d=" + d + ", m=" + m + ", y=" + y + "]";
	}
	
}
class TestWrapper<T>{
	T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	
}
public class WrapAnyObject {

	public static void main(String[] args) {
		TestWrapper<Date> tw=new TestWrapper<Date>();
		tw.setT(new Date(26,12,1997));
		System.out.println(tw.getT());
		

	}

}
