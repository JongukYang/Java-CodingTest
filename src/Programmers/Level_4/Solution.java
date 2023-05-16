package Programmers.Level_4;

import java.util.*;

class Solution {
    public int solution(int[] pays, String[][] infos, String[] target) {
        // target 성별과 연령이 주어지면, 해당 성별과 연령의 평균 연봉 return
        // pays : 개발자들의 연봉
        // infos : 개발자들의 성별과 연령
        // target : 대상
        int totalAvg = 0;
        int divAvg = 0;
        ArrayList<Integer> targetPays = new ArrayList<>();

        for (int i = 0; i < infos.length; i++) {
            // target들의 연봉 찾기
            for (int j = 0; j < infos[i].length; j++) {
                if (infos[i][0].equals(target[0]) && infos[i][1].equals(target[1])) {
                    targetPays.add(pays[i]);
                }
            }
        }

        // target들의 연봉 전체 평균 구하기
        for (int j = 0; j < targetPays.size(); j++) {
            totalAvg += targetPays.get(j)/targetPays.size();
        }

        // 180 이상과 20 이하인 연봉 제외 평균 구하기
        for (int j = 0; j < targetPays.size(); j++) {
            if (!(totalAvg*0.2 >= targetPays.get(j) || totalAvg*1.8 <= targetPays.get(j))) {
                divAvg += targetPays.get(j);
            }
        }

        // 만약 0이라면 전체 연봉 사용
        return divAvg == 0 ? divAvg : totalAvg;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] pays = {1000, 2000, 3000, 4000, 5000};
        String[][] infos = {{"M", "20"}, {"F", "40"}, {"M", "60"}, {"M", "20"}, {"F", "30"}};
        String[] target = {"M", "20"};
        System.out.println(s.solution(pays, infos, target));
    }
}