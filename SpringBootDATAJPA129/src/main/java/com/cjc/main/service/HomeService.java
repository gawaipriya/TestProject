package com.cjc.main.service;

import com.cjc.main.model.Student;

public interface HomeService
{

	public void savedata(Student stu);
	public Student logincheck(String un,String pass);
	public Iterable<Student> getAllData();
	public void deletedata(Student s);
	public Student editdata(int uid);
	
}
