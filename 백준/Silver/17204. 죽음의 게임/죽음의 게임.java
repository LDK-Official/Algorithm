import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 사람 수
        int K = Integer.parseInt(st.nextToken()); // 목표 번호

        int[] arr = new int[N]; // 각 사람이 가리키는 번호
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        boolean[] visited = new boolean[N];
        int cnt = 0;
        int cur = 0;

        while (true) {
            if (cur == K) {
                System.out.println(cnt);
                return;
            }
            if (visited[cur]) {
                System.out.println(-1);
                return;
            }
            visited[cur] = true;
            cur = arr[cur];
            cnt++;
        }
    }
}