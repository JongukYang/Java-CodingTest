package Programmers.Level_1;

public class Pro_CT_27 {
    public int solution(int left, int right) {
//      두 정수 left와 right가 매개변수로 주어집니다.
//      left부터 right까지의 모든 수들 중에서, 약수의 개수가 짝수인 수는 더하고,
//      약수의 개수가 홀수인 수는 뺀 수를 return 하도록 solution 함수를 완성해주세요.
//        1 ≤ left ≤ right ≤ 1,000
        int answer = 0;
        if(left<1 || right> 1000 || right <= left) return -1;

        for(int j = left; j <= right; j++) { // l ~ r 까지 수
            int cnt = 0; // 짝수인지 세기
            for(int i = 1; i <= right; i++) { // 1 ~ r 까지 수로 나누기
                if(j % i == 0) {
                    cnt++; // 약수라면 증가
                }
            }
            if (cnt % 2 == 0) { // 짝수라면 더하기
                answer += j;
            } else { // 홀수라면 뺴기
                answer -= j;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Pro_CT_27 sol = new Pro_CT_27();
        int left = 13;
        int right = 17;
        System.out.println(sol.solution(left,right));
    }
}
//################################################################
// for (int i=left;i<=right;i++) {
//         //제곱수인 경우 약수의 개수가 홀수
//         if (i % Math.sqrt(i) == 0) {
//         answer -= i;
//         }
//         //제곱수가 아닌 경우 약수의 개수가 짝수
//         else {
//         answer += i;
//         }
//         }
