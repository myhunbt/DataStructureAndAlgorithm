package com.LiuBoTing.data_structure.sparsearray;

import java.io.*;

/**
 * @author liuboting
 * @date 2020/9/12 15:22
 */

public class WuZiQi {
    public static void main(String[] args) {
        int[][] arr = new int[11][11];
        arr[1][2] = 1;
        arr[2][3] = 2;
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }
//        for(int[] a:arr){
//            for(int b:a){
//                System.out.printf("%d ",b);
//            }
//            System.out.println();
//        }

        // 计数不等于0的
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] != 0){
                    count++;
                }
            }
        }
//        System.out.println(count);

        // 转换稀疏数组
        int[][] spaceArray = new int[count + 1][3];
        spaceArray[0] = new int[]{11, 11, count};
        int c = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length ; j++) {
                if(arr[i][j] != 0){
                    c++;
                    spaceArray[c] = new int[]{i,j,arr[i][j]};
                }
            }
        }


//        // 打印稀疏数组
//        for (int i = 0; i < spaceArray.length; i++) {
//            for (int j = 0; j < spaceArray[i].length; j++) {
//                System.out.print(spaceArray[i][j] + "\t");
//            }
//            System.out.println();
//        }

        FileWriter writer = null;
        FileReader reader = null;
       try{
           File file = new File("src/com/neusoft/data_structure/sparsearray/sparseArray.txt");
           writer = new FileWriter(file);

           for (int i = 0; i < spaceArray.length; i++) {
               for (int j = 0; j < spaceArray[i].length ; j++) {
                   writer.write(spaceArray[i][j]);
               }
           }

//           int data;
//           while ((data = reader.read()) != -1){
//               System.out.println(data);
//           }
       } catch (IOException e) {
           e.printStackTrace();
       }finally {
           if(writer != null){
               try {
                   writer.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }

       }

       try{
           File file = new File("src/com/neusoft/data_structure/sparsearray/sparseArray.txt");
           reader = new FileReader(file);
           int data;
           while ((data = reader.read())!= -1){
               System.out.print(data + "\t");
           }
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }finally {
           if(reader != null){
               try {
                   reader.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
       }

        int[][] ints = new int[spaceArray[0][0]][spaceArray[0][1]];
        for (int i = 1; i < spaceArray.length; i++) {
            ints[spaceArray[i][0]][spaceArray[i][1]] = spaceArray[i][2];
        }


//        for(int[] a:ints){
//            for(int b:a){
//                System.out.printf("%d ",b);
//            }
//            System.out.println();
//        }
    }
}
