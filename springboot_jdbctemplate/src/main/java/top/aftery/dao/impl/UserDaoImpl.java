package top.aftery.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import top.aftery.dao.UserDao;
import top.aftery.entity.User;
import top.aftery.mapper.UserMapper;

import java.sql.Types;
import java.util.List;
import java.util.Map;

@Repository()
@SuppressWarnings("all")
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public int add(User user) {
        String sql = "insert into user(name,password) values(:name,:password)";

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(this.jdbcTemplate.getDataSource());

        return template.update(sql, new BeanPropertySqlParameterSource(user));
    }

    @Override
    public int update(User user) {
        String sql = "update user set name=?,password=? where id=?";
        Object[] args = {user.getName(), user.getPassword(), user.getId()};
        int[] argsType = {Types.VARCHAR, Types.VARCHAR, Types.INTEGER};
        return this.jdbcTemplate.update(sql, args, argsType);
    }

    @Override
    public int deleteById(Integer id) {
        String sql = "";
        Object[] args = {id};
        int[] argsType = {Types.INTEGER};
        return this.jdbcTemplate.update(sql, args, argsType);
    }

    @Override
    public List<Map<String, Object>> queryUserList() {
        String sql = "select * from user";
        return this.jdbcTemplate.queryForList(sql);
    }

    @Override
    public User queryUserById(Integer id) {
        String sql = "select * from user where id=?";
        Object[] args = {id};
        int[] argsType = {Types.INTEGER};
        List<User> query = this.jdbcTemplate.query(sql, args, argsType, new UserMapper());
        if (query != null && query.size() > 0) {
            return query.get(0);
        } else {
            return null;
        }
    }
}
