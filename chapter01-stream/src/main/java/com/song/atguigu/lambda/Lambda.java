package com.song.atguigu.lambda;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;


//函数式接口
interface MyInterface{
    int sum(int i ,int j);
}

@FunctionalInterface
interface  MyHaHa{
    int haha(int y);
}
public class Lambda {


    public static void main(String[] args) {
        List<String> names = new ArrayList<>();

        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("David");

//        Collections.sort(names, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o2.compareTo(o1);
//            }
//        });

        //Collections.sort(names,(o1, o2) -> o1.compareTo(o2));
        //只能从小到大排列
        Collections.sort(names, String::compareTo);
        System.out.println(names);
    }


    @Test
    public void MyInterFacee(){

        Supplier<String> supplier = () -> UUID.randomUUID().toString().replaceAll("-","");

        System.out.println(supplier.get());
    }


    @Test
    public void aaa() {
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
