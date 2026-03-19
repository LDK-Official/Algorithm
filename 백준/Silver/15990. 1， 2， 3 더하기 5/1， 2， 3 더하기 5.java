import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static final long MOD = 1_000_000_009L;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        long[][] dp = new long[100001][4];

        dp[1][1] = 1; // 1
        
        dp[2][2] = 1; // 2
        
        dp[3][1] = 1; // 2+1
        dp[3][2] = 1; // 1+2
        dp[3][3] = 1; // 3

        for (int i = 4; i <= 100000; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % MOD;
            
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % MOD;
            
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % MOD;
        }

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long result = (dp[n][1] + dp[n][2] + dp[n][3]) % MOD;
            sb.append(result).append("\n");
        }
        
        System.out.print(sb);
    }
}