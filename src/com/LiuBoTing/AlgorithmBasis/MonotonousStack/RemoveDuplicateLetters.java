package com.LiuBoTing.AlgorithmBasis.MonotonousStack;

import java.util.ArrayDeque;
import java.util.HashMap;

/**
 * @author liuboting
 * @date 2022/9/21 20:10
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * 示例 1：
 * 输入：s = "bcabc"
 * 输出："abc"
 *
 * 示例 2：
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 * 提示：
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/remove-duplicate-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        String s = "cbacdcbc";
        System.out.println(removeDuplicateLetters(s));
    }
    public static String removeDuplicateLetters(String s) {
        char[] charArray = s.toCharArray();
        int[] set = new int[26];
        for (char c:charArray) {
            set[c-'a']++;
        }

        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char c:charArray) {
            if(stack.contains(c)){
                set[c-'a']--;
                continue;
            }
            while (!stack.isEmpty() && stack.peek()>c && set[stack.peek()-'a'] > 0){
                stack.pop();
            }
            stack.push(c);
            set[c-'a']--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
