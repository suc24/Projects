package com.jspiders.student_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.student_management.exception.InvalidEmailException;
import com.jspiders.student_management.pojo.StudentPojo;
import com.jspiders.student_management.response.StudentResponse;
import com.jspiders.student_management.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired 
	private StudentService service;
	
	@PostMapping("/add")
	public ResponseEntity<?> addStudent(@RequestBody StudentPojo pojo){
		try {
			StudentPojo student = service.addStudent(pojo);
			
			if (student!=null) {
				return new ResponseEntity<StudentResponse>(new StudentResponse("Data Added Successfully", student, null),HttpStatus.ACCEPTED);
			}
			return new ResponseEntity<StudentResponse>(new StudentResponse("Data Not Added", student, null),HttpStatus.NOT_ACCEPTABLE);
			
		} catch (Exception e) {
			return new ResponseEntity<InvalidEmailException>(new InvalidEmailException(true, "Please Enter Right Email"),HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("/search/{id}")
	public ResponseEntity<?> searchById(@PathVariable int id){
		StudentPojo student = service.searchById(id);
		if (student!=null) {
			return new ResponseEntity<StudentResponse>(new StudentResponse("Record Found", student, null),HttpStatus.FOUND);
		}
		return new ResponseEntity<StudentResponse>(new StudentResponse("Record Not Found", student, null),HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/searchAll")
	public ResponseEntity<?> searchAll(){
		List<StudentPojo> students = service.searchAll();
		
		if (students.isEmpty()==false) {
			return new ResponseEntity<StudentResponse>(new StudentResponse("Data Found", null, students),HttpStatus.FOUND);
		}
		return new ResponseEntity<StudentResponse>(new StudentResponse("Data Not Found", null, students),HttpStatus.NOT_FOUND);
	}

	@GetMapping("/searchByName/{name}")
	public ResponseEntity<?> searchByName(@PathVariable String name){
		List<StudentPojo> students = service.searchByName(name);
		
		if (students.isEmpty()==false) {
			return new ResponseEntity<StudentResponse>(new StudentResponse("Data Found", null, students),HttpStatus.FOUND);
		}
		return new ResponseEntity<StudentResponse>(new StudentResponse("Data Not Found", null, students),HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/searchByAddress/{address}")
	public ResponseEntity<?> searchByAddress(@PathVariable String address){
		List<StudentPojo> students = service.searchByAddress(address);
		if (students.isEmpty()==false) {
			return new ResponseEntity<StudentResponse>(new StudentResponse("Data Found", null, students),HttpStatus.FOUND);
		}
		return new ResponseEntity<StudentResponse>(new StudentResponse("Data Not Found", null, students),HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> updateStudent(@RequestBody StudentPojo pojo){
		StudentPojo student = service.updateStudent(pojo);
		
		if (student!=null) {
			return new ResponseEntity<StudentResponse>(new StudentResponse("Record Updated Successfully", pojo, null),HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<StudentResponse>(new StudentResponse("Record Not Found", null, null),HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> removeStudent(@PathVariable int id){
		StudentPojo student = service.removeStudent(id);
		
		if (student!=null) {
			return new ResponseEntity<StudentResponse> (new StudentResponse("Record Deleted", student, null),HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<StudentResponse>(new StudentResponse("Record Not Found", student, null),HttpStatus.NOT_FOUND);
	}
	
	
}
