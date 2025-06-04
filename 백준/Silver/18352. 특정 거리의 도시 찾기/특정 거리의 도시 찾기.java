import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K, X;
    static int[] distance;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        distance = new int[N + 1];
        Arrays.fill(distance, -1);

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int form = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[form].add(to);
        }

        bfs(X);

        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (distance[i] == K) {
                answer.add(i);
            }
        }

        if (answer.isEmpty()) {
            System.out.println(-1);
        } else {
            Collections.sort(answer);
            for (int city : answer) {
                System.out.println(city);
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        distance[start] = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : graph[now]) {
                if (distance[next] == -1) {
                    distance[next] = distance[now] + 1;
                    queue.offer(next);
                }
            }
        }
    }
}