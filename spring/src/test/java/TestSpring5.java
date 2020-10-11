import com.spring.at.bean.User;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


public class TestSpring5 {

    @Test
    public void addTest(){

        Resource resource = new ClassPathResource("applicationContext.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        //2 获取在配置文件中创建的对象
        //1 加载spring的配置文件，
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        BeanFactory applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");


        User user1 = applicationContext.getBean("user", User.class);

        System.out.println(user1);

        user1.add();
        user1.setName("孟老板");
        User user2 = applicationContext.getBean("user", User.class);
        System.out.println(user2);
        user2.add();
    }
}
