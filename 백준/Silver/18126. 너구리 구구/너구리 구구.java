import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int to, distance;

        Node(int to, int distance) {
            this.to = to;
            this.distance = distance;
        }
    }

    static List<Node>[] graph;
    static boolean[] visited;
    static long result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        dfs(1, 0L);

        System.out.println(result);
    }

    static void dfs(int now, long dist) {
        visited[now] = true;
        result = Math.max(result, dist);

        for (Node next : graph[now]) {
            if (!visited[next.to]) {
                dfs(next.to, dist + next.distance);
            }
        }
    }
}