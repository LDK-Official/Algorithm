import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int test = Integer.parseInt(st.nextToken());
            int[] students = new int[20];

            for (int j = 0; j < 20; j++) {
                students[j] = Integer.parseInt(st.nextToken());
            }

            int count = 0;
            List<Integer> line = new ArrayList<>();

            for (int x = 0; x < 20; x++) {
                int student = students[x];

                int pos = 0;
                while (pos < line.size() && line.get(pos) < student) {
                    pos++;
                }

                count += line.size() - pos;

                line.add(pos, student);
            }

            System.out.println(test + " " + count);
        }
    }
}