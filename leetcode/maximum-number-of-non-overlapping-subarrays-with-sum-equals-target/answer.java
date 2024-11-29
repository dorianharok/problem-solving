class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        int answer = 0;
        set.add(0);
        for(int n : nums) {
            sum += n;
            if(set.contains(sum - target)) {
                answer++;
                set.clear();
            }

            set.add(sum);
        }

        return answer;
    }
}