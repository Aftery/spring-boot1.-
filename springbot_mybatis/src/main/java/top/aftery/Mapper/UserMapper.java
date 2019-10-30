package top.aftery.Mapper;

import org.apache.ibatis.annotations.Mapper;
import top.aftery.entity.User;

import java.util.List;

@Mapper
public interface UserMapper {

    int add(User user);

    int update(User user);


    int deleteById(Integer id);

    User queryUserById(Integer id);

    List<User> queryUserList();
}
