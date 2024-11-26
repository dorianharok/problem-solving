class Solution {
    public int maxSubArray(int[] nums) {
        int sum = (int)-1e9;
        int max = sum;
        for(int n : nums) {
            sum = Math.max(sum + n, n);
            max = Math.max(max, sum);
        }

        return max;
    }
}