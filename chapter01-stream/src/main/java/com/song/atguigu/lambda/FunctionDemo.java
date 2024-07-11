package com.song.atguigu.lambda;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionDemo {

    @Test
    public void FunctionDemoTest(){
        Supplier<String> supplier = () -> "41";

        //断言 Predicate 验证是否是一个数字
        Predicate<String> isNumber = str -> str.matches("-?\\d+(\\.\\d+)?");

        //Function<String , Integer> change = str -> Integer.parseInt(str);
        Function<String , Integer> change = Integer::parseInt;


        Consumer<Integer> consumer = integer -> {
            if(integer%2 == 0) {
                System.out.println("偶数: " + integer);
            }else {
                System.out.println("基数: " + integer);
            }
        };

        if(isNumber.test(supplier.get())){
            consumer.accept(change.apply(supplier.get()));
        }else {
            System.out.println("非法的数字");
        }

    }


    @Test
    public void FunctionDemoTest2(){
        Supplier<String> supplier = () -> "41";

        //断言 Predicate 验证是否是一个数字
        Predicate<String> isNumber = str -> str.matches("-?\\d+(\\.\\d+)?");

        //Function<String , Integer> change = str -> Integer.parseInt(str);
        Function<String , Integer> change = Integer::parseInt;


        Consumer<Integer> consumer = integer -> {
            if(integer%2 == 0) {
                System.out.println("偶数: " + integer);
            }else {
                System.out.println("基数: " + integer);
            }
        };

        mymethod(str -> str.matches("-?\\d+(\\.\\d+)?"),
                ()->"777",
                System.out::println,
                Integer::parseInt
                );

    }

    private static void mymethod(Predicate<String> isNumber, Supplier<String> supplier, Consumer<Integer> consumer, Function<String, Integer> change) {
        if(isNumber.test(supplier.get())){
            consumer.accept(change.apply(supplier.get()));
        }else {
            System.out.println("非法的数字");
        }
    }

}
