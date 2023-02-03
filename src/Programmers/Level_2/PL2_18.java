package Programmers.Level_2;

public class PL2_18 {
    // 카펫 - 완전탐색
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int tileSum = brown+yellow; // 전체 타일 개수
        int yellow_sqrt = (int)Math.sqrt(yellow); // yellow의 제곱근 구하기

        for(int i = yellow_sqrt; i>0; i--) {
            for (int j = yellow_sqrt; j <= brown; j++) {
                if (i * j == yellow) {
                    int x = j+2;
                    int y= i+2;
                    if ((x * y - yellow) == brown) {
                        answer[0] = x;
                        answer[1] = y;
                        return answer;
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        PL2_18 p = new PL2_18();
        int brown = 10;
        int yellow = 2;
        System.out.println(p.solution(brown, yellow)); // [4,3]
    }
}
