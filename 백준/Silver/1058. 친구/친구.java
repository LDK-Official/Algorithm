import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[][] friendMap = new char[N][N];
        for (int i = 0; i < N; i++) {
            friendMap[i] = br.readLine().toCharArray();
        }

        int maxFriends = 0;

        for (int i = 0; i < N; i++) {
            boolean[] isFriend = new boolean[N];

            for (int j = 0; j < N; j++) {
                if (i == j) continue;

                // 직접 친구면 추가
                if (friendMap[i][j] == 'Y') {
                    isFriend[j] = true;
                } else {
                    // j와 i가 직접 친구는 아니지만
                    // j와 i 사이에 친구의 친구가 있는지 확인
                    for (int k = 0; k < N; k++) {
                        if (friendMap[i][k] == 'Y' && friendMap[k][j] == 'Y') {
                            isFriend[j] = true;
                            break;
                        }
                    }
                }
            }

            int count = 0;
            for (boolean f : isFriend) {
                if (f) count++;
            }

            maxFriends = Math.max(maxFriends, count);
        }

        System.out.println(maxFriends);
    }
}
