package com.LiuBoTing.data_structure.thread;

/**
 * @author liuboting
 * @date 2020/10/3 18:23
 */
//生产者与消费者模式：管城法
public class TestPC {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();
        new Productor(container).start();
        new Consumer(container).start();
    }
}

//消费者
class Consumer extends Thread{
    SynContainer container = new SynContainer();

    public Consumer(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println("消费了第" + container.pop().id + "只鸡");
        }
    }
}

//生产者
class Productor extends Thread{
    SynContainer container = new SynContainer();

    public Productor(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            container.push(new Chicken(i));
            System.out.println("生产第" + i + "只鸡");
        }
    }
}

//产品
class Chicken{
    int id; //产品编号

    public Chicken(int id) {
        this.id = id;
    }
}

//缓冲区
class SynContainer{
    //容器大小
    Chicken[] chickens = new Chicken[10];

    //容器计数
    static int count = 0;

    //生产者生产鸡
    public synchronized void push(Chicken chicken){
        //如果容器满了，就等待消费者消费
        if(count == chickens.length){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //如果容器未满，生产鸡
        chickens[count++] = chicken;

        //消费者可以消费了
        this.notifyAll();
    }

    public synchronized Chicken pop(){
        //如果容器为空，就等待生产者生产
        if(count == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //如果容器不为空，消费
        Chicken chicken = chickens[--count];
        this.notifyAll();
        return chicken;
    }
}

