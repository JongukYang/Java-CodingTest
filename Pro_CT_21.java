
public class Pro_CT_21 {
    public int solution(int[] numbers) {
        int answer = 45;
        for (int n : numbers) {
            answer -= n;
        }

        return answer;
    }

    public static void main(String[] args) {
        Pro_CT_21 sol = new Pro_CT_21();
        int[] numbers = {1,2,3,4,6,7,8,0};
        System.out.println(sol.solution(numbers));
    }
}
