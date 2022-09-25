package com.LiuBoTing.data_structure.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liuboting
 * @date 2020/10/4 19:09
 */
//测试线程池
public class TestPool {
    public static void main(String[] args) {
        //创建服务，创建线程池
        //参数为线程池大小
        ExecutorService service = Executors.newFixedThreadPool(10);

        service.execute(new MyThead());
        service.execute(new MyThead());
        service.execute(new MyThead());

        //关闭连接
        service.shutdown();
    }
}

class MyThead implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
