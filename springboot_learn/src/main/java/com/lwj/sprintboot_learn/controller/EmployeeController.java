package com.lwj.sprintboot_learn.controller;

import com.lwj.sprintboot_learn.dao.DepartmentDao;
import com.lwj.sprintboot_learn.dao.EmployeeDao;
import com.lwj.sprintboot_learn.pojo.Department;
import com.lwj.sprintboot_learn.pojo.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String employee(Model model){
        Collection<Employee> allEmployees = employeeDao.getAllEmployees();
        model.addAttribute("employees",allEmployees);
        return "employee/list";
    }
    //去到add页面
    @GetMapping("/add")
    public String toAddPage(Model model){
        Collection<Department> allDepartments = departmentDao.getAllDepartments();
        model.addAttribute("departments",allDepartments);
        return "employee/add";
    }
    @PostMapping("/add")
    public String addEmployee(Employee employee){
        log.info("add Employee"+employee);
        employeeDao.add(employee);
        return "redirect:/emps";
    }
    //去到update页面
    @GetMapping("/update/{id}")
    public String toUpdatePage(@PathVariable("id") Integer id,Model model){
        Employee employee= employeeDao.getEmployeeById(id);
        model.addAttribute("employee",employee);
        model.addAttribute("departments",departmentDao.getAllDepartments());
        return "employee/update";
    }
    //删除操作
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        employeeDao.deleteById(id);
        return "redirect:/emps";
    }
}
