import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); 
        int[] L = new int[N + 1]; 
        int[] J = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            L[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            J[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N + 1][101]; 

        for (int i = 1; i <= N; i++) {
            for (int h = 1; h <= 100; h++) { 
                if (h - L[i] > 0) {
                    dp[i][h] = Math.max(dp[i - 1][h], dp[i - 1][h - L[i]] + J[i]);
                } else {
                    dp[i][h] = dp[i - 1][h];
                }
            }
        }

        System.out.println(dp[N][100]);
    }
}