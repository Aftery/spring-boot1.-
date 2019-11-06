package top.aftery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.aftery.bean.Employee;
import top.aftery.mapper.EmployeeMapper;

@RestController
public class EmpController {

    @Autowired
    private EmployeeMapper mapper;


    @RequestMapping("/emp/{id}")
    public Employee queryEmpById(@PathVariable("id") Integer id){
        return mapper.getEmpById(id);
    }

    @RequestMapping("/add_emp")
    public Employee saveEmp(Employee employee){
        mapper.insertEmp(employee);
        return  employee;
    }

}
