import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String target = br.readLine();

        int count = 0;
        while(s.contains(target)) {
            s = s.replaceFirst(target, "-");
            count++;
        }

        System.out.println(count);
    }
}
d