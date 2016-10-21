package com.home.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.home.service.personservice;

import com.home.dao.personDAO;
import com.home.model.person;

@Service
public class personserviceimpl implements personservice{

	@Autowired
	personDAO udao;
	public void addperson(person p) {
		// TODO Auto-generated method stub
		udao.addPerson(p);
	}

	public void updatePerson(person p) {
		// TODO Auto-generated method stub
		udao.updatePerson(p);
	}

	public List<person> listpersons() {
		// TODO Auto-generated method stub
		return udao.listpersons();
	}

	public person getpersonById(int id) {
		// TODO Auto-generated method stub
		return udao.getPersonById(id);
	}

	public void removePerson(int id) {
		// TODO Auto-generated method stub
		udao.removePerson(id);
	}

	
	

}
