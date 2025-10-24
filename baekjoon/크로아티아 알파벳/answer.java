import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> alphabets = List.of(
                "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="
        );

        String s = br.readLine();
        for(String a : alphabets) {
            if(s.contains(a)) {
                s = s.replaceAll(a, "*");
            }
        }

        System.out.println(s.length());
    }
}