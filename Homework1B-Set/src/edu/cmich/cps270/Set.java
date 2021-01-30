package edu.cmich.cps270;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a set of elements numbered from 0 to 63. Standard set operations
 * are supported such as adding and removing elements, union, intersection and
 * complement.
 * 
 * @author [list the globalID of contributing members of the group here]
 *
 */
/**
 * @author gupta4a
 *
 */
public class Set {

	public static final int MAX_SET_ELEMENT_VALUE = 63;

	private long s; // The long used to represent a set

	public long getS() {
		return s;
	}

	public void setS(long s) {
		this.s = s;
	}

	/**
	 * Initializes the set to 64 zeroes in binary. Each '0' bit represents the
	 * absence of a particular value in the set between 0 and MAX_SET_ELEMENT_VALUE.
	 */
	public Set() {
		s = 0l;
	}

	/**
	 * Initializes the set based on the given list of integers. If a certain value
	 * n between 0 and MAX_SET_ELEMENT_VALUE appears in the set, the nth bit of the
	 * binary is populated with a 1.
	 *
	 * @param elements the list of integers to represent as a set
	 * @throws SetElementValueOutOfRange
	 */
	public Set(List<Integer> elements) throws SetElementValueOutOfRange {
		int element;
		for (int i = 0; i < elements.size(); ++i) {
			element = elements.get(i);
			if (element <= MAX_SET_ELEMENT_VALUE && element >= 0)
				s = (long) (s | (1l << elements.get(i)));
			else
				throw new SetElementValueOutOfRange();
		}
	}

	/**
	 * checks if the element is in the set
	 * @param x integer element to be checked if its present in the sate or not 
	 * @return boolean true if the element is present, otherwise returns fal se
	 */
	public boolean isInSet(int x) {
		long mask =  (1l<<x);

		if((mask & this.s) == mask) {
			return true;
		}
		return false; 
	}

	public void empty() {
		this.s = 0l; 
	}

	/**
	 * Adds an element to the set.
	 * 
	 * @param x The identifier of the element to add. Must be in the range of 0 to 63.
	 * @throws SetElementValueOutOfRange
	 */
	public void addElement(int x) throws SetElementValueOutOfRange {
		if (x <= MAX_SET_ELEMENT_VALUE && x >= 0) {
			s = (long) (s | (1l << x));
		}
		else
			throw new SetElementValueOutOfRange();
	}

	/**
	 * Removes an element to the set.
	 * 
	 * @param x The identifier of the element to remove. Must be in the range of 0 to 63.
	 * @throws SetElementValueOutOfRange
	 */
	public void removeElement(int x) throws SetElementValueOutOfRange {
		if (x <= MAX_SET_ELEMENT_VALUE && x >= 0)
			s = (long) (s & ~(1l << x));
		else
			throw new SetElementValueOutOfRange();
	}


	/**
	 * finds the intersection between this Set with a given Set
	 * @param s Set that is given to find the intersection with this Set.
	 * @return Set representing the intersection of this Set and s Set. 
	 */
	public Set intersection(Set s) {

		Set result=new Set();

		result.s =(long) (this.s & s.s);

		return result; 

	}

	/**
	 * finds the union between this Set with a given Set
	 * @param s Set that is given to find the union with this Set.
	 * @return Set representing the union of this Set and s Set. 
	 */
	public Set union(Set s1) {

		Set result=new Set();

		result.setS( (long) (this.s | s1.getS()));

		return result; 
	}

	public List<Integer> toList() {
		List<Integer> list =new ArrayList<>();
		long mask= 1l;
		for(int i=0 ; i<64 ;i++) {
			mask = (long)1l<<i ; 
			if((mask  & this.s) == mask) {
				list.add(i);
			}
		}
		return list;
	}

	public boolean isEmpty() {

		if(this.s==0l) {
			return true;
		}
		return false; 
	}

	/**
	 * @return Integer representing the number of elements in the set. 
	 */
	public int size() {
		int count =0;
		long mask= 1l;
		for(int i=0 ; i<64 ;i++) {
			mask = (long)1l<<i ; 
			if((mask  &this.s) == mask) {
				count++;
			}
		}
		return count;

	}

	/**
	 * complements this Set.
	 */
	public void complement() {
		this.s = (long) ~(s);
	}





	//helper methods. 

	public  String byteToString(byte b) {
		byte[] masks = { -128, // 1000 0000 
				64, // 0100 0000
				32, // 0010 0000
				16, // 0001 0000
				8,  // 0000 1000
				4,  // 0000 0100
				2,  // 0000 0010
				1 };// 0000 0001	    
		StringBuilder builder = new StringBuilder();

		/* For each mask, do a bit-wise AND with b and the mask, this
	       checks if that bit is set.  If so, append 1 to the string, otherwise
	       append a 0*/
		for (byte m : masks) {
			if ((b & m) == m) {
				builder.append('1');
			} else {
				builder.append('0');
			}
		}
		return builder.toString();
	}

	/**
	 * Converts an array of bytes to string representation.      
	 *  
	 * @param bytes an array of bytes to be converted to a string
	 * @return string representation of the bits in the provided byte array
	 */
	public  String byteToString(byte[] bytes) {
		StringBuilder builder = new StringBuilder();

		for(byte b: bytes) {
			builder.append(byteToString(b) + " ");
		}

		return builder.toString();
	}

	/**
	 * Extract a representation of a short as a byte array.
	 * 
	 * @param s A short, signed integer to convert
	 * @return A byte array for the two bytes that make up the short
	 */


	public  byte[] toByteArray(long l) {
		byte[] b = new byte[8];
		for(int i= 0; i < 8; i++){
			b[7 - i] = (byte)(l >>> (i * 8));
		}
		return b;
	}
	//	public static byte[] toByteArray(long l) {
	//		byte[] b = new byte[8];
	//		b[7] = (byte) (l);
	//		l >>= 8;
	//		b[6] = (byte) (l);
	//		l >>= 8;
	//		b[5] = (byte) (l);
	//		l >>= 8;
	//		b[4] = (byte) (l);
	//		l >>= 8;
	//		b[3] = (byte) (l);
	//		l >>= 8;
	//		b[2] = (byte) (l);
	//		l >>= 8;
	//		b[1] = (byte) (l);
	//		l >>>= 8;
	//		b[0] = (byte) (l);
	//
	//		return b;
	//	}


}

