package Baekjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//골드3 양 구출 작전 풀었으나 시간초과 ㅜ
public class Main {
    static int N;
    static String[][] map;
    static boolean[] visited;
    static long result;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N  = Integer.parseInt(br.readLine());
        map = new String[N-1][3];
        visited = new boolean[N-1];

        //데이터 삽입
        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j]=st.nextToken();
            }

        }
        result=0;
        long cnt = 0;
        for (int i = N-2; i >= 0; i--) {
            if(map[i][0].equals("S")&&!visited[i]){
                System.out.println("#############  for문을 통해 시작" + (i + 2) + "#############");
                visited[i]=true;
                dfs(Long.parseLong(map[i][1]),Integer.parseInt(map[i][2]),i);
                cnt+=result;
                result=0;

            }
        }

        System.out.println(cnt);

    }

    static void dfs(long sheep,int bridge,int index){
        System.out.println("#########################");
        System.out.println("DFS 함수 실행 - 현재 노드 " + (index+2));

        if(bridge==1){
            System.out.println("1버 노드 도착 - 현재 양 :" +sheep);
            result+=sheep;
            return;
        }

        if(map[bridge-2][0].equals("W")){ //이어진 섬에 늑대가있을때
            System.out.println("다음 노드가 늑대일 때 수행");

            if(Long.parseLong(map[index][1]) > Long.parseLong(map[bridge-2][1])){//현재섬의 양이 더 많을때
                System.out.println("// 현재까지 구한 양의 수가 더 많을 때");
                System.out.println("현재 양 :"+ (sheep - Long.parseLong(map[bridge-2][1])));
                System.out.println("map[bridge-2][1] : " + map[bridge-2][1]);
                dfs(sheep - Long.parseLong(map[bridge-2][1]),Integer.parseInt(map[bridge-2][2]),bridge-2);
                map[bridge-2][1]="0";//늑대 수 초기화
                System.out.println((bridge-2)+"의 남은 늑대:"+map[bridge-2][1]);


            }else{//양의수가 늑대보다 적을때
                System.out.println("// 현재까지 구한 양의 수가 더 적을 때");
                System.out.println("현재 양 :" +0);
                dfs(0,Integer.parseInt(map[bridge-2][2]),bridge-2);
                int wolf = Integer.parseInt(map[bridge-2][1])-Integer.parseInt(map[index][1]);
                map[bridge-2][1] = Integer.toString(wolf);
                System.out.println((bridge-2)+"의 남은 늑대:"+map[bridge-2][1]);
            }
        }else if(!visited[bridge-2]){//양이있을때
            visited[bridge-2]=true;//방문체크
            System.out.println("다음 노드가 양일 때");
            System.out.println("현재 양 :"+(sheep+Integer.parseInt(map[bridge-2][1])));
            dfs(sheep+Integer.parseInt(map[bridge-2][1]),Integer.parseInt(map[bridge-2][2]),bridge-2);
        }else if(visited[bridge-2]){ //전에 이미 방문을 했을때
            System.out.println("이미 방문한 노드라면");
            System.out.println("현재 양 :"+sheep);
            dfs(sheep,Integer.parseInt(map[bridge-2][2]),bridge-2);
        }
    }
}
