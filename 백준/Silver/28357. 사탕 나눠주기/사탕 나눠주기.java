import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        long[] scores = new long[N];
        long maxScore = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            scores[i] = Long.parseLong(st.nextToken());
            if (scores[i] > maxScore) {
                maxScore = scores[i];
            }
        }

        long low = 0;
        long high = maxScore;
        long answer = maxScore;

        while (low <= high) {
            long mid = (low + high) / 2;

            if (check(scores, mid, K)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(answer);
    }

    private static boolean check(long[] scores, long X, long K) {
        long totalCandy = 0;
        for (long score : scores) {
            if (score > X) {
                totalCandy += (score - X);
                if (totalCandy > K) return false;
            }
        }
        return totalCandy <= K;
    }
}