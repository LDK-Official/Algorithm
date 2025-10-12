import java.io.*;
import java.util.*;

public class Main {
    static int N, L, R;
    static int[][] A;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        A = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int days = 0;

        while (true) {
            visited = new boolean[N][N];
            boolean moved = false; // 오늘 하루 인구 이동이 있었는지 표시

            // 모든 칸을 탐색
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        List<int[]> union = bfs(i, j);
                        if (union.size() > 1) { // 연합이 2칸 이상일 때만 인구 이동 발생
                            moved = true;
                            // 연합 평균 인구 계산
                            int sum = 0;
                            for (int[] pos : union) sum += A[pos[0]][pos[1]];
                            int avg = sum / union.size();
                            // 인구 재분배
                            for (int[] pos : union) A[pos[0]][pos[1]] = avg;
                        }
                    }
                }
            }

            if (!moved) break; // 더 이상 이동이 없으면 종료
            days++;
        }

        System.out.println(days);
    }

    // BFS로 한 연합을 찾아 반환
    static List<int[]> bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        List<int[]> union = new ArrayList<>();
        visited[x][y] = true;
        q.offer(new int[]{x, y});
        union.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0], cy = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                // 범위 체크
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny]) continue;

                int diff = Math.abs(A[cx][cy] - A[nx][ny]);
                // 인구 차이가 L 이상 R 이하일 때만 국경 개방
                if (diff >= L && diff <= R) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                    union.add(new int[]{nx, ny});
                }
            }
        }
        return union;
    }
}