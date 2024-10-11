import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] girl = new int[7];
        int[] boy = new int[7];
        while(N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());

            if(sex == 0) {
                girl[grade]++;
            } else {
                boy[grade]++;
            }
        }

        int answer = 0;
        for(int i=1; i<7; i++) {
            answer += (int)Math.ceil((double) girl[i] / K);
            answer += (int)Math.ceil((double) boy[i] / K);
        }

        System.out.println(answer);
    }
}