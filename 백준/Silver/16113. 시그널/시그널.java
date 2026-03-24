import java.io.*;

public class Main {
    static boolean[][] grid;
    static int col;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        col = N / 5;
        grid = new boolean[5][col];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < col; j++) {
                if (s.charAt(i * col + j) == '#') {
                    grid[i][j] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < col; j++) {
            if (grid[0][j] || grid[1][j] || grid[2][j] || grid[3][j] || grid[4][j]) {

                if (j + 1 == col || (!grid[0][j+1] && !grid[1][j+1] && !grid[2][j+1] && !grid[3][j+1] && !grid[4][j+1])) {
                    sb.append(1);
                }
                else {
                    sb.append(getNumber(j));
                    j += 2;
                }
            }
        }
        System.out.println(sb.toString());
    }

    // 특징적인 위치를 찍어서 숫자 판별하기
    static int getNumber(int j) {
        // 0: 가운데가 비어있음
        if (!grid[1][j+1] && !grid[2][j+1] && !grid[3][j+1]) {
            // 0과 7 구분
            if (grid[4][j+1]) return 0;
            else return 7;
        }

        // 2, 3: 왼쪽 위(1,0)가 비어있음
        if (!grid[1][j]) {
            if (!grid[3][j]) return 3;
            else return 2;
        }

        // 4: 위쪽 가운데(0,1)가 비어있음 (문제의 4 모양 확인 필수)
        if (!grid[0][j+1]) return 4;

        // 5, 6: 오른쪽 위(1,2)가 비어있음
        if (!grid[1][j+2]) {
            if (!grid[3][j]) return 5;
            else return 6;
        }

        // 9: 왼쪽 아래(3,0)가 비어있음
        if (!grid[3][j]) return 9;

        // 8: 남은 건 8
        return 8;
    }
}