import java.io.*;
import java.util.*;
class Main {
public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long ab = Long.parseLong(st.nextToken());
        long ac = Long.parseLong(st.nextToken());

        long g = gcd(ab, ac);

        System.out.println((ab / g) + ":" + (ac / g));
    }

    public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}