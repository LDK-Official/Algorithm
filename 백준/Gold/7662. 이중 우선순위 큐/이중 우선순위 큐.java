import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int value, id;
        Node(int value, int id) {
            this.value = value;
            this.id = id;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {

            int k = Integer.parseInt(br.readLine());

            PriorityQueue<Node> maxPQ = new PriorityQueue<>(
                    (a, b) -> Integer.compare(b.value, a.value)
            );

            PriorityQueue<Node> minPQ = new PriorityQueue<>(
                    (a, b) -> Integer.compare(a.value, b.value)
            );

            boolean[] visited = new boolean[k];

            int id = 0;

            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (cmd.equals("I")) {
                    maxPQ.add(new Node(num, id));
                    minPQ.add(new Node(num, id));
                    visited[id] = true;
                    id++;

                } else {
                    if (num == 1) {

                        while (!maxPQ.isEmpty() && !visited[maxPQ.peek().id]) {
                            maxPQ.poll();
                        }
                        if (!maxPQ.isEmpty()) {
                            visited[maxPQ.peek().id] = false;
                            maxPQ.poll();
                        }
                    } else {
                        while (!minPQ.isEmpty() && !visited[minPQ.peek().id]) {
                            minPQ.poll();
                        }
                        if (!minPQ.isEmpty()) {
                            visited[minPQ.peek().id] = false;
                            minPQ.poll();
                        }
                    }
                }
            }

            while (!maxPQ.isEmpty() && !visited[maxPQ.peek().id]) {
                maxPQ.poll();
            }
            while (!minPQ.isEmpty() && !visited[minPQ.peek().id]) {
                minPQ.poll();
            }

            if (maxPQ.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                sb.append(maxPQ.peek().value).append(" ")
                  .append(minPQ.peek().value).append("\n");
            }
        }

        System.out.print(sb);
    }
}