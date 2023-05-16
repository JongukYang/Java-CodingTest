package Study_CT.AnswerCode;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 좌표 정렬하기 - 실버5
public class 좌표_정렬하기 {

    private static class Coordinate{
        int x, y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public String toString() {
            return "x = " + this.x + " / y = " + this.y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        Coordinate[] coordinates = new Coordinate[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            coordinates[i] = new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(coordinates, (o1, o2) -> {
            if (o1.x == o2.x) {
                return Integer.compare(o1.y, o2.y);
            }
            return Integer.compare(o1.x, o2.x);
        });

        for (Coordinate coordinate : coordinates) {
//            System.out.println("coordinate = " + coordinate);
            bw.write(coordinate.x + " " + coordinate.y +"\n");
        }

        bw.flush();
    }
}
