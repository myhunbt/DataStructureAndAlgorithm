package com.LiuBoTing.data_structure.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author liuboting
 * @date 2020/9/24 21:22
 */

public class TestSleep {
    public static void main(String[] args) {

        Date date = new Date();
        while (true){
            try {
                Thread.sleep(1000);
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(date));
                date = new Date();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
