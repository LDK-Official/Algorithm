import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        int count = 0;
        int turn = 0;
        int round = 1;

        while (true) {
            int[] pattern = {0, 1, 0, 1};
            for (int i = 0; i < pattern.length; i++) {
                if (pattern[i] == target) count++;
                if (count == T) {
                    System.out.println(turn);
                    return;
                }
                turn = (turn + 1) % A;
            }
            for (int i = 0; i < round + 1; i++) {
                if (0 == target) count++;
                if (count == T) {
                    System.out.println(turn);
                    return;
                }
                turn = (turn + 1) % A;
            }
            for (int i = 0; i < round + 1; i++) {
                if (1 == target) count++;
                if (count == T) {
                    System.out.println(turn);
                    return;
                }
                turn = (turn + 1) % A;
            }
            round++;
        }
    }
}