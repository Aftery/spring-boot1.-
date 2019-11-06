package top.aftery.mapper;

import top.aftery.bean.Employee;

public interface EmployeeMapper {

    Employee getEmpById(Integer id);

    void  insertEmp(Employee employee);


}
