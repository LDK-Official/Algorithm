import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();

        if (N > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
        }

        if (N == P && score <= list.get(list.size() - 1)) {
            System.out.println(-1);
            return;
        }

        int rank = 1;
        for (int s : list) {
            if (s > score) rank++;
            else break;
        }
        System.out.println(rank);
    }
}
