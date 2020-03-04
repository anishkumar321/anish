package com.jUnit;

import java.util.Random;

public class RandomNumber {

		Random r=new Random();
		public int createRandom() {
			return r.nextInt(100);
		}
}
