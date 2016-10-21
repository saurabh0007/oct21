package com.home.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.home.dao.typeDAO;
import com.home.model.type;


@Service
public class typeserviceimpl implements typeservice {
	@Autowired
	typeDAO udao;
	public void addType(type t) {
		// TODO Auto-generated method stub
		udao.addType(t);
	}

	public void updateType(type t) {
		// TODO Auto-generated method stub
		udao.updateType(t);
	}

	public List<type> listtype() {
		// TODO Auto-generated method stub
		return udao.listtype();
	}

	public type getTypeById(int id) {
		// TODO Auto-generated method stub
		return udao.getTypeById(id);
	}

	public void removeType(int id) {
		// TODO Auto-generated method stub
		udao.removeType(id);
	}

	
}