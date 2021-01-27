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
public class Set {

	public static final int MAX_SET_ELEMENT_VALUE = 63;

	private long s; // The long used to represent a set

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
		for (int i = 0; i < elements.size(); ++i) {
			s = (long) (s | (1 << elements.get(i)));
		}
		// TODO: Handle when values exceed 63
	}

	public boolean isInSet(int x) {

		return false;
	}

	public void empty() {

	}

	/**
	 * Adds an element to the set.
	 * 
	 * @param x The identifier of the element to add. Must be in the range of 0 to 63.
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
