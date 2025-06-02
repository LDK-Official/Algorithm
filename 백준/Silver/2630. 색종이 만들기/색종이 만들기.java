import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] paper;
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, N);  // (0,0)부터 전체 영역 탐색

        System.out.println(white);
        System.out.println(blue);
    }

    // (x,y)부터 size 크기의 영역 탐색
    static void divide(int x, int y, int size) {
        if (check(x, y, size)) {  // 모든 색이 같으면
            if (paper[x][y] == 0) white++;
            else blue++;
            return;
        }

        int newSize = size / 2;
        divide(x, y, newSize);                   // 좌상
        divide(x, y + newSize, newSize);         // 우상
        divide(x + newSize, y, newSize);         // 좌하
        divide(x + newSize, y + newSize, newSize); // 우하
    }

    // 현재 영역의 모든 색이 같은지 검사
    static boolean check(int x, int y, int size) {
        int color = paper[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (paper[i][j] != color) return false;
            }
        }
        return true;
    }
}