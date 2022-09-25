package com.LiuBoTing.AlgorithmBasis.MonotonousStack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author liuboting
 * @date 2022/9/19 19:32
 * 84. 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。

 * 示例 1:
 * 输入：heights = [2,1,5,6,2,3]
 * 输出：10
 * 解释：最大的矩形为图中红色区域，面积为 10
 * 示例 2：
 * 输入： heights = [2,4]
 * 输出： 4
 * 提示：
 *
 * 1 <= heights.length <=105
 * 0 <= heights[i] <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/largest-rectangle-in-histogram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class LargestRectangleArea {
    public static void main(String[] args) {
        int[] height = new int[]{2, 4};
        System.out.println(largestRectangleArea(height));
    }

    public static int largestRectangleArea(int[] heights) {
        int[] height = new int[heights.length + 1];
        for (int i = 0; i < heights.length; i++) {
            height[i] = heights[i];
        }
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int index = 0;
        while (index < height.length) {
            while (!stack.isEmpty() && height[stack.peek()] > height[index]) {
                int cur = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                int possibleMax = (index - left - 1) * height[cur];
                max = Math.max(max, possibleMax);
            }
            stack.push(index);
            index++;
        }
        return max;
    }

    public static int largestRectangleArea2(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }

        if (len == 1) {
            return heights[0];
        }

        int res = 0;

        int[] newHeights = new int[len + 2];
        newHeights[0] = 0;
        System.arraycopy(heights, 0, newHeights, 1, len);
        newHeights[len + 1] = 0;
        len += 2;
        heights = newHeights;

        Deque<Integer> stack = new ArrayDeque<>(len);
        // 先放入哨兵，在循环里就不用做非空判断
        stack.addLast(0);

        for (int i = 1; i < len; i++) {
            while (heights[i] < heights[stack.peekLast()]) {
                int curHeight = heights[stack.pollLast()];
                int curWidth = i - stack.peekLast() - 1;
                res = Math.max(res, curHeight * curWidth);
            }
            stack.addLast(i);
        }
        return res;
    }
}

