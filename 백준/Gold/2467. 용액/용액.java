import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N]; 

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = N - 1;

        long minSum = Long.MAX_VALUE; 
        int ans1 = 0, ans2 = 0; 

        while (left < right) {
            long sum = (long) arr[left] + arr[right];

            if (Math.abs(sum) < minSum) {
                minSum = Math.abs(sum);
                ans1 = arr[left];
                ans2 = arr[right];
            }

            if (sum > 0) {
                right--;
            }
            else {
                left++;
            }
        }

        System.out.println(ans1 + " " + ans2);
    }
}