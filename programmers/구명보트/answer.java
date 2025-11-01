import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);

        int l = 0;
        int r = people.length - 1;
        int cnt = 0;
        while(l <= r) {
            int sum = people[l] + people[r];

            if(sum <= limit) {
                r--;
                l++;
            } else {
                r--;
            }

            cnt++;
        }

        return cnt;
    }
}