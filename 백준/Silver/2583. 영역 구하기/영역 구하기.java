import java.io.*;
import java.util.*;

public class Main {
    static int M, N, K;
    static boolean[][] board;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 세로
        N = Integer.parseInt(st.nextToken()); // 가로
        K = Integer.parseInt(st.nextToken());

        board = new boolean[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    board[y][x] = true;
                }
            }
        }

        ArrayList<Integer> areas = new ArrayList<>();

        for (int y = 0; y < M; y++) {
            for (int x = 0; x < N; x++) {
                if (!board[y][x] && !visited[y][x]) {
                    areas.add(bfs(x, y));
                }
            }
        }

        Collections.sort(areas);
        System.out.println(areas.size());
        for (int area : areas) {
            System.out.print(area + " ");
        }
    }

    public static int bfs(int sx, int sy) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sx, sy});
        visited[sy][sx] = true;

        int area = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (!board[ny][nx] && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        queue.add(new int[]{nx, ny});
                        area++;
                    }
                }
            }
        }

        return area;
    }
}