import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine()); // 날짜 수
            long[] prices = new long[N];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                prices[i] = Long.parseLong(st.nextToken());
            }

            long maxPrice = 0;   // 현재까지의 최고 주가
            long profit = 0;     // 총 이익

            for (int i = N - 1; i >= 0; i--) {
                if (prices[i] > maxPrice) {
                    maxPrice = prices[i];
                } else {
                    profit += (maxPrice - prices[i]);
                }
            }

            sb.append(profit).append("\n");
        }

        System.out.print(sb);
    }
}