import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            int[] alpha = new int[26];

            for (int ii = 0; ii < line.length(); ii++) {
                char c = line.charAt(ii);
                if (c >= 'a' && c <= 'z') {
                    alpha[c - 'a']++;
                }
            }

            int max = 0;
            char result = '?';
            boolean duplicate = false;

            for (int iii = 0; iii < 26; iii++) {
                if (alpha[iii] > max) {
                    max = alpha[iii];
                    result = (char)(iii + 'a');
                    duplicate = false;
                } else if (alpha[iii] == max) {
                    duplicate = true;
                }
            }
            if (duplicate) {
                sb.append("?").append("\n");
            } else {
                sb.append(result).append("\n");
            }
        }
        System.out.println(sb);
    }
}