import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<int[]> meetings = new ArrayList<>();

        while(N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            meetings.add(new int[]{a,b});
        }

        meetings.sort((a,b) -> {
            if(a[1] != b[1]) return a[1] - b[1];

            return a[0] - b[0];
        });
        int count = 0;
        int endTime = -1;

        for(int i=0; i<meetings.size(); i++) {
            if(meetings.get(i)[0] < endTime) continue;

            count++;
            endTime = meetings.get(i)[1];
        }

        System.out.println(count);
    }
}