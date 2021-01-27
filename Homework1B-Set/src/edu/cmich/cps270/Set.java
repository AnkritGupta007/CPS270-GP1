package edu.cmich.cps270;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a set of elements numbered from 0 to 63.  Standard set operations
 * are supported such as adding and removing elements, union, intersection and
 * complement.  
 * 
 * @author [list the globalID of contributing members of the group here] 
 *
 */
public class Set {	
	
	public static final int MAX_SET_ELEMENT_VALUE = 63;
	
	public Set() {
		//I am writng a commment
		//tfksjfkasjk
	}
	
	public Set(List<Integer> elements) throws SetElementValueOutOfRange{

	}
	
	public boolean isInSet(int x) {

		return false;
	}
	
	public void empty() {
		
	}
	
	/**
	 * Adds an element to the set.  
	 * @param x The identifier of the element to add.  Must be in the range of 0 to 63.
	 * @throws SetElementValueOutOfRange
	 */
	public void addElement(int x) throws SetElementValueOutOfRange {

		
	}
	
	public void removeElement(int x) throws SetElementValueOutOfRange {

		
	}
	
	public Set intersection(Set s) {

		return null;
	}
	
	public Set union(Set s) {

		return null;
	}
	
	public List<Integer> toList() {

		return null;
	}
	
	public boolean isEmpty() {

		return false;
	}

	public int size() {

		return 0;
		
		
	}

	public void complement() {


	}
 }
