import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static char[] target;

    static void toggle(char[] arr, int i) {
        for (int k = i - 1; k <= i + 1; k++) {
            if (0 <= k && k < N) {
                arr[k] = (arr[k] == '0') ? '1' : '0';
            }
        }
    }

    static int solve(char[] start, boolean firstPress) {
        char[] cur = start.clone();
        int cnt = 0;

        if (firstPress) {
            toggle(cur, 0);
            cnt++;
        }

        for (int i = 1; i < N; i++) {
            if (cur[i - 1] != target[i - 1]) {
                toggle(cur, i);
                cnt++;
            }
        }

        if (Arrays.equals(cur, target)) return cnt;
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine().trim());
        char[] start = br.readLine().trim().toCharArray();
        target = br.readLine().trim().toCharArray();

        int a = solve(start, false); 
        int b = solve(start, true);  

        int ans = Math.min(a, b);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
}