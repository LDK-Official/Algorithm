import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] trees = new int[N];
        int maxLen = 0;
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(br.readLine());
            maxLen = Math.max(maxLen, trees[i]);
        }

        long maxTotalProfit = 0;

        for (int L = 1; L <= maxLen; L++) {
            long currentTotalProfit = 0;

            for (int i = 0; i < N; i++) {
                if (trees[i] < L) continue;

                long pieces = trees[i] / L;
                long cuts = (trees[i] % L == 0) ? (pieces - 1) : pieces; // 자르는 횟수

                long profit = (pieces * L * W) - (cuts * C);

                if (profit > 0) {
                    currentTotalProfit += profit;
                }
            }
            maxTotalProfit = Math.max(maxTotalProfit, currentTotalProfit);
        }

        System.out.println(maxTotalProfit);
    }
}