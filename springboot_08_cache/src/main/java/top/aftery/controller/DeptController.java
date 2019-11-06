package top.aftery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.aftery.bean.Department;
import top.aftery.service.DeptServiceImpl;

@RestController
public class DeptController {

    @Autowired
    private DeptServiceImpl service;

    @GetMapping("/dept/{id}")
    public Department getDept(@PathVariable("id") Integer id){
        return service.getDeptById(id);
    }
}
