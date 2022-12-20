package Programmers.Level_1;

import java.util.Arrays;

public class Pro_CT_25 {
    public String solution(String s) {
        String answer = "";
        char arr[] = s.toCharArray();
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder(new String(arr));
        answer = sb.reverse().toString();
        return answer;
    }

    public static void main(String[] args) {
        Pro_CT_25 sol = new Pro_CT_25();
        String s = "Zbcdefg";
        System.out.println(sol.solution(s));
    }
}

//    public String reverseStr(String str){
//        String[] arry = str.split("");
//        Arrays.sort(arry,  Collections.reverseOrder());
//        StringBuffer sb = new StringBuffer();
//        for( String s : arry )
//        {
//            sb.append(s);
//        }
//        return sb.toString();
//    }