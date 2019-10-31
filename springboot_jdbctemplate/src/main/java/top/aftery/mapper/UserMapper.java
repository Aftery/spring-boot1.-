package top.aftery.mapper;

import org.springframework.jdbc.core.RowMapper;
import top.aftery.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user=new User();
        user.setName(resultSet.getString("name"));
        user.setId(resultSet.getInt("id"));
        user.setPassword(resultSet.getString("password"));
        return user;
    }
}
