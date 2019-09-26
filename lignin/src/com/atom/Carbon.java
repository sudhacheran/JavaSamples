package com.atom;

import org.openscience.cdk.Atom;

public class Carbon extends Atom {
	
	private static final long serialVersionUID = 1L;
	
	int atomicNumber;
	String id;
	
	public Carbon(String id)
	{
		atomicNumber = 6;
		super.atomicNumber=6;
		this.id=id;
	}
	
	public Integer getAtomicNumber() {
		return atomicNumber;
	}
	public void setAtomicNumber(int atomicNumber) {
		this.atomicNumber = atomicNumber;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
