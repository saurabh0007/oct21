package com.home.service;

import java.util.List;

import com.home.model.type;


public interface typeservice {
	public void addType(type t);
	public void updateType(type t);
	public List<type> listtype();
	public type getTypeById(int id);
	public void removeType(int id);
}
