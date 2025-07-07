import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int x = N / 2;
        int y = N / 2;

        map[x][y] = 1;
        int num = 2;
        int len = 1;
        int dir = 0;
        int tx = x;
        int ty = y;

        while (num <= N * N) {
            for (int d = 0; d < 2; d++) {
                for (int i = 0; i < len; i++) {
                    x += dx[dir];
                    y += dy[dir];
                    if (x < 0 || y < 0 || x >= N || y >= N) continue;
                    map[x][y] = num++;
                }
                dir = (dir + 1) % 4;
            }
            len++;
        }
        outer:
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == target) {
                    tx = i;
                    ty = j;
                    break outer;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
        System.out.printf("%d %d\n", tx + 1, ty + 1);
    }
}