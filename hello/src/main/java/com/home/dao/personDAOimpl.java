package com.home.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.home.service.personservice;

import com.home.dao.personDAO;
import com.home.model.person;


@Repository
@Transactional
@EnableTransactionManagement
public class personDAOimpl implements personDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	public void addPerson(person p) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(p);
		
	}

	public void updatePerson(person p) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(p);
	}

	public List<person> listpersons() {
		// TODO Auto-generated method stub
List<person> list = sessionFactory.getCurrentSession().createQuery("from person p").list();
		
		return list;
	}

	public person getPersonById(int id) {
		// TODO Auto-generated method stub
List<person> list = sessionFactory.getCurrentSession().createQuery("from person p where p.id = :id").setInteger("id", id).list();
		
		if( !list.isEmpty() )
			return list.get(0);
		else
			return null;
		
	}

	public void removePerson(int id) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().createQuery("delete from  person p where p.id = :id").setInteger("id", id).executeUpdate();
		
	}


}

	