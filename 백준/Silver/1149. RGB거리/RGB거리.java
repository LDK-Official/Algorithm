import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); 

        int[][] cost = new int[N + 1][3];

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken()); // R
            cost[i][1] = Integer.parseInt(st.nextToken()); // G
            cost[i][2] = Integer.parseInt(st.nextToken()); // B
        }

        int[][] dp = new int[N + 1][3];

        dp[1][0] = cost[1][0]; // 빨강
        dp[1][1] = cost[1][1]; // 초록
        dp[1][2] = cost[1][2]; // 파랑

        for (int i = 2; i <= N; i++) {
            dp[i][0] = cost[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);

            dp[i][1] = cost[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);

            dp[i][2] = cost[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        int answer = Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2]));

        System.out.println(answer);
    }
}