import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] N1 = new int[N];
        for (int i = 0; i < N; i++) {
            N1[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] M1 = new int[M];
        for (int i = 0; i < M; i++) {
            M1[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(N1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            if (binarySearch(N1, M1[i])) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }
        System.out.println(sb);
    }

    static boolean binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) return true;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}