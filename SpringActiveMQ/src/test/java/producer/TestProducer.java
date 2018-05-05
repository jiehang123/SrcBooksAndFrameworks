package producer;

import com.jiehang.producer.Producer;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestProducer {

    private static Producer producer;

    @BeforeClass
    public static void init() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring_activemq_config.xml");
        producer = (Producer) context.getBean("producer");
    }

    @Test
    public void TestSend() {
        long begin = System.currentTimeMillis() + 2000L;
        for (int i=0;;i++) {
            producer.sendMessage("--" + i);
            if (System.currentTimeMillis() > begin)
                break;
        }
        System.out.println("send message over !");
    }

}
