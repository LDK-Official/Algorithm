import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            boolean[] visited = new boolean[26];
            boolean groupWord = true;

            for (int j = 0; j < word.length(); j++) {
                char alpha = word.charAt(j);

                if (j > 0 && word.charAt(j - 1) != alpha && visited[alpha - 'a']) {
                    groupWord = false;
                    break;
                }
                visited[alpha - 'a'] = true;
            }
            if (groupWord) count++;
        }
        System.out.println(count);
    }
}
