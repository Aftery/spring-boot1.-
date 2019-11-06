package top.aftery.mapper;

import org.apache.ibatis.annotations.*;
import top.aftery.bean.Employee;

@Mapper
public interface EmployeeMapper {


    @Select("select * from employee where id=#{id}")
    Employee queryEmpById(Integer id);

    @Update("update employee set lastName=#{lastName}, email=#{email},gender=#{gender},d_id=#{dId} where id=#{id}")
    void  updateEmployee(Employee employee);


    @Delete("delete from employee where id=#{id}")
    void deleteEmpByiD(Integer id);


    @Insert("INSERT INTO employee(lastName,email,gender,d_id) VALUES(#{lastName},#{email},#{gender},#{dId})")
    void saveEmp(Employee employee);

    @Select("select * from employee where lastName=#{lastName}")
    Employee getEmpByLastName(String lastName);
}
