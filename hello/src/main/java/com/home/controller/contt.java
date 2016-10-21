
package com.home.controller;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ModelAndViewMethodReturnValueHandler;

import com.home.model.person;
import com.home.model.type;
import com.home.service.personservice;
import com.home.service.typeservice;




@Controller
public class contt 
{
	
	

	@Autowired
	typeservice ts;
		 

	@RequestMapping("/bloodtype")
	public ModelAndView bloodtype()
	{
		ModelAndView mav = new ModelAndView("bloodtype");
		
		mav.addObject("type", new type());
		
		return mav;
	}
	
	@RequestMapping("/AddUserToDB1")
	public ModelAndView AddUserToDB( @Valid @ModelAttribute("type")type t , BindingResult bi )
	{
		ModelAndView mav = new ModelAndView("bloodtype");
		
		if( bi.hasErrors() )
			mav.addObject("type", t);
		else
		{
			if( !t.getBLOODUNIT().equals(t.getBLOODUNIT()) )
			{
				mav.addObject("error", "BLOODUNIT Mismatch");
				mav.addObject("type", t);
			}
			else
			{
				List<type> list = ts.listtype();
				
				boolean check = false;
				
				for( type ul : list )
				{
					if( ul.getBLOODGROUPID().equals(t.getBLOODGROUPID()) )
					{
						check = true;
						break;
					}
				}
				
				if( check )
				{
					mav.addObject("error", "Username Already Exists");
					mav.addObject("type", t);
				}
				else
				{
				ts.addType(t);
					mav.addObject("success", "User Added Succesfully");
					mav.addObject("type", new type());
				}
			}
		}
			
		return mav;
	}

		  




}
