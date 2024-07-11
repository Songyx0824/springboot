package demo1;

import java.util.Scanner;

public class SystemDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入 a 的值");
        int a = scanner.nextInt();

        System.out.println("请输入 b 的值");
        int b = scanner.nextInt();

        System.out.println("输入值 a:"+a+"\t 输入值 b: "+b);
    }
}
