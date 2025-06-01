import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            String name = input[0];
            int amount = Integer.parseInt(input[1]);
            map.put(name, map.getOrDefault(name, 0) + amount);
        }

        List<Integer> amounts = new ArrayList<>(map.values());

        for (int i = 0; i < amounts.size(); i++) {
            int a = amounts.get(i);
            int goldCok = a * 1618 / 1000;
            for (int j = 0; j < amounts.size(); j++) {
                if (i== j) continue;
                if (amounts.get(j) == goldCok) {
                    System.out.println("Delicious!");
                    return;
                }
            }
        }
        System.out.println("Not Delicious...");
    }
}
