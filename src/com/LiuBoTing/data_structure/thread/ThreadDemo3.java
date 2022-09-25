package com.LiuBoTing.data_structure.thread;

/**
 * @author liuboting
 * @date 2020/9/23 21:32
 */

public class ThreadDemo3 implements Runnable {
    private int ticket = 10;
    @Override
    public void run() {
        while (ticket >= 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "抢到了第" + ticket-- + "张票");
        }
    }

    public static void main(String[] args) {
        ThreadDemo3 threadDemo3 = new ThreadDemo3();

        new Thread(threadDemo3,"小明").start();
        new Thread(threadDemo3,"小红").start();
        new Thread(threadDemo3,"小刚").start();
    }
}
