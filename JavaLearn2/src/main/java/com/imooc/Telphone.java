package com.imooc;

public class Telphone {
    float screen;
    float cpu;
    float mum;
    public Telphone(){
        System.out.println("�޲ι��췽��");
    }
    public Telphone(float newScreen,float newCpu,float newMem){
        if(newScreen < 3.5) {
            System.out.println("������������Զ�����3.5");
            screen = 3.5f;
        }
        else {
            screen = newScreen;
        }
        cpu = newCpu;
        mum = newMem;
        System.out.println("�вι��췽��");


    }
}
