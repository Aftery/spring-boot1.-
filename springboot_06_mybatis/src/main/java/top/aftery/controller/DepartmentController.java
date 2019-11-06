package top.aftery.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.aftery.bean.Department;
import top.aftery.mapper.DepartmentMapper;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentMapper mapper;

    @RequestMapping("/dept/{id}")
    public Department getdept(@PathVariable("id") Integer id) {
        return mapper.getDeptById(id);
    }

    @RequestMapping("/dept")
    public Department insetDept(Department department) {
        mapper.insertDept(department);
        return department;

    }

}
