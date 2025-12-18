import java.util.*;

class Solution {
    public int[] solution(int n, int s) {

        if (s < n) {
            return new int[]{-1};
        }

        int[] answer = new int[n];

        int base = s / n;
        int remain = s % n;

        Arrays.fill(answer, base);

        for (int i = n - 1; i >= n - remain; i--) {
            answer[i]++;
        }

        return answer;
    }
}