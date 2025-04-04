import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input;
        while ((input = br.readLine()) != null) {
            sb.append(input);
        }

        String text = sb.toString();
        int[] arr = new int[26];

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c >= 'a' && c <= 'z') {
                arr[c - 'a']++;
            }
        }

        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] > count) {
                count = arr[i];
            }
        }

        for (int i = 0; i < 26; i++) {
            if (arr[i] == count) {
                System.out.print((char) (i + 'a'));
            }
        }

    }
}