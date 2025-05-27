import java.io.*;
import java.util.*;

public class Main {
    static int[] dist = new int[100001];
    static boolean[] visited = new boolean[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        bfs(A, B, N, M);

        System.out.println(dist[M]);
    }

    static void bfs(int A, int B, int N, int M) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        visited[N] = true;
        dist[N] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            int[] moves = {
                    cur + 1,
                    cur - 1,
                    cur + A,
                    cur - A,
                    cur + B,
                    cur - B,
                    cur * A,
                    cur * B
            };

            for (int next : moves) {
                if (next < 0 || next > 100000) continue;

                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                    dist[next] = dist[cur] + 1;
                    if (next == M) return;
                }
            }
        }
    }
}
