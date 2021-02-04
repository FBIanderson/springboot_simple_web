package com.lwj.sprintboot_learn.dao;

import com.lwj.sprintboot_learn.pojo.Department;
import com.lwj.sprintboot_learn.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    @Autowired
    private DepartmentDao departmentDao;
    private static Map<Integer, Employee> employees = new HashMap<>();
    static{
        employees = new HashMap<>();
        employees.put(1001,new Employee(1001,"AA","Ajiasansui1573@foxmail.com",0,new Department(101,"后勤部")));
        employees.put(1002,new Employee(1002,"BB","Bjiasansui1573@foxmail.com",1,new Department(102,"销售部")));
        employees.put(1003,new Employee(1003,"CC","Cjiasansui1573@foxmail.com",0,new Department(103,"教学部")));
        employees.put(1004,new Employee(1004,"DD","Djiasansui1573@foxmail.com",1,new Department(104,"教研部")));
        employees.put(1005,new Employee(1005,"EE","Ejiasansui1573@foxmail.com",0,new Department(105,"组织部")));
    }
    private static Integer id=1006;
    public Collection<Employee> getAllEmployees(){
        return employees.values();
    }
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }
    public void add(Employee employee){
        if(employee.getId()==null){
           employee.setId(id++);
        }
        if(employee.getDepartment().getId()!=null){
            employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));

        }
        employees.put(employee.getId(),employee);
    }
    public void deleteById(Integer id){
        employees.remove(id);
    }
}
