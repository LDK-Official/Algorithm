import java.io.*;
import java.util.*;

public class Main {
    static char[][] map = new char[12][6];
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean isExploded;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 12; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int totalChains = 0;

        while (true) {
            isExploded = false;
            visited = new boolean[12][6];

            // 1. 전체 맵을 돌며 터뜨릴 수 있는 뿌요 그룹 찾기
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (map[i][j] != '.' && !visited[i][j]) {
                        bfs(i, j, map[i][j]);
                    }
                }
            }

            // 2. 이번 라운드에 터진 게 없다면 연쇄 종료
            if (!isExploded) break;

            // 3. 터진 자리를 메우기 위해 중력 작용
            applyGravity();
            totalChains++;
        }

        System.out.println(totalChains);
    }

    // 같은 색 뿌요가 4개 이상인지 확인하고 터뜨리는 함수
    static void bfs(int r, int c, char color) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> puyoGroup = new ArrayList<>(); // 터질 후보군 저장

        queue.add(new int[]{r, c});
        puyoGroup.add(new int[]{r, c});
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = curr[0] + dx[i];
                int nc = curr[1] + dy[i];

                if (nr >= 0 && nr < 12 && nc >= 0 && nc < 6) {
                    if (!visited[nr][nc] && map[nr][nc] == color) {
                        visited[nr][nc] = true;
                        queue.add(new int[]{nr, nc});
                        puyoGroup.add(new int[]{nr, nc});
                    }
                }
            }
        }

        // 4개 이상 모였다면 실제 폭발 처리
        if (puyoGroup.size() >= 4) {
            isExploded = true;
            for (int[] pos : puyoGroup) {
                map[pos[0]][pos[1]] = '.';
            }
        }
    }

    // 중력 로직: 각 열마다 아래에서부터 빈칸을 채워 넣음
    static void applyGravity() {
        for (int j = 0; j < 6; j++) {
            Stack<Character> stack = new Stack<>();
            // 아래에서 위로 올라가며 뿌요만 수집
            for (int i = 0; i < 12; i++) {
                if (map[i][j] != '.') {
                    stack.push(map[i][j]);
                    map[i][j] = '.'; // 일단 다 비움
                }
            }
            
            // 아래(11번 행)부터 다시 채우기
            int rowIdx = 11;
            while (!stack.isEmpty()) {
                map[rowIdx--][j] = stack.pop();
            }
        }
    }
}