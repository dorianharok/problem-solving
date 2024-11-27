import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            Long n = Long.parseLong(br.readLine());

            int answer = 0;
            boolean flag = false;
            while(n > 1) {
                if(n % 2 == 0) {
                    n /= 2;
                } else if (n % 3 == 0) {
                    n /= 3;
                    n *= 2;
                } else if (n % 5 == 0) {
                    n /= 5;
                    n *= 4;
                } else {
                    flag = true;
                    break;
                }

                answer++;
            }

            System.out.println(flag ? -1 : answer);
        }

    }
}