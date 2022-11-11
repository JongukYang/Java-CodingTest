import java.util.ArrayList;

public class Pro_CT_34 {
//    자연수 n이 매개변수로 주어집니다. n을 3진법 상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.
    public int solution(int n) {
//        int answer = 0;
//        String a = Integer.toString(n,3);
//        StringBuffer sbf = new StringBuffer(a);
//        sbf.reverse();
////        3진법을 10진법으로 표현
//        answer = Integer.parseInt(sbf.toString(),3);
//        System.out.println(answer);
//        return answer;
//
        int answer = 0;
        String a = Integer.toString(n,3);
        StringBuffer sbf = new StringBuffer(a).reverse();
        answer = Integer.parseInt(sbf.toString(),3);
        return answer;

    }

    public static void main(String[] args) {
        Pro_CT_34 sol = new Pro_CT_34();
        int n = 45;
        System.out.println(sol.solution(n));
    }

}

//########################################
class Solution {
    public int solution(int n) {
        int answer = 0;

        String str = "";

        while(n>0)
        {
            int r = n%3;
            n = n / 3;
            str = r + str;
        }
        System.out.println(str);

        for(int i=0; i<str.length(); i++)
        {
            answer += Math.pow(3,i) * (str.charAt(i) - '0');
        }

        return answer;
    }
}