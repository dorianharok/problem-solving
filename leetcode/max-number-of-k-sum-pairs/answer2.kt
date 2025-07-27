class Solution {
    fun maxOperations(nums: IntArray, k: Int): Int {
        Arrays.sort(nums)

        var l = 0
        var r = nums.size - 1

        var answer = 0
        while(l < r) {
            val sum = nums[l] + nums[r]

            if(sum == k) {
                answer++
                l++
                r--
            } else if (sum < k) {
                l++
            } else {
                r--
            }
        }

        return answer
    }
}