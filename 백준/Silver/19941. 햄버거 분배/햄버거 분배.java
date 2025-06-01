import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static char[] map;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // 길이
        K = Integer.parseInt(st.nextToken());   // 이동 가능 거리

        map = br.readLine().toCharArray();      // 입력 문자열 문자 배열로 변환
        visited = new boolean[N];               // 먹었는지 여부

        int count = 0;

        for (int i = 0; i < N; i++) {
            if (map[i] == 'H') {
                for (int j = Math.max(0, i - K); j <= Math.min(N - 1, i + K); j++) {
                    if (map[j] == 'P' && !visited[j]) {
                        visited[j] = true;
                        count++;
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }
}