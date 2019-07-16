package com.imooc;

public class StaticTest {

        // 定义静态变量score1
        static int score1 = 86;
        // 定义静态变量score2
        int score2 = 92;

        // 定义静态方法sum，计算成绩总分，并返回总分
        public  static   int sum() {
            StaticTest hello =  new  StaticTest();

            int allScore = StaticTest.score1 + hello.score2;

        }

        public static void main(String[] args) {

            // 调用静态方法sum并接收返回值
            int allScore = StaticTest.sum();

            System.out.println("总分：" + allScore);
        }
    }
