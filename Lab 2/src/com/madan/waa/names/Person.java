package com.madan.waa.names;

public class Person {
	private String key;
	private String fname;
	private String lname;

	public Person(String key, String fname, String lname) {
		this.key = key;
		this.fname = fname;
		this.lname = lname;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

}
