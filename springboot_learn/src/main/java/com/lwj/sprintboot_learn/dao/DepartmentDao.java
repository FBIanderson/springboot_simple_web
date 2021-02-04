package com.lwj.sprintboot_learn.dao;

import com.lwj.sprintboot_learn.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentDao {
    private static Map<Integer, Department> departments;
    static{
        departments =new HashMap<>();
        departments.put(101,new Department(101,"后勤部"));
        departments.put(102,new Department(102,"销售部"));
        departments.put(103,new Department(103,"教学部"));
        departments.put(104,new Department(104,"教研部"));
        departments.put(105,new Department(105,"组织部"));
    }
    public Collection<Department> getAllDepartments(){
        return departments.values();
    }
    public  Department getDepartmentById(Integer id){
        return departments.get(id);
    }
}
