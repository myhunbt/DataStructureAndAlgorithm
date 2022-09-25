package com.LiuBoTing.AlgorithmBasis.ProducerConsumerProblem.BlcokingQueue;

import java.util.concurrent.BlockingDeque;

/**
 * @author liuboting
 * @date 2021/9/20 17:49
 */

public class Goods {
    private String name;
    private BlockingDeque<Goods> goods;


    public Goods(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public synchronized void takeGoods() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            synchronized (this){

                Thread.sleep(100);
                System.out.println("消费者消费" + this.getName());
                notify();
            }
        }
    }

    public void putGoods() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            synchronized(this){

                Thread.sleep(100);
                System.out.println("生产者生产" + this.getName());
                notify();
            }
        }
    }

    public static void main(String[] args) {
        Goods goods = new Goods("薯片");
        Thread t1 = new Thread(new Consumer(goods));
        Thread t2 = new Thread(new Producer(goods));
        t1.start();
        t2.start();
    }
}
