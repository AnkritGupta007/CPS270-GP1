package edu.cmich.cps270;

public class Main {

	public static void main(String[] args) throws SetElementValueOutOfRange {
		Set s =new Set();
		s.addElement(28);
		s.addElement(27);
		s.addElement(36);
		s.addElement(37);
//		s.addElement(1);
		s.addElement(62);
//		s.addElement(45);
//		s.addElement(31);
		byte[] array= s.toByteArray(s.getS()) ;
	
		
		System.out.println(s.byteToString(array));
		
		System.out.println(s.getS());
		
	}
}
