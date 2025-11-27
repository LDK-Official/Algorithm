import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long S = Long.parseLong(br.readLine());

        long sum = 0;
        long count = 0;

        long i = 1;
        while (true) {
            if (sum + i > S) break;

            sum += i;
            count++;
            i++;
        }

        System.out.println(count);
    }
}