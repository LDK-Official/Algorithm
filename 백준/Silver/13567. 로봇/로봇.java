import java.io.*;
import java.util.*;

public class Main {
    static int M, n;
    static int[] dx = {1, 0, -1, 0}; // 동, 남, 서, 북
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        int x = 0;
        int y = 0;
        int dir = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            if (cmd.equals("TURN")) {
                if (num == 0) {
                    dir = (dir + 3) % 4; // 왼쪽 90도
                } else {
                    dir = (dir + 1) % 4; // 오른쪽 90도
                }
            } else if (cmd.equals("MOVE")) {
                int nx = x + dx[dir] * num;
                int ny = y + dy[dir] * num;

                if (nx < 0 || nx > M || ny < 0 || ny > M) {
                    System.out.println(-1);
                    return;
                }
                x = nx;
                y = ny;
            }
        }
        System.out.println(x + " " + y);
    }
}