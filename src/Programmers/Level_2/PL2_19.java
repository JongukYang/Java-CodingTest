package Programmers.Level_2;

import java.util.ArrayList;
import java.util.Arrays;

public class PL2_19 {
    // 구명보트 - 탐욕법(Greedy)
    public int solution(int[] people, int limit) {
        int answer = 0;
        int mid = limit/2;
        Arrays.sort(people); // 오름차순

        ArrayList<Integer> low = new ArrayList<>();
        ArrayList<Integer> high = new ArrayList<>();

        for(int i = 0; i<people.length; i++) {
            if (people[i] <= mid) {
                low.add(people[i]);
            } else {
                high.add(people[i]);
            }
        }

        int idx = low.size() - 1;
        for (int i = 0; i < high.size(); i++) {
            for(int j = idx; j >= 0; j--) {
                if ((high.get(i) + low.get(j)) <= limit) {
                    answer++;
                    idx = j;
                    break;
                }
            }
            if (i == high.size() - 1) {
                int resLow = low.size() - answer;
                int resHigh = high.size() - answer;
                answer += resLow/2 + resLow%2 + resHigh;
                break;
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        PL2_19 p = new PL2_19();
        int[] people = {70, 50, 80, 50};
        int limit = 100;
        System.out.println(p.solution(people, limit)); // 3
    }
}
