import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] state = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            state[i] = Integer.parseInt(st.nextToken());
        }

        int student = Integer.parseInt(br.readLine());
        for (int i = 0; i < student; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                for (int k = num - 1; k < N; k += num) {
                    state[k] = 1 - state[k];
                }
            } else {
                int idx = num - 1;

                state[idx] = 1 - state[idx];

                int left = idx - 1;
                int right = idx + 1;

                while (left >= 0 && right < N && state[left] == state[right]) {
                    state[left] = 1 - state[left];
                    state[right] = 1 - state[right];
                    left--;
                    right++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(state[i]).append(" ");
            if ((i + 1) % 20 == 0) sb.append("\n");
        }

        System.out.println(sb);
    }
}