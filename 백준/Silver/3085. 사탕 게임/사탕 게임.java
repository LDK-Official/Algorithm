import java.io.*;

public class Main {
    static int N;
    static char[][] board;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (j + 1 < N) {
                    swap(i, j, i, j + 1);
                    check(); 
                    swap(i, j, i, j + 1); 
                }

                if (i + 1 < N) {
                    swap(i, j, i + 1, j);
                    check(); 
                    swap(i, j, i + 1, j); 
                }
            }
        }

        System.out.println(max);
    }

    // 두 칸의 사탕 교환
    static void swap(int x1, int y1, int x2, int y2) {
        char temp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = temp;
    }

    // 가장 긴 연속된 사탕 수
    static void check() {
        for (int i = 0; i < N; i++) {
            int rowCount = 1;
            int colCount = 1;

            for (int j = 1; j < N; j++) {
                if (board[i][j] == board[i][j - 1]) {
                    rowCount++;
                } else {
                    rowCount = 1;
                }
                max = Math.max(max, rowCount);

                if (board[j][i] == board[j - 1][i]) {
                    colCount++;
                } else {
                    colCount = 1;
                }
                max = Math.max(max, colCount);
            }
        }
    }
}