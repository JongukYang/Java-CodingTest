import java.util.Arrays;

public class Pro_CT_46 {
    //    소수 찾기
    public int solution(int n) {
        int answer = 0;
        boolean[] primeN = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            primeN[i] = true;
        }
        int sqrtN = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrtN; i++) {
            if (primeN[i] == true) {
                for (int j = i; i * j <= n; j++) {
                    primeN[i * j] = false;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (primeN[i] == true) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Pro_CT_46 sol = new Pro_CT_46();
        int n = 10;
        System.out.println(sol.solution(n));
    }
}

//
//    문제 설명
//1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.
//
//        소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다.
//        (1은 소수가 아닙니다.)
//
//        제한 조건
//        n은 2이상 1000000이하의 자연수입니다.
//        입출력 예
//        n	result
//        10	4
//        5	3
//        입출력 예 설명
//        입출력 예 #1
//        1부터 10 사이의 소수는 [2,3,5,7] 4개가 존재하므로 4를 반환
//
//        입출력 예 #2
//        1부터 5 사이의 소수는 [2,3,5] 3개가 존재하므로 3를 반환

//    int answer = 0;
//
//        if (n < 2) {
//        return answer;
//        }
//
//        for (int i = 2; i <= n; i++) {
//        boolean flag = true;
//        for (int j = 2; j <= Math.sqrt(i); j++) {
//        if (i % j == 0) {
//        flag = false;
//        break;
//        }
//        }
//        if(flag == true) {
//        answer++;
//        }
//        }
//
//        return answer;