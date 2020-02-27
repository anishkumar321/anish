package com.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

class User{
	String name;
	String loginid;
	String pass;
	public User(String name, String loginid, String pass) {
		super();
		this.name = name;
		this.loginid = loginid;
		this.pass = pass;
	}
	
}
public class ChatRoom {
	static TreeSet<String> usersList = new TreeSet<String>(); 
	static List<String> msgList = new ArrayList<String>();
	static Map<String,TreeSet > hmapUsers=new HashMap<String,TreeSet>();
	static	 Map<String,ArrayList > hmapMsg=new HashMap<String,ArrayList>();

	public static void main(String[] args) {
		
	  	System.out.println("\n\n\n\t\t\t\tWelcome to ChatRoom\r\n\n");
		 try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
				
		 System.out.println("A : Create chatRoom\nB : Add User\nC : Userlogin"
		 		+ "D: Send Message\nE: Display Specific ChatRoom Message\n"
		 		+ "F: List spcific ChatRoom Users\n"
		 		+ "G: Logout\n"
		 		+ "H: Delete a user");
		 System.out.print("\nPlease Select Option   :\t");
		 String choiceMain;
		 Scanner sc=new Scanner(System.in);
		 choiceMain=sc.next();
		 Iterator<String> itr= hmapUsers.keySet().iterator();
		 switch(choiceMain)
		 {
		 case "A": {
			 boolean isKeyPresent = false;
			 		String chatRoom="";
			 		System.out.print("Enter the Name of the chatroom you want to create :  ");
			 		chatRoom=sc.next();
			 		if(hmapUsers.containsKey(chatRoom))
			 			isKeyPresent = true;
			 		else
			 			isKeyPresent = false;
			 		
			 		if(isKeyPresent==true)
			 			{
			 			System.out.println("ChatRoom with this name already created !!");
	 			     	System.exit(0);
			 			}
			 		
			 		else {
			 		hmapUsers.put(chatRoom , usersList);
			 		System.out.println("Chatroom "+chatRoom+" Created !!");
			 		}
		 }break;
		 case "B": {
			 System.out.println("Enter the user details");
			 System.out.println("User Name");
			 String n=sc.next();
			 
			 
		 }break;
		 }
		 
		 
		 
		
	}

}