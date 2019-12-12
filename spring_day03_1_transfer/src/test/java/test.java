import com.itheima.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author tyler.chen
 * @date 2019/12/12 23:37
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class test {

    @Resource
    AccountService accountService;

    @Test
    public void test01(){
//       创建类对象，创建springIOC容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        accountService.transfer("aaa","bbb",100f);
    }


}
