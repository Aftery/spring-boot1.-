package top.aftery.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.aftery.bean.Department;

@Mapper
public interface DeptmentMapper {

    @Select("select * from department where id=#{id}")
    public Department getDeptById(Integer id);
}
