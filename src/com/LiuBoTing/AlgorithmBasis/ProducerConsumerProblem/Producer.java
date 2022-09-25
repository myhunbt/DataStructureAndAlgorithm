package com.LiuBoTing.AlgorithmBasis.ProducerConsumerProblem;

import sun.plugin.com.Utils;

/**
 * @author liuboting
 * @date 2021/9/20 17:49
 */

public class Producer implements Runnable{
    Goods goods;


    public Producer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        try {
            goods.putGoods();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
