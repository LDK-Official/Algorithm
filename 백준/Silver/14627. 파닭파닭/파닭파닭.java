import java.io.*;
import java.util.*;

public class Main {
    static int S, M;
    static int[] greenOnions;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken()); // 파의 개수
        M = Integer.parseInt(st.nextToken()); // 닭의 수

        greenOnions = new int[S];
        int max = 0;

        for (int i = 0; i < S; i++) {
            greenOnions[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, greenOnions[i]);
        }

        int left = 1;
        int right = max;
        int answerLength = 0;

        // 이진 탐색으로 자를 최대 길이 구하기
        while (left <= right) {
            int mid = (left + right) / 2;

            int count = 0;
            for (int len : greenOnions) {
                count += len / mid;
            }

            if (count >= M) {
                answerLength = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // 잘라서 남은 파 총합 계산
        long total = 0;
        for (int len : greenOnions) {
            total += len;
        }

        System.out.println(total - (long) answerLength * M);
    }
}