package com.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.Model.Student;
import com.app.Service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/student")
	public Student saveStudentHandler(@RequestBody Student student)
	{
		return studentService.saveStudent(student);
	}
	
	@GetMapping("/students/{roll}")
	public Student getStudentByRollHandler(@PathVariable("roll") Integer roll)
	{
		return studentService.getStudentByRoll(roll);
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudentHandler()
	{
		List<Student> students = studentService.getAllStudentDetails();
		return new ResponseEntity<List<Student>>(students,HttpStatus.OK);
	}

	@DeleteMapping("/students/delete/{roll}")
	public Student deleteStudentHandler(@PathVariable Integer roll)
	{
		return studentService.deleteStudentByRoll(roll);
	}
	
	@PutMapping("/students/update/{roll}")
	public ResponseEntity<Student> updateStudentHandler(@RequestBody Student student)
	{
		Student student2 = studentService.updateStudent(student);
		return new ResponseEntity<Student>(student2,HttpStatus.OK);
	}
	
	@PutMapping("/students/updateMarks/{roll}")
	public ResponseEntity<Student> updateMarksHandler(@PathVariable("roll") Integer roll,@RequestParam("marks") Double gMarks)
	{
		Student updatedStudent = studentService.updateStudentMarks(roll, gMarks);
		
		return new ResponseEntity<Student>(updatedStudent,HttpStatus.OK);
	}
	
}
