package com.app.Service;

import java.util.List;

import com.app.Exception.StudentException;
import com.app.Model.Student;

public interface StudentService {
	
	public Student saveStudent(Student student);
	
	public Student getStudentByRoll(Integer roll) throws StudentException;

	public List<Student> getAllStudentDetails() throws StudentException;
	
	public  Student deleteStudentByRoll(Integer roll) throws StudentException;
	
	public  Student updateStudent(Student student)throws StudentException;
	
	public Student updateStudentMarks(Integer roll, Double Marks) throws StudentException;
	
}
