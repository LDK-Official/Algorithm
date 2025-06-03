import java.io.*;
import java.util.*;

public class Main {
    static int[][] graph = new int[5][5];
    static boolean possible = false;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());

        dfs(startX, startY, 0, 0);
        System.out.println(possible ? 1 : 0);
    }

    static void dfs(int x, int y, int depth, int appleCount) {
        if (depth > 3) return;
        if (appleCount >= 2) {
            possible = true;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
            if (graph[nx][ny] == -1) continue;

            int now = graph[nx][ny];
            int newAppleCount = appleCount + (now == 1 ? 1 : 0);

            graph[x][y] = -1;
            dfs(nx, ny, depth + 1, newAppleCount);
            graph[x][y] = now == 1 ? 1 : 0;
        }
    }
}