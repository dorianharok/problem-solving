import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            List<Integer> list = new ArrayList<>();
            for (String s : br.readLine().split(" ")) {
                Integer parseInt = Integer.parseInt(s);
                list.add(parseInt);
            }
            Collections.sort(list);
            int a = list.get(0);
            int b = list.get(1);
            int c = list.get(2);

            if(a == 0 && b == 0 && c == 0) {
                break;
            }

            if(Math.pow(a,2) + Math.pow(b,2) == Math.pow(c,2)) {
                sb.append("right\n");
            } else {
                sb.append("wrong\n");
            }
        }

        System.out.println(sb);
    }
}
