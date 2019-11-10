package top.aftery.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import top.aftery.bean.Book;

@Slf4j
@Service
public class BookService {

    @RabbitListener(queues = "atguigu.news")
    public void receive(Book book){
      log.info("\n{}",book);
    }

    @RabbitListener(queues="atguigu")
    public void  receive2(Message message){
        log.info("\n",message.getBody());
        log.info("\n",message.getMessageProperties());
    }

}
