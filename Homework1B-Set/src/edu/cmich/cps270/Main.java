package edu.cmich.cps270;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws SetElementValueOutOfRange {
		Set s =new Set();
		s.addElement(0);
		s.addElement(1);
		s.addElement(7);
		s.addElement(31);
		s.addElement(37);
		s.addElement(62);
		s.addElement(45);
		s.addElement(63);
	
		
		System.out.println(s.toList().toString());
		System.out.println(s.size());
		
		
		byte[] array= s.toByteArray(s.getS()) ;
	
		
		System.out.println(s.byteToString(array)); 
		
		
		s.removeElement(63);
		s.removeElement(0);
		
		System.out.println("-----------------------------------------------------");
		
		array= s.toByteArray(s.getS()) ;	
		System.out.println(s.byteToString(array));
	
		
		
		Set s2 =new Set(Arrays.asList(new Integer[]{1, 2,61}));
		array= s2.toByteArray(s2.getS()) ;	
		System.out.println(s2.byteToString(array));
		
		
		
		System.out.println("-----------------------------------------------------");
		
		s2 = s2.union(s);
		array= s2.toByteArray(s2.getS()) ;	
		System.out.println(s2.byteToString(array));
		
		
		Set s1 =new Set();
		s1.addElement(0);
		s1.addElement(4);
		s1.addElement(7);
		s1.addElement(32);
		s1.addElement(37);
		s1.addElement(62);
		s1.addElement(46);
		s1.addElement(63);
		
	}
}
