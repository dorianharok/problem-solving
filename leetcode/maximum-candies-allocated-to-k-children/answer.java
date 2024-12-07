class Solution {
    public int maximumCandies(int[] candies, long k) {
        int left = 1;
        int right = Arrays.stream(candies).max().getAsInt();
        int result = 0;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(canAllocate(candies, mid, k)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public boolean canAllocate(int[] candies, int num, long k) {
        long cnt = 0;
        for(int candy : candies) {
            cnt += candy / num;
        }
        return cnt >= k;
    }
}