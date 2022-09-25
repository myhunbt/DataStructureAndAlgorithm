package com.LiuBoTing.data_structure.thread;

import java.util.ArrayList;

/**
 * @author liuboting
 * @date 2020/10/1 20:37
 */
// 安全的集合只有 Vector和hashTable 因为其里面的方法都添加了synchronized同步
public class UnsafeList {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                synchronized (list){ //添加同步机制
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }
        Thread.sleep(3000);
        System.out.println(list.size()); //少于10000，因为会有同时添加的情况发生导致只添加成功一个，另一个杯覆盖掉
    }
}
