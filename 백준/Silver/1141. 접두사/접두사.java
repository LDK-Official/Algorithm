import java.io.*;
import java.util.*;

public class Main {

    static class TrieNode {
        TrieNode[] child = new TrieNode[26];
        boolean isEnd;
    }

    static TrieNode root = new TrieNode();

    static void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (cur.child[idx] == null) {
                cur.child[idx] = new TrieNode();
            }
            cur = cur.child[idx];
        }
        cur.isEnd = true;
    }

    static int dfs(TrieNode node) {
        boolean hasChild = false;
        int sum = 0;

        for (int i = 0; i < 26; i++) {
            if (node.child[i] != null) {
                hasChild = true;
                sum += dfs(node.child[i]);
            }
        }

        if (!hasChild && node.isEnd) {
            return 1;
        }

        return sum;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        for (String word : set) {
            insert(word);
        }

        System.out.println(dfs(root));
    }
}