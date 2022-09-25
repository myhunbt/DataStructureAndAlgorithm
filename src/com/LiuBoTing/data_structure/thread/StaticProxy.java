package com.LiuBoTing.data_structure.thread;

/**
 * @author liuboting
 * @date 2020/9/24 20:57
 */

public class StaticProxy {
    public static void main(String[] args) {
        WeddingCompany weddingCompany = new WeddingCompany(new Me());
        weddingCompany.happyMarry();
    }
}


    interface Marry{
        void happyMarry();
    }

    class Me implements Marry{
        @Override
        public void happyMarry() {
            System.out.println("我开心地去结婚");
        }
    }

    class WeddingCompany implements Marry{
        private Marry target;
        public WeddingCompany(Marry target){
            this.target = target;
        }

        @Override
        public void happyMarry() {
            before();
            target.happyMarry();
            after();
        }

        private void before(){
            System.out.println("婚礼之前，布置现场");
        }

        private void after(){
            System.out.println("婚礼之后，支付尾款");
        }
    }


