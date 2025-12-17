import java.io.*;
import java.util.*;

public class Main {

    static int R, C;
    static char[][] map;
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};

    static char[][] explode(char[][] cur) {
        char[][] next = new char[R][C];

        for (int i = 0; i < R; i++) {
            Arrays.fill(next[i], 'O');
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (cur[i][j] == 'O') {
                    next[i][j] = '.';
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                            next[nx][ny] = '.';
                        }
                    }
                }
            }
        }
        return next;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        if (N == 1) {
            print(map);
            return;
        }

        if (N % 2 == 0) {
            char[][] full = new char[R][C];
            for (int i = 0; i < R; i++) {
                Arrays.fill(full[i], 'O');
            }
            print(full);
            return;
        }

        char[][] first = explode(map);

        if (N % 4 == 3) {
            print(first);
            return;
        }

        char[][] second = explode(first);
        print(second);
    }

    static void print(char[][] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            sb.append(arr[i]).append('\n');
        }
        System.out.print(sb);
    }
}