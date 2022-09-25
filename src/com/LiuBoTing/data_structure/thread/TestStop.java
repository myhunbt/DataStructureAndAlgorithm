package com.LiuBoTing.data_structure.thread;

/**
 * @author liuboting
 * @date 2020/9/24 20:37
 */

public class TestStop implements Runnable {
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag){
            System.out.println("TestStop跑了" + i++ + "次");
        }
    }

    public void stop(){
        this.flag = false;
    }


    public static void main(String[] args) {
        TestStop td = new TestStop();
        new Thread(td).start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("main" + i);
            if(i == 888){
                td.stop();
                System.out.println("线程停止");
            }
        }
    }
}
