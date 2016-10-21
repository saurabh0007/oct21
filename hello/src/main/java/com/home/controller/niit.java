
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
import com.home.service.personservice;




@Controller
public class niit
{
	
	

	@Autowired
	personservice ps;
		 

	@RequestMapping("/signup")
	public ModelAndView signup()
	{
		ModelAndView mav = new ModelAndView("signup");
		
		mav.addObject("person", new person());
		
		return mav;
	}
	
	@RequestMapping("/AddUserToDB")
	public ModelAndView AddUserToDB( @Valid @ModelAttribute("person")person p , BindingResult bi )
	{
		ModelAndView mav = new ModelAndView("signup");
		
		if( bi.hasErrors() )
			mav.addObject("person", p);
		else
		{
			if( !p.getPassword().equals(p.getCPassword()) )
			{
				mav.addObject("error", "Password Mismatch");
				mav.addObject("person", p);
			}
			else
			{
				List<person> list = ps.listpersons();
				
				boolean check = false;
				
				for( person ul : list )
				{
					if( ul.getUsername().equals(p.getUsername()) )
					{
						check = true;
						break;
					}
				}
				
				if( check )
				{
					mav.addObject("error", "Username Already Exists");
					mav.addObject("person", p);
				}
				else
				{
				ps.addperson(p);
					mav.addObject("success", "User Added Succesfully");
					mav.addObject("person", new person());
				}
			}
		}
			
		return mav;
	}

		  
}