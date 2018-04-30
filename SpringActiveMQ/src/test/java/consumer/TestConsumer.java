package consumer;

import com.jiehang.consumer.Consumer;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestConsumer {

    public static Consumer consumer;

    @BeforeClass
    public static void init() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        consumer = (Consumer) context.getBean("consumer");
    }

    @Test
    public void TestReceive() {
        consumer.receive(consumer.getJmsTemplate().getDefaultDestination());
    }

}
