public class Pro_CT_31 {
//    두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수,
//    solution을 완성해 보세요. 배열의 맨 앞에 최대공약수,
//    그다음 최소공배수를 넣어 반환하면 됩니다.
//    예를 들어 두 수 3, 12의 최대공약수는 3, 최소공배수는 12이므로
//    solution(3, 12)는 [3, 12]를 반환해야 합니다.
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int maxNum = Math.max(n, m);
        int minNum = Math.min(n, m);

        answer[0] = gcd(maxNum, minNum);
        answer[1] = maxNum*minNum / answer[0];

        return answer;
    }
    static int gcd(int a, int b) {
        if(a % b == 0) {
            return b;
        }
        return gcd(b, a%b);
    }

    public static void main(String[] args) {
        Pro_CT_31 sol = new Pro_CT_31();
        int n = 3;
        int m = 12;
        System.out.println(sol.solution(n, m));
    }
}

//######################
//for(int i=1; i<=num1 && i<=num2; i++)
//        {
//        if(num1%i==0 && num2%i==0)
//        {
//        max = i;
//        }
//        }
//
//        int min = (num1*num2)/max; //최소 공배수
