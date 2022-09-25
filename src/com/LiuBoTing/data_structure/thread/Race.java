package com.LiuBoTing.data_structure.thread;

/**
 * @author liuboting
 * @date 2020/9/24 9:40
 */

public class Race implements Runnable {
    private String winner;

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if(Thread.currentThread().getName().equals("兔子") && i%20 == 0){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (gameOver(i)) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "跑了" + i + "步");


        }

    }

    private boolean gameOver(int s) {
        if (winner != null) {
            return true;
        } else if (s >= 100) {
            winner = Thread.currentThread().getName();
            System.out.println("winner是" + winner);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();

        new Thread(race, "乌龟").start();
        new Thread(race, "兔子").start();
    }
}
