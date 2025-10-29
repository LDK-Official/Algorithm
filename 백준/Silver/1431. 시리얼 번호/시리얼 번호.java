import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] guitars = new String[N];

        for (int i = 0; i < N; i++) {
            guitars[i] = br.readLine().trim();
        }

        Arrays.sort(guitars, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                if (a.length() != b.length()) {
                    return a.length() - b.length();
                }

                int sumA = getDigitSum(a);
                int sumB = getDigitSum(b);
                if (sumA != sumB) {
                    return sumA - sumB;
                }

                return a.compareTo(b);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String s : guitars) {
            sb.append(s).append("\n");
        }
        System.out.print(sb);
    }

    private static int getDigitSum(String s) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                sum += c - '0';
            }
        }
        return sum;
    }
}