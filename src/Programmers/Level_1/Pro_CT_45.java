package Programmers.Level_1;

import java.util.ArrayList;

public class Pro_CT_45 {
//    모의고사 수포자 문제
    public int[] solution(int[] answers) {
        int[] stu1 = {1,2,3,4,5};
        int[] stu2 = {2,1,2,3,2,4,2,5};
        int[] stu3 = {3,3,1,1,2,2,4,4,5,5};
        int[] cnt = new int[3];

        for(int i = 0; i<answers.length; i++) {
            if(stu1[i%stu1.length] == answers[i]) { cnt[0]++; }
            if(stu2[i%stu2.length] == answers[i]) { cnt[1]++; }
            if(stu3[i%stu3.length] == answers[i]) { cnt[2]++; }
        }

        int max = Math.max(Math.max(cnt[0], cnt[1]),cnt[2]);

        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int i = 0; i<cnt.length; i++) {
            if(max == cnt[i]) {
                arrayList.add(i+1);
            }
        }

        int[] answer = new int[arrayList.size()];
        for(int i = 0; i<arrayList.size(); i++) {
            answer[i] = arrayList.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] answers = {1,2,3,4,5};
        Pro_CT_45 sol = new Pro_CT_45();
        System.out.println(sol.solution(answers));
    }
}


//class Solution {
//    public static int[] solution(int[] answers) {
//        int[][] patterns = {
//                {1, 2, 3, 4, 5},
//                {2, 1, 2, 3, 2, 4, 2, 5},
//                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
//        };
//
//        int[] hit = new int[3];
//        for(int i = 0; i < hit.length; i++) {
//            for(int j = 0; j < answers.length; j++) {
//                if(patterns[i][j % patterns[i].length] == answers[j]) hit[i]++;
//            }
//        }
//
//        int max = Math.max(hit[0], Math.max(hit[1], hit[2]));
//        List<Integer> list = new ArrayList<>();
//        for(int i = 0; i < hit.length; i++)
//            if(max == hit[i]) list.add(i + 1);
//
//        int[] answer = new int[list.size()];
//        int cnt = 0;
//        for(int num : list)
//            answer[cnt++] = num;
//        return answer;
//    }
//}