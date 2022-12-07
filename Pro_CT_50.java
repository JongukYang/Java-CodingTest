public class Pro_CT_50 {
    // 콜라 문제
    public int solution(int a, int b, int n) {
        int answer = 0;
        int cola = 0;
        int bottle = n;

        while (true) {
            boolean d = div(bottle, a);
            if(d == false) {
                break;
            }
            else {
                cola = bottle/a * b;
                answer += cola;
                bottle = bottle%a;
                bottle += cola;
            }
        }
        return answer;
    }
    public boolean div(int n, int a) {
        if (n/a > 0) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        Pro_CT_50 sol = new Pro_CT_50();
        int a = 3; // 마트에서 콜라로 바꿔줄 때 제공해야하는 빈병의 개수
        int b = 1; // 마트가 주는 빈병의 개수
        int n = 20; // 초기 빈병
        System.out.println(sol.solution(a,b,n));
    }
}
