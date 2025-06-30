import java.io.*;
import java.util.*;


// 1초일떄 초기 상태 -> 2초일때 전체 폭탄 -> 3초일떄 기존 폭탄 터짐 -> 4초일떄 전체 폭탄 -> 5초일떄 폭탄 터짐
// 짝수초는 전체 폭탄, 홀수는 3초 5초 패턴 반복
public class Main {
    static int R, C, N;
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String row = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = row.charAt(j);
            }
        }

        if (N == 1) {
            print(map); // 1초면 아무 변화 없이 출력
        } else if (N % 2 == 0) {
            // 짝수초면 전체 폭탄
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    System.out.print('O');
                }
                System.out.println();
            }
        } else {
            // 3초 상태 먼저 만들기
            char[][] after3 = explode(map);
            if (N % 4 == 3) {
                print(after3);
            } else {
                // 5초 상태
                char[][] after5 = explode(after3);
                print(after5);
            }
        }
    }

    // 폭탄 터트리기
    static char[][] explode(char[][] before) {
        char[][] result = new char[R][C];
        for (int i = 0; i < R; i++) {
            Arrays.fill(result[i], 'O');
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (before[i][j] == 'O') {
                    result[i][j] = '.';
                    for (int d = 0; d < 4; d++) {
                        int ni = i + dx[d];
                        int nj = j + dy[d];
                        if (ni >= 0 && ni < R && nj >= 0 && nj < C) {
                            result[ni][nj] = '.';
                        }
                    }
                }
            }
        }

        return result;
    }

    static void print(char[][] board) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    }