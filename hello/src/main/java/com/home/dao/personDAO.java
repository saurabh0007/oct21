package com.home.dao;


import java.util.List;

import com.home.model.person;

public interface personDAO {

	public void addPerson(person p);
	public void updatePerson(person p);
	public List<person> listpersons();
	public person getPersonById(int id);
	public void removePerson(int id);


}