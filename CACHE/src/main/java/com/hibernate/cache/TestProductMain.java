package com.hibernate.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestProductMain {

	public static void main(String[] args)throws Exception  {
		 Configuration configuration =  new Configuration();
	      configuration.configure("hibernate.cfg.xml");
	      SessionFactory sessionFactory = configuration.buildSessionFactory();
	     
	      Session session=sessionFactory.openSession();
	      Transaction t=session.beginTransaction();
	      Product p=new Product("Laptop",50000);
	      Long productId=(Long)session.save(p);
	      t.commit();
	      session.close();
	      
	      
	      Session session1=sessionFactory.openSession();
	      Transaction t1=session1.beginTransaction();
	      Product p1=session1.get(Product.class,1L);
	      System.out.println(p1);
	      t1.commit();
	      session1.close();
	      //sessionFactory.getCache().evict(Product.class);  //to check evict() i.e it cancels the cache inspite od second level caching is done.
	      
	      //Thread.sleep(3000);     //if ehcache is for less than 3000 sec then after 3 sec it again fires a query to load the class object.
	      Session session2=sessionFactory.openSession();
	      Transaction t2=session2.beginTransaction();
	      //Long id=session2.get(Product.class, Product.getId());
	      Product p2=session2.get(Product.class,1L);
	      System.out.println(p2);
	      t2.commit();
	      session2.close();
	     
	}

}
