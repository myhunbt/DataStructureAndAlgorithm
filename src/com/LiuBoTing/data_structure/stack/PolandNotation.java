package com.LiuBoTing.data_structure.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuboting
 * @date 2020/10/12 15:50
 * 逆波兰表达式
 */

public class PolandNotation {
    public static void main(String[] args) {
        // 中缀表达式转后缀表达式
        // 1. 1+((2+3)*4)-5 => 1 2 3 + 4 * + 5 -
        // 2. 因为直接对str进行操作不方便，因此先将“1+((2+3)*4)-5” => 中缀的表达式的list  [1+, (, (, 2+, 3), *, 4), -, 5]
        // 3. 将得到的中缀表达式对应的list [1+, (, (, 2+, 3), *, 4), -, 5]vgv => 后缀表达式对应的list  [1,2,3,+,4,*,+,5,-]

        String expression = "1+((2+3)*4)-5";
        List<String> infixExpressionList = toInfixExpressionList(expression);
        System.out.println(infixExpressionList);
    }

    // 字符串格式的中缀表达式转列表的
    public static List<String> toInfixExpressionList(String infixExpression){
        List<String> infixExpressionList = new ArrayList<>();
        int index = 0;
        String str;
        char c;
        while (index < infixExpression.length()){
            c = infixExpression.charAt(index);
            //非数字
            if(c > '9' || c < '0'){
                infixExpressionList.add(c + "");
                index++;
            }else { // 数字
                str = "";
                while (index < infixExpression.length() && c <= '9' && c >= '0'){
                    c = infixExpression.charAt(index);
                      str += c + "";
                      index ++;
                }
                infixExpressionList.add(str);
            }
        }

        return  infixExpressionList;
    }
}
