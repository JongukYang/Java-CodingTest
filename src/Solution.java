import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int w = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int _1rm = (int) Math.floor(w * (1.0 + r / 30.0));

        System.out.println(_1rm);
    }
}
