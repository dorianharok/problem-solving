class Solution {
    public int singleNumber(int[] nums) {
        int answer = 0;
        for(int n : nums) {
            answer ^= n;
        }

        return answer;
    }
}