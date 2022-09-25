package com.LiuBoTing.AlgorithmBasis.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuboting
 * @date 2022/3/15 12:16
 * 打印字符串全部子序列
 * “abc” -> “a”,"b","c","ab","ac","bc","abc"
 *
 */

public class PrintAllSubsquences {
    public static void main(String[] args) {
        String str = "abc";
        List<String> ans = subs(str);
        for (String s :
                ans) {
            System.out.println(s);
        }
    }

    // 打印字符串全部子序列(“abc” -> “a”,"b","c","ab","ac","bc","abc")
    private static List<String> subs(String s) {
        List<String> ans = new ArrayList<>();
        char[] str = s.toCharArray();
        String path = "";
        process1(str,0,ans,path);

        return ans;
    }

    private static void process1(char[] str, int index, List<String> ans, String path) {
        if(index == str.length){
            ans.add(path);
            return;
        }
        // 不加当前位置
        process1(str,index+1,ans,path);

        //加当前位置
        process1(str,index+1,ans,path + str[index]);
    }


   // 打印字符串全排序["a","b","c"]
    public static List<String> permutation(String s){
        ArrayList<String> ans = new ArrayList<>();
        char[] str = s.toCharArray();
        ArrayList<Character> rest = new ArrayList<>();
        for (char c:
             str) {
            rest.add(c);
        }
        process2(rest,"",ans);
        return ans;
    }

    private static void process2(ArrayList<Character> rest, String path, ArrayList<String> ans) {
        if(rest.size() == 0){
            ans.add(path);
            return;
        }
        for (int i = 0; i < rest.size(); i++) {
            char cur = rest.remove(i);
            process2(rest,path+cur,ans);
            rest.add(i,cur);
        }
    }

    public static List<String> permutation2(String s){
        ArrayList<String> ans = new ArrayList<>();
        char[] str = s.toCharArray();
        process3(str,0,ans);
        return ans;
    }

    private static void process3(char[] str, int index, ArrayList<String> ans) {
        if(index == str.length){
            ans.add(String.valueOf(str));
            return;
        }
        for (int i = index; i < str.length; i++) {
            swap(str,index,i);
            process3(str,index +1,ans);
            swap(str,index,i);
        }
    }

    private static void swap(char[] str, int index, int i) {
        char temp = str[i];
        str[i] = str[index];
        str[i] = temp;
    }

}
