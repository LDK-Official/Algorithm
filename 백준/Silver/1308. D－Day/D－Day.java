import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] today = br.readLine().split(" ");
        int y1 = Integer.parseInt(today[0]);
        int m1 = Integer.parseInt(today[1]);
        int d1 = Integer.parseInt(today[2]);

        String[] dday = br.readLine().split(" ");
        int y2 = Integer.parseInt(dday[0]);
        int m2 = Integer.parseInt(dday[1]);
        int d2 = Integer.parseInt(dday[2]);

        LocalDate now = LocalDate.of(y1, m1, d1);
        LocalDate future = LocalDate.of(y2, m2, d2);

        long day = ChronoUnit.DAYS.between(now, future);

        if (day >= 365243) {
            System.out.println("gg");
        } else {
            System.out.println("D-" + day);
        }
    }
}