import java.io.*;
import java.util.*;

public class Main {
    static int C, S, T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        C = Integer.parseInt(br.readLine());

        for (int i = 0; i < C; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            T = Integer.parseInt(st.nextToken());

            bfs(S, T);
        }
    }

    static void bfs(int start, int end) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {start, end, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int tae = cur[0];   // 태균이 점수
            int other = cur[1];    // 상대 점수
            int cnt = cur[2];

            if (tae == other) {
                System.out.println(cnt);
                return;
            }

            if (tae > other) continue;

            queue.offer(new int[]{tae + 1, other, cnt + 1});
            queue.offer(new int[]{tae * 2, other + 3, cnt + 1});
        }
    }
}