import java.io.*;
import java.util.*;

public class Main {
    static int N, K, answer = 0;
    static int[] kits;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        kits = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            kits[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 500);

        System.out.println(answer);
    }

    static void dfs(int day, int muscle) {
        if (day == N) {
            answer++;
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                int next = muscle + kits[i] - K;
                if (next >= 500) {
                    visited[i] = true;
                    dfs(day + 1, next);
                    visited[i] = false;
                }
            }
        }
    }
}