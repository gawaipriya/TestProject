package com.cjc.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cjc.main.model.Student;
import com.cjc.main.service.HomeService;

@Controller
public class HomeController {

	@Autowired
	HomeService hs;
	
	
	@RequestMapping("/")
	public String prelogin()
	{
		
		System.out.println("This login Page");
		return "login";
	}
	
	@RequestMapping("/login")
	public String loginpage(@RequestParam("uname") String un,@RequestParam("password") String pass,Model m)
	{
		
		Student stu=hs.logincheck(un,pass);
		
		if(stu!=null)
		{
			Iterable<Student> list=hs.getAllData();
			m.addAttribute("data",list);

			return "success";
			
		}
		else {
		
			return "login";
			
		}
		
	}
	
	@RequestMapping("/delete")
	public String deletedata(@ModelAttribute Student s,Model m)
	
	{
	
		hs.deletedata(s);
		Iterable<Student> list=hs.getAllData();
		m.addAttribute("data",list);
		return "success";
		
	}
	
	@RequestMapping("/edit")
	public String editdata(@RequestParam("uid") int uid,Model m)
	{

		Student s=hs.editdata(uid);
		m.addAttribute("data",s);
		
		return "edit";
	}

	@RequestMapping("/update")
	public String updatedata(@ModelAttribute Student s,Model m)
	{
		hs.savedata(s);
		Iterable<Student> list=hs.getAllData();
		m.addAttribute("data",list);
		return "success";
		
	}
	
	
	
	
	
	
	@RequestMapping("/registration")
	public String preregister()
	{
		return "registration";
	}
	
	@RequestMapping("/reg")
	public String registerdata(@ModelAttribute Student stu)
	{
		
		hs.savedata(stu);
		return "login";
	}
}

