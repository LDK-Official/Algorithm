import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            long N = Long.parseLong(br.readLine());

            long left = 0;
            long right = 2_000_000_000L;
            long ans = 0;

            while (left <= right) {
                long mid = (left + right) / 2;
                long sum = mid * (mid + 1) / 2;

                if (sum <= N) {
                    ans = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            sb.append(ans).append('\n');
        }

        System.out.print(sb);
    }
}