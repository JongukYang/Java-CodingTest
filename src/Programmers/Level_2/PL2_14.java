package Programmers.Level_2;
//다음 큰 숫자
public class PL2_14 {
    public int solution(int n) {
        int answer = 0;

        int bitCnt = Integer.bitCount(n);

        int idx = n+1;
        int bitCnt2 = 0;
        while(bitCnt != bitCnt2) {
            bitCnt2 = Integer.bitCount(idx);
            idx++;
        }

        answer = idx -1;
        return answer;
    }

    public static void main(String[] args) {
        PL2_14 p = new PL2_14();
//        int n = 1_000_000;
        int n = 78;
        System.out.println(p.solution(n));
    }
}
