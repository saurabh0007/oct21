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

import com.home.model.type;

@Repository
@Transactional
@EnableTransactionManagement
public class typeDAOimpl implements typeDAO
{

	@Autowired
	SessionFactory sessionFactory;
	
	public void addType(type t) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(t);
	}

	public void updateType(type t) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(t);
	}

	public List<type> listtype() {
		// TODO Auto-generated method stub
		List<type> list = sessionFactory.getCurrentSession().createQuery("from type t").list();
		return null;
	}

	public type getTypeById(int id) {
		// TODO Auto-generated method stub
List<type> list = sessionFactory.getCurrentSession().createQuery("from type t where p.id = :id").setInteger("id", id).list();
		
		if( !list.isEmpty() )
			return list.get(0);
		else
			return null;
	}

	public void removeType(int id) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().createQuery("delete from  type t where p.id = :id").setInteger("id", id).executeUpdate();
			
	}

		
}