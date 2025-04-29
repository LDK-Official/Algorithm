import java.io.*;
import java.util.*;

public class Main {
    static class Student {
        int country;
        int num;
        int grade;

        Student(int country, int num, int grade) {
            this.country = country;
            this.num = num;
            this.grade = grade;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Student> students = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int country = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());

            students.add(new Student(country, num, grade));
        }

        Collections.sort(students, (a, b) -> b.grade - a.grade);

        int[] countryNum = new int[101];
        int count = 0;

        StringBuilder sb = new StringBuilder();

        for (Student s : students) {
            if (countryNum[s.country] < 2) {
                sb.append(s.country).append(" ").append(s.num).append('\n');
                countryNum[s.country]++;
                count++;
            }
            if (count == 3) break;
        }

        System.out.println(sb);
    }
}