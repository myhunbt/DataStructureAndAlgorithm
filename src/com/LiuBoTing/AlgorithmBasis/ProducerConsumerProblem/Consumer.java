package com.LiuBoTing.AlgorithmBasis.ProducerConsumerProblem;

/**
 * @author liuboting
 * @date 2021/9/20 17:49
 */

public class Consumer implements Runnable{
    Goods goods;

    public Consumer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        try {
            goods.takeGoods();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
