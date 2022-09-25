package com.LiuBoTing.data_structure.io;

import org.junit.Test;

import java.io.*;

/**
 * @author liuboting
 * @date 2020/9/12 16:45
 * 数据流向：输入流，输出流
 * 分类：字节流(二进制)，字符流(char)
 * 流的角色：节点流，处理流（缓存流）
 * inputStream outStream
 * reader write
 */

public class io {
    public static void main(String[] args){
        FileWriter writer = null;
        FileReader reader = null;
        try{
            File file = new File("src/com/neusoft/data_structure/io/hello.txt");
//            writer = new FileWriter(file);
//            String str = "lbtNB!!!";
//            for (int i = 0; i < str.length(); i++) {
//                writer.write(str.charAt(i));
//            }

            reader = new FileReader(file);
//            int data = reader.read();
//            while (data != -1){
//                System.out.print((char)data);
//                data = reader.read();
//            }
            char[] cbuf = new char[5];
            int len;
            while ((len = reader.read(cbuf)) != -1){
//                for (int i = 0; i < len; i++) {
//                    System.out.print(cbuf[i]);
//                }

                String s = new String(cbuf, 0, len);
                System.out.println(s);
            }

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                reader.close();
//                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


    @Test
    public void testFileWriter(){
        FileWriter writer = null;

         /*
         输出操作，对应的File可以不存在
         如果不存在，在输出的过程中，会自动创建此文件
         如果存在，默认会覆盖原文件  writer = new FileWriter(file)/ writer = new FileWriter(file,false);
         如果不想覆盖，想在原文件后添加  writer = new FileWriter(file,true);
         */
        try{
            //提供File类对象，指明写出到的文件
            File file = new File("src/com/neusoft/data_structure/io/hello1.txt");

            //提供FileWriter的对象，用于数据的写出
            writer = new FileWriter(file,true);

            //写出操作
            writer.write("I have a dream !\n");
            writer.write("You need to have a dream !");


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    @Test
    public void testFileReaderFileWriter(){
        FileWriter writer = null;
        FileReader reader = null;
         /*
            文件读进来的同时写在另一个文件里
         */
        try{
            //提供File类对象，指明写出到的文件
            File file1 = new File("src/com/neusoft/data_structure/io/hello.txt");
            File file2 = new File("src/com/neusoft/data_structure/io/hello1.txt");

            //提供FileWriter和FileReader的对象，用于数据的写入写出
            reader = new FileReader(file1);
            writer = new FileWriter(file2,true);

            //写入写出操作
           char[] cbuf = new char[5];
           int len; // 每次读到的字符个数
           while ((len = reader.read(cbuf)) != -1){
               //每次写出len个字符
               writer.write(cbuf,0,len);
           }


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
