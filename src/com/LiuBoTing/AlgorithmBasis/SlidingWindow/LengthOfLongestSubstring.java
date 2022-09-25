package com.LiuBoTing.AlgorithmBasis.SlidingWindow;

import java.util.HashMap;

/**
 * @author liuboting
 * @date 2022/9/3 21:40
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。

 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class LengthOfLongestSubstring {
    public static void main(String[] args) {

    }
    public static int lengthOfLongestSubstring(String s){
        char[] c = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;
        int[] dp = new int[c.length];
        for (int w = 0; w < c.length; w++) {
            if(map.containsKey(c[w]) && map.get(c[w]) >= left){
                left =  map.get(c[w])+1;
            }
            map.put(c[w],w);
            max = Math.max(max,max-left+1);
        }
        return max;
    }
}
