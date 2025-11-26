import java.io.*;
import java.util.*;

public class Main {
    static int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int g = arr[1] - arr[0];
        for (int i = 2; i < N; i++) {
            g = gcd(g, arr[i] - arr[i - 1]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= Math.sqrt(g); i++) {
            if (g % i == 0) {
                sb.append(i).append(" ");
                if (i != g / i) sb.append(g / i).append(" ");
            }
        }

        sb.append(g);

        String[] res = sb.toString().trim().split(" ");
        Arrays.sort(res, (a, b) -> Integer.parseInt(a) - Integer.parseInt(b));

        for (String s : res) System.out.print(s + " ");
    }
}