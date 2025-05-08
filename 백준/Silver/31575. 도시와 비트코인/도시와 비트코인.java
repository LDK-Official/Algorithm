import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[][] visited;
    static int[][] map;
    static int[] dx = {1, 0};//동쪽 이동
    static int[] dy = {0, 1};//남쪽 이동
    static boolean reached = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (map[0][0] == 1) {
            dfs(0, 0);
        }

        System.out.println(reached ? "Yes" : "No");
    }

    static void dfs(int y, int x) {
        if (y == M - 1 && x == N - 1) {
            reached = true;
            return;
        }
        visited[y][x] = true;

        for (int i = 0; i < 2; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny >= 0 && ny < M && nx >= 0 && nx < N) {
                if (!visited[ny][nx] && map[ny][nx] == 1) {
                    dfs(ny, nx);
                }
            }
        }
    }
}