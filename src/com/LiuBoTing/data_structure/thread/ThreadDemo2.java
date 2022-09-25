package com.LiuBoTing.data_structure.thread;

/**
 * @author liuboting
 * @date 2020/9/23 21:14
 */
//创建线程方式二：实现Runnable接口，重写run方法，执行线程需要丢入runnable接口实现类，调用start方法
public class ThreadDemo2 implements Runnable {

    @Override
    public void run() {
        // run方法线程体
        System.out.println("1111111");
    }

    public static void main(String[] args) {
        //创建实现类
        ThreadDemo2 threadDemo2 = new ThreadDemo2();
        //创建线程对象,通过线程对象开启我们的线程，代理
        Thread thread = new Thread(threadDemo2);

        thread.start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("111");
        }
    }
}
