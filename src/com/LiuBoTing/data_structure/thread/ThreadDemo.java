package com.LiuBoTing.data_structure.thread;

/**
 * @author liuboting
 * @date 2020/9/23 20:13
 * 进程是一个具有一定独立功能的程序在一个数据集上的一次动态执行的过程，是操作系统进行资源分配和调度的一个独立单位，是应用程序运行的载体。
 * 操作系统运行的程序叫进程；我们写的代码是静态的，运行之后就是进程，未创建线程默认有两个线程（main，gc）
 * 进程具有的特征：
 * 动态性：进程是程序的一次执行过程，是临时的，有生命期的，是动态产生，动态消亡的；
 * 并发性：任何进程都可以同其他进行一起并发执行；
 * 独立性：进程是系统进行资源分配和调度的一个独立单位；
 * 结构性：进程由程序，数据和进程控制块三部分组成
 */

// 创建线程方法一：创建一个类继承Thread类，重写run()方法
    //线程开启不一定立即执行，由cpu调度执行
public class ThreadDemo extends Thread {

    @Override
    public void run() {
        System.out.println("1111111");
    }

    public static void main(String[] args) {

        ThreadDemo threadDemo = new ThreadDemo();
        threadDemo.start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("111");
        }
    }
}
