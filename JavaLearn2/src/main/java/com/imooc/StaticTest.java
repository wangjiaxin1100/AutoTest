package com.imooc;

public class StaticTest {

        // ���徲̬����score1
        static int score1 = 86;
        // ���徲̬����score2
        int score2 = 92;

        // ���徲̬����sum������ɼ��ܷ֣��������ܷ�
        public  static   int sum() {
            StaticTest hello =  new  StaticTest();

            int allScore = StaticTest.score1 + hello.score2;

        }

        public static void main(String[] args) {

            // ���þ�̬����sum�����շ���ֵ
            int allScore = StaticTest.sum();

            System.out.println("�ܷ֣�" + allScore);
        }
    }
