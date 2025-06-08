import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] count1 = new int[N];
        int[] result = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            count1[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int count = count1[i];

            for (int j = 0; j < N; j++) {
                if (result[j] == 0) {
                    if (count == 0) {
                        result[j] = i + 1;
                        break;
                    }
                    count--;
                }
            }

        }
        for (int i = 0; i < N; i++) {
            System.out.print(result[i] + " ");
        }
    }
}