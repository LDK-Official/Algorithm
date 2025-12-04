import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String L = st.nextToken();
        String R = st.nextToken();

        if (L.length() != R.length()) {
            System.out.println(0);
            return;
        }

        int count = 0;

        for (int i = 0; i < L.length(); i++) {
            char lc = L.charAt(i);
            char rc = R.charAt(i);

            if (lc != rc) {
                break;
            }

            if (lc == '8') {
                count++;
            }
        }

        System.out.println(count);
    }
}