import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());  
        M = Integer.parseInt(br.readLine()); 

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }


        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        visited = new boolean[N + 1];
        System.out.println(bfs(1));
    }

    static int bfs(int start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0});
        visited[start] = true;

        int count = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int now = cur[0];
            int depth = cur[1];

            if (depth >= 2) continue;

            for (int next : graph[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    count++;
                    queue.offer(new int[]{next, depth + 1});
                }
            }
        }

        return count;
    }
}