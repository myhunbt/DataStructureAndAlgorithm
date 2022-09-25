package com.LiuBoTing.AlgorithmBasis.GreedyAlgorithm;
import java.util.*;
/**
 * @author liuboting
 * @date 2022/3/6 18:53
 * 给定一组会议的开始时间以及结束时间，求一天最多可以安排会议的数量
 * [[1,3],[2,4],[3,6]]
 */

public class BestArrange {
    public static void main(String[] args) {

    }
    public static class Program{
        int start;
        int end;
        public Program(int start,int end){
            this.start = start;
            this.end = end;
        }
    }
    public static class MyComparator implements Comparator<Program>{

        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }
    }

    public static int bestArrange2(Program[] programs){
        Arrays.sort(programs,new MyComparator());

        return 0;
    }

    public static Program[] removeProgramIndex(Program[] programs,int index){
        Program[] program = new Program[programs.length-1];
        int ansIndex = 0;
        for (int i = 0; i < programs.length; i++) {
            if(i != index){
                program[ansIndex++] = programs[i];
            }
        }
        return program;
    }
}
