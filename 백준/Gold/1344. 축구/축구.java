import java.io.*;
import java.util.*;

public class Main {

    static final int[] PRIMES = {2, 3, 5, 7, 11, 13, 17};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double pA = Integer.parseInt(br.readLine()) / 100.0;
        double pB = Integer.parseInt(br.readLine()) / 100.0;

        double[][] comb = new double[19][19];
        for (int n = 0; n <= 18; n++) {
            comb[n][0] = comb[n][n] = 1.0;
            for (int r = 1; r < n; r++) {
                comb[n][r] = comb[n - 1][r - 1] + comb[n - 1][r];
            }
        }

        double PA = primeGoalProbability(pA, comb);

        double PB = primeGoalProbability(pB, comb);

        double ans = 1.0 - (1.0 - PA) * (1.0 - PB);

        System.out.println(ans);
    }

    static double primeGoalProbability(double p, double[][] comb) {
        double res = 0.0;

        for (int k : PRIMES) {
            res += comb[18][k] * Math.pow(p, k) * Math.pow(1.0 - p, 18 - k);
        }

        return res;
    }
}