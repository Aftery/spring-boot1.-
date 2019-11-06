package top.aftery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.aftery.bean.Employee;
import top.aftery.service.EmployeeService;

@SuppressWarnings("all")
@RestController
public class EmpController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/queryemp/{id}")
    public Employee queryEmpById(@PathVariable("id") Integer id) {
        Employee employee = service.queryEmpById(id);
        return employee;
    }

    @GetMapping("/emp")
    public Employee update(Employee employee) {
        Employee emp = service.updateEmp(employee);

        return emp;
    }

    @GetMapping("/delemp")
    public String deleteEmp(Integer id) {
        service.deleteEmp(id);
        return "success";
    }

    @GetMapping("/emp/lastname/{lastName}")
    public Employee getEmpByLastName(@PathVariable("lastName") String lastName) {
        return service.getEmpByLastName(lastName);
    }

}
