package com.jspiders.student_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspiders.student_management.pojo.StudentPojo;

public interface StudentRepository extends JpaRepository<StudentPojo, Integer> {

	List<StudentPojo> findByName(String name);

	List<StudentPojo> findByAddress(String address);

}
