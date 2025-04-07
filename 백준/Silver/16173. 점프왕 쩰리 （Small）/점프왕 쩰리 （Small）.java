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
        dfs(0, 0);
        System.out.println(success ? "HaruHaru" : "Hing");
    }

    public static void dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= N || visited[x][y]) return;

        visited[x][y] = true;

        if (map[x][y] == -1) {
            success = true;
            return;
        }

        int jump = map[x][y];
        dfs(x + jump, y);   // 아래로 점프
        dfs(x, y + jump);   // 오른쪽으로 점프

    }
}