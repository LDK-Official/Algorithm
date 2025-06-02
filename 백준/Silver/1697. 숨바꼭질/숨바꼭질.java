import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] visited = new int[100001];  // 위치별 방문 시간 기록

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());  // 수빈이 위치
        K = Integer.parseInt(st.nextToken());  // 동생 위치

        bfs(N);
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = 1;  // 시작점 방문 처리 (시간 0으로 보고 1로 시작)

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == K) {
                System.out.println(visited[now] - 1);  // 시간 출력 (1 빼기)
                return;
            }

            int[] next = {now - 1, now + 1, now * 2};

            for (int nx : next) {
                if (nx >= 0 && nx < 100001 && visited[nx] == 0) {
                    queue.offer(nx);
                    visited[nx] = visited[now] + 1;  // 이동 시간 기록
                }
            }
        }
    }
}