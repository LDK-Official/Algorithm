import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] inputNums;
    static int[] result;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        inputNums = new int[N];
        visited = new boolean[N];
        result = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inputNums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(inputNums);

        backtrack(0);
        System.out.print(sb.toString());
    }

    static void backtrack(int depth) {
        if (depth == M) {
            for (int val : result) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        int lastUsed = -1;

        for (int i = 0; i < N; i++) {
            if (!visited[i] && inputNums[i] != lastUsed) {
                visited[i] = true;
                result[depth] = inputNums[i];
                lastUsed = inputNums[i];
                
                backtrack(depth + 1);
                
                visited[i] = false;
            }
        }
    }
}