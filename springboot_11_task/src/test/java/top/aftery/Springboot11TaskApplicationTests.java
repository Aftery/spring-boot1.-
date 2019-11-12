package top.aftery;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot11TaskApplicationTests {

    @Autowired
    private JavaMailSender sender;

    @Test
    public void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件设置
        message.setSubject("今晚开会");
        message.setText("今晚 8：00 开会");
        message.setTo("@qq.com");
        message.setFrom("@163.com");
        sender.send(message);
    }

    @Test
    public void  sendEmail() throws MessagingException {
        MimeMessage mimeMessage = sender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,true);

        helper.setSubject("今晚开会");
        helper.setText("<b style='color:red'>今天 7:30 开会</b>",true);
        helper.setTo("@qq.com");
        helper.setFrom("@163.com");
        helper.addAttachment("1.jpg",new File("/home/aftery/Pictures/1.jpg"));
        helper.addAttachment("2.jpg",new File("/home/aftery/Pictures/1.jpg"));

        sender.send(mimeMessage);
    }

}
