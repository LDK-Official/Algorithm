import java.io.*;
import java.util.*;
public class Main {
    static boolean[] visited;
    static int[][] graph;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());        // 컴퓨터 수
        int m = Integer.parseInt(br.readLine());        // 연결 수

        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = 1;  // 양방향 연결
        }
        dfs(1);
        System.out.println(count - 1);
    }

    public static void dfs(int node) {
        visited[node] = true;
        count++;

        for (int i = 1; i < visited.length; i++) {
            if (!visited[i] && graph[node][i] == 1) {
                dfs(i);
            }
        }
    }
}
