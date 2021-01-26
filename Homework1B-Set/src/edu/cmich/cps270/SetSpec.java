package edu.cmich.cps270;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SetSpec {

	@Test
	void setWithoutElementsAddedIsEmpty() {
		Set s = new Set();
		
		List<Integer> elements = s.toList();
		
		assertTrue(elements.isEmpty(), () -> "A set without any elements added should be empty.");
	}
	
	@Test
	void setNotEmptyAfterValidElementAdded() throws Exception {
		Set s = new Set();
		
		s.addElement(1);
		
		List<Integer> elements = s.toList();
		assertFalse(elements.isEmpty(), () -> "A set with an element added should not be empty.");
	}
	
	@Test
	void emptiedSetIsEmpty() throws Exception {
		Set s = new Set();
		s.addElement(1);

		s.empty();
		
		List<Integer> elements = s.toList();
		assertTrue(elements.isEmpty(), () -> "An emptied set should be empty.");
		
	}
	
	@Test
	void checkIf0IsInSetFalseOnEmpty() {
		Set s = new Set();
		
		assertFalse(s.isInSet(0), () -> "0 should not be found in an empty set.");
	}
	
	@Test 
	void exceptionThrownWhenNonValidElementAdded() {
		Set s = new Set();
		
		Assertions.assertThrows(SetElementValueOutOfRange.class, () -> {
			s.addElement(Set.MAX_SET_ELEMENT_VALUE + 1);
		});
	}
	
	@Test 
	void exceptionThrownWhenNonValidElementRemoved() {
		Set s = new Set();
		
		Assertions.assertThrows(SetElementValueOutOfRange.class, () -> {
			s.removeElement(Set.MAX_SET_ELEMENT_VALUE + 1);
		});
	}
	
	@Test
	void setEmptyAfterOnlyElementRemoved() throws Exception {
		Set s = new Set();
		
		s.addElement(1);
		s.removeElement(1);
		
		List<Integer> elements = s.toList();
		assertTrue(elements.isEmpty(), () -> "A set with its only element removed should be empty.");
	}
	
	@Test
	void sizeOfSetIsTwoAfterTwoElementsAdded() throws Exception {
		Set s = new Set();
		
		s.addElement(1);
		s.addElement(2);
		
		assertEquals(s.size(), 2, () -> "A set with two elements added should have a size of 2.");
	}
	
	@Test
	void maxSetElementValueCanBeAdded() throws Exception {
		Set s = new Set();
		
		s.addElement(Set.MAX_SET_ELEMENT_VALUE);
		
		assertEquals(Arrays.asList(Set.MAX_SET_ELEMENT_VALUE), s.toList(), () -> "The maximum value for an element can be added to set.");
	}
	
	
	@Test
	void unionOfSetE1andSetE2HasE1and2() throws Exception {
		Set s = new Set();
		
		s.addElement(1);
		Set t = new Set();
		t.addElement(2);
		
		Set u = s.union(t);
		List<Integer> elements = u.toList();
		
		assertEquals(Arrays.asList(new Integer[]{1, 2}), elements, () -> "The Union of {1} and {2} should be {1, 2}.");
		
	}
	
	
	@Test
	void complementOfAnEmptySetIsUniversalSet() throws Exception {
		Set s = new Set();
		s.complement();
		
		List<Integer> l = new ArrayList<Integer>();
		for(int i = 0; i <= Set.MAX_SET_ELEMENT_VALUE; i++) {
			l.add(new Integer(i));
		}
		
		assertEquals(l, s.toList(), () -> "The complement of an empty set should be universal set.");
	}
 	
	@Test
	void intersectionOfTwoDistictSetsIsEmptySet() throws Exception {
		Set s = new Set();
		s.addElement(1);
		Set t = new Set();
		t.addElement(2);
		
		Set i = s.intersection(t);
		assertTrue(i.isEmpty(), () -> "The intersection of two distict sets should be empty.");
	}
	
	@Test 
	void intersectionOf64DistictSetsIsEmpty() throws Exception {
		Set i = new Set(Arrays.asList(new Integer(0)));
		
		for(int j = 1; j <= Set.MAX_SET_ELEMENT_VALUE; j++) {
			Set s = new Set(Arrays.asList(new Integer(j)));
			i = i.intersection(s);
		}
		
		assertTrue(i.isEmpty(), () -> "The intersection of 64 distict sets should be empty.");	
	}
	
	@Test 
	void unionOf64DistictSetsIsUniversalSet() throws Exception {
		Set u = new Set(Arrays.asList(new Integer(0)));
		
		for(int j = 0; j <= Set.MAX_SET_ELEMENT_VALUE; j++) {
			Set s = new Set(Arrays.asList(new Integer(j)));
			u = u.union(s);
		}
		
		List<Integer> l = new ArrayList<Integer>();
		for(int i = 0; i <= Set.MAX_SET_ELEMENT_VALUE; i++) {
			l.add(new Integer(i));
		}
		
		assertEquals(l, u.toList(), () -> "The union of 64 distict sets should be the universal set.");	
	}
	
	
}

