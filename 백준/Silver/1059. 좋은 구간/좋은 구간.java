import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        int[] S = new int[L];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < L; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        int n = Integer.parseInt(br.readLine());
        Arrays.sort(S);

        for (int s : S) {
            if (s == n) {
                System.out.println(0);
                return;
            }
        }

        int left = 0;   
        int right = 1001; 

        for (int s : S) {
            if (s < n) left = s;
            else if (s > n && s < right) right = s;
        }

        int count = (n - left) * (right - n) - 1;

        System.out.println(count);
    }
}