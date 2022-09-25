package com.LiuBoTing.data_structure.thread;

/**
 * @author liuboting
 * @date 2020/9/25 15:17
 */
//join合并线程，待此线程执行完成后，在执行其他线程，其他线程堵塞
    //可以理解为插队
public class TestJoin implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("我是vip，我要插队" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();

        for (int i = 0; i < 100; i++) {
            if(i == 50){
                thread.join();
            }
            System.out.println("main执行" + i);
        }

    }
}
