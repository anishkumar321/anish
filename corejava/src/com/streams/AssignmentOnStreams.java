package com.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Fruit {
	public String name; 
	public int calories; 
	public int price; 
	public String color;

	public Fruit() {
	}

	public Fruit(String name, int calories, int price, String color) {
		super();
		this.name = name;
		this.calories = calories;
		this.price = price;
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Fruit [name=" + name + ", calories=" + calories + ", price=" + price + ", color=" + color + "]";
	}
	
}
class News {
	public int newsId; 
	public String postedByUser; 
	public String commentByUser; 
	public String comment;
	
	public News() {}
	
	public News(int newsId, String postedByUser, String commentByUser, String comment) {
		super();
		this.newsId = newsId;
		this.postedByUser = postedByUser;
		this.commentByUser = commentByUser;
		this.comment = comment;
	}

	public int getNewsId() {
		return newsId;
	}

	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}

	public String getPostedByUser() {
		return postedByUser;
	}

	public void setPostedByUser(String postedByUser) {
		this.postedByUser = postedByUser;
	}

	public String getCommentByUser() {
		return commentByUser;
	}

	public void setCommentByUser(String commentByUser) {
		this.commentByUser = commentByUser;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "News [newsId=" + newsId + ", postedByUser=" + postedByUser + ", commentByUser=" + commentByUser
				+ ", comment=" + comment + "]";
	}
	
}

class Trader {
	public String name; 
	public String city;
	public Trader() {}
	public Trader(String name, String city) {
		super();
		this.name = name;
		this.city = city;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Trader [name=" + name + ", city=" + city + "]";
	}
	
}

class Transaction {

	public Trader trader; 
	public int year; 
	public int value;
	
	public Transaction() { }

	public Transaction(Trader trader, int year, int value) {
		super();
		this.trader = trader;
		this.year = year;
		this.value = value;
	}

	public Trader getTrader() {
		return trader;
	}

	public void setTrader(Trader trader) {
		this.trader = trader;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Transaction [trader=" + trader + ", year=" + year + ", value=" + value + "]";
	}

}

public class AssignmentOnStreams {

		public static List<Fruit> getAllFruits() {
			List<Fruit> fruits = new ArrayList<Fruit>();
			fruits.add(new Fruit("Peach", 90, 50, "Red"));
			fruits.add(new Fruit("Banana", 200, 10, "Yellow"));
			fruits.add(new Fruit("Pomegranate", 200, 70, "Red"));
			fruits.add(new Fruit("Apple", 300, 150, "Red"));
			fruits.add(new Fruit("Watermelon", 30, 20, "Red"));
			return fruits;
		}
		public static void printFruits(List<Fruit> fruits) {
			fruits.stream().forEach(System.out::println);
		}

		public static List<News> getAllNews() {
			List<News> newsList = new ArrayList<News>();
			newsList.add(new News(1, "Tom", "Anand", "Very nice article on budget"));
			newsList.add(new News(2, "Ivan", "Bipin", "Good budget description"));
			newsList.add(new News(1, "Tom", "Narang", "How can you write such an article?"));
			newsList.add(new News(2, "Jerry", "Mitul", "I agree with you!!"));
			newsList.add(new News(2, "James", "Anand", "This seems to be paid news for glorifying the budget"));
			newsList.add(new News(3, "Sara", "Daji", "Good article"));
			return newsList;
		}
		public static void printNews(List<News> newsList) {
			newsList.stream().forEach(System.out::println);
		}

		public static List<Transaction> getAllTransactions() {
			List<Transaction> transactions = new ArrayList<Transaction>();
			transactions.add(new Transaction(new Trader("Anand", "Pune"), 2016, 10000));
			transactions.add(new Transaction(new Trader("Neeraja", "Indore"), 2015, 25000));
			transactions.add(new Transaction(new Trader("Yog", "Mumbai"), 2011, 33000));
			transactions.add(new Transaction(new Trader("Lokesh", "Nagpur"), 2016, 200000));
			transactions.add(new Transaction(new Trader("Komal", "Pune"), 2011, 80000));
			transactions.add(new Transaction(new Trader("Ishwar", "Indore"), 2016, 12000));
			return transactions;
		}
		
		public static void printTransactions(List<Transaction> transactions) {
			transactions.stream().forEach(System.out::println);
		}
		public static void main(String args[]) {
			
			List<Fruit> fruitList=getAllFruits();
			List<Fruit> fruitListWithLowCalorie=fruitList.stream().filter(Fruit->Fruit.getCalories()<100).sorted(Comparator.comparing(Fruit::getCalories).reversed()).collect(Collectors.toList());
			System.out.println("LOW CALORIE DESCENDING ORDER");
			printFruits(fruitListWithLowCalorie);//q1
			
			
			List<Fruit> fruitListColorWise=fruitList.stream().sorted(Comparator.comparing(Fruit::getColor)).collect(Collectors.toList());                                             
			System.out.println("\nCOLOR WISE FRUITS");
			printFruits(fruitListColorWise);//q2
			
			
			List<Fruit> fruitListRedColor=fruitList.stream().filter(Fruit->Fruit.getColor().equals("Red")).sorted(Comparator.comparing(Fruit::getPrice)).collect(Collectors.toList()); 
			System.out.println("\nRED COLOR FRUITS");
			printFruits(fruitListRedColor);//q3
			
			
			List<News> newsList=getAllNews();
			
			
			
			int count=(int)newsList.stream().filter(News->News.getComment().contains("budget")).count();
			System.out.println("\nTHE NUMBER OF TIMES THE WORD BUDGET IS PRESENT IN COMMENTS IS "+count);//q5
			
			
			List<Transaction> transactionList=getAllTransactions();
			List<Transaction> transactionList2011=transactionList.stream().filter(Transaction->Transaction.getYear()==2011).sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());
			System.out.println("\nRANSACTIONS OF 2011 IN ASCENDING ORDER");
			printTransactions(transactionList2011); //q7
			
			
			
		
			//Map<String, List<Trader>> traderByCity= transactionList.stream().collect(groupingBy(Trader::getCity));
			List<String> uniqueCity=transactionList.stream().filter(Transaction::getCity().distinct()).collect(Collectors.toList());
			
		}
	}
