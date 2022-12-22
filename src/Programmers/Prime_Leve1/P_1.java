package Programmers.Prime_Leve1;
// 자릿수 더하기
// 자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
// 예를들어 N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다.
public class P_1 {
    public int solution(int n) {
        int answer = 0;
        // 1번 방식 -> 정수를 문자열로 바꿔서 풀기
//        String s = Integer.toString(n);
//        System.out.println(s + " " + s.getClass().getName());
//        for(int i = 0; i<s.length(); i++) {
//            int num = Integer.parseInt(s.substring(i, i+1));
//            System.out.println(num);
//            answer += num;
//        }

        // 2번 방식 -> 나누기를 하여 나머지를 더하는 방식
        while (true) {
            if(n < 10) {
                answer+= n;
                break;
            }
            answer += n%10;
            n = n/10;
        }
        return answer;
    }

    public static void main(String[] args) {
        P_1 sol = new P_1();
        System.out.println(sol.solution(123));
    }
}
