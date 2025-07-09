import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[][] map;
    static int[] location;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        location = new int[K];
        map = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
        }

        search(0, 0);
        System.out.println(result);
    }

    static void search(int depth, int start) {
        if (depth == K) {
            int far = 0;
            for (int i = 0; i < N; i++) {
                int near = Integer.MAX_VALUE;
                for (int j = 0; j < K; j++) {
                    int idx = location[j];
                    int dist = Math.abs(map[i][0] - map[idx][0]) + Math.abs(map[i][1] - map[idx][1]);
                    if (dist < near) near = dist;
                }
                if (near > far) far = near;
            }
            if (far < result) result = far;
            return;
        }
        for (int i = start; i < N; i++) {
            location[depth] = i;
            search(depth + 1, i + 1);
        }
    }
}