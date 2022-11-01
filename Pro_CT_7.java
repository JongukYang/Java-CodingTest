public class Pro_CT_7 {
    public static int[] solution(long n) {

        String str = String.valueOf(n);
        System.out.println("str:" + str);
        int[] answer = new int[str.length()];
        for (int i = str.length() - 1; i >= 0; i--) {
            System.out.println(str.charAt(i));
            answer[str.length() - 1 - i] = str.charAt(i) - '0';
        }
        return answer;

        // 문자로 바꾸고 하나씩 끊고 하나씩 정수로 변환해 넣어주기
        // String s = Long.toString(n);
        // int[] answer = new int[s.length()];
        // for (int i = s.length() - 1; i >= 0; i--) {
        // System.out.println("i:" + i + " " + "s.sub:" +
        // Integer.parseInt(s.substring(s.length()-i-1, s.length()-i)));
        // answer[s.length() - 1 - i] = Integer.parseInt(s.substring(s.length()-i-1,
        // s.length()-i));
        // System.out.println("answer[" + i + "]: " + answer[i]);
        // }
        // System.out.println(answer);
        // return answer;

    //     String a = "" + n;
    //     int[] answer = new int[a.length()];
    //     int cnt=0;

    //     while(n>0) {
    //         answer[cnt]=(int)(n%10);
    //         n/=10;
    //         System.out.println(n);
    //         cnt++;
    //     }
    //   return answer;
    }

    public static void main(String[] args) {
        int n = 12345;
        System.out.println(solution(n));
    }
}


// import java.util.stream.IntStream;

// class Solution {
//     public int[] solution(long n) {
//         return new StringBuilder().append(n).reverse().chars().map(Character::getNumericValue).toArray();
//     }
// }

// public int[] solution(long n) {
//     char[] arr = new StringBuffer(String.valueOf(n)).reverse().toString().toCharArray();
//     int[] answer = new int[arr.length];

//     for(int i = 0; i < arr.length; i++){
//         answer[i] = arr[i] - 48;
//     }

//     return answer;
// }