package Programmers.Level_1;

import java.util.Arrays;
import java.util.LinkedList;

public class Pro_CT_67 {
    // 신고 결과 받기
        public int[] solution(String[] id_list, String[] report, int k) {
            int[] answer = new int[id_list.length];

            String[][] sarr = new String[report.length][2];
            
            for(int i = 0; i<report.length; i++) {
                String[] s = report[i].split(" ");
                sarr[i][0] = s[0];
                sarr[i][1] = s[1];
                System.out.println(Arrays.toString(sarr[i]));
            }



            return answer;
        }

        public static void main(String[] args) {
            Pro_CT_67 sol = new Pro_CT_67();
            // 전체 유저 목록
            String[] id_list = {"muzi", "frodo", "apeach", "neo"};
            // 유저 ID / 유저가 신고한 ID
            String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
            int k = 2; // k 번 이상 신고된 유저는 게시판 이용 정지

            // 각 유저별로 결과 처리 메일을 받은 횟수를 배열에 담아 return
            // 신고당한 유저가 정지되면 신고를 한 유저에게 메일 보냄
            // 신고당한 유저가 정지되면 메일을 받음
            System.out.println(sol.solution(id_list, report, k));
        }
}



//            // 신고당한 유저 hashmap -> 누가 신고했는지 모름
//            ArrayList<String> arrayList = new ArrayList<>();
//            ArrayList<String> arrayList2 = new ArrayList<>();
//            HashMap<String, Integer> report_user = new HashMap<String, Integer>();
//            for(int i = 0; i<report.length; i++) {
//                String[] s = report[i].split(" ");
//                arrayList.add(s[0]);
//                arrayList2.add(s[0]);
//                report_user.put(s[1], report_user.getOrDefault(s[1], 0) +1 );
//            }
//            report_user.forEach((key, value) -> {
//                if(value >= k) {
//                    System.out.println("key : " + key + "   " + value);
//                }
//            });
//
//
//
//            // 메일 개수 카운트
//            HashMap<String, Integer> user = new HashMap<String, Integer>();