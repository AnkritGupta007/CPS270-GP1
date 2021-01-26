package edu.cmich.cps270;

@SuppressWarnings("serial")
class SetElementValueOutOfRange extends Exception {

	SetElementValueOutOfRange() {
		super();
	}
	
	SetElementValueOutOfRange(String message) {
		super(message);
	}
}
