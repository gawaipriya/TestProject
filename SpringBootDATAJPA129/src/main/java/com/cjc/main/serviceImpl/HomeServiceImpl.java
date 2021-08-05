package com.cjc.main.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.main.model.Student;
import com.cjc.main.repository.HomeRepository;
import com.cjc.main.service.HomeService;

@Service
public class HomeServiceImpl  implements HomeService{

	@Autowired
	HomeRepository hr;
	
	
	@Override
	public void savedata(Student stu) {
		
		hr.save(stu);
	}


	@Override
	public Student logincheck(String un, String pass) {
		
		
		return hr.findAllByUnameAndPassword(un,pass);
	}


	@Override
	public Iterable<Student> getAllData() {
		
		
		return hr.findAll();
	}


	@Override
	public void deletedata(Student s) {
		
		hr.delete(s);
		
		
	}


	@Override
	public Student editdata(int uid) {
		
		
		return hr.findByUid(uid);
	}
	
	

}
