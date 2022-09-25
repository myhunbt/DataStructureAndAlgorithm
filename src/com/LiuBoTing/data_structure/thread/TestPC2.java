package com.LiuBoTing.data_structure.thread;

/**
 * @author liuboting
 * @date 2020/10/4 16:14
 */
//测试生产者消费者问题2：信号灯法，标志位解决
public class TestPC2 {
    public static void main(String[] args) {
        Tv tv = new Tv();
        new Player(tv).start();
        new Watcher(tv).start();
    }
}

//演员
class Player extends Thread{
    Tv tv;
    public Player(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if(i%2 == 0){
                this.tv.play("快乐大本营");
            }else {
                this.tv.play("抖音");
            }
        }
    }
}

//观众
class Watcher extends Thread{
    Tv tv;
    public Watcher(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            this.tv.watch();
        }
    }
}

//节目
class Tv{
    //演员表演，观众等待 T
    //观众观看，演员等待 F

    //节目
    String program;

    //标志位
    boolean flag = true;

    public synchronized void play(String program){
        //观众观看
        if(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.program = program;
        System.out.println("演员表演了" + this.program);
        flag = !flag;
        this.notifyAll();
    }

    public synchronized void watch(){
        //演员表演
        if(flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        flag = !flag;
        System.out.println("观众观看了" + this.program);
        this.notifyAll();
    }
}
