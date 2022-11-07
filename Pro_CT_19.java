
public class Pro_CT_19 {
    public int[] solution(int[] arr) {
        int min = arr[0];
        int[] a = {-1};
        for(int i = 0; i<arr.length; i++) {
            if (arr.length == 1) {
                return a;
            }
            if(arr[i] < min) {
                min = arr[i];
            }
        }

        int[] answer = new int[arr.length-1];

        int j = 0;

        for(int i = 0; i<arr.length; i++) {
//            if (arr.length == 1) {
//                answer[j] = -1;
//                return answer;
//            }
            if(arr[i] == min) {
                continue;
            }
            answer[j++] = arr[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        Pro_CT_19 sol = new Pro_CT_19();
        int[] arr = {4,3,2,1};
        System.out.println(sol.solution(arr));
    }
}
