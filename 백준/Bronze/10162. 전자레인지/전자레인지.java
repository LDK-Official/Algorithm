import java.io.*;

public class Main {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        int A = 300;
        int B = 60;
        int C = 10;

        int a = 0, b = 0, c = 0;

        a = T / A;
        T %= A;

        b = T / B;
        T %= B;

        c = T / C;
        T %= C;

        if (T != 0) {
            System.out.println(-1);
        } else {
            System.out.println(a + " " + b + " " + c);
        }

    }
}