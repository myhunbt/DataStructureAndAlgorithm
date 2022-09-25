package com.LiuBoTing.data_structure.thread;

/**
 * @author liuboting
 * @date 2020/10/3 15:44
 */
//死锁：多个线程互相抱着对方需要的资源，然后形成僵持
public class TestDeadLock {
    public static void main(String[] args) {
        MakeUp girl1 = new MakeUp(0, "girl1");
        MakeUp girl2 = new MakeUp(1, "girl2");

        girl1.start();
        girl2.start();
    }
}

class LipStick{}

class Mirror{}

class MakeUp extends Thread{
    //需要的资源只有一份，static保证只有一份
    static LipStick lipStick = new LipStick();
    static Mirror mirror = new Mirror();

    int choice; //选择
    String name;//名字
    public MakeUp(int choice,String name) {
        this.choice = choice;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            makeUp();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //死锁的情况
    public void makeUp() throws InterruptedException {
        if(choice == 0){
            synchronized (lipStick){
                System.out.println(name + "正在使用口红");
                Thread.sleep(1000);
                synchronized (mirror){ //既要口红也要镜子，口红用完了也不打算交出去
                    System.out.println(name + "正在使用镜子");
                }
            }
        }else if(choice == 1){
            synchronized (mirror){
                System.out.println(name + "正在使用镜子");
                Thread.sleep(1000);
                synchronized (lipStick){
                    System.out.println(name + "正在使用口红");
                }
            }
        }

    }

//    解决方法
//    public void makeUp() throws InterruptedException {
//        if(choice == 0){
//            synchronized (lipStick){
//                System.out.println(name + "正在使用口红");
//                Thread.sleep(1000);
//            }
//            synchronized (mirror){ //既要口红也要镜子，口红用完了也不打算交出去
//                System.out.println(name + "正在使用镜子");
//            }
//        }else if(choice == 1){
//            synchronized (mirror){
//                System.out.println(name + "正在使用镜子");
//                Thread.sleep(1000);
//            }
//            synchronized (lipStick){
//                System.out.println(name + "正在使用口红");
//            }
//        }
//
//    }
}
