package Programmers.Level_2;
//숫자의 표현
public class PL2_12 {
    public int solution(int n) {
        int answer = 0;

        for(int i = 1; i <= n; i++) {
            int sum = 0;
            for(int j = i; j<=n; j++) {
                sum += j;
                if(sum == n) {
                    answer++;
                    break;
                } else if(sum > n) {
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        PL2_12 p = new PL2_12();
        int n = 15;
        System.out.println(p.solution(n));
    }

}

//public int expressions(int num) {
//        int answer = 0;
//        for (int i = 1; i <= num; i += 2) {
//            if (num % i == 0) {
//                answer++;
//            }
//        }
//        return answer;
//    }

