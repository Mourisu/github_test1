package com.gsh.dao;

import com.gsh.domain.Student;

import java.util.List;

public interface StudentDao {

    List<Student> getAllStudent();

    Student getById(Integer id);

}
