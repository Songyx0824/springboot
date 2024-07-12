package com.song.atguigu.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {


    @Test
    public void DemoTest1(){
        //找出最大的偶数
        List<Integer> list = List.of(1,2,3,4,5,6,7,8,9,10);

        //2. StreamAPI
        //1) 把数据封装成 流
        //2) 定义流式操作
        //3) 获取最终结果
        list.stream().filter(ele -> ele%2 == 0).
                max(Integer::compareTo).ifPresent(System.out::println);

        //流 的三大部分:  数据流; N个中间操作;  一个终止操作;
        //1. 数据流:
        //  1) 创建数据流

        Stream<Integer> integerStream = Stream.of(1, 2, 3);

    }


    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    class Person{
        private String name;
        private String gender;
        private Integer age ;
    }

    @Test
    public void DemoTest2() {
        List<Person> list = List.of(
                new Person("雷 冯扬","男",16),
                new Person("王 五","女",20),
                new Person("赵 六","男",22),
                new Person("王 琪","女",33),
                new Person("雷 二","女",18));

        list.stream()
                .filter(person -> person.age>18)
                .map(person -> person.getName())
                .peek(System.out::println)
                .flatMap(e -> {
                  String[] str = e.split(" ");
                  return Arrays.stream(str);
                })
                .forEach( e -> {

//                    try {
//                        Thread.sleep(5000);
//                    } catch (InterruptedException ex) {
//                        throw new RuntimeException(ex);
//                    }
                    System.out.println(STR."元素: \{e}");

                });
    }


    @Test
    public void CollectStreamDemo(){
        List<Integer> collect = List.of(1, 2, 3, 4, 5)
                .stream()
                .filter(i -> i > 2)
                .collect(Collectors.toList());

        System.out.println("filter: " + collect);


        List<Integer> collect1 = List.of(1, 2, 3, 4, 5)
                .stream()
                //takeWhile 当满足条件时 拿取该元素 ; 不满足条件时直接结束
                .takeWhile(i -> i > 2)
                .collect(Collectors.toList());

        System.out.println("takeWhile: " + collect1);

    }
}
