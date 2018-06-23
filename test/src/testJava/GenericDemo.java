package testJava;

import java.util.ArrayList;

class MyGen<T>{
	T obj;
	
	void add1 (T ob) {
		this.obj=ob;
	}
	
	T get() {
		return obj;
	}
	
	
}

public class GenericDemo {
	
public static <E> void printArr(E[] elem) {
		
		for (E elems :elem) {
			System.out.println(elems);
			
			
		}
		
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
MyGen<Integer>  m = new  MyGen<Integer>();

m.add1(12);

System.out.println(m.get());

MyGen<String> m1 = new MyGen<String>();

m1.add1("onetwo");

System.out.println(m1.get());


Integer[] intArray = { 10, 20, 30, 40, 50 };  
Character[] charArray = { 'J', 'A', 'V', 'A', 'T','P','O','I','N','T' };  

System.out.println( "Printing Integer Array" );  
printArr( intArray  );   

System.out.println( "Printing Character Array" );  
printArr( charArray );   

System.out.println();
	}

}
