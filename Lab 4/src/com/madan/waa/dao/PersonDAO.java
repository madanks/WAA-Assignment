package com.madan.waa.dao;

import java.util.ArrayList;
import java.util.List;

import com.madan.waa.model.Person;

/**
 * @author Madan
 *
 */
public class PersonDAO {

	List<Person> personList;

	public PersonDAO() {
		personList = new ArrayList<Person>();
	}

	public void add(Person person) {
		personList.add(person);
	}

	public List<Person> getPersonList() {
		return personList;
	}

	public Person findByKey(String key) {
		for (Person p : personList) {
			if (key.equals("" + p.getKey())) {
				return p;
			}
		}
		return null;
	}

	public void delete(String key) {
		personList.remove(this.findByKey(key));
	}

}
