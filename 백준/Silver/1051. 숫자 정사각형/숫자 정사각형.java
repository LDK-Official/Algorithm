import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int max = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 1; (i + k < N) && (j + k < M); k++) {
                    int a = map[i][j];
                    int b = map[i][j + k];
                    int c = map[i + k][j];
                    int d = map[i + k][j + k];

                    if (a == b && b == c && c == d) {
                        int area = (k + 1) * (k + 1);
                        if (area > max) max = area;
                    }
                }
            }
        }
        System.out.println(max);
    }
}