package com.imooc;

public class Telphone {
    float screen;
    float cpu;
    float mum;
    public Telphone(){
        System.out.println("无参构造方法");
    }
    public Telphone(float newScreen,float newCpu,float newMem){
        if(newScreen < 3.5) {
            System.out.println("输入参数错误，自动输入3.5");
            screen = 3.5f;
        }
        else {
            screen = newScreen;
        }
        cpu = newCpu;
        mum = newMem;
        System.out.println("有参构造方法");


    }
}
