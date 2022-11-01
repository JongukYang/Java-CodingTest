public class Pro_CT_4 {
    public static String solution(int num) {
        String answer = "";
        if (num % 2 == 0) {
            answer = "Even";
        } else {
            answer = "Odd";
        }
        
        return answer;
        // return num % 2 == 0 ? "Even": "Odd";
    }

    public static void main(String[] args) {
        int num = 4;
        System.out.println(solution(num));
    }

}
