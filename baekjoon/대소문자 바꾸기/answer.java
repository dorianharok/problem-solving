import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        char[] arr = s.toCharArray();
        for(int i=0; i<arr.length; i++) {
            if('a' <= arr[i] && arr[i] <= 'z') {
                arr[i] = (char)('A' + arr[i] - 'a');
            } else {
                arr[i] = (char)('a' + arr[i] - 'A');
            }
        }

        System.out.println(arr);
    }
}
