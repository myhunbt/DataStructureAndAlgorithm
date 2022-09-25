package com.LiuBoTing.AlgorithmBasis.BacktrackingAlgorithm;

import javax.net.ssl.SSLContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * @author liuboting
 * @date 2022/9/4 8:50
 *
 * class Solution {
 *     List<List<String>> lists = new ArrayList<>();
 *     Deque<String> deque = new LinkedList<>();
 *
 *     public List<List<String>> partition(String s) {
 *         backTracking(s, 0);
 *         return lists;
 *     }
 *
 *     private void backTracking(String s, int startIndex) {
 *         //如果起始位置大于s的大小，说明找到了一组分割方案
 *         if (startIndex >= s.length()) {
 *             lists.add(new ArrayList(deque));
 *             return;
 *         }
 *         for (int i = startIndex; i < s.length(); i++) {
 *             //如果是回文子串，则记录
 *             if (isPalindrome(s, startIndex, i)) {
 *                 String str = s.substring(startIndex, i + 1);
 *                 deque.addLast(str);
 *             } else {
 *                 continue;
 *             }
 *             //起始位置后移，保证不重复
 *             backTracking(s, i + 1);
 *             deque.removeLast();
 *         }
 *     }
 *     //判断是否是回文串
 *     private boolean isPalindrome(String s, int startIndex, int end) {
 *         for (int i = startIndex, j = end; i < j; i++, j--) {
 *             if (s.charAt(i) != s.charAt(j)) {
 *                 return false;
 *             }
 *         }
 *         return true;
 *     }
 * }
 *
 * 作者：carlsun-2
 * 链接：https://leetcode.cn/problems/palindrome-partitioning/solution/131-fen-ge-hui-wen-chuan-hui-su-sou-suo-yp2jq/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

public class SplitString {
    List<List<String>> ans = new ArrayList<>();
    public static void main(String[] args) {
        SplitString splitString = new SplitString();
        List<List<String>> list = splitString.partition("aab");
        for (List<String> l: list) {
            ListIterator<String> iterator = l.listIterator();
            while (iterator.hasNext()){
                System.out.print(iterator.next() + ',');
            }
            System.out.println();
        }
    }
    public  List<List<String>> partition(String s) {
        List<String> cur = new ArrayList<>();
        backTracking(s,0,cur);
        return ans;
    }

    public void backTracking(String s, int index,List<String> cur){
        //越界则找到一组答案
        if(index >= s.length()){
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if(isPalindromeString(s,index,i)){
                cur.add(s.substring(index,i+1));
            }else {
                continue;
            }
            backTracking(s,i+1,cur);
            cur.remove(cur.size()-1);
        }


    }

    private boolean isPalindromeString(String s, int start, int end) {
        //abcddcba
        for (int i = start,j = end; i < j; i++,j--) {
            if(s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }
}
