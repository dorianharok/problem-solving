class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        Arrays.sort(nums);
        int left = 1;
        int right = nums[nums.length - 1];
        int result = 0;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(isPossible(nums, mid, maxOperations)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public boolean isPossible(int[] nums, int target, int maxOperations) {
        int cnt = 0;
        for(int n : nums) {
            cnt += (n - 1) / target;
        }

        return cnt <= maxOperations;
    }
}