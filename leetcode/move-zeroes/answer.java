class Solution {
    public void moveZeroes(int[] nums) {
        int p = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != 0) {
                swap(nums, i, p++);
            }
        }
    }

    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}