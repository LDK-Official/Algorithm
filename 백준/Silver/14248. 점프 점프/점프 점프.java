import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[n];
        int[] P = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        int start = Integer.parseInt(br.readLine()) - 1;    // 다른 인덱스값이 0으로 시작이라 1을 뺴줌

        dfs(start, P, visited);

        int count = 0;
        for (boolean v : visited) {
            if (v) count++;
        }

        System.out.println(count);
    }

    static void dfs(int star, int[] P, boolean[] visited) {
        if (star < 0 || star >= P.length || visited[star]) return;

        visited[star] = true;

        int left = star - P[star];
        int right = star + P[star];

        if (left >= 0 && left < P.length && !visited[left]) {
            dfs(left, P, visited);
        }

        if (right >= 0 && right < P.length && !visited[right]) {
            dfs(right, P, visited);
        }
    }
   }