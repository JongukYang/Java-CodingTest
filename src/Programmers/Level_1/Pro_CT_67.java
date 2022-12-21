package Programmers.Level_1;

public class Pro_CT_67 {
    // 신고 결과 받기
        public int[] solution(String[] id_list, String[] report, int k) {
            int[] answer = {};
            return answer;
        }

        public static void main(String[] args) {
            Pro_CT_67 sol = new Pro_CT_67();
            String[] id_list = {"muzi", "frodo", "apeach", "neo"};
            String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
            int k = 2;
            System.out.println(sol.solution(id_list, report, k));
        }
}
