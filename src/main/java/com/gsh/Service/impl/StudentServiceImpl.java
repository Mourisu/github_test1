package com.gsh.Service.impl;

import com.gsh.Service.StudentService;
import com.gsh.dao.StudentDao;
import com.gsh.domain.Student;
import com.gsh.utils.SqlSessionUtil;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    @Override
    public List<Student> getAllStudent() {

        StudentDao mapper = SqlSessionUtil.getSqlSession().getMapper(StudentDao.class);

        List<Student> allStudent = mapper.getAllStudent();

        return allStudent;
    }
}
