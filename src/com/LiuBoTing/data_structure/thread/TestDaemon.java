package com.LiuBoTing.data_structure.thread;


/**
 * @author liuboting
 * @date 2020/10/1 16:33
 * 线程分为用户线程和守护线程
 * 虚拟机必须确保用户线程执行完毕
 * 虚拟机不用等待守护线程执行完毕
 * 如后台记录操作日志，监控内存，垃圾回收等
 */

public class TestDaemon {
    public static void main(String[] args) {

        God god = new God();
        Person person = new Person();
        Thread thread = new Thread(god);
        thread.setDaemon(true); // 设置守护线程 默认为false
        thread.start();
        new Thread(person).start();
    }
}

class God implements Runnable{

    @Override
    public void run() {
        while (true){
            System.out.println("上帝保佑着你");
        }
    }
}

class Person implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("活着的第"+i+"天");
        }
        System.out.println("===============GameOver================");
    }
}