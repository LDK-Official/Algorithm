import java.io.*;
import java.util.*;

public class Main {
    static class Star {
        int x, y;
        Star(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); 
        int M = Integer.parseInt(st.nextToken()); 
        int L = Integer.parseInt(st.nextToken()); 
        int K = Integer.parseInt(st.nextToken()); 

        Star[] stars = new Star[K];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            stars[i] = new Star(x, y);
        }

        int maxCatch = 0;

        for (int i = 0; i < K; i++) {
            for (int j = 0; j < K; j++) {
                int tx = stars[i].x;
                int ty = stars[j].y;

                int count = 0;
                for (int k = 0; k < K; k++) {
                    if (stars[k].x >= tx && stars[k].x <= tx + L &&
                        stars[k].y >= ty && stars[k].y <= ty + L) {
                        count++;
                    }
                }

                maxCatch = Math.max(maxCatch, count);
            }
        }

        System.out.println(K - maxCatch);
    }
}