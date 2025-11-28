import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean isHansu(int x) {

        if (x < 100) return true;

        int a = x / 100;
        int b = (x / 10) % 10;
        int c = x % 10;

        return (a - b) == (b - c);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0;

        for (int i = 1; i <= N; i++) {
            if (isHansu(i)) {
                count++;
            }
        }

        System.out.println(count);
    }
}