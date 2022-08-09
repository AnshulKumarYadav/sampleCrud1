package com.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.Model.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer>{
	
	 

}
