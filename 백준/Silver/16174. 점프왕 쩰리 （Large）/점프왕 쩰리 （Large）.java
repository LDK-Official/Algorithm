import java.io.*;
import java.util.*;
public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int N;
    static boolean success = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs(0, 0);
        System.out.println(success ? "HaruHaru" : "Hing");
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            if (map[cx][cy] == -1) {
                success = true;
                return;
            }

            int jump = map[cx][cy];

            // 오른쪽 이동
            int nx = cx;
            int ny = cy + jump;
            if (ny < N && !visited[nx][ny]) {
                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny});
            }

            // 아래쪽 이동
            nx = cx + jump;
            ny = cy;
            if (nx < N && !visited[nx][ny]) {
                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny});
            }

        }
    }
}