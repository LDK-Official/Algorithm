import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        
        // 최대 250까지
        BigInteger[] dp = new BigInteger[251];
        dp[0] = BigInteger.ONE;
        dp[1] = BigInteger.ONE;

        for (int i = 2; i <= 250; i++) {
            dp[i] = dp[i-1].add(dp[i-2].multiply(BigInteger.valueOf(2)));
        }

        // 여러 줄 입력
        while ((input = br.readLine()) != null && !input.isEmpty()) {
            int n = Integer.parseInt(input.trim());
            System.out.println(dp[n]);
        }
    }
}