import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        int min = 256;
        int max = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (min > map[i][j]) min = map[i][j];
                if (max < map[i][j]) max = map[i][j];
            }
        }

        int resultTime = Integer.MAX_VALUE;
        int resultHeight = -1;

        for (int h = min; h <= max; h++) {
            int time = 0;
            int inventory = B;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int diff = map[i][j] - h;

                    if (diff > 0) {
                        time += (diff * 2);
                        inventory += diff;
                    } else if (diff < 0) {
                        time += (Math.abs(diff) * 1);
                        inventory -= Math.abs(diff);
                    }
                }
            }

            if (inventory >= 0) {
                if (time <= resultTime) {
                    resultTime = time;
                    resultHeight = h;
                }
            }
        }

        System.out.println(resultTime + " " + resultHeight);
    }
}