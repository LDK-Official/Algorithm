import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] W;
    static boolean[] visited;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            visited[i] = true;
            dfs(i, i, 0, 0);    // 출발도시, 현재 도시, 방문수, 비용
            visited[i] = false;
        }
        System.out.println(result);
    }

    static void dfs(int start, int now, int cnt, int cost) {
        if (cnt == N - 1) {
            if (W[now][start] != 0) {
                cost += W[now][start];
                result = Math.min(result, cost);
            }
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i] && W[now][i] != 0) {
                visited[i] = true;
                dfs(start, i, cnt + 1, cost + W[now][i]);
                visited[i] = false;
            }
        }
    }
}