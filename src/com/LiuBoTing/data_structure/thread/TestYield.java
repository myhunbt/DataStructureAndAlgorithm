package com.LiuBoTing.data_structure.thread;

/**
 * @author liuboting
 * @date 2020/9/24 21:27
 */
//测试礼让线程
    //礼让不一定成功，看cpu心情
public class TestYield {
    public static void main(String[] args) {
        MyYield myYield = new MyYield();

        new Thread(myYield,"a").start();
        new Thread(myYield,"b").start();
    }
}


class MyYield implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始执行");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + "停止执行");
    }
}