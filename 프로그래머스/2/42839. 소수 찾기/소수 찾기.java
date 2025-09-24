import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();
    boolean[] used;

    public int solution(String numbers) {
        used = new boolean[numbers.length()];
        dfs("", numbers);
        
        int count = 0;
        for (int num : set) {
            if (isPrime(num)) count++;
        }
        return count;
    }

    // 모든 순열 조합 생성
    private void dfs(String cur, String numbers) {
        if (!cur.isEmpty()) {
            set.add(Integer.parseInt(cur));
        }
        for (int i = 0; i < numbers.length(); i++) {
            if (!used[i]) {
                used[i] = true;
                dfs(cur + numbers.charAt(i), numbers);
                used[i] = false;
            }
        }
    }

    // 소수 판별
    private boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}