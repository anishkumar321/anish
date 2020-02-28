package com.lamdaexpressions;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

class Student{
	String name;
	int marks;
	public Student(String name, int marks) {
		super();
		this.name = name;
		this.marks = marks;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", marks=" + marks + "]";
	}
	
}
public class TestLambdaExpressions {

	private static final String String = null;
	public static void main(String[] args) throws Exception {
		Student s[]=new Student[4];
		s[0]=new Student("Anish",40);
		s[1]=new Student("Rahul",50);
		s[2]=new Student("Vinit",35);
		s[3]=new Student("Raj",90);
		testPredicate(s);
		testFunction(s);
		testConsumer(s);
		testSupplier();
	}
	public static void testPredicate(Student s[]) {
		Predicate<Student> ps=(Student st)->
		{if (st.getMarks()>40)
			return true;
		else 
			return false;};
			System.out.println("PASS STUDENTS ARE");
			for(int i=0;i<s.length;i++) {
				boolean result=ps.test(s[i]);
				if (result==true)
					System.out.println(s[i]);
			}
			
	}
	public static void testFunction(Student s[]) {
		Function<Student,String> f=(Student st)->(st.getMarks()>40)?"PASS":"FAIL";
		System.out.println("RESULTS ARE");
		for(int i=0;i<s.length;i++) {
			String result=f.apply(s[i]);
			if (result=="PASS")
				System.out.println(s[i]+result);
			else
				System.out.println(s[i]+"FAIL");
		}
	}
	public static void testConsumer(Student s[]) {
		Consumer<Student> printOrder=(Student st)->System.out.println(st);
		System.out.println("Student details are :");
		for(int i=0;i<s.length;i++) {
			printOrder.accept(s[i]);
		}
		}
	public static void testSupplier() {
		Random r=new Random();
		Supplier<Integer> su=()->r.nextInt(100);
		int marks=su.get();
		System.out.println(marks);
	}
}

	
