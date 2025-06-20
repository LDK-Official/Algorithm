import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   // 타워버거 먹는시간
        int m = Integer.parseInt(st.nextToken());   // 불고기버거 먹는시간
        int t = Integer.parseInt(st.nextToken());   // 총 먹는 시간

        int maxBurger = 0;
        int colaTime = t;

        for (int i = 0; i <= t / n; i++) {
            int tower = i * n;
            int remain = t - tower;

            int j = remain / m;
            int bulgogi = j * m;

            int total = tower + bulgogi;

            int cola = t - total;
            int totalBurger = i + j;

            if (cola < colaTime) {
                colaTime = cola;
                maxBurger = totalBurger;
            } else if (cola == colaTime && totalBurger > maxBurger) {
                maxBurger = totalBurger;
            }
        }
        System.out.println(maxBurger + " " + colaTime);
    }
}