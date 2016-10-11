package com.example;

import com.example.dubbo.service.HelloService;
import net.sourceforge.groboutils.junit.v1.MultiThreadedTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
public class AppTest {

    @Autowired
    private HelloService helloService;

    public AtomicInteger atomicInteger;

    @Test
    public void test(){
//        for(int i = 0; i < 10000; i++){
//            System.out.println("开始执行" + i);
            helloService.sayHello("123");

//        }

    }

    @Test
    public void MultiRequestsTest() throws InterruptedException {
        ExecutorService exec = Executors.newFixedThreadPool(500);
        for (int i = 0; i < 500; i++) {
            exec.execute(new Test1(helloService, i));
        }
        exec.shutdown();
        Thread.sleep(1000000);
        System.out.println("111");
    }

}

class Test1 extends Thread{

    private HelloService helloService;
    private Integer i;

    public Test1(HelloService helloService, Integer i){
        this.helloService = helloService;
        this.i = i;
    }

    @Override
    public void run(){
        System.out.println("开始执行"+i);
        helloService.sayHello(i+"");
    }

}
