package Programmers.Level_3;

public class 징검다리_건너기 {
    // 징검다리 건너기
    public int solution(int[] stones, int k) {
        int answer = 0; // 건너는 친구들 수

        while (answer == k) {
            int limit_k = 0; // 못 건너는 징검다리
            for(int i = 0; i < stones.length; i++) {
                stones[i]--;
                if (stones[i] <= 0) {
                    limit_k++;
                }
            }

            answer++;
            limit_k++;
        }

        return answer;
    }

    public static void main(String[] args) {
        징검다리_건너기 p = new 징검다리_건너기();
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1}; // 디딤돌에 적힌 숫자, 한번 밟으면 -1
        int k = 3; // 한 번에 건널 수 있는 디딤돌의 최대 칸수
        System.out.println(p.solution(stones, k));
    }
}
