class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];

        for (int i=0; i<nums.length; i++) {
            Integer another = map.get(target - nums[i]);
            if (another != null) {
                result[0] = another;
                result[1] = i;

                return result;
            }

            map.put(nums[i], i);
        }

        return result;
    }
}