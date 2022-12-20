package Programmers.Level_1;

public class Pro_CT_24 {
    public int solution(int[] a, int[] b) {
//        a[0]*b[0] + a[1]*b[1] + ... + a[n-1]*b[n-1]
        int answer = 0;
        for(int i = 0; i <a.length; i++) {
            answer += a[i]*b[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        Pro_CT_24 sol = new Pro_CT_24();
        int[] a = {1, 2, 3, 4};
        int[] b = {-3, -1, 0, 2};
        System.out.println(sol.solution(a, b));
    }
}
