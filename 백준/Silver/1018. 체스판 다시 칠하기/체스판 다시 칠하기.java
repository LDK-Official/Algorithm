import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] board;
    static int minCount = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                minCount = Math.min(minCount, paint(i, j));
            }
        }
        System.out.println(minCount);
    }

    static int paint(int x, int y) {
        int wStart = 0;
        int bStart = 0;

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if ((i + j) % 2 == 0) {
                    if (board[i][j] != 'W') wStart++;
                    if (board[i][j] != 'B') bStart++;
                } else {
                    if (board[i][j] != 'B') wStart++;
                    if (board[i][j] != 'W') bStart++;
                }
            }
        }
        return Math.min(wStart, bStart);
    }
}