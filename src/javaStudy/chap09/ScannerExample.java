package javaStudy.chap09;

import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a;
        double b;
        String s;
        long l;
        a = sc.nextInt();                           // int 변수 1개 입력받는 예제
        b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
        s = sc.next();                            // 문자열 1개 입력받는 예제
        l = sc.nextLong();                         // long 변수 1개 입력받는 예제

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("s = " + s);
        System.out.println("l = " + l);
    }
}
