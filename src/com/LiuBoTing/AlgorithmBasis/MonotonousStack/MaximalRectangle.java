package com.LiuBoTing.AlgorithmBasis.MonotonousStack;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @author liuboting
 * @date 2022/9/20 20:45
 *  85. 最大矩形
 * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * 示例 1：
 * 输入：matrix = [["1","0","1","0","0"],
 *                ["1","0","1","1","1"],
 *                ["1","1","1","1","1"],
 *                ["1","0","0","1","0"]]
 * 输出：6
 * 解释：最大矩形如上图所示。
 * 示例 2：
 *
 * 输入：matrix = []
 * 输出：0
 * 示例 3：
 *
 * 输入：matrix = [["0"]]
 * 输出：0
 * 示例 4：
 *
 * 输入：matrix = [["1"]]
 * 输出：1
 * 示例 5：
 *
 * 输入：matrix = [["0","0"]]
 * 输出：0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximal-rectangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class MaximalRectangle {
    public static void main(String[] args) {
        char[][] matrix = new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        char[][] chars = {{'0'}};
        //[["1","0","1","0","0"],
        // ["1","0","1","1","1"],
        // ["1","1","1","1","1"],
        // ["1","0","0","1","0"]]
        System.out.println(new MaximalRectangle().maximalRectangle(chars));
    }
    public  int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        int[] heights = new int[matrix[0].length];
        int max = 0;
        int index = 0;
        int possibleMax;
        while (index<matrix.length){
            for (int i = 0; i < matrix[0].length;i++) {
                heights[i] = matrix[index][i] == '0' ? 0 : heights[i]+1;
//                if(matrix[index][i] == '0')  heights[i] = 0;
//                if(matrix[index][i] == '1')  heights[i] += 1;
            }
            possibleMax = largestRectangleArea(heights);
            max = Math.max(max,possibleMax);
            index++;
        }
        return max;
    }
    public int largestRectangleArea(int[] heights) {
        int[] height = new int[heights.length + 2];
        System.arraycopy(heights,0,height,1,heights.length);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int max = 0;
        int index = 1;
        stack.push(0);
        while (index < height.length){
            while (height[stack.peek()]>height[index]){
                int cur = stack.pop();
                int left = stack.peek();
                max = Math.max(max,(index-left-1)*height[cur]);
            }
            stack.push(index);
            index++;
        }
        return max;
    }

}
