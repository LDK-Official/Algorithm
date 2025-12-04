import java.io.*;
import java.util.*;

public class Main {

    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n;
    static Point[] points;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            points = new Point[n + 2];
            visited = new boolean[n + 2];

            for (int i = 0; i < n + 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                points[i] = new Point(x, y);
            }

            if (bfs()) sb.append("happy\n");
            else sb.append("sad\n");
        }

        System.out.print(sb);
    }

    static boolean bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == n + 1) return true;

            for (int next = 0; next < n + 2; next++) {
                if (!visited[next] && distance(points[now], points[next]) <= 1000) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }

        return false;
    }

    static int distance(Point a, Point b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }
}