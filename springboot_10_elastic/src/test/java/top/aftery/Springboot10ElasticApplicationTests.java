package top.aftery;

import top.aftery.bean.Article;
import top.aftery.bean.Book;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.aftery.repository.BookRepository;

import java.io.IOException;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot10ElasticApplicationTests {

    @Autowired
    private JestClient jestClient;


    @Autowired
    BookRepository bookRepository;


    @Test
    public void test02(){
//        Book book=new Book();
//        book.setId(1);
//        book.setBookName("吴承恩");
//        book.setAuthor("西游记");
//        Book index = bookRepository.index(book);
        for (Book book : bookRepository.findByBookNameLike("承")) {
            log.info("\n 5:{}",book);
        }
        ;


    }




    @Test
    public void contextLoads() throws IOException {

        Article article = new Article();
        article.setId(1);
        article.setTitle("msg");
        article.setAuthor("zhangsan");
        article.setContent("hello");
        //构建一个索引功能
        Index build = new Index.Builder(article).index("atguigu").type("news").build();
        //执行
        jestClient.execute(build);
    }

    @Test
    public void search() throws IOException {
        String json = "{\n" +
                "    \"query\" : {\n" +
                "        \"match\" : {\n" +
                "            \"content\" : \"hello\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        //更多操作：https://github.com/searchbox-io/Jest/tree/master/jest
        //构建搜索功能
        Search build = new Search.Builder(json).addIndex("atguigu").addType("news").build();
        SearchResult execute = jestClient.execute(build);
        log.info("\n search:{}", execute.getJsonObject());
    }

}
