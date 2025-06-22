import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean[] dp = new boolean[N + 5]; 

        dp[1] = true;     // 상근이 승
        dp[2] = false;    // 창영이 승
        dp[3] = true;     // 상근이 승
        dp[4] = true;     // 상근이 승

        for (int i = 5; i <= N; i++) {
            if (!dp[i - 1] || !dp[i - 3] || !dp[i - 4]) {
                dp[i] = true; // 상근이 승
            } else {
                dp[i] = false; // 창영이 승
            }
        }

        System.out.println(dp[N] ? "SK" : "CY");
    }
}