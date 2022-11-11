import java.util.Arrays;

public class Pro_CT_37 {
    //    모든 명함의 가로 길이와 세로 길이를 나타내는 2차원 배열 sizes가 매개변수로 주어집니다.
//    모든 명함을 수납할 수 있는 가장 작은 지갑을 만들 때,
//    지갑의 크기를 return 하도록 solution 함수를 완성해주세요.
//    int[][] => [width, height]
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxWidth = 0;
        int maxHeight = 0;

        for(int i = 0; i<sizes.length; i++) {
            if(sizes[i][0] < sizes[i][1]) {
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
            if(maxWidth < sizes[i][0]) {
                maxWidth = sizes[i][0];
            }
            if(maxHeight < sizes[i][1]) {
                maxHeight = sizes[i][1];
            }
        }
        answer = maxWidth * maxHeight;

        return answer;
    }

    public static void main(String[] args) {
        Pro_CT_37 sol = new Pro_CT_37();
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        System.out.println(sol.solution(sizes));
    }
}
//###########################################################
//class Solution {
//    public int solution(int[][] sizes) {
//        int long_max = 1;
//        int short_max = 1;
//
//        for(int i = 0; i < sizes.length; i++){
//            int longer = Math.max(sizes[i][0], sizes[i][1]);
//            int shorter = Math.min(sizes[i][0], sizes[i][1]);
//
//            if(longer > long_max) {
//                long_max = longer;
//            }
//            if(shorter > short_max) {
//                short_max = shorter;
//            }
//        }
//
//        return long_max * short_max;
//    }
//}


//class Solution {
//    public int solution(int[][] sizes) {
//        int length = 0, height = 0;
//        for (int[] card : sizes) {
//            length = Math.max(length, Math.max(card[0], card[1]));
//            height = Math.max(height, Math.min(card[0], card[1]));
//        }
//        int answer = length * height;
//        return answer;
//    }
//}
