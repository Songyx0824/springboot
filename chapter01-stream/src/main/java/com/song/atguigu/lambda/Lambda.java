package com.song.atguigu.lambda;


//函数式接口

interface MyInterface{
    int sum(int i ,int j);
}

interface  MyHaHa{
    int haha(int y);
}
public class Lambda {

    public static void main(String[] args) {
        //1. 自己创建实现类对象

        //2。 匿名实现类
        MyInterface myInterface1 = new MyInterface() {
            @Override
            public int sum(int i, int j) {
                return i*i + j*j;
            }
        };

        System.out.println( myInterface1.sum(2,5));
        //冗余型

        //3. lambda 表达式
        MyInterface myInterface2 = (int i , int j) ->{
            return i*i + j*j;
        };
        System.out.println("myInterface2: "+ myInterface2.sum(3,4));
        //完整写法如上
        //简化写法
        //1) 参数类型可以不写，只写参数名
        //  参数表最少可以只有一个() 或者 只有一个 参数
        //2) 方法体只有一句话 ，{} 可以省略

        MyHaHa myHaHa = y -> y*y;

        System.out.println("myInterface3: "+ myHaHa.haha(6));

        MyInterface myInterface4 = (i,j) -> i*i + j*j;
    }
}
