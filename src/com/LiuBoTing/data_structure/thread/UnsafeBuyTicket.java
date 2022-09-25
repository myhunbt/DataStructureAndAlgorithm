package com.LiuBoTing.data_structure.thread;

/**
 * @author liuboting
 * @date 2020/10/1 16:57
 */
//不安全的买票
    //线程不安全，有负数
public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket ticket = new BuyTicket();
        Thread t1 = new Thread(ticket, "我");
        Thread t2 = new Thread(ticket, "他们");
        Thread t3 = new Thread(ticket, "黄牛");

        t1.start();
        t2.start();
        t3.start();

    }
}

class BuyTicket implements Runnable{

    //票
    private int ticketNum = 10;
    private boolean flag = true;
    @Override
    public void run() {
        //买票
        while (flag){
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //synchronized 同步方法，锁的是this --> BuyTicket这个对象
    private synchronized void buy() throws InterruptedException {
        //判断是否有票
        if(ticketNum <= 0){
            flag = false;
            return;
        }
        //模拟延迟
        Thread.sleep(100);

        //买票
        System.out.println(Thread.currentThread().getName() + "买了" + ticketNum--);
    }
}
