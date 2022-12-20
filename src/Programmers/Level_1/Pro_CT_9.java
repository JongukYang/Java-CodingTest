package Programmers.Level_1;

public class Pro_CT_9 {
    public static boolean solution(int x) {
        boolean answer = true;
        int sum = 0;
        String s = Integer.toString(x);
        System.out.println(x);
        System.out.println(s);
        for (int i = 0; i < s.length(); i++) {
            sum += Integer.valueOf(s.substring(i, i + 1));
        }
        if (x % sum == 0) {
            answer = true;
        } else {
            answer = false;
        }

        return answer;
    }

    public static void main(String[] args) {
        int x = 12;
        System.out.println(solution(x));
    }
}

// public class HarshadNumber{
//     public boolean isHarshad(int num){

//     String[] temp = String.valueOf(num).split("");

//     int sum = 0;
//     for (String s : temp) {
//         sum += Integer.parseInt(s);
//     }

//     if (num % sum == 0) {
//             return true;
//     } else {
//       return false;
//     }
//     }

//        // 아래는 테스트로 출력해 보기 위한 코드입니다.
//     public static void  main(String[] args){
//         HarshadNumber sn = new HarshadNumber();
//         System.out.println(sn.isHarshad(18));
//     }
// }
