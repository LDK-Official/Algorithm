import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int answer = 5;
        
        for (int i = 0; i < N; i++) {
            int leftValue = arr[i];
            int rightValue = leftValue + 4;

            int count = 0;
            for (int j = i; j < N; j++) {
                if (arr[j] <= rightValue) {
                    count++;
                } else {
                    break;
                }
            }

            int need = 5 - count;

            if (need < answer) {
                answer = need;
            }
        }

        System.out.println(answer);
    }
}