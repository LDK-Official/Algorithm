import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new LinkedList<>();

        for (int i = N; i >= 1; i--) {
            dq.addFirst(i);
            for (int j = 0; j < i; j++) {
                if (dq.size() > 1) {
                    dq.addFirst(dq.removeLast());
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int x : dq) sb.append(x).append(" ");
        System.out.println(sb);
    }
}