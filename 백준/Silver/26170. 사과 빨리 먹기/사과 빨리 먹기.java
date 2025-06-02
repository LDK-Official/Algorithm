import java.io.*;
import java.util.*;

public class Main {
    static int[][] board = new int[5][5];
    static boolean[][] visited = new boolean[5][5];
    static int minMove = Integer.MAX_VALUE;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());

        int inital = board[startX][startY] == 1 ? 1 : 0;
        board[startX][startY] = -1;
        visited[startX][startY] = true;
        dfs(startX, startY, inital, 0);

        System.out.println(minMove == Integer.MAX_VALUE ? - 1: minMove);
    }

    static void dfs(int x, int y, int apple, int moves) {
        if (apple == 3) {
            minMove = Math.min(minMove, moves);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
                if (!visited[nx][ny] && board[nx][ny] != -1) {
                    visited[nx][ny] = true;
                    int original = board[nx][ny];
                    board[nx][ny] = -1;

                    if (original == 1) {
                        dfs(nx, ny, apple + 1, moves + 1);
                    } else {
                        dfs(nx, ny, apple, moves + 1);

                    }
                    board[nx][ny] = original;
                    visited[nx][ny] = false;
                }

            }
        }
    }
}