package com.app.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Exception.StudentException;
import com.app.Model.Student;
import com.app.Repository.StudentDao;
@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDao sDao;

	@Override
	public Student saveStudent(Student student) {
		Student savedStudent = sDao.save(student);
		return savedStudent;
	}

	@Override
	public Student getStudentByRoll(Integer roll) throws StudentException {
		Optional<Student> os  = sDao.findById(roll);
//		if(os.isPresent())
//		{
//			return os.get();
//		}
//		else {
//			throw new StudentException("Student does not exist with Roll "+roll);
//		}
		return os.orElseThrow(()->new StudentException("Student does not exist with Roll "+roll));
	}

	@Override
	public List<Student> getAllStudentDetails() throws StudentException {
		List<Student> students= sDao.findAll();
		
		if(students.size()>0)
		{
			return students;
		}
		else {
			throw new StudentException("Student does not exist");
		}
		
	}

	@Override
	public Student deleteStudentByRoll(Integer roll) throws StudentException {
		
	Student  existingStudent =	sDao.findById(roll).orElseThrow(()-> new StudentException("Student does not exist with the roll "+roll));
	sDao.delete(existingStudent);	
	return existingStudent;
	
	}

	@Override
	public Student updateStudent(Student student) throws StudentException {
		
		Student  existingStudent = sDao.findById(student.getRoll()).orElseThrow(()->new StudentException("Student does not exist "));
		return  sDao.save(student);
		
	}

	@Override
	public Student updateStudentMarks(Integer roll, Double Marks) throws StudentException {
		Optional<Student> sOptional = sDao.findById(roll);
		
		if(sOptional.isPresent())
		{
			Student existingStudent = sOptional.get();
			existingStudent.setMarks(Marks);
			return sDao.save(existingStudent);
		}
		else {
			throw new StudentException("Student does not exist with Roll "+roll);
		}
		
	}

}
