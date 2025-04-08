import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String base = "";

        long multiplier = 1;

        for (int i = 0; i < 3; i++) {
            String N = br.readLine();

            switch (N) {
                case "black":
                    if (i == 0 || i == 1) {
                        base += "0";
                    } else {
                        multiplier *= 1;
                    }
                    break;
                case "brown":
                    if (i == 0 || i == 1) {
                        base += "1";
                    } else {
                        multiplier *= 10;
                    }
                    break;
                case "red":
                    if (i == 0 || i == 1) {
                        base += "2";
                    } else {
                        multiplier *= 100;
                    }
                    break;
                case "orange":
                    if (i == 0 || i == 1) {
                        base += "3";
                    } else {
                        multiplier *= 1000;
                    }
                    break;
                case "yellow":
                    if (i == 0 || i == 1) {
                        base += "4";
                    } else {
                        multiplier *= 10000;
                    }
                    break;
                case "green":
                    if (i == 0 || i == 1) {
                        base += "5";
                    } else {
                        multiplier *= 100000;
                    }
                    break;
                case "blue":
                    if (i == 0 || i == 1) {
                        base += "6";
                    } else {
                        multiplier *= 1000000;
                    }
                    break;
                case "violet":
                    if (i == 0 || i == 1) {
                        base += "7";
                    } else {
                        multiplier *= 10000000;
                    }
                    break;
                case "grey":
                    if (i == 0 || i == 1) {
                        base += "8";
                    } else {
                        multiplier *= 100000000;
                    }
                    break;
                case "white":
                    if (i == 0 || i == 1) {
                        base += 9;
                    } else {
                        multiplier *= 1000000000;
                    }
                    break;
            }
        }
        System.out.println(Integer.parseInt(base) * multiplier);
    }
}