import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();

        int[] card = new int[10];

        int count = 0;

        for (int i = 0; i < N.length(); i++) {
            int num = N.charAt(i) - '0';

            if (num == 6 || num == 9) {
                if (card[6] <= card[9]) {
                    card[6]++;
                } else {
                    card[9]++;
                }
            } else {
                card[num]++;
            }
        }

        for (int j = 0; j < 10; j++) {
            count = Math.max(count, card[j]);
        }
        System.out.println(count);
    }
}