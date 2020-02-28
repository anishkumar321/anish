package com.lamdaexpressions;

@FunctionalInterface
interface First<T>{
	T operation(T t1, T t2);
	
}
public class BasicOperations  {

	public static void main(String[] args) {
		
		First<Integer> add=(Integer x,Integer y)->x+y;
		First<Integer> sub=(Integer x,Integer y)->x-y;
		First<Integer> mul=(Integer x,Integer y)->x*y;
		First<Integer> div=(Integer x,Integer y)->x/y;
		int addition=add.operation(5,3);
		int substraction=sub.operation(5,3);
		int multiplication=mul.operation(5,3);
		int division=add.operation(15,5);
		System.out.println(addition);
		System.out.println(substraction);
		System.out.println(multiplication);
		System.out.println(division);
	}

	

}
