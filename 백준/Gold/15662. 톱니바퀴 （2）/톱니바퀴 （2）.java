import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static int[][] wheel;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        wheel = new int[T][8];

        for (int i = 0; i < T; i++) {
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                wheel[i][j] = s.charAt(j) - '0';
            }
        }

        int K = Integer.parseInt(br.readLine());

        for (int k = 0; k < K; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());

            int[] dirs = new int[T];
            dirs[num] = dir;

            for (int i = num - 1; i >= 0; i--) {
                if (wheel[i][2] != wheel[i + 1][6]) {
                    dirs[i] = -dirs[i + 1];
                } else break;
            }

            for (int i = num + 1; i < T; i++) {
                if (wheel[i][6] != wheel[i - 1][2]) {
                    dirs[i] = -dirs[i - 1];
                } else break;
            }

            for (int i = 0; i < T; i++) {
                if (dirs[i] == 0) continue;
                rotate(i, dirs[i]);
            }
        }
        int cnt = 0;
        for (int i = 0; i < T; i++) {
            if (wheel[i][0] == 1) cnt++;
        }
        System.out.println(cnt);
    }
    static void rotate(int idx, int dir) {
        if (dir == 1) {
            int temp = wheel[idx][7];
            for (int i = 7; i > 0; i--) {
                wheel[idx][i] = wheel[idx][i - 1];
            }
            wheel[idx][0] = temp;
        } else { // 반시계방향: 맨 앞을 뒤로
            int temp = wheel[idx][0];
            for (int i = 0; i < 7; i++) {
                wheel[idx][i] = wheel[idx][i + 1];
            }
            wheel[idx][7] = temp;
        }
    }
}