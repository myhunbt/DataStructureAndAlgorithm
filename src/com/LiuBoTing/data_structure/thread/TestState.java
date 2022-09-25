package com.LiuBoTing.data_structure.thread;

/**
 * @author liuboting
 * @date 2020/9/25 20:37
 */
//观测线程状态
public class TestState {
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("线程终止");
        });

        //观察状态
        Thread.State state = thread.getState();
        System.out.println(state);

        //观察启动状态
        thread.start();
        state = thread.getState();
        System.out.println(state);


        while (state != Thread.State.TERMINATED){//判断线程终止
            Thread.sleep(200);
            state = thread.getState(); //更新线程状态
            System.out.println(state);
        }

    }

}
