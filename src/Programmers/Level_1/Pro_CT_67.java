package Programmers.Level_1;

import java.util.*;

public class Pro_CT_67 {
    // 신고 결과 받기
        public int[] solution(String[] id_list, String[] report, int k) {
            int[] answer = new int[id_list.length];

            // user의 순서 저장
            HashMap<String, Integer> user_id = new HashMap<>();
            // 각 user별로 자신을 신고한 user의 set 저장
            HashMap<String, HashSet<String>> user_report = new HashMap<>();

            // HashMap 초기화
            for(int i = 0; i< id_list.length; i++) {
                user_id.put(id_list[i], i); // 입력되는 user_id 순서대로 index 지정
                user_report.put(id_list[i], new HashSet<>()); // user_id별로 HashSet 생성
            }

            System.out.println("###  HashMap 초기화  ###");
            System.out.println("###### user_id ######");
            user_id.forEach((key, value) -> {
                System.out.println(key + " : " + value);
            });
            System.out.println("###### user_report ######");
            user_report.forEach((key, value) -> {
                System.out.println(key + " : " + value);
            });

            // user 자신을 신고한 user의 이름 저장
            for(String s : report) {
                String[] sarr = s.split(" ");
                user_report.get(sarr[1]).add(sarr[0]);
            }

            System.out.println("###### 입력 후 user_report ######");
            System.out.println("# 신고당한 user : 신고한 user #");
            user_report.forEach((key, value) -> {
                System.out.println(key + " : " + value);
            });

            System.out.println("#######  신고한 user가 신고당한 user 출력  #######");
            // user별로 신고당한 횟수가 k 보다 많으면 메일 보내기
            for(int i = 0; i<id_list.length; i++) {
                // 자신을 신고한 user set 가져오기
                HashSet<String> hashSet = user_report.get(id_list[i]);
                System.out.println("신고한 user : " + hashSet + " -> 신고당한 user : " + id_list[i]);
                // 신고한 user가 k 이상이면
                if(hashSet.size() >= k) {
                    for(String s : hashSet) {
                        // user_id 별로 초기화를 통해 index를 설정해 주었기 때문에
                        // answer[]의 user index 순서에 맞게 값 증가
                        System.out.println(s);
                        answer[user_id.get(s)]++;
                    }
                }
            }

            return answer;
        }

        public static void main(String[] args) {
            Pro_CT_67 sol = new Pro_CT_67();
            // 전체 유저 목록
            String[] id_list = {"muzi", "frodo", "apeach", "neo"};
            // 유저 ID / 유저가 신고한 ID
            String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
//            String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
            int k = 2; // k 번 이상 신고된 유저는 게시판 이용 정지

            // 각 유저별로 결과 처리 메일을 받은 횟수를 배열에 담아 return
            // 신고당한 유저가 정지되면 신고를 한 유저에게 메일 보냄
            System.out.println(sol.solution(id_list, report, k));
        }
}