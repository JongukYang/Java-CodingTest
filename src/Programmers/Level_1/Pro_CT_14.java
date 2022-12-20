package Programmers.Level_1;

public class Pro_CT_14 {
    public long solution(int a, int b) {
        long answer = 0;
//        for (int i = ((a < b) ? a : b); i <= ((a < b) ? b : a); i++)
//            answer += i;

//        if(a!=b){
//            for(int i=Math.min(a,b);i<=Math.max(a,b);i++){
//                answer+=i;
//            }
//        }else{
//            answer=a;
//        }

        if(a<b) {
            for (int i = a; i <= b; i++) {
                answer += i;
            }
        } else if(a>b) {
            for(int i = b; i<=a; i++) {
                answer += i;
            }
        } else {
            answer = a;
        }
        return answer;
    }

    public static void main(String[] args) {
        Pro_CT_14 sol = new Pro_CT_14();
        System.out.println(sol.solution(3, 5));

    }
}
//
//    public long solution(int a, int b) {
//        return sumAtoB(Math.min(a, b), Math.max(b, a));
//    }
//
//    private long sumAtoB(long a, long b) {
//        return (b - a + 1) * (a + b) / 2;
//    }
