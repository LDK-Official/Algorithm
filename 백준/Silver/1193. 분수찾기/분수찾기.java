import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        int count = 0;
        int N = 1;

        while (true) {
            for (int i = 0; i < N; i++) {
                int a = (N % 2 == 0) ? (i + 1) : (N - i);
                int b = (N % 2 == 0) ? (N - i) : (i + 1);
                count++;

                if (count == X) {
                    System.out.println(a + "/" + b);
                    return;
                }
            }
            N++;
        }
    }
}
