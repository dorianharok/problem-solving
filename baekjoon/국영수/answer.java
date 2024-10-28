import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        List<Student> students = new ArrayList<>();

        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Student student = new Student(
                    st.nextToken(),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );
            students.add(student);
        }

        students.sort(Comparator
                .comparing(Student::getKorean, Comparator.reverseOrder())
                .thenComparingInt(Student::getEnglish)
                .thenComparing(Student::getMath, Comparator.reverseOrder())
                .thenComparing(Student::getName)
        );

        for(Student student : students) {
            System.out.println(student.getName());
        }
    }

    public static class Student {
        private String name;
        private int korean;
        private int english;
        private int math;

        public Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        public String getName() {
            return name;
        }

        public int getKorean() {
            return korean;
        }

        public int getEnglish() {
            return english;
        }

        public int getMath() {
            return math;
        }
    }
}