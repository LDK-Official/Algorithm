import java.util.*;

class Solution {

    private boolean diffOne(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
            if (diff > 1) return false; 
        }
        return diff == 1;
    }

    public int solution(String begin, String target, String[] words) {

        boolean exist = false;
        for (String w : words) {
            if (w.equals(target)) {
                exist = true;
                break;
            }
        }
        if (!exist) return 0;

        Queue<String> q = new LinkedList<>();
        Queue<Integer> dist = new LinkedList<>();
        boolean[] visited = new boolean[words.length];

        q.offer(begin);
        dist.offer(0);

        while (!q.isEmpty()) {
            String cur = q.poll();
            int step = dist.poll();

            if (cur.equals(target)) return step;

            for (int i = 0; i < words.length; i++) {
                if (visited[i]) continue;

                if (diffOne(cur, words[i])) {
                    visited[i] = true;
                    q.offer(words[i]);
                    dist.offer(step + 1);
                }
            }
        }

        return 0;
    }
}