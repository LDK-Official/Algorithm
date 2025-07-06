import java.io.*;
import java.util.*;

public class Main {
    static int k;
    static int[] arr;
    static int[] comb = new int[6];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k == 0) break;

            arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0, sb);
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int start, int depth, StringBuilder sb) {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(comb[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i < k; i++) {
            comb[depth] = arr[i];
            dfs(i + 1, depth + 1, sb);
        }
    }
}