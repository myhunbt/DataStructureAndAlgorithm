package com.LiuBoTing.data_structure.recursive;

import java.util.Arrays;

/**
 * @author liuboting
 * @date 2020/9/11 19:57
 * [1, 1, 1, 1, 1, 1, 1, 1]
 * [1, 0, 0, 0, 0, 0, 0, 1]
 * [1, 0, 0, 0, 0, 0, 0, 1]
 * [1, 1, 1, 0, 0, 0, 0, 1]
 * [1, 0, 0, 0, 0, 0, 0, 1]
 * [1, 0, 0, 0, 0, 0, 0, 1]
 * [1, 1, 1, 1, 1, 1, 1, 1]
 * 小球从左上角能否走到左下角 (1为墙，0可以走)
 */

public class XiaoQiuZouMiGong {
    public static void main(String[] args) {
        int[][] map = new int[7][8];
        for (int i = 0; i < 8; i++) {
            map[0][i] = 1;
            map[6][i] = 1;
        }
        for (int i = 0; i < 7; i++) {
            map[i][0] = 1;
            map[i][7] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;

        setWay(map, 1, 1);

        for (int i = 0; i < map.length; i++) {
            System.out.println(Arrays.toString(map[i]));
        }

    }
    public static boolean setWay(int[][] map,int i,int j){
        if(map[5][6] == 2){
            return true;
        }else if (map[i][j] == 0) { // 如果这个点还没有走过
                map[i][j] = 2; //假定可以走通
            //按照策略 上 右 下 左
                if (setWay(map, i + 1, j)) {
                    return true;
                } else if (setWay(map, i, j + 1)) {
                    return true;
                } else if (setWay(map, i - 1, j)) {
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    return true;
                } else {
                    //上下左右都走不通
                    map[i][j] = 3;
                    return false;
                }
        }else {
            // map[i][j] != 0 // 1,2,3
            return false;
        }
    }

}
