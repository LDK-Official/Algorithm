import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1,  0,  1,-1, 1,-1, 0, 1};

    static int N, M;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int peakCount = 0;

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (!visited[x][y] && map[x][y] > 0) {
                    if (bfsCheckPeak(x, y)) {
                        peakCount++;
                    }
                }
            }
        }

        System.out.println(peakCount);
    }
    
    static boolean bfsCheckPeak(int sx, int sy) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sx, sy});
        visited[sx][sy] = true;

        int height = map[sx][sy];
        boolean isPeak = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int dir = 0; dir < 8; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                int nh = map[nx][ny];

                if (nh > height) {
                    isPeak = false;
                } else if (nh == height && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }

        return isPeak;
    }
}