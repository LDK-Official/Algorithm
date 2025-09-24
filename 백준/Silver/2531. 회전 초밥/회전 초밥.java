import java.io.*;
import java.util.*;

public class Main {
    static int N, d, k, c;
    static int[] belt, cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 벨트 위 접시
        d = Integer.parseInt(st.nextToken()); // 초밥 수
        k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 수
        c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        belt = new int[N];
        for (int i = 0; i < N; i++) {
            belt[i] = Integer.parseInt(br.readLine());
        }

        cnt = new int[d + 1];
        int distinct = 0;

        for (int i = 0; i < k; i++) {
            int type = belt[i % N];
            if (cnt[type]++ == 0) distinct++;
        }

        int ans = distinct + (cnt[c] == 0 ? 1 : 0);

        for (int start = 1; start < N; start++) {
            int leftType = belt[start - 1];
            if (--cnt[leftType] == 0) distinct--;

            int rightIdx = (start + k - 1) % N;
            int rightType = belt[rightIdx];
            if (cnt[rightType]++ == 0) distinct++;

            int cur = distinct + (cnt[c] == 0 ? 1 : 0);
            ans = Math.max(ans, cur);
        }
        System.out.println(ans);
    }
}
