import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        char[][] sky = new char[H][W];
        int[][] result = new int[H][W];

        for (int i = 0; i < H; i++) {
            String line = br.readLine();
            for (int j = 0; j < W; j++) {
                sky[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < H; i++) {
            int time = -1; 
            for (int j = 0; j < W; j++) {
                if (sky[i][j] == 'c') {
                    time = 0; 
                    result[i][j] = 0;
                } else {
                    if (time != -1) {
                        time++; 
                        result[i][j] = time;
                    } else {
                        result[i][j] = -1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}