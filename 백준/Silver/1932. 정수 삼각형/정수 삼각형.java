import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] triangle = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // DP 진행
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    triangle[i][j] += triangle[i - 1][j]; // 왼쪽 위
                } else if (j == i) {
                    triangle[i][j] += triangle[i - 1][j - 1]; // 오른쪽 위
                } else {
                    triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]); // 둘 중 큰 값
                }
            }
        }

        // 마지막 줄에서 최댓값 찾기
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, triangle[n - 1][i]);
        }

        System.out.println(max);
    }
}