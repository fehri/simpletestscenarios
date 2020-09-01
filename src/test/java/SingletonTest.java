import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class SingletonTest {

    // What is the difference between Test 01 and Test 02?
    // Why is test03 not failing?
    // Why is test04 sometimes failing and sometimes passing?
    // Can you change the code in the Singleton class to ensure test04 will always succeed?

    @Test
    public void test01(){

        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        Assertions.assertTrue(singleton1 == singleton2);

    }

    @Test
    public void test02(){

        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        Assertions.assertEquals(singleton1,singleton2);

    }


    @Test
    public void test03(){

        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        singleton1.setName("John");
        singleton2.setName("Peter");

        Assertions.assertEquals(singleton1,singleton2);

    }

    @Test
    public void test04() throws InterruptedException {
        int threadsAmount = 500;
        Set<Singleton> singletonSet = Collections.newSetFromMap(new ConcurrentHashMap<>());

        ExecutorService executorService = Executors.newFixedThreadPool(threadsAmount);

        for (int i = 0; i < threadsAmount; i++) {
            executorService.execute(() -> {
                Singleton singleton = Singleton.getInstance();
                singletonSet.add(singleton);
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);

        Assertions.assertEquals(1, singletonSet.size());
    }





}
