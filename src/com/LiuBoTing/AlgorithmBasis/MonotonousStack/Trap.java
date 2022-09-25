package com.LiuBoTing.AlgorithmBasis.MonotonousStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author liuboting
 * @date 2022/9/3 8:36
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 *
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *
 *  4 3 3 3 2 5
 * 1 + 3 + 2 + 1 + 1 + 1
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Trap {
    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
        System.out.println(ms(height));
        ArrayList<Object> list = new ArrayList<>();
    }
    public static int trap(int[] height){
        int res = 0;
        for (int i = 1; i < height.length-1; i++) {
            int leftHeight = findLeftHeight(height, i);
            int rightHeight = findRightHeight(height, i);
            if(leftHeight>height[i] && rightHeight>height[i]){
                res+=leftHeight>rightHeight? (rightHeight-height[i]) : (leftHeight-height[i]);
            }
        }
        return res;
    }
    //单调栈解法
        public static int ms(int[] height){
        Stack<Integer> s = new Stack<>();
        int index = 0;
        int res = 0;
        while (index <= height.length-1){
            while (!s.isEmpty() && height[s.peek()]<height[index]){
                Integer cur = s.pop();
                if(s.isEmpty()) break;
                int left = s.peek();
                res+=(index-left-1) * (Math.min(height[index],height[left])-height[cur]);
            }
            s.push(index);
            index++;
        }
        return res;
    }
    //找到当前位置的左边最高值
    public static int findLeftHeight(int[] height,int index){
        int maxLeft = 0;
        int i = index-1;
        while (i>=0){
            maxLeft = Math.max(maxLeft, height[i]);
            i--;
        }
        return maxLeft;
    }
    //找到当前位置的右边最高值
    public static int findRightHeight(int[] height,int index){
        int maxRight = 0;
        int i = index+1;
        while (i<height.length){
            maxRight = Math.max(maxRight, height[i]);
            i++;
        }
        return maxRight;
    }

}
