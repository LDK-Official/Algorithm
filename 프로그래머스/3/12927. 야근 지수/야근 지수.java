import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int w : works) {
            pq.offer(w);
        }

        while (n > 0 && !pq.isEmpty()) {
            int cur = pq.poll();

            if (cur == 0) break;

            pq.offer(cur - 1);
            n--;
        }

        long fatigue = 0;
        while (!pq.isEmpty()) {
            long w = pq.poll();
            fatigue += w * w;
        }

        return fatigue;
    }
}