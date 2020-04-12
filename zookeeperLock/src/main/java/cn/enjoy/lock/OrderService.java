package cn.enjoy.lock;

import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;


/**
 * Created by VULCAN on 2018/9/20.
 */
//使用多线程模拟生成订单号
public class OrderService implements Runnable {
    private OrderNumGenerator orderNumGenerator = new OrderNumGenerator();

    private static CountDownLatch countDownLatch = new CountDownLatch(50);

    private static List<String> result = new Vector<String>();



    public void run() {
        countDownLatch.countDown();
        result.add(orderNumGenerator.getNumber());
    }


    public static void main(String[] args) throws InterruptedException {

        System.out.println("####生成唯一订单号###");

        OrderService orderService = new OrderService();
        for (int i = 0; i < 50; i++) {
            new Thread( orderService).start();
        }

        countDownLatch.await();

        Thread.sleep(1000);

        Collections.sort(result);
       for(String str:result) {
           System.out.println(str);
       }

    }
}