package com.home.service;
import java.util.List;

import com.home.model.person;

public interface personservice {

	public void addperson(person p);
	public void updatePerson(person p);
	public List<person> listpersons();
	public person getpersonById(int id);
	public void removePerson(int id);
	
}