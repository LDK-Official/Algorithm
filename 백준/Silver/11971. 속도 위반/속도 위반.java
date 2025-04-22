import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 제한 속도 구간 수
        int M = Integer.parseInt(st.nextToken());   // 실제 속도 구간 수

        int[] limit = new int[100];
        int[] actual = new int[100];

        int idx = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());

            for (int j = 0; j < length; j++) {
                limit[idx++] = speed;
            }
        }

        idx = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());

            for (int j = 0; j < length; j++) {
                actual[idx++] = speed;
            }
        }

        int max = 0;
        for (int i = 0; i < 100; i++) {
            if (actual[i] > limit[i]) {
                max = Math.max(max, actual[i] - limit[i]);
            }
        }
        System.out.println(max);
    }
}