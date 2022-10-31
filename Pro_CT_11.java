
public class Pro_CT_11 {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        // long j = (long)x;
        for(int i=0; i<n; i++) {
            answer[i] = (long)x * (i+1);
            // answer[i] = j;
            System.out.println(answer[i]);
            // j = j+(long)x;            
        }
        // System.out.println(answer);
        return answer;
    }
    public static void main(String[] args) {
        Pro_CT_11 sol = new Pro_CT_11();
        System.out.println(sol.solution(2, 5));
    }
}
