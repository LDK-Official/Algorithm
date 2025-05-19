import java.io.*;
import java.util.*;

public class Main {
    static class Shortcut {
        int start, end, cost;

        Shortcut(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 지름길 개수
        int D = Integer.parseInt(st.nextToken()); // 고속도로 길이

        List<Shortcut> shortcuts = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            // 조건: 도착점이 D를 넘지 않고, 지름길이 진짜 가까워야 의미 있음
            if (end <= D && end - start > cost) {
                shortcuts.add(new Shortcut(start, end, cost));
            }
        }

        // 거리 배열: dp[i] = 0부터 i까지 최소 거리
        int[] dp = new int[D + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i <= D; i++) {
            if (i > 0) {
                dp[i] = Math.min(dp[i], dp[i - 1] + 1); // 일반 도로 한 칸
            }

            for (Shortcut s : shortcuts) {
                if (s.start == i) {
                    dp[s.end] = Math.min(dp[s.end], dp[i] + s.cost); // 지름길 사용
                }
            }
        }

        System.out.println(dp[D]);
    }
}