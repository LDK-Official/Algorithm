import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int to, cost;

        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static List<Node>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, dist));
            graph[b].add(new Node(a, dist));
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            visited = new boolean[N + 1];
            int distance = bfs(start, end);
            sb.append(distance).append("\n");
        }
        System.out.println(sb);
    }

    static int bfs(int start, int end) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(start, 0));
        visited[start] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.to == end) {
                return cur.cost;
            }

            for (Node next : graph[cur.to]) {
                if (!visited[next.to]) {
                    visited[next.to] = true;
                    q.offer(new Node(next.to, cur.cost + next.cost));
                }
            }
        }

        return -1;
    }
}
