
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        int bread_cnt = 0;
        int i = 0;
        
        while(true) {
            if(i == 9) {
                break;
            }
            if(ingredient[i] == 1) {
                bread_cnt++;
                if(ingredient[i+1] == 2 && ingredient[i+2] == 3 && ingredient[i+3] == 1) {
                    answer++;
                    // if(bread_cnt == 2) {
                    //     answer++;
                    // }
                    break;
                }
                // else {
                //     continue;
                // }
            }
            i++;
        }
        return answer;
    }
}