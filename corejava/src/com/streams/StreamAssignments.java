package com.streams;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.java8.stream.utils.Fruit;
import com.java8.stream.utils.News;
import com.java8.stream.utils.TestData;
import com.java8.stream.utils.Trader;
import com.java8.stream.utils.Transaction;

public class StreamAssignments {
	
	private static List<Fruit> fruits = TestData.getAllFruits();
	private static List<News> newsList = TestData.getAllNews();
	private static List<Transaction> transactions = TestData.getAllTransactions();

	public static void main(String[] args) {
		
		//1.	Display the fruit names of low calories fruits i.e. calories < 100 sorted in descending order of calories.
		fruits.stream().
		filter((Fruit fruit)->fruit.calories < 100).
		sorted(Comparator.comparing(Fruit::getCalories).reversed()).
		forEach(System.out::println);
		
		//2.	Display color wise list of fruit names.
		fruits.stream().
		collect(groupingBy(Fruit::getColor)).entrySet().forEach(System.out::println);
		//System.out.println("\n\n\nColorwise fruits: " + mapFruitColor + "\n\n\n");
		
		//3.	Display only RED color fruits sorted as per their price in ascending order.
		fruits.stream().
		filter((Fruit fruit)->fruit.getColor().equalsIgnoreCase("Red")).
		sorted(Comparator.comparing(Fruit::getPrice)).
		forEach(System.out::println);
		
		//4.	Find out the newsId which has received maximum comments.
		Entry<Integer, Long> mapNewsComments =
		newsList.stream().
		collect(groupingBy(News::getNewsId, counting())).
		entrySet().stream().
		max(Comparator.comparing(Entry::getValue)).
		get();
		System.out.println("\n\n\nNews Id: " + mapNewsComments.getKey() + " has maximum number of comments i.e. " + mapNewsComments.getValue());
		
		//5.	Find out how many times the word 'budget' arrived in user comments of all news.
		int newsCountForWordBudget =
		newsList.stream().
		mapToInt((News news)-> {
			int i = 0;
			Pattern p = Pattern.compile("budget");
			Matcher m = p.matcher( news.getComment() );
			while (m.find()) {
			    i++;
			}
			return i;
		}).
		sum();
		System.out.println("\n\n\nWord 'budget' has appeared " + newsCountForWordBudget + " times in comments");
		
		//6.	Find out which user has posted maximum comments.
		Entry<String, Long> mapUserComments =
		newsList.stream().
		collect(groupingBy(News::getCommentByUser, counting())).
		entrySet().stream().
		max(Comparator.comparing(Entry::getValue)).
		get();
		System.out.println("\n\n\nUser: " + mapUserComments.getKey() + " has maximum number of comments i.e. " + mapUserComments.getValue());
		
		//7.	Display commentByUser wise number of comments.
		Map<String, Long> mapCommentByUser = 
		newsList.stream().
		collect(groupingBy(News::getCommentByUser, counting()));
		System.out.println("\n\n\ncommentByUser wise number of comments: " + mapCommentByUser);
		
		//8.	Find all transactions in the year 2011 and sort them by value (small to high).
		List<Transaction> filteredTransactions =
		transactions.stream().
		filter((Transaction transaction)->transaction.getYear() == 2011).
		sorted(Comparator.comparing(Transaction::getValue)).
		collect(toList());
		System.out.println("\n\n\nTransactions in the year 2011 sorted by their value: " + filteredTransactions);
		
		//9.	What are all the unique cities where the traders work?
		List<String> traderCities =
		transactions.stream().
		map((Transaction transaction)->transaction.getTrader().getCity()).
		distinct().
		collect(toList());
		System.out.println("\n\n\nTraders work in cities: " + traderCities);
		
		//10.	Find all traders from Pune and sort them by name.
		List<Trader> puneTraders =
		transactions.stream().
		filter((Transaction transaction)->transaction.getTrader().getCity().equals("Pune")).
		sorted((Transaction t1, Transaction t2)->t1.getTrader().getName().compareTo(t2.getTrader().getName())).
		map((Transaction transaction)->transaction.getTrader()).
		collect(toList());
		System.out.println("\n\n\nTraders in Pune: " + puneTraders);
		
		//11.	Return a string of all traders’ names sorted alphabetically.
		String traderNames = 
		transactions.stream().
		map((Transaction transaction)->transaction.getTrader().getName()).
		sorted().
		collect(joining(","));
		System.out.println("\n\n\nTrader names: " + traderNames);
		
		//12.	Are any traders based in Indore?
		Optional<Transaction> opTransaction = 
		transactions.stream().
		filter((Transaction transaction)->transaction.getTrader().getCity().equals("Indore")).
		findAny();
		System.out.println("\n\n\nAre any traders based in Indore? " + opTransaction.isPresent());
		
		//13.	Print all transaction values from the traders living in Delhi.
		List<Integer> transactionValues = 
		transactions.stream().
		filter((Transaction transaction)->transaction.getTrader().getCity().equals("Delhi")).
		map((Transaction transaction)->transaction.getValue()).
		collect(toList());
		System.out.println("\n\n\nTransaction values from the traders living in Delhi: " + transactionValues);
		
		//14.	What’s the highest value of all the transactions?
		Optional<Integer> opMaxTransactionValue = 
		transactions.stream().
		map((Transaction transaction)->transaction.getValue()).
		reduce(Integer::max);
		System.out.println("\n\n\nMax transaction value: " + opMaxTransactionValue.get());
		
		//15.	Find the transaction with the smallest value.
		Optional<Integer> opMinTransactionValue = 
		transactions.stream().
		map((Transaction transaction)->transaction.getValue()).
		reduce(Integer::min);
		System.out.println("\n\n\nMin transaction value: " + opMinTransactionValue.get());
	}

}