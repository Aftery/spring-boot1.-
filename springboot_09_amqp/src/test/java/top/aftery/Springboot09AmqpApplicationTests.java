package top.aftery;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.aftery.bean.Book;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot09AmqpApplicationTests {

    @Autowired
    private RabbitTemplate template;

    //单播(点对点)
    @Test
    public void contextLoads() {
        //template.convertAndSend("hello");
//        Map<Object,Object> map=new HashMap<>(16);
//        map.put("msg","这是第一个消息");
//        map.put("data", Arrays.asList("hello","123"));
//        template.convertAndSend("atguigu.news",map);
        template.convertAndSend("exchange.direct", "atguigu.news", new Book("西游记", "吴承恩"));

    }

    @Test
    public void receive() {
        Object o = template.receiveAndConvert("atguigu.news");
        log.debug("\n:{}",o.getClass());
        log.info("\n{}", o);
    }

    @Test
    public void  sendMsg(){
     template.convertAndSend("exchange.fanout⎵","",new  Book("红楼梦","曹雪芹"));
    }
}
