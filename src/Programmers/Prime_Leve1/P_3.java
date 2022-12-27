package Programmers.Prime_Leve1;
//하샤드 수
//        문제 설명
//        양의 정수 x가 하샤드 수이려면 x의 자릿수의 합으로 x가 나누어져야 합니다.
//        예를 들어 18의 자릿수 합은 1+8=9이고, 18은 9로 나누어 떨어지므로 18은 하샤드 수입니다.
//        자연수 x를 입력받아 x가 하샤드 수인지 아닌지 검사하는 함수, solution을 완성해주세요.
//

public class P_3 {
    public boolean solution(int x) {
        boolean answer = true;
        // 풀이 1
//        int num = x;
//        int sum = 0;
//        while (true) {
//            if(x < 10) {
//                sum += x;
//                break;
//            }
//            sum += x%10;
//            x = x/10;
//        }
//        if (num%sum ==0) {
//            answer = true;
//        }

        // 풀이 2
        String s = Integer.toString(x);
        int sum = 0;
        for(int i = 0; i<s.length(); i++) {
            sum += Integer.valueOf(s.substring(i, i+1));
        }
        if(x%sum == 0) {
            answer = true;
        }

        return answer;
    }

    public static void main(String[] args) {
        P_3 sol = new P_3();
        int x = 10;
        System.out.println(sol.solution(x));
    }
}
