package com.annotation;
import java.lang.annotation.*;
import java.lang.reflect.*;
import java.lang.reflect.*;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)

 @interface Getter {
	
	 //int age;
	 public String value();
}

class Fun{
	private int age;
	
	public Fun(int age)
	{
		this.age=age;
	}
	
	@Getter(value="CaptainAmerica")
	public int getAge()
	{
		return this.age;
		
	}
	
	@Getter(value="CaptainAmerica")
	public void deploy()
	{
		System.out.println("This is not a Getter method !!");
	}
}

public  class AnnotationTest2
{
	public static void main(String args[]) throws Exception
	{
		Class c=Class.forName("Fun");
		Method m[]=c.getDeclaredMethods();
		
		for(int i=0;i<m.length;i++)
		{
			//System.out.println("zddsvsz");
			Method myMethod = m[i];
			Annotation annotations[]=myMethod.getAnnotations();
			for(int j=0;j<annotations.length;j++)
			{
				//System.out.println(annotations[j].getName());
				String str=annotations[j].annotationType().getName();
				if(str.equals("Getter") )
				//System.out.println(str);
				//to check getter
				{ //System.out.println("zddsvsz");
				
					String temp=m[i].getName();
					String temp2=temp.substring(3);
					temp2=temp2.toLowerCase();
					System.out.println(temp2);
					Field fields[] = c.getDeclaredFields();
					//System.out.println(" hi"+fields[0].getName());
					for(int k=0;k<fields.length;k++)
					{
						
						
						if( (fields[k].getName()).equals(temp2) )
							System.out.println("@Getter Annotation is Properly used in "+ temp2 + "Method");
						
						else
							System.out.println("@Getter Annotation is Not Properly used ");
					}
				}
			}
		}
	}
}
	