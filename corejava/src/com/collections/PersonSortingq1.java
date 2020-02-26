package com.collections;

import java.util.Iterator;
import java.util.TreeSet;

class Person implements Comparable<Person>{
	String name;
	int weight;
	int height;
	public Person(String name, int weight, int height) {
		super();
		this.name = name;
		this.weight = weight;
		this.height = height;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", weight=" + weight + ", height=" + height + "]";
	}
	@Override
	public int compareTo(Person p) {
		if(this.weight>p.weight)
			return 1;
		else if (this.weight < p.weight){
			return -1;
		}
		else {
			if(this.height>p.height)
				return 1;
			else if (this.height < p.height){
				return -1;	
			}
		}
		return 0;
			
	}
	
}
public class PersonSortingq1 {

	public static void main(String[] args) {
		TreeSet<Person> treeSet = new TreeSet<Person>();
		treeSet.add(new Person("Anish",60,50));
		treeSet.add(new Person("Mahesh",60,40));
		treeSet.add(new Person("Rajesh",30,50));
		
		Iterator<Person> itr = treeSet.iterator();
		while(itr.hasNext()) {
			Person p = itr.next();
			System.out.println(p);
		}

	}

}
