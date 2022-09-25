package com.LiuBoTing.AlgorithmBasis.GreedyAlgorithm;


import java.util.*;

/**
 * @author liuboting
 * @date 2022/3/6 9:33
 * 给一个字符串数组
 * 求数组所有字符拼接最小值
 * ["a","a,b"] => aab
 */

public class LowestLexicography {
    public static void main(String[] args) {
        String[] strings = generateRandomArray(5);
        System.out.println(Arrays.toString(strings));
    }
    public static class MyComparator implements Comparator<String> {
        @Override
        public int compare(String t1, String t2) {
            return (t1+t2).compareTo(t2+t1);
        }
    }
    //暴力枚举所有解取最小值
    public static String lowestString1(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        TreeSet<String> set = process(strs);
        return set.first();
    }

    public static TreeSet<String> process(String[] strs){
        TreeSet<String> ans = new TreeSet<>();
        if(strs.length==0) return ans;
        for (int i = 0; i < strs.length; i++) {
            String first = strs[i];
            String[] nexts = removeIndexString(strs, i);
            TreeSet<String> next = process(nexts);
            for(String cur: next){
                ans.add(first + cur);
            }
        }
        return ans;
    }

    public static String[] removeIndexString(String[] strs,int index){
        String[] ans = new String[strs.length-1];
        int ansIndex = 0;
        for (int i = 0; i < strs.length; i++) {
            if(i != index){
                ans[ansIndex++] = strs[i];
            }
        }
        return ans;
    }

    //贪心算法
    public static String lowestString2(String[] strs){
        if(strs == null || strs.length == 0) return "";
        //根据排序规则排序
        Arrays.sort(strs,new MyComparator());
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            ans.append(strs[i]);
        }
        return ans.toString();
    }
    //对数器
    public static String[] generateRandomArray(int maxSize) {
        String[] strings = new String[maxSize];
        for (int i = 0; i < maxSize; i++) {

             int count = (int)(Math.random()*5);
             String s = "";
            for (int j = 0; j < count; j++) {
                int ranInt = (97 + (int)(Math.random()*26));
                char ranChar = (char)ranInt;
                s = s + ranChar;
            }
            strings[i] = s;
        }
        return strings;
    }
}
