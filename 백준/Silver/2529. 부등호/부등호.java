import java.io.*;
import java.util.*;

public class Main {
    static int k;
    static char[] op;               // 부등호들
    static boolean[] used = new boolean[10];
    static String maxAns = null;    // 사전상 가장 큰 해
    static String minAns = null;    // 사전상 가장 작은 해

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine().trim());
        op = new char[k];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) op[i] = st.nextToken().charAt(0);

        // 최댓값 탐색: 9 -> 0
        Arrays.fill(used, false);
        dfsMax(0, new StringBuilder());

        // 최솟값 탐색: 0 -> 9
        Arrays.fill(used, false);
        dfsMin(0, new StringBuilder());

        System.out.println(maxAns);
        System.out.println(minAns);
    }

    // idx: 현재 채울 자리(0..k), sb: 지금까지 만든 숫자 문자열
    static boolean dfsMax(int idx, StringBuilder sb) {
        if (idx == k + 1) {
            maxAns = sb.toString();
            return true; // 첫 해를 찾으면 바로 종료
        }
        for (int d = 9; d >= 0; d--) {        // 큰 숫자부터 시도 → 최댓값 먼저 발견
            if (used[d]) continue;
            if (idx > 0) {
                int prev = sb.charAt(idx - 1) - '0';
                if (!ok(prev, d, op[idx - 1])) continue; // 부등호 불일치면 skip
            }
            used[d] = true;
            sb.append(d);
            if (dfsMax(idx + 1, sb)) return true;
            sb.deleteCharAt(sb.length() - 1);
            used[d] = false;
        }
        return false;
    }

    static boolean dfsMin(int idx, StringBuilder sb) {
        if (idx == k + 1) {
            minAns = sb.toString();
            return true; // 첫 해를 찾으면 바로 종료
        }
        for (int d = 0; d <= 9; d++) {        // 작은 숫자부터 시도 → 최솟값 먼저 발견
            if (used[d]) continue;
            if (idx > 0) {
                int prev = sb.charAt(idx - 1) - '0';
                if (!ok(prev, d, op[idx - 1])) continue;
            }
            used[d] = true;
            sb.append(d);
            if (dfsMin(idx + 1, sb)) return true;
            sb.deleteCharAt(sb.length() - 1);
            used[d] = false;
        }
        return false;
    }

    // 부등호 검사: a < b 또는 a > b
    static boolean ok(int a, int b, char sign) {
        if (sign == '<') return a < b;
        else return a > b;
    }
}