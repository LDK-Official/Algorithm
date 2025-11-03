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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            Point[] p = new Point[4];


            for (int i = 0; i < 4; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                p[i] = new Point(x, y);
            }


            List<Long> dist = new ArrayList<>();

            for (int i = 0; i < 4; i++) {
                for (int j = i + 1; j < 4; j++) {
                    dist.add(squared(p[i], p[j]));
                }
            }


            Collections.sort(dist);

     
            long side = dist.get(0);
            long diag = dist.get(5); 

            if (
                side > 0 && 
                dist.get(0).equals(dist.get(1)) &&
                dist.get(1).equals(dist.get(2)) &&
                dist.get(2).equals(dist.get(3)) && 
                dist.get(4).equals(dist.get(5)) && 
                diag == 2 * side 
            ) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }

        System.out.print(sb);
    }

    static long squared(Point a, Point b) {
        long dx = a.x - b.x;
        long dy = a.y - b.y;
        return dx * dx + dy * dy;
    }
}