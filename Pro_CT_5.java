public class Pro_CT_5 {
    public static int solution(int n) {
        int answer = 0;
        // n = 123
        String s = Integer.toString(n);
        for(int i = 0; i<s.length(); i++) {
            answer += Integer.parseInt(s.substring(i, i+1));
        }
        return answer;
    }
    public static void main(String[] args) {
        int n = 123;
        System.out.println(solution(n));
        
        // String s = "hello";
        // System.out.println(s[0]);
    }
}

// public int solution(int n) {
//     int answer = 0;

//     while(n>10){
//         answer+=n%10;
//         if(n<10)
//             break;

//         n=n/10;
//     }

//     // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
//     System.out.println("Hello Java");

//     return answer;
// }
