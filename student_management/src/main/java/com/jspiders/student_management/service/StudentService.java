package com.jspiders.student_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jspiders.student_management.exception.InvalidEmailException;
import com.jspiders.student_management.pojo.StudentPojo;
import com.jspiders.student_management.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repository;

	public StudentPojo addStudent(StudentPojo pojo) throws InvalidEmailException {
		if (pojo.getEmail().contains("@gmail.com")) {
			StudentPojo student = repository.save(pojo);
			return student;
		}
		throw new InvalidEmailException();
		
	}

	public StudentPojo searchById(int id) {
		StudentPojo studentPojo = repository.findById(id).orElse(null); //we write orElse() method because that method return object of Optional<> and we need only of required class so if found we get object or else we will get null
		return studentPojo;
	}

	public List<StudentPojo> searchAll() {
		List<StudentPojo> students = repository.findAll();
		return students;
	}

	public List<StudentPojo> searchByName(String name) {
		List<StudentPojo> students = repository.findByName(name);
		return students;
	}

	public List<StudentPojo> searchByAddress(String address) {
		List<StudentPojo> students = repository.findByAddress(address);
		return students;
	}

	public StudentPojo updateStudent(StudentPojo pojo) {
		StudentPojo student = repository.findById(pojo.getId()).orElse(null);
		if (student!=null) {
			repository.save(pojo);
			return pojo;
		}
		return null;
	}

	public StudentPojo removeStudent(int id) {
		StudentPojo student = repository.findById(id).orElse(null);
		if (student!=null) {
			repository.delete(student);
			return student;
		}
		return null;
	}

}
