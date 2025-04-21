import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int totalSheep = 0, totalWolf = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        for (int y = 0; y < R; y++) {
            for (int x = 0; x < C; x++) {
                if (!visited[y][x] && map[y][x] != '#') {
                    bfs(x, y);
                }
            }
        }

        System.out.println(totalSheep + " " + totalWolf);
    }

    public static void bfs(int sx, int sy) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sx, sy});
        visited[sy][sx] = true;

        int sheep = 0;
        int wolf = 0;

        if (map[sy][sx] == 'o') sheep++;
        else if (map[sy][sx] == 'v') wolf++;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && ny >= 0 && nx < C && ny < R) {
                    if (!visited[ny][nx] && map[ny][nx] != '#') {
                        visited[ny][nx] = true;
                        queue.add(new int[]{nx, ny});

                        if (map[ny][nx] == 'o') sheep++;
                        else if (map[ny][nx] == 'v') wolf++;
                    }
                }
            }
        }

        if (sheep > wolf) {
            totalSheep += sheep;
        } else {
            totalWolf += wolf;
        }
    }
}