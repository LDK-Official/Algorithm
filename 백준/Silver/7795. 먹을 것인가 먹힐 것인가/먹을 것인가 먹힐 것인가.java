import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] A = new int[N];
            int[] B = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(B);

            int result = 0;
            for (int i = 0; i < N; i++) {
                result += counter(B, A[i]);
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    static int counter(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] < target) {
                answer = mid + 1;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }
}