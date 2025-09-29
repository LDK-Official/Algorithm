import java.io.*;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        String first = br.readLine().trim();

        int[] base = count(first);

        int similar = 0;
        for (int i = 1; i < N; i++) {
            String w = br.readLine().trim();

            if (Math.abs(first.length() - w.length()) >= 2) continue;

            int[] diff = Arrays.copyOf(base, 26);
            for (int k = 0; k < w.length(); k++) {
                diff[w.charAt(k) - 'A']--;
            }

            int plus = 0, minus = 0;
            for (int v : diff) {
                if (v > 0) plus += v;
                else minus += -v;
            }

            if (plus <= 1 && minus <= 1) similar++;
        }

        System.out.println(similar);
    }

    private static int[] count(String s) {
        int[] c = new int[26];
        for (int i = 0; i < s.length(); i++) c[s.charAt(i) - 'A']++;
        return c;
    }
}