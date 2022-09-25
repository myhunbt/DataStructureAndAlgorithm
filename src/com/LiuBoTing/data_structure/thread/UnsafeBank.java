package com.LiuBoTing.data_structure.thread;

/**
 * @author liuboting
 * @date 2020/10/1 20:14
 */

public class UnsafeBank {
    public static void main(String[] args) {
        Account account = new Account(1000, "结婚基金");
        Bank XM = new Bank(account, 600, "小明");
        Bank XH = new Bank(account, 800, "小红");

        XM.start();
        XH.start();

    }
}
//账户
class Account{

     int money;
     String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

class Bank extends Thread{
    private Account account;

    private int drawingMoney;


    public Bank(Account account,int drawingMoney,String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {
        synchronized (account){ //同步块，修改操作的是account这个对象
            drawingMoney();
            System.out.println("余额" + account.money);
        }
    }

    public void drawingMoney(){
        //余额不足
        if(drawingMoney > account.money){
            System.out.println(this.getName() + "余额不足");
            return;
        }
        //模拟延迟
        try {
            Thread.sleep(1000);
            account.money -= drawingMoney;
            System.out.println(this.getName() + "取了" + drawingMoney + "万");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
