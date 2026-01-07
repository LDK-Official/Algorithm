import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arr = br.readLine();

            Deque<Integer> deque = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(arr, "[],");

            while (st.hasMoreTokens()) {
                deque.add(Integer.parseInt(st.nextToken()));
            }

            boolean isRight = true;
            boolean isError = false;

            for (char command : p.toCharArray()) {
                if (command == 'R') {
                    isRight = !isRight;
                } else {
                    if (deque.isEmpty()) {
                        isError = true;
                        break;
                    }
                    if (isRight) deque.pollFirst();
                    else deque.pollLast();
                }
            }

            if (isError) {
                sb.append("error\n");
            } else {
                makeString(deque, isRight, sb);
            }
        }
        System.out.println(sb);
    }

    public static void makeString(Deque<Integer> deque, boolean isRight, StringBuilder sb) {
        sb.append("[");
        if (!deque.isEmpty()) {
            if (isRight) {
                sb.append(deque.pollFirst());
                while (!deque.isEmpty()) {
                    sb.append(",").append(deque.pollFirst());
                }
            } else {
                sb.append(deque.pollLast());
                while (!deque.isEmpty()) {
                    sb.append(",").append(deque.pollLast());
                }
            }
        }

        sb.append("]\n");
    }
}

