package com.collections;

import java.util.HashMap;
import java.util.Map;

class Employee{
	int id;
	String name;
	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public boolean equals(Object ob) {
			return true;    //return false; = it will make everythng null
	}
	@Override
	public int hashCode() {
		return 45;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
	
}
public class EmployeeOverrideq5 {

	public static void main(String[] args) {
		Map<Employee,String> hash=new HashMap<Employee,String>();
		Employee e1=new Employee(52,"Anish");
		Employee e2=new Employee(53,"Mahesh");
		Employee e3=new Employee(54,"Rajesh");
		hash.put(e1,"A");
		hash.put(e2,"A");
		hash.put(e3,"R");
		System.out.println(e1);
		System.out.println(e2);
		System.out.println(e3);

		//String s=hash.get(new Employee(59,"ABC"));  it will return always R
		String s=hash.get(e1);
		System.out.println(s);
		String s1=hash.get(e2);
		System.out.println(s1);
		String s2=hash.get(e3);
		System.out.println(s2);

	}

}
