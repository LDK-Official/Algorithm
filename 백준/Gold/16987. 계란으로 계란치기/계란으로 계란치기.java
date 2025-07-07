import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] S; // 내구도
    static int[] W; // 무게
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N];
        W = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            S[i] = Integer.parseInt(st.nextToken());
            W[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        System.out.println(max);
    }

    static void dfs(int idx) {
        if (idx == N) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if (S[i] <= 0) cnt++;
            }
            max = Math.max(max, cnt);
            return;
        }

        if (S[idx] <= 0) {
            dfs(idx + 1);
            return;
        }

        boolean hit = false;
        for (int i = 0; i < N; i++) {
            if (i == idx || S[i] <= 0) continue;
            hit = true;

            S[idx] -= W[i];
            S[i] -= W[idx];

            dfs(idx + 1);

            S[idx] += W[i];
            S[i] += W[idx];
        }

        if (!hit) dfs(idx + 1);
    }
}