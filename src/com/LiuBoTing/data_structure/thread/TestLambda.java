package com.LiuBoTing.data_structure.thread;

/**
 * @author liuboting
 * @date 2020/9/24 11:01
 */

public class TestLambda {

    //静态内部类
    static class Like2 implements ILike{
        @Override
        public void lambda() {
            System.out.println("i like lambda2");
        }
    }
    public static void main(String[] args) {
        ILike like = new Like1();
        like.lambda();
        like = new Like2();
        like.lambda();
        //局部内部类
        class Like3 implements ILike{
            @Override
            public void lambda() {
                System.out.println("i like lambda3");
            }
        }
        like = new Like3();
        like.lambda();

        //匿名内部类
        like = new ILike(){
            @Override
            public void lambda() {
                System.out.println("i like lambda4");
            }
        };
        like.lambda();

        // lambda表达式
        like = ()->{
            System.out.println("i like lambda5");
        };
        like.lambda();
    }
}

// 接口，只含一个抽象方法的接口叫函数式接口
interface ILike{
    void lambda();
}

// 实现类
class Like1 implements ILike{
    @Override
    public void lambda() {
        System.out.println("i like lambda1");
    }
}