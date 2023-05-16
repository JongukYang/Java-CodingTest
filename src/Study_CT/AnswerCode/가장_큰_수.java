package Study_CT.AnswerCode;

import java.io.*;
import java.util.*;
public class 가장_큰_수 {
    /**
     * Collections.sort 정렬에 대해 알아보자
     *
     * Integer.compare(int x, int y)
     * 함수(메소드)는 아래와 같은 리턴 값을 줍니다.
     *
     * x > y : 1 (x 가 y 보다 크면 1 리턴)
     * x == y : 0 (x 와 y 가 같으면 0 리턴)
     * x < y : -1 (x 가 y 보다 작으면 -1 리턴)
     *
     * 따라서 파라미터의 순서가 a, b -> b, a 로 바뀌면
     * 리턴 값이 반대로 나올 수 있습니다.
     *
     * Comparator 는
     * 해당 리턴 값으로 대소 비교를 해서 정렬을 합니다.
     *
     * 리턴 값에 따라,
     * 0 = o1 과 o2 는 같은 값으로 취급
     * 1 = o2 가 o1 보다 앞에 와야함
     * -1 = o1 이 o2 보다 앞에 와야함
     *
     * 그래서 이렇게 o1 과 o2 를 반대로
     * Integer.compare(int x, int y) 함수에 넘기시면 내림차순 정렬이 됩니다.
     */
    public String solution(int[] numbers) throws IOException {
        String answer = "";
        ArrayList<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int n :numbers){
            list.add(Integer.toString(n));
        }

        System.out.println("Origin list = " + list);

        Collections.sort(list,(o1,o2)->{
            int a = Integer.parseInt(o1); // 6
            int b = Integer.parseInt(o2); // 10
             return Integer.compare(a,b); // 오름차순 6 10 -> return -1
//            return Integer.compare(b,a); // 내림차순 10 6 -> return 1
            // compare를 a, b 형식의 순서로 하지 않고 b, a로 함
            // b(10)이 a(6)보다 크기 때문에 1이 리턴되고 1은 b가 더 크다는 뜻
            // 원본 list에서 뒤에 있는 숫자를 앞의 숫자와 자리를 바꿈

        });

//        오름차순 :[2, 6, 10]
//        내림차순 :[10, 6, 2]
        System.out.println("Compare list = " + list);

        for(String s:list){
            sb.append(s);
        }
//        Collections.sort(list,(o1,o2)->{
//            int a = Integer.parseInt(o1+o2);
//            int b = Integer.parseInt(o2+o1);
//            return Integer.compare(b,a);
//        });
//
//        for(String s:list){
//            sb.append(s);
//        }

        if(sb.charAt(0)=='0') return "0";

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        가장_큰_수 p2 = new 가장_큰_수();
        int[] numbers = {10,6,2};
//        int[] numbers = {6,10,2};
//        int[] numbers = {3, 30, 34, 5, 9};
        System.out.println(p2.solution(numbers)); //9 5 34 3 30
    }
}
