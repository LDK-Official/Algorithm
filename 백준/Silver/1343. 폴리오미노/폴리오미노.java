import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String board = br.readLine();

        String[] parts = board.split("\\.", -1);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < parts.length; i++) {
            String part = parts[i];
            int len = part.length();

            if (len % 2 != 0) {
                System.out.println(-1);
                return;
            }

            String converted = "AAAA".repeat(len / 4) + "BB".repeat((len % 4) / 2);
            sb.append(converted);

            if (i != parts.length - 1) sb.append(".");
        }
        System.out.println(sb);
    }
}