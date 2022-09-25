package com.LiuBoTing.data_structure.thread;

/**
 * @author liuboting
 * @date 2020/9/26 19:29
 */
// 设置优先级
    //线程调度按照优先级决定应该调度哪个线程来执行
public class TestPriority implements Runnable {
    public static void main(String[] args) {
            TestPriority testPriority = new TestPriority();


            Thread t1 = new Thread(testPriority);
            Thread t2 = new Thread(testPriority);
            Thread t3 = new Thread(testPriority);
            Thread t4 = new Thread(testPriority);


            t1.setPriority(1);
            t2.setPriority(Thread.MAX_PRIORITY);
            t3.setPriority(2);
            t4.setPriority(3);

            t1.start();
            t2.start();
            t3.start();
            t4.start();
    }


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "---->" + Thread.currentThread().getPriority());
    }
}

