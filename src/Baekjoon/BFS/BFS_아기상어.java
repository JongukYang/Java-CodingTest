package Baekjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BFS_아기상어 {
    // 백준 골드 3
    private static class Node {
        int r, c;
        int dist;

        public Node(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }

    private static int[] rx = {1, -1, 0, 0};
    private static int[] ry = {0, 0, 1, -1};
    private static int N, ANSWER;
    private static int[][] MAP, dist;
    private static int babySharkSize = 2;
    private static int babySharkEatenFishCnt = 0;
    private static ArrayDeque<Node> babySharkPosQueue;
    private static ArrayList<Node> canEatFishPosList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 좌표 크기 - 정사각형
        MAP = new int[N][N]; // 원본 배열

        babySharkPosQueue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                MAP[i][j] = Integer.parseInt(st.nextToken());
                if (MAP[i][j] == 9) {
                    babySharkPosQueue.addLast(new Node(i, j, 0));
                    MAP[i][j] = 0;
                }
            }
        }

        printMAP(MAP);

        while (true) {
            dist = new int[N][N]; // 거리 측정 배열
            canEatFishPosList = new ArrayList<>();
            while (!babySharkPosQueue.isEmpty()) {
                Node babySharkPos = babySharkPosQueue.pollFirst();
                for (int i = 0; i < 4; i++) {
                    // 다음 노드 위치
                    int nr = babySharkPos.r + ry[i];
                    int nc = babySharkPos.c + rx[i];
                    // 예외처리
                    if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
                        continue; // 맵 밖으로 나가는 경우
                    }
                    if (MAP[nr][nc] > babySharkSize) {
                        continue; // 물고기가 더 크면
                    }
                    // 갈 수 있는 곳이라면, 거리 0 : 아직 방문하지 않은곳
                    if (dist[nr][nc] == 0 && MAP[nr][nc] <= babySharkSize) {
                        dist[nr][nc] = dist[babySharkPos.r][babySharkPos.c] + 1;
                        babySharkPosQueue.addLast(new Node(nr, nc, dist[nr][nc]));
                        // 먹을 수 있는 물고기라면
                        if (MAP[nr][nc] != 0 && MAP[nr][nc] < babySharkSize) {
                            canEatFishPosList.add(new Node(nr, nc, dist[nr][nc]));
                        }
                        printMAP(dist);
                    }
                }
            }

            // 먹을 수 있는 물고기가 없을 때 리턴
            if (canEatFishPosList.size() == 0) {
                System.out.println(ANSWER);
                return;
            }

            // 현재 먹을 수 있는 물고기가 있을 때 (여러마리 일 수 있음)
            Node nowFish = canEatFishPosList.get(0); // 초기 첫 번째 물고기 선택
            // 물고기들 간에 상어와의 거리 비교하기
            for (int i = 1; i < canEatFishPosList.size(); i++) {
                // 현재 고른 물고기와의 거리가 다음 물고기와의 거리보다 클 때 작은거 선택
                if (nowFish.dist > canEatFishPosList.get(i).dist) {
                    nowFish = canEatFishPosList.get(i);
                }
                // 현재 고른 물고기와의 거리가 다음 물고기와의 거리와 같을 때 좌표상의 위치 비교하기
                else if (nowFish.dist == canEatFishPosList.get(i).dist) {
                    // 현재 고른 물고기가 더 아래 행이라면 -> 다음 물고기 선택 : 행 위치상 높은거 선택
                    if (nowFish.r > canEatFishPosList.get(i).r) {
                        nowFish = canEatFishPosList.get(i);
                    }
                    // 두 물고기가 서로 같은 행에 있다면
                    else if (nowFish.r == canEatFishPosList.get(i).r) {
                        // 더 왼쪽꺼 선택
                        if (nowFish.c > canEatFishPosList.get(i).c) {
                            nowFish = canEatFishPosList.get(i);
                        }
                    }
                }
            }

            // 현재 고른 물고기는 위 포문 결과를 통해 나온 물고기, 물고기 먹고 0으로 바꿔줌
            MAP[nowFish.r][nowFish.c] = 0;
            ANSWER += nowFish.dist;
            babySharkEatenFishCnt++;

            // 아기상어가 먹은 물고기 숫자가 아기상어의 사이즈와 같다면, 아기상어 크기 증가
            if(babySharkEatenFishCnt == babySharkSize) {
                babySharkSize++;
                babySharkEatenFishCnt = 0;
            }
            // 현재 물고기가 있던 자리를 다음 상어의 위치로 해줌.
            babySharkPosQueue.addLast(nowFish);
        }
    }

    private static void printMAP(int[][] currMAP) {
        System.out.println("###################################");
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(currMAP[i]));
        }
    }
}
