package top.aftery.mapper;


import org.apache.ibatis.annotations.*;
import top.aftery.bean.Department;

@SuppressWarnings("all")
//@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    Department getDeptById(Integer id);

    @Delete("delete from department where id=#{id}")
    int deleteDeptById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into department(departmentName) values(#{departmentName})")
    int insertDept(Department department);

    @Update("update department set departmentName=#{departmentName} where id=#{id}")
    int updateDept(Department department);
}
