import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] cowLo = new int[11];
        boolean[] visited = new boolean[11];
        int count = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cow = Integer.parseInt(st.nextToken());
            int location = Integer.parseInt(st.nextToken());

            if (!visited[cow]) {
                visited[cow] = true;
                cowLo[cow] = location;
            } else {
                if (cowLo[cow] != location) {
                    count++;
                    cowLo[cow] = location;
                }
            }
        }

        System.out.println(count);
    }
}