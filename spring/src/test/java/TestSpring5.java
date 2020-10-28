import com.spring.at.autowire.Emp;
import com.spring.at.bean.Book;
import com.spring.at.bean.Orders;
import com.spring.at.bean.User;
import com.spring.at.factoryBean.MyFactoryBean;
import com.spring.at.service.UserService;
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

    @Test
    public void OrdersTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = applicationContext.getBean("userService",UserService.class);
        userService.add();
    }

    @Test
    public void factoryBeanTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Book myFactoryBean = applicationContext.getBean("myFactoryBean",Book.class);
        System.out.println(myFactoryBean);

    }

    @Test
    public void scopeTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        User a1 = applicationContext.getBean("user1",User.class);
//        User a2 = applicationContext.getBean("user1",User.class);
        User b1 = applicationContext.getBean("user2",User.class);
        User b2 = applicationContext.getBean("user2",User.class);
//        System.out.println(a1+"\n"+a2+"\n"+b1+"\n"+b2);
    }

    @Test
    public void initMethod(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Book book = applicationContext.getBean("book",Book.class);
        //applicationContext调用close方法的时候就会执行配置文件中的bean中属性destroy-method的方法
        ((ClassPathXmlApplicationContext)applicationContext).close();
    }
    @Test
    public void testAutoWire(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean5.xml");
        Emp book = applicationContext.getBean("empl",Emp.class);
        book.test();
    }

}
