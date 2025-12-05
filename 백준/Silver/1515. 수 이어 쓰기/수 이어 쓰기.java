import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String T = br.readLine().trim();

        int idx = 0;
        int N = 0;

        while (idx < T.length()) {
            N++;

            String s = String.valueOf(N);

            for (int i = 0; i < s.length() && idx < T.length(); i++) {
                if (s.charAt(i) == T.charAt(idx)) {
                    idx++;
                }
            }
        }

        System.out.println(N);
    }
}