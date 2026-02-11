import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        Map<Character, Integer> minKeys = new HashMap<>();

        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                int count = i + 1;

                if (!minKeys.containsKey(c) || count < minKeys.get(c)) {
                    minKeys.put(c, count);
                }
            }
        }

        int[] answer = new int[targets.length];

        for (int i = 0; i < targets.length; i++) {
            int total = 0;
            String target = targets[i];

            for (int j = 0; j < target.length(); j++) {
                char c = target.charAt(j);

                if (!minKeys.containsKey(c)) {
                    total = -1;
                    break;
                }
                total += minKeys.get(c);
            }
            answer[i] = total;
        }

        return answer;
    }
}