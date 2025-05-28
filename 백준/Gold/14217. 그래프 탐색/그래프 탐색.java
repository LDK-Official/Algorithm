import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            addEdge(u, v);
        }

        int q = Integer.parseInt(br.readLine());

        for (int y = 0; y < q; y++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            if (a == 1) {
                if (!graph[i].contains(j)) addEdge(i, j);
            } else if (a == 2) {
                removeEdge(i, j);
            }
            bfs();
        }
    }

    static void addEdge(int a, int b) {
        graph[a].add(b);
        graph[b].add(a);
    }

    static void removeEdge(int a, int b) {
        graph[a].remove(Integer.valueOf(b));
        graph[b].remove(Integer.valueOf(a));
    }

    static void bfs() {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, -1);
        Queue<Integer> queue = new LinkedList<>();
        dist[1] = 0;
        queue.offer(1);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : graph[now]) {
                if (dist[next] == -1) {
                    dist[next] = dist[now] + 1;
                    queue.offer(next);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(dist[i]);
            if (i < N) System.out.print(" ");

        }
        System.out.println();
    }
}