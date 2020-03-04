package com.jUnit;

public class ComplexAdd {

		private int real;
		private int img;
		
		public ComplexAdd(int real, int img) {
			//this.real = real;
			//this.img = img;
		}

		public ComplexAdd add(ComplexAdd c2) {
			int real=this.real+c2.real;
			int img=this.img+c2.img;
			return new ComplexAdd(real,img);
		}
}
