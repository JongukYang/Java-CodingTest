package Baekjoon.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//골드3 양 구출 작전 풀었으나 시간초과 ㅜ
public class DFS_양구출작전_수빈 {
    static int N;
    static String[][] map;

    static int result;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N  = Integer.parseInt(br.readLine());
        map = new String[N-1][3];

        //데이터 삽입
        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j]=st.nextToken();
            }

        }
        result=0;

        for (int i = 0; i < N-1; i++) {
            if(map[i][0].equals("S")){
                dfs(Long.parseLong(map[i][1]),Integer.parseInt(map[i][2]),i);
            }
        }

        System.out.println(result);

    }

    static void dfs(long sheep,int bridge,int index){
        if(bridge==1){
            result+=sheep;
            return;
        }

        if(map[bridge-2][0].equals("W")){ //이어진 섬에 늑대가있을때
            if(Long.parseLong(map[index][1])>Long.parseLong(map[bridge-2][1])){
                dfs(Long.parseLong(map[index][1])-Long.parseLong(map[bridge-2][1]),Integer.parseInt(map[bridge-2][2]),bridge-2);
            }else{
                dfs(0,Integer.parseInt(map[bridge-2][2]),bridge-2);
            }
        }else{//양이있을때
            dfs(sheep,Integer.parseInt(map[bridge-2][2]),bridge-2);
        }
    }
}
