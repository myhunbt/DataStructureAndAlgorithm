package com.LiuBoTing.data_structure.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liuboting
 * @date 2020/10/3 16:07
 */
//lock是显示锁(手动开关闭),synchronized是隐式锁(出了作用域自动释放)
//lock只有代码块锁，synchronized有代码块锁和方法锁
//使用Lock锁，JVM将花费较少的时间来调度线程，性能更好，并且具有良好的扩展性
//优先使用顺序：
//    Lock > 同步代码块 > 同步方法
public class TestLock {
    public static void main(String[] args) {
        BuyTicket1 ticket1 = new BuyTicket1();

        new Thread(ticket1).start();
        new Thread(ticket1).start();
        new Thread(ticket1).start();
    }
}
class BuyTicket1 extends Thread{
    private int ticketNum = 10;
    private final ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        try{
            lock.lock();
            while (true){
                if(ticketNum>0){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(ticketNum--);
                }else {
                    break;
                }
            }
        }finally {
            lock.unlock();
        }
    }
}
