package top.aftery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public  class Springboot06JdbcApplicationTests {

    @Autowired
    private DataSource datasource;

    @Test
   public void contextLoads() throws SQLException {

        System.out.println(datasource.getClass());

        Connection connection = datasource.getConnection();
        System.out.println(connection);
        connection.close();


    }


    @Test
    public  void  test(){
        System.out.println("hello word");
    }

}
