package Programmers.Level_1;

public class Pro_CT_29 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
//        행렬의 덧셈은 행과 열의 크기가 같은 두 행렬의 같은 행,
//        같은 열의 값을 서로 더한 결과가 됩니다.
//        2개의 행렬 arr1과 arr2를 입력받아, 행렬 덧셈의 결과를 반환하는 함수,
//        solution을 완성해주세요.
        if(arr1.length > 500 || arr2[0].length > 500) return null;

        int[][] ans = new int[arr1.length][arr1[0].length];
        for(int i = 0; i<arr1.length; i++) {
            for (int j = 0 ; j<arr1[0].length; j++) {
                ans[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Pro_CT_29 sol = new Pro_CT_29();
        int[][] arr1 = {{1,2}, {2,3}};
        int[][] arr2 = {{3,4}, {5,6}};
        System.out.println(sol.solution(arr1,arr2));
    }
}
