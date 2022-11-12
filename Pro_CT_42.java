public class Pro_CT_42 {
//    한국중학교 학생들의 번호를 나타내는 정수 배열 number가 매개변수로 주어질 때,
//    학생들 중 삼총사를 만들 수 있는 방법의 수를 return 하도록 solution 함수를 완성하세요.
    public int solution(int[] number) {
        int answer = 0;
        for (int i = 0; i< number.length; i++) {
            for (int j = i+1; j<number.length; j++) {
                for (int k = j+1; k<number.length; k++) {
                    if (number[i] + number[j] + number[k] == 0) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Pro_CT_42 sol = new Pro_CT_42();
        int[] number = {-2, 3,0,2,-5};
        System.out.println(sol.solution(number));
    }
}
