package com.LiuBoTing.AlgorithmBasis.Recursion;

/**
 * @author liuboting
 * @date 2022/3/14 21:20
 * 汉诺塔问题
 */

public class Hanoi {

    public static void main(String[] args) {
        hanoi1(3);
        System.out.println("======================");
        hanoi2(3);
    }

    public static void  hanoi1(int n){
        leftToRight(n);
    }

    public static void hanoi2(int n){
        process("left","right","mid",n);
    }

    private static void process(String from, String to, String other, int n) {
        if(n == 1){
            System.out.println("Move " + n + " from " + from + " to " + to );
            return;
        }
        process(from,other,to,n-1);
        System.out.println("Move " + n + " from " + from + " to " + to );
        process(other,to,from,n-1);
    }

    public static void leftToRight(int n){
        if(n == 1){
            System.out.println("Move " + n + " from left to right");
            return;
        }
        leftToMid(n-1);
        System.out.println("Move " + n + " from left to right");
        midToRight(n-1);
    }

    private static void midToRight(int n) {
        if(n == 1){
            System.out.println("Move " + n + " from mid to right");
            return;
        }
        midToLeft(n-1);
        System.out.println("Move " + n + " from mid to right");
        leftToRight(n-1);
    }

    private static void midToLeft(int n) {
        if(n == 1){
            System.out.println("Move " + n + " from mid to left");
            return;
        }
        midToRight(n-1);
        System.out.println("Move " + n + " from mid to left");
        rightToLeft(n-1);
    }

    private static void rightToLeft(int n) {
        if(n == 1){
            System.out.println("Move " + n + " from mid to left");
            return;
        }
        rightToMid(n-1);
        System.out.println("Move " + n + " from mid to left");
        midToLeft(n-1);
    }

    private static void rightToMid(int n) {
        if(n == 1){
            System.out.println("Move " + n + " from right to mid");
            return;
        }
        rightToLeft(n-1);
        System.out.println("Move " + n + " from right to mid");
        leftToMid(n-1);
    }

    private static void leftToMid(int n) {
        if(n == 1){
            System.out.println("Move " + n + " from left to mid");
            return;
        }
        leftToRight(n-1);
        System.out.println("Move " + n + " from left to mid");
        rightToMid(n-1);
    }
}
