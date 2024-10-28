import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<User> users = new ArrayList<>();

        while(N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            User user = new User(
                    Integer.parseInt(st.nextToken()),
                    st.nextToken()
            );
            users.add(user);
        }

        users.sort(
                Comparator
                        .comparingInt(User::getAge)
        );

        users.forEach(System.out::println);
    }

    public static class User {
        private int age;
        private String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return age + " " + name;
        }
    }
}