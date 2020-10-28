import com.spring.at.bean.Book;
import com.spring.at.bean.User;
import com.spring.at.config.SpringConfig;
import com.spring.at.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestSpring5 {

    @Test
    public void addTest(){

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Book book = applicationContext.getBean("books", Book.class);
        System.out.println(book.toString());
    }

    @Test
    public void userTest(){

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        System.out.println(userService);
        UserService userService2 = applicationContext.getBean("userService", UserService.class);
        System.out.println(userService2);
        userService.add();
    }
    @Test
    public void user2Test(){
        //加载配置文件转化成加载配置类
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = applicationContext.getBean("userService", UserService.class);
        System.out.println(userService);
        UserService userService2 = applicationContext.getBean("userService", UserService.class);
        System.out.println(userService2);
        userService.add();
    }


}
